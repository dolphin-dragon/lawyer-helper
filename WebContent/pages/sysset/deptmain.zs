import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Vector;

import com.law.client.zk.Messagebox;
import com.law.client.zk.DeptManager;
import com.law.bean.Department;
import com.law.client.zk.LoginManager;
import com.law.service.Service;

//判断是否已经登录
LoginManager loginObj = new LoginManager();
if(!loginObj.isLogined()){
	return;
}

//用户管理类DeptManager对象
DeptManager dmobj = new DeptManager();
//初始化部门列表
List deptLst = dmobj.getDepts();
//记录是否是修改状态
boolean _isUpdate = false;
//部门ID
private String _deptid = "";
//Department对象实例
private Department _deptObj = null;
//系统ID
private String _sysid = Service.getCurrentSessionLogin().getSysid();
//登录用户ID
private String _userid = Service.getCurrentSessionLogin().getUserid();
//记录空行数
private int _iList = 0;


public void initAddItem(){
	_iList = deptLst.size();
	// 如果节点不够10行，用空行补齐
	if(_iList < 10){
		int iRows = 10 - _iList;
		for (int i = 0; i < iRows; i++) {
			Listitem listitem = new Listitem();
			for (int j = 0; j < 5; j++) {
				Listcell listcell = new Listcell();				
				listcell.setParent(listitem);
			}
			listitem.setParent(winDeptMain.getFellow("box"));						
		}
		winDeptMain.getFellow("box").invalidate();
	}
}

void btnOK(){
	String deptname = windept.getFellow("txtDeptName").getValue();
	
	if(null == deptname || "".equals(deptname)){				
		Messagebox.showExclamation("MSG", "108");
		windept.getFellow("txtDeptName").focus();
		return;
	}
		
	Date date = windept.getFellow("dbcreate").getValue();
	if(null == date){
		Messagebox.showExclamation("MSG", "110");
		return;
	}
	
	String des = windept.getFellow("des").getValue();
	
	Map parmap = new HashMap();
	parmap.put("DEPTNAME",deptname);
	parmap.put("CTRATETIME",date);
	parmap.put("DES",des);	
	
	if(!_isUpdate){//新建部门
		dmobj.addDept(parmap);
		Department departmentObj = dmobj.getDepartment();
		closeWin();	
		addListbox(departmentObj);	
	}else{//修改部门
		this._deptObj.setName(deptname);
		this._deptObj.setRemarks(des);
		this._deptObj.setSdate(date);

		dmobj.updateDept(this._deptObj);
		closeWin();	
		updateListbos(winDeptMain.getFellow("box").getSelectedItem(),this._deptObj);
	}
}

//更新Listbox
void updateListbos(Listitem listitem,Department departmentObj){
	List list = listitem.getChildren();
	
	for (int i = 0; i < list.size(); i++) {
		Listcell listcell = (Listcell)list.get(i);
		if(i==0){
			listcell.setLabel(departmentObj.getName());
		}else if(i==1){
			listcell.setLabel(departmentObj.getStatus());
		}else if(i==2){
			listcell.setLabel("未设置");
		}else if(i==3){
			listcell.setLabel("未设置");
		}else if(i==4){
			listcell.setLabel(departmentObj.getRemarks());
		}
	}
}

//添加一行记录
void addListbox(Department departmentObj){		
	Listitem li = null;
	if(_iList < 10){
		li = winDeptMain.getFellow("box").getItemAtIndex(_iList);
		li.setId(departmentObj.getId());
		updateListbos(li,departmentObj);
		_iList++;
	}else{
		li.setId(departmentObj.getId());				
		li.appendChild(new Listcell(departmentObj.getName()));//部门名称			
		li.appendChild(new Listcell(departmentObj.getStatus()));//启用状态	
		li.appendChild(new Listcell("未设置"));//文档空间	
		li.appendChild(new Listcell("未设置"));//使用状态	
		li.appendChild(new Listcell(departmentObj.getRemarks()));//部门描述
		
		winDeptMain.getFellow("box").appendChild(li);
	}
}

void create(){
	windept.getFellow("rowDept").setVisible(false);
	windept.doModal();
}

void del(){ 
	try {	
		if(winDeptMain.getFellow("box").getSelectedItem()==null){
			Messagebox.showExclamation("MSG", "124");
			return;
		}
		
		Messagebox.show("确认要删除这个部门吗？", "消息框", Messagebox.YES|Messagebox.NO,
				   Messagebox.QUESTION,
				   new EventListener() {
					public void onEvent(Event evt) {
						if ("onYes".equals(evt.getName())) {
							String deptid = winDeptMain.getFellow("box").getSelectedItem().getId();
							dmobj.deleteDept(_sysid,deptid);
							winDeptMain.getFellow("box").removeItemAt(winDeptMain.getFellow("box").getSelectedIndex());
							winDeptMain.getFellow("box").invalidate();
						}
					}
				   }
				);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

void update(){
	if(winDeptMain.getFellow("box").getSelectedItem()==null){
		Messagebox.showExclamation("MSG", "124");
		return;
	}
	_isUpdate = true;
	_deptid = winDeptMain.getFellow("box").getSelectedItem().getId();		
	_deptObj = dmobj.getDepartment(_sysid,_deptid);
	
	windept.getFellow("txtDeptName").setValue(_deptObj.getName());
	windept.getFellow("txtDeptNum").setValue(_deptObj.getId());
	windept.getFellow("dbcreate").setValue(_deptObj.getSdate());
	windept.getFellow("des").setValue(_deptObj.getRemarks());
	
	windept.doModal();
	isUpdate = false;
}

void closeWin(){
	windept.getFellow("txtDeptName").setValue("");
	windept.getFellow("txtDeptNum").setValue("");
	windept.getFellow("dbcreate").setValue(new Date());
	windept.getFellow("des").setValue("");
	windept.setVisible(false);
}

void btnCancle(){
	closeWin();
}
