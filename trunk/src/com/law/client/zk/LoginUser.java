package com.law.client.zk;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Vector;

import org.omg.CORBA.PRIVATE_MEMBER;
import org.python.antlr.PythonParser.return_stmt_return;
import org.zkoss.zk.ui.Sessions;

import com.law.bean.Login;
import com.law.bean.SysUser;
import com.law.service.LoginService;
import com.law.service.SysUserService;

public class LoginUser {
	private String _userId = "";
	private String _loginid = "";
	private String _username = "";
	private String _pwd = "";
	private String _isflag = "";
	private SysUserService _sysUserServiceObj = null;
	private LoginService _LoginServiceObj = null;
	private String _sysid = "";
	private Login _loginObj = null;

	public LoginUser() {
		this._sysUserServiceObj = new SysUserService();
		this._LoginServiceObj = new LoginService();		
		this._sysid = (String)Sessions.getCurrent().getAttribute("SYSID");
	}

	public void addUser(HashMap parmap) {
		initInfo(parmap);
		setUserInfo();
	}
	
	private void setUserInfo(){
		try {			
			this._loginObj = new Login(this._sysid,this._loginid);
			this._loginObj.setName(this._username);
			this._loginObj.setPw(this._pwd);
			this._loginObj.setUserid(this._userId);
			this._loginObj.setStatus(this._isflag);//启用状态
			this._loginObj.setSdate(new Date());//设置启用时间
			this._loginObj.setEdate(new Date());//设置截止时间
			this._loginObj.setRole(null);//设置角色
			
			this._LoginServiceObj.saveLogin(this._loginObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void updateLoginUser(Login source){
		try {
			this._LoginServiceObj.updateLogin(source);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public void deleteLoginUser(String loginid){
		try {
			this._LoginServiceObj.deleteLogin(this._sysid, loginid);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initInfo(HashMap parmap) {
		this._userId = parmap.get("USERID") != null ? String.valueOf(parmap.get("USERID")) : "";
		this._loginid = parmap.get("LOGINID") != null ? String.valueOf(parmap.get("LOGINID")) : "";
		this._username = parmap.get("USERNAME") != null ? String.valueOf(parmap.get("USERNAME")) : "";
		this._pwd = parmap.get("PASSWORD") != null ? String.valueOf(parmap.get("PASSWORD")) : "";	
		this._isflag = parmap.get("ISFLAG") != null ? String.valueOf(parmap.get("ISFLAG")) : "";
	}
	
	public List<SysUser> getSystemUsers(){
		return _sysUserServiceObj.getSystemUser(this._sysid);
	}
	
	public List<Login> getLoginers(){
		return this._LoginServiceObj.getSysLogins(_sysid);
	}
	
	public Login getLogin(String sysid,String loginid){
		return this._LoginServiceObj.getLogin(sysid, loginid);
	}
	
	public boolean checkLoginId(String loginid){
		return this._LoginServiceObj.checkLoginIDExist(this._sysid, loginid);
	}
}
