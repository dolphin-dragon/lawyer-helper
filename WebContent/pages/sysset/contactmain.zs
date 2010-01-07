import com.law.client.zk.ContactManager;
import com.law.client.zk.LoginManager;
import com.law.client.zk.Messagebox;
import com.law.bean.LinkMan;
import java.util.Date;
import java.util.List;

import org.zkoss.zk.ui.Sessions;
import org.zkoss.zul.Listcell;
import com.law.service.Service;

// 判断是否已经登录
LoginManager loginObj = new LoginManager();
if(!loginObj.isLogined()){
	return;
}

ContactManager contacterObj = new ContactManager();
// 初始化联系人列表
List contacterLst = contacterObj.getContacters();
//记录是否是修改状态
private boolean _isUpdate = false;
//联系人ID
private String _contacterId = "";
//LinkMan对象
private LinkMan _linkManObj = null;
//系统ID
private String _sysid = Service.getCurrentSessionLogin().getSysid();
//登录用户ID
private String _userid = Service.getCurrentSessionLogin().getUserid();
//记录空行数
private int _iList = 0;

// 调用添加信息窗口
public void addContacter(){
	winCon.doModal();
}

// 是否添加详细信息
public void addInfo(){
	winCon.getFellow("chkInfo").isChecked()?winCon.getFellow("gridInfo").setVisible(true):winCon.getFellow("gridInfo").setVisible(false);	
}

public void initAddItem(){
	_iList = contacterLst.size();
	// 如果节点不够10行，用空行补齐
	if(_iList < 10){
		int iRows = 10 - _iList;
		for (int i = 0; i < iRows; i++) {
			Listitem listitem = new Listitem();
			for (int j = 0; j < 4; j++) {
				Listcell listcell = new Listcell();				
				listcell.setParent(listitem);
			}
			listitem.setParent(winContact.getFellow("box"));						
		}
		winContact.getFellow("box").invalidate();
	}
}

// 按钮确定事件
public void btnOK(){
	String nameStr = winCon.getFellow("txtName").getValue();	
	
	if(null == nameStr || "".equals(nameStr)){
		Messagebox.showExclamation("MSG", "101");
		winCon.getFellow("txtName").focus();
		return;
	}
	
	String sexStr = winCon.getFellow("radSex").getSelectedItem().getId();
	String sexNameStr = winCon.getFellow("radSex").getSelectedItem().getLabel();
	String shenfenStr = winCon.getFellow("shenfen").getSelectedItem()==null?"":winCon.getFellow("shenfen").getSelectedItem().getId();
	String weihuStr = winCon.getFellow("weihu").getSelectedItem()==null?"":winCon.getFellow("weihu").getSelectedItem().getId();
	String fenzuStr = winCon.getFellow("fenzu").getSelectedItem()==null?"":winCon.getFellow("fenzu").getSelectedItem().getId();
	String deptStr = winCon.getFellow("cmbDept").getSelectedItem()==null?"":winCon.getFellow("cmbDept").getSelectedItem().getId();
	String isPubStr = winCon.getFellow("checkIsPub").isChecked()?"1":"0";
	
	Map parmap = new HashMap();
	parmap.put("CNAME",nameStr);
	parmap.put("SEX",sexStr);
	parmap.put("SEXNAME",sexNameStr);
	parmap.put("SHENFEN",shenfenStr);
	parmap.put("WEIHU",weihuStr);
	parmap.put("FENZU",fenzuStr);
	parmap.put("DEPT",deptStr);
	parmap.put("ISPUB",isPubStr);
	
	if(winCon.getFellow("chkInfo").isChecked()){
		Date birthday = winCon.getFellow("birthday").getValue();
		if(null == birthday){
			Messagebox.showExclamation("MSG", "121");
			return;
		}
		String addressStr = winCon.getFellow("txtAddress").getValue();
		String emailStr = winCon.getFellow("txtEmail").getValue();
		String telStr = winCon.getFellow("txtTel").getValue();
		String workAddStr = winCon.getFellow("txtWordAdd").getValue();
		
		parmap.put("BIRTHDAY",birthday);
		parmap.put("ADDRESS",addressStr);
		parmap.put("EMAIL",emailStr);
		parmap.put("TEL",telStr);
		parmap.put("WORK",workAddStr);
	}
	
	if(!_isUpdate){//新建部门
		contacterObj.addContacter(parmap);
		LinkMan linkManObj = contacterObj.getLinkManObj();
		clearContent();	
		addListbox(linkManObj);	
	}else{//修改部门
		this._linkManObj.setName(nameStr);
		this._linkManObj.setSex(sexStr);
		this._linkManObj.setSexName(sexNameStr);
		this._linkManObj.setPhone("");
		this._linkManObj.setEmail("");
		this._linkManObj.setCreator(_userid);

		contacterObj.updateContacter(this._linkManObj);
		clearContent();	
		updateListbos(winContact.getFellow("box").getSelectedItem(),this._linkManObj);
	}
	
}

