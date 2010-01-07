import java.util.List;

import org.zkoss.zul.Listcell;

import com.law.bean.SysUser;
import com.law.client.zk.Messagebox;
import com.law.client.zk.UserManager;
import com.law.service.Service;

UserManager dmobj = new UserManager();
//用户ID
private String _userid = "";	
//SysUser对象
private SysUser _sysuserObj = null;
//系统ID
private String _sysid = Service.getCurrentSessionLogin().getSysid();
//登录用户ID
private String _userid = Service.getCurrentSessionLogin().getUserid();
//初始化网格
List usersLst = dmobj.getSystemUser();
//记录空行数
private int _iList = 0;
//判断是否修改
private boolean _isUpdate = false;


public void initAddItem(){
	_iList = usersLst.size();
	// 如果节点不够10行，用空行补齐
	if(_iList < 10){
		int iRows = 10 - _iList;
		for (int i = 0; i < iRows; i++) {
			Listitem listitem = new Listitem();
			for (int j = 0; j < 5; j++) {
				Listcell listcell = new Listcell();				
				listcell.setParent(listitem);
			}
			listitem.setParent(winUserMain.getFellow("box"));						
		}
		winUserMain.getFellow("box").invalidate();
	}
}

void btnOK(){
	String username = winuser.getFellow("txtUsername").getValue();
	
	if(null == username || "".equals(username)){
		Messagebox.showExclamation("MSG", "101");
		txtUsername.focus();
		return;
	}
	
	String strSex = winuser.getFellow("radSex").getSelectedItem().getId();
	Date birthday = winuser.getFellow("birthday").getValue();
	String strAddress = winuser.getFellow("txtAddress").getValue();
	String strEmail = winuser.getFellow("txtEmail").getValue();
	String strTel = winuser.getFellow("txtTel").getValue();
	Date entry = winuser.getFellow("entry").getValue();
//	String strJiaoyu = winuser.getFellow("txtUsername")jiaoyu.getSelectedItem().getId();
//	String strMSN = txtMSN.getValue();
//	String strQQ = txtQQ.getValue();
//	String strDuty = duty.getSelectedItem().getId();
	
	Map parmap = new HashMap();
	parmap.put("USERNAME",username);
	parmap.put("SEX",strSex);
	parmap.put("BIRTHDAY",birthday);
	parmap.put("ADDRESS",strAddress);
	parmap.put("EMAIL",strEmail);
	parmap.put("TEL",strTel);
	parmap.put("ENTRY",entry);
//	parmap.put("JIAOYU",strJiaoyu);
//	parmap.put("MSN",strMSN);
//	parmap.put("QQ",strQQ);
//	parmap.put("DUTY",strDuty);
			
	if(!_isUpdate){	
		System.out.println("_isUpdate");
		dmobj.addUser(parmap);
		SysUser sysuserObj = dmobj.getSysUser();
		closeWin();	
		addListbox(sysuserObj);	
	}else{	
		this._sysuserObj.setName(username);
		this._sysuserObj.setSex(strSex);
		this._sysuserObj.setBirthday(birthday);
		this._sysuserObj.setAddress(strAddress);
		this._sysuserObj.setEmail(strEmail);
		this._sysuserObj.setPhone(strTel);
		this._sysuserObj.setWorkeDate(birthday);
		this._sysuserObj.setWorksDate(entry);
		this._sysuserObj.setStatus("");

		dmobj.updateUser(_sysuserObj);
		closeWin();	
		updateListbos(winUserMain.getFellow("box").getSelectedItem(),this._sysuserObj);
	}		
}

//更新Listbox
void updateListbos(Listitem listitem,SysUser sysuserObj){
	List list = listitem.getChildren();
	for (int i = 0; i < list.size(); i++) {
		Listcell listcell = (Listcell)list.get(i);
		if(i==0){
			listcell.setLabel(sysuserObj.getName());
		}else if(i==1){
			listcell.setLabel(getSexName(sysuserObj.getSex()));
		}else if(i==2){
			listcell.setLabel(sysuserObj.getPhone());
		}else if(i==3){
			listcell.setLabel(sysuserObj.getEmail());
		}else if(i==4){
			listcell.setLabel(String.valueOf(sysuserObj.getAge()));
		}
	}
}

String getSexName(String strSex){
	if("1".equals(strSex)){
		return "男";
	}else if("0".equals(strSex)){
		return "女";
	}else if("2".equals(strSex)){
		return "未知";
	}
}

