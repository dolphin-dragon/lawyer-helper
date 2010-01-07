import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.law.client.zk.Messagebox;
import com.law.client.zk.RoleManager;
import com.law.bean.Role;

//用户管理类DeptManager对象
RoleManager dmobj = new RoleManager();
//记录是否是修改状态
boolean _isUpdate = false;
//系统ID
private String _sysid = "001";
//部门ID
private String _roleid = "";
//Department对象实例
private Role _roleObj = null;

void btnOK(){
	String rolename = winrole.getFellow("txtRoleName").getValue();
	
	if(null == rolename || "".equals(rolename)){				
		Messagebox.showExclamation("MSG", "116");
		winrole.getFellow("txtRoleName").focus();
		return;
	}
	
	String isUsed = winrole.getFellow("checkIsUsed").isChecked()?"1":"0";
	
	String des = winrole.getFellow("des").getValue();
	
	Map parmap = new HashMap();
	parmap.put("ROLENAME",rolename);
	parmap.put("DSC",des);
	parmap.put("ISUSED",isUsed);
	
	if(!_isUpdate){//新建部门
		dmobj.addRole(parmap);
		Role roleObj = dmobj.getRole();
		closeWin();	
		addListbox(roleObj);	
	}else{//修改部门
		this._roleObj.setName(rolename);
		this._roleObj.setRemarks(des);
		this._roleObj.setStatus(isUsed);

		dmobj.updateRole(this._sysid,this._roleObj);
		closeWin();	
		updateListbos();
	}
}

//更新Listbox
void updateListbos(){
	Listitem listitem = winRole.getFellow("box").getSelectedItem();	
	List list = listitem.getChildren();
	
	for (int i = 0; i < list.size(); i++) {
		Listcell listcell = (Listcell)list.get(i);
		if(i==0){
			listcell.setLabel(this._roleObj.getName());
		}else if(i==1){
			listcell.setLabel(this._roleObj.getDescript());
		}else if(i==2){
			listcell.setLabel(this._roleObj.getDescript());
		}
	}
}

//添加一行记录
void addListbox(Role roleObj){
	Listitem li = new Listitem();		
	
	li.setId(roleObj.getId());				
	li.appendChild(new Listcell(roleObj.getName()));//角色名称			
	li.appendChild(new Listcell(roleObj.getDescript()));//说明	
	li.appendChild(new Listcell(roleObj.getDescript()));//备注
	
	winRole.getFellow("box").appendChild(li);
}

void create(){
	winrole.getFellow("rowRoleNum").setVisible(false);
	winrole.doModal();
}

void del(){ 
	try {		
		Messagebox.show("确认要删除这个部门吗？", "消息框", Messagebox.YES|Messagebox.NO,
				   Messagebox.QUESTION,
				   new EventListener() {
					public void onEvent(Event evt) {
						if ("onYes".equals(evt.getName())) {
							String roleid = winRole.getFellow("box").getSelectedItem().getId();
							dmobj.deleteRole(_sysid,roleid);
							winRole.getFellow("box").removeItemAt(winRole.getFellow("box").getSelectedIndex());
							winRole.getFellow("box").invalidate();
						}
					}
				   }
				);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

void update(){	
	_isUpdate = true;
	_roleid = winRole.getFellow("box").getSelectedItem().getId();		
	_roleObj = dmobj.getRole(_sysid,_roleid);
	
	winrole.getFellow("txtRoleNum").setValue(_roleid);
	winrole.getFellow("txtRoleName").setValue(_roleObj.getName());
	winrole.getFellow("des").setValue(_roleObj.getDescript());
	
	String isUsedStr = _roleObj.getStatus();
	if("1".equals(isUsedStr)){
		windept.getFellow("checkIsUsed").setChecked(true);
	}else{
		windept.getFellow("checkIsUsed").setChecked(false);
	}
	winrole.doModal();
	isUpdate = false;
}

void closeWin(){
	winrole.getFellow("txtRoleNum").setValue("");
	winrole.getFellow("txtRoleName").setValue("");
	winrole.getFellow("des").setValue("");
	winrole.getFellow("checkIsUsed").setChecked(true);
	winrole.setVisible(false);
}

void btnCancle(){
	closeWin();
}
