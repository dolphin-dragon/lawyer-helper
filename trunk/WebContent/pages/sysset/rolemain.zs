import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import com.law.client.zk.Messagebox;
import com.law.client.zk.RoleManager;
import com.law.bean.Role;

//�û�������DeptManager����
RoleManager dmobj = new RoleManager();
//��¼�Ƿ����޸�״̬
boolean _isUpdate = false;
//ϵͳID
private String _sysid = "001";
//����ID
private String _roleid = "";
//Department����ʵ��
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
	
	if(!_isUpdate){//�½�����
		dmobj.addRole(parmap);
		Role roleObj = dmobj.getRole();
		closeWin();	
		addListbox(roleObj);	
	}else{//�޸Ĳ���
		this._roleObj.setName(rolename);
		this._roleObj.setRemarks(des);
		this._roleObj.setStatus(isUsed);

		dmobj.updateRole(this._sysid,this._roleObj);
		closeWin();	
		updateListbos();
	}
}

//����Listbox
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

//���һ�м�¼
void addListbox(Role roleObj){
	Listitem li = new Listitem();		
	
	li.setId(roleObj.getId());				
	li.appendChild(new Listcell(roleObj.getName()));//��ɫ����			
	li.appendChild(new Listcell(roleObj.getDescript()));//˵��	
	li.appendChild(new Listcell(roleObj.getDescript()));//��ע
	
	winRole.getFellow("box").appendChild(li);
}

void create(){
	winrole.getFellow("rowRoleNum").setVisible(false);
	winrole.doModal();
}

void del(){ 
	try {		
		Messagebox.show("ȷ��Ҫɾ�����������", "��Ϣ��", Messagebox.YES|Messagebox.NO,
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