//根据SysUser对象添加一行记录
void addListbox(SysUser sysuserObj){
	Listitem li = null;
	if(_iList < 10){
		li = winUserMain.getFellow("box").getItemAtIndex(_iList);
		li.setId(sysuserObj.get_ID());
		updateListbos(li,sysuserObj);
		_iList++;
	}else{
		li = new Listitem();
		//设置部门ID	
		li.setId(sysuserObj.get_ID());	
		
		//设置部门名称
		Listcell namecell=new Listcell(sysuserObj.getName());
		namecell.setHeight("20px");		
		li.appendChild(namecell);
		
		li.appendChild(new Listcell(getSexName(sysuserObj.getSex())));	
		li.appendChild(new Listcell(sysuserObj.getPhone()));
		li.appendChild(new Listcell(sysuserObj.getEmail()));
		li.appendChild(new Listcell(String.valueOf(sysuserObj.getAge())));
		
		winUserMain.getFellow("box").appendChild(li); 
	}
}

void del(){ 
	try {
		if(winUserMain.getFellow("box").getSelectedItem()==null){
			Messagebox.showExclamation("MSG", "124");
			return;
		}
		
		String userid = winUserMain.getFellow("box").getSelectedItem().getId();
		Messagebox.show("确认要删除这个部门吗？", "消息框", Messagebox.YES|Messagebox.NO,
				   Messagebox.QUESTION,
				   new EventListener() {
					public void onEvent(Event evt) {
						if ("onYes".equals(evt.getName())) {								
							dmobj.deleteUser(_sysid,userid);
							winUserMain.getFellow("box").removeItemAt(winUserMain.getFellow("box").getSelectedIndex());
														
							_iList--;
							if(_iList < 10){
								Listitem li = new Listitem();										
								li.appendChild(new Listcell());		
								li.appendChild(new Listcell());
								li.appendChild(new Listcell());	
								li.appendChild(new Listcell());
								li.appendChild(new Listcell());
								winUserMain.getFellow("box").appendChild(li);
							}
							winUserMain.getFellow("box").invalidate();	
						}
					}
				   }
				);
	} catch (Exception e) {
		e.printStackTrace();
	}
}

void closeWin(){
	winuser.getFellow("txtUsername").setValue("");
	winuser.getFellow("radSex").setSelectedIndex(0);
	winuser.getFellow("birthday").setValue(null);
	winuser.getFellow("txtAddress").setValue("");
	winuser.getFellow("txtEmail").setValue("");
	winuser.getFellow("txtTel").setValue("");
	winuser.getFellow("entry").setValue(null);
	winuser.getFellow("jiaoyu").setSelectedIndex(0);
	winuser.getFellow("txtMSN").setValue("");
	winuser.getFellow("txtQQ").setValue("");
	winuser.getFellow("duty").setSelectedIndex(0);
	winuser.setVisible(false);
}

void update(){
	if(winUserMain.getFellow("box").getSelectedItem()==null){
		Messagebox.showExclamation("MSG", "124");
		return;
	}
	_isUpdate = true;
	_userid = winUserMain.getFellow("box").getSelectedItem().getId();		
	_sysuserObj = dmobj.getSysUser(_sysid,_userid);
	
	String sexStr = _sysuserObj.getSex();
	Date birthdayDate = _sysuserObj.getBirthday();
	String adressStr = _sysuserObj.getAddress();
	String emailStr = _sysuserObj.getEmail();
	String telStr = _sysuserObj.getPhone();
	Date entryDate = _sysuserObj.getWorksDate();
	
	winuser.getFellow("txtUsername").setValue(_sysuserObj.getName());
	if("1".equals(sexStr)){
		winuser.getFellow("radSex").setSelectedIndex(0);
	}else if("0".equals(sexStr)){
		winuser.getFellow("radSex").setSelectedIndex(1);
	}else if("2".equals(sexStr)){
		winuser.getFellow("radSex").setSelectedIndex(2);
	}
	winuser.getFellow("birthday").setValue(birthdayDate);
	winuser.getFellow("txtAddress").setValue(adressStr);
	winuser.getFellow("txtEmail").setValue(emailStr);
	winuser.getFellow("txtTel").setValue(telStr);
	winuser.getFellow("entry").setValue(entryDate);
		
	winuser.doModal();
	isUpdate = false;
}

void btnCancle(){
	closeWin();
}
