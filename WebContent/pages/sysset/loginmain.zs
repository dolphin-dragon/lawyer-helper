import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.List;

import org.zkoss.zk.ui.Sessions;

import com.law.client.zk.Messagebox;
import com.law.client.zk.LoginUser;
import com.law.client.zk.MSG;
import com.law.bean.SysUser;
import com.law.client.zk.LoginManager;
import com.law.bean.Login;


LoginUser dmobj = new LoginUser();
//获得系统用户对象
List items = dmobj.getLoginers();
//Login对象
private Login _loginObj = null;
//记录空行数
private int _iList = 0;
//系统ID
private String _sysId = (String)Sessions.getCurrent().getAttribute("SYSID");
//记录是否是修改状态
private boolean isUpdate = false;
//记录用户列表
private List _lstUserId = new ArrayList();

public void initInfo(){
	initAddItem();
	initCmbUsers();
}

public void initAddItem(){
	_iList = items.size();
	// 如果节点不够10行，用空行补齐
	if(_iList < 10){
		int iRows = 10 - _iList;
		for (int i = 0; i < iRows; i++) {
			Listitem listitem = new Listitem();
			for (int j = 0; j < 4; j++) {
				Listcell listcell = new Listcell();				
				listcell.setParent(listitem);
			}
			listitem.setParent(winLoginMain.getFellow("box"));						
		}
		winLoginMain.getFellow("box").invalidate();
	}
}

public void initCmbUsers(){
	List list = dmobj.getSystemUsers();
	
	for (int i = 0; i < list.size(); i++) {
		SysUser sysUserObj = (SysUser)list.get(i);
		Comboitem comboitem = new Comboitem(sysUserObj.getName());
		comboitem.setId(sysUserObj.get_ID());
		_lstUserId.add(sysUserObj.get_ID());
		comboitem.setParent(winlogin.getFellow("cmbUsers"));
	}
	winlogin.getFellow("cmbUsers").invalidate();
}

public void btnOK(){
	String userId = winlogin.getFellow("cmbUsers").getSelectedItem().getId();
	if(null == userId || "".equals(userId)){
		Messagebox.showExclamation("MSG", "122");
		winlogin.getFellow("cmbUsers").focus();
		return;
	}
	
	String loginid = winlogin.getFellow("txtUserID").getValue();	
	if(null == loginid || "".equals(loginid)){//判断登录ID是否为空
		Messagebox.showExclamation("MSG", "103");
		winlogin.getFellow("txtUserID").focus();
		return;
	}
	if(dmobj.checkLoginId(loginid) && !isUpdate){//判断登录ID是否存在
		Messagebox.showExclamation("MSG", "123");
		winlogin.getFellow("txtUserID").focus();
		return;
	}
	
	String username = winlogin.getFellow("cmbUsers").getSelectedItem().getLabel();
	if(null == username || "".equals(username)){
		Messagebox.showExclamation("MSG", "104");
		winlogin.getFellow("cmbUsers").focus();
		return;
	}
	
	String pwd = winlogin.getFellow("txtPwd").getValue();
	if(null == pwd || "".equals(pwd)){
		Messagebox.showExclamation("MSG", "105");
		winlogin.getFellow("txtPwd").focus();
		return;
	}
	
	String repwd = winlogin.getFellow("txtRePwd").getValue();
	if(null == repwd || "".equals(repwd)){
		Messagebox.showExclamation("MSG", "106");
		winlogin.getFellow("txtRePwd").focus();
		return;
	}
	
	if(!repwd.equals(pwd)){
		Messagebox.showExclamation("MSG", "107");
		winlogin.getFellow("txtRePwd").focus();
		return;
	}
	
	Map parmap = new HashMap();
	parmap.put("USERID",userId);
	parmap.put("LOGINID",loginid);
	parmap.put("USERNAME",username);
	parmap.put("PASSWORD",pwd);
	parmap.put("ISFLAG",winlogin.getFellow("rapFlag").getSelectedItem().getId());
		
	if(!isUpdate){
		dmobj.addUser(parmap);
		closeWin();
		addListbox(parmap);
	}else{
		this._loginObj.setUserid(userId);
		this._loginObj.setName(username);
		this._loginObj.setPw(pwd);
		this._loginObj.setStatus((String)parmap.get("ISFLAG"));
		
		dmobj.updateLoginUser(this._loginObj);
		closeWin();
		updateListbos(winLoginMain.getFellow("box").getSelectedItem(),parmap);
	}
}

