import com.law.client.zk.OrgManager;
import com.law.client.zk.UserManager;
import com.law.client.zk.Messagebox;
import org.zkoss.zul.Include;
import org.zkoss.zul.Listitem;

import com.law.service.Service;
import java.util.List;
import java.util.ArrayList;


OrgManager _orgObj = new OrgManager();

//系统ID
private String _sysid = Service.getCurrentSessionLogin().getSysid();
//登录用户ID
private String _userid = Service.getCurrentSessionLogin().getUserid();
//获得传递过来的参数

String deptId = "";
if(Executions.getCurrent().getParameter("deptId")!=null){
	deptId = Executions.getCurrent().getParameter("deptId");
}
//部门名称初始化
List deptItems = _orgObj.getDepts(_sysid);
//记录空行数
private int _iList = 0;
private int _iUsersLst = 0;

//根据部门名称初始化用户
List userslst = null;
if(!"".equals(deptId)){
	userslst = _orgObj.getUsers(_sysid,deptId);
	System.out.println("userslst>>" + userslst.size());
}else{
	userslst = new ArrayList();
}

public void initAddItem(){
	_iList = userslst.size();
	// 如果节点不够10行，用空行补齐
	if(_iList < 10){
		int iRows = 10 - _iList;
		for (int i = 0; i < iRows; i++) {
			Listitem listitem = new Listitem();
			for (int j = 0; j < 6; j++) {
				Listcell listcell = new Listcell();				
				listcell.setParent(listitem);
			}
			listitem.setParent(winOrgMain.getFellow("lstUsers"));						
		}
		winOrgMain.getFellow("lstUsers").invalidate();
	}
}

/**    用户搜索帮助初始化*/
//人员初始化
List usersItems = _orgObj.getSystemUser(_sysid);
public void initAddUsersItem(){
	_iUsersLst = usersItems.size();
	// 如果节点不够10行，用空行补齐
	if(_iUsersLst < 10){
		int iRows = 10 - _iList;
		for (int i = 0; i < iRows; i++) {
			Listitem listitem = new Listitem();
			for (int j = 0; j < 5; j++) {
				Listcell listcell = new Listcell();				
				listcell.setParent(listitem);
			}
			listitem.setParent(winUsers.getFellow("lstSysUsers"));						
		}
		winUsers.getFellow("lstSysUsers").invalidate();
	}
}

public void showUsersHelp(){	
	winUsers.doModal();
}

public void btnOK(){
	List lst = new ArrayList();
	Map parmap = new HashMap();
	parmap.put("DEPTID",deptId);
	
	Object[] obj = winUsers.getFellow("lstSysUsers").getSelectedItems().toArray();
	int iItems = obj.length;
	for (int i = 0; i < iItems; i++) {
		Listitem item = (Listitem)obj[i];
		lst.add(item.getId());
	}
	
	parmap.put("USERLST",lst);
	
	_orgObj.addUnit(parmap);
	closeWindow();
	addListbox(lst);	
}

private addListbox(List lst){
	int iLst = lst.size();
	for (int i = 0; i < iLst; i++) {
		Listitem li = null;
		if(_iList < 10){
			li = winOrgMain.getFellow("lstUsers").getItemAtIndex(_iList);
			String deptid = (String)lst.get(i); 
			li.setId(deptid);
			updateListbos(li,deptid);
			_iList++;
		}else{
			li.setId((String)lst.get(i));				
			li.appendChild(new Listcell((String)lst.get(i)));//部门名称			
			li.appendChild(new Listcell("未设置"));//启用状态	
			li.appendChild(new Listcell("未设置"));//文档空间	
			li.appendChild(new Listcell("未设置"));//使用状态	
			li.appendChild(new Listcell("未设置"));//部门描述
			
			winOrgMain.getFellow("lstUsers").appendChild(li);
		}
	}
}

//更新Listbox
private void updateListbos(Listitem listitem,String deptid){
	List list = listitem.getChildren();
	
	for (int i = 0; i < list.size(); i++) {
		Listcell listcell = (Listcell)list.get(i);
		if(i==0){
			listcell.setLabel(deptid);
		}else if(i==1){
			listcell.setLabel("未设置");
		}else if(i==2){
			listcell.setLabel("未设置");
		}else if(i==3){
			listcell.setLabel("未设置");
		}else if(i==4){
			listcell.setLabel("未设置");
		}
	}
}

public void delUsers(){
	try {	
		if(winOrgMain.getFellow("lstUsers").getSelectedItem()==null){
			Messagebox.showExclamation("MSG", "124");
			return;
		}
		
		Messagebox.show("确认要删除这个部门吗？", "消息框", Messagebox.YES|Messagebox.NO,
				   Messagebox.QUESTION,
				   new EventListener() {
					public void onEvent(Event evt) {
						if ("onYes".equals(evt.getName())) {
							List lst = new ArrayList();
							Map parmap = new HashMap();
							parmap.put("DEPTID",deptId);
							
							Object[] obj = winUsers.getFellow("lstSysUsers").getSelectedItems().toArray();
							int iItems = obj.length;
							for (int i = 0; i < iItems; i++) {
								Listitem item = (Listitem)obj[i];
								lst.add(item.getId());
							}
							
							parmap.put("USERLST",lst);
							
							_orgObj.deleteSysUser(parmap);
							winOrgMain.getFellow("lstUsers").removeItemAt(winOrgMain.getFellow("lstUsers").getSelectedIndex());
							winOrgMain.getFellow("lstUsers").invalidate();
							_iList--;
						}
					}
				   }
				);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

private void initHelpInfo(){
	winUsers.getFellow("lstSysUsers").clearSelection();
}

private void closeWindow(){
	initHelpInfo();
	winUsers.setVisible(false);
}

public void cancle(){	
	closeWindow();
}