//添加一行记录
void addListbox(LinkMan linkManObj){
	Listitem li = null;
	if(_iList < 10){
		li = winContact.getFellow("box").getItemAtIndex(_iList);
		li.setId(linkManObj.getId());
		updateListbos(li,linkManObj);
		_iList++;
	}else{
		li = new Listitem();
		li.setId(linkManObj.getId());				
		li.appendChild(new Listcell(linkManObj.getName()));//联系人名称			
		li.appendChild(new Listcell(linkManObj.getSexName()));//性别
		li.appendChild(new Listcell("未设置"));//文档空间	
		li.appendChild(new Listcell("未设置"));//使用状态	
		
		winContact.getFellow("box").appendChild(li);
	}		
}

//更新Listbox
void updateListbos(Listitem listitem,LinkMan linkManObj){	 
	List list = listitem.getChildren();
	
	for (int i = 0; i < list.size(); i++) {
		Listcell listcell = (Listcell)list.get(i);
		if(i==0){
			listcell.setLabel(linkManObj.getName());
		}else if(i==1){
			listcell.setLabel(linkManObj.getSex());
		}else if(i==2){
			listcell.setLabel("未设置");
		}else if(i==3){
			listcell.setLabel("未设置");
		}
	}
}

public void update(){
	_isUpdate = true;
	_contacterId = winContact.getFellow("box").getSelectedItem().getId();		
	_linkManObj = contacterObj.getLinkManObj(_sysid,_contacterId);
	String sexStr = _linkManObj.getSex();
	
	winCon.getFellow("txtName").setValue(_linkManObj.getName());
	if("1".equals(sexStr)){
		winCon.getFellow("radSex").setSelectedIndex(0);
	}else if("0".equals(sexStr)){
		winCon.getFellow("radSex").setSelectedIndex(1);
	}else if("2".equals(sexStr)){
		winCon.getFellow("radSex").setSelectedIndex(2);
	}
	
	winCon.doModal();
	isUpdate = false;
}

public void delContacter(){
	try {
		if(winContact.getFellow("box").getSelectedItem()==null){
			Messagebox.showExclamation("MSG", "124");
			return;
		}
		
		Messagebox.show("确认要删除这个联系人吗？", "消息框", Messagebox.YES|Messagebox.NO,
				   Messagebox.QUESTION,
				   new EventListener() {
					public void onEvent(Event evt) {
						if ("onYes".equals(evt.getName())) {														
							String contacterid = winContact.getFellow("box").getSelectedItem().getId();
							contacterObj.deleteContacter(contacterid);
							winContact.getFellow("box").removeItemAt(winContact.getFellow("box").getSelectedIndex());
							_iList--;
							if(_iList < 10){
								Listitem li = new Listitem();										
								li.appendChild(new Listcell());		
								li.appendChild(new Listcell());
								li.appendChild(new Listcell());	
								li.appendChild(new Listcell());
								winContact.getFellow("box").appendChild(li);
							}
							winContact.getFellow("box").invalidate();							
						}
					}
				   }
				);
	} catch (Exception e) {
		e.printStackTrace();
	}	
}

public void btnCancle(){
	clearContent();	
}

private void clearContent(){
	winCon.getFellow("txtName").setValue("");
	winCon.getFellow("radSex").setSelectedIndex(0);
	winCon.getFellow("shenfen").setSelectedIndex(0);
	winCon.getFellow("weihu").setSelectedIndex(0);
	winCon.getFellow("fenzu").setSelectedIndex(0);
	winCon.getFellow("cmbDept").setSelectedIndex(0);
	winCon.getFellow("chkInfo").setChecked(false);
	
	winCon.getFellow("gridInfo").setVisible(false);
	winCon.getFellow("birthday").setValue(null);
	winCon.getFellow("txtAddress").setValue("");
	winCon.getFellow("txtEmail").setValue("");
	winCon.getFellow("txtTel").setValue("");
	winCon.getFellow("txtWordAdd").setValue("");
	
	winCon.setVisible(false);
}