private void addListbox(HashMap parmap){	
	Listitem li = null;
	if(_iList < 10){
		System.out.println("_iList>>" + _iList);
		li = winLoginMain.getFellow("box").getItemAtIndex(_iList);
		li.setId((String)parmap.get("LOGINID"));
		updateListbos(li,parmap);
		_iList++;
	}else{
		li = new Listitem();
		li.setId((String)parmap.get("LOGINID"));				
		li.appendChild(new Listcell((String)parmap.get("LOGINID")));//登录ID	
		li.appendChild(new Listcell((String)parmap.get("USERNAME")));//性别
		li.appendChild(new Listcell(getStatusName((String)parmap.get("ISFLAG"))));//是否启用
		li.appendChild(new Listcell("未设置"));//使用状态	
		
		winLoginMain.getFellow("box").appendChild(li);
	}
}

public void update(){
	isUpdate = true;
	String loginid = winLoginMain.getFellow("box").getSelectedItem().getId();
	_loginObj = dmobj.getLogin(_sysId,loginid);
	
	int index = _lstUserId.indexOf(_loginObj.getUserid());
	
	winlogin.getFellow("cmbUsers").setSelectedIndex(index);
	winlogin.getFellow("txtUserID").setValue(_loginObj.getId());
	winlogin.getFellow("txtUserID").setReadonly(true);
	String status = _loginObj.getStatus();
	if("1".equals(status)){
		winlogin.getFellow("rapFlag").setSelectedIndex(0);
	}else{
		winlogin.getFellow("rapFlag").setSelectedIndex(1);
	}
	
	winlogin.doModal();
	isUpdate = false;
	winlogin.getFellow("txtUserID").setReadonly(false);
}

//更新Listbox
private void updateListbos(Listitem listitem,HashMap parmap){	 
	List list = listitem.getChildren();
	
	for (int i = 0; i < list.size(); i++) {
		Listcell listcell = (Listcell)list.get(i);
		if(i==0){
			listcell.setLabel((String)parmap.get("LOGINID"));
		}else if(i==1){
			listcell.setLabel((String)parmap.get("USERNAME"));
		}else if(i==2){
			listcell.setLabel(getStatusName((String)parmap.get("ISFLAG")));
		}else if(i==3){
			listcell.setLabel("未设置");
		}
	}
}

private String getStatusName(String statusId){
	"1".equals(statusId)?"启用":"未启用";
}

void del(){ 
	try {		
		Messagebox.show("确认要删除这个用戶吗？", "消息框", Messagebox.YES|Messagebox.NO,
				   Messagebox.QUESTION,
				   new EventListener() {
					public void onEvent(Event evt) {
						if ("onYes".equals(evt.getName())) {
							String loginid = winLoginMain.getFellow("box").getSelectedItem().getId();
							dmobj.deleteLoginUser(loginid);
							winLoginMain.getFellow("box").removeItemAt(winLoginMain.getFellow("box").getSelectedIndex());
							winLoginMain.getFellow("box").invalidate();
							_iList--;
						}
					}
				   }
				);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

void closeWin(){
	winlogin.getFellow("txtUserID").setValue("");
	winlogin.getFellow("txtPwd").setValue("");
	winlogin.getFellow("txtRePwd").setValue("");	
	winlogin.getFellow("rapFlag").setSelectedIndex(1);	
	winlogin.setVisible(false);
}

void btnCancle(){
	closeWin();
}
