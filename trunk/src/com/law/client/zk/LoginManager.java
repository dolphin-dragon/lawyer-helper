package com.law.client.zk;

import java.util.HashMap;
import java.util.List;

import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.Sessions;


import com.law.bean.Login;
import com.law.service.Service;

public class LoginManager {
	private String _userIdStr = "";
	private String _pwdStr = "";
	private String _sysIdStr = "";
	private Service _serviceObj = null;	

	public LoginManager() {
		this._serviceObj = new Service();
		
	}

	public void onLogin(HashMap<String, String> parmap) {
		initInfo(parmap);// 初始化用户登录信息
		if (checkUser()) {
			Login loginObj = this._serviceObj.getLogin(this._sysIdStr, this._userIdStr);
			Service.setCurrentSessionLogin(loginObj);			
			Executions.sendRedirect("indexLawyer.zul");
		}
	}

	private boolean checkUser() {
		try {									
			//判断用户是否存在
			if(!this._serviceObj.checkExistUser(_sysIdStr, _userIdStr)){
				Messagebox.showInformation("MSG", "119");
				return false;
			}
			
			//判断用户名、密码是否正确
			if(!this._serviceObj.ckeckLogin(_sysIdStr, _userIdStr,_pwdStr)){
				Messagebox.showExclamation("MSG", "120");
				return false;
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	private void initInfo(HashMap<String, String> parmap) {
		this._userIdStr = parmap.get("USERID");
		this._pwdStr = parmap.get("PWD");
		this._sysIdStr = parmap.get("SYSID");
	}

	public boolean isLogined() {
		if (Sessions.getCurrent().getAttribute("LOGIN") == null) {
			Executions.sendRedirect("../pages/login.zul");
			return false;
		}
		return true;
	}
	
	public List<String[][]> getSysId(){
		return this._serviceObj.getSystems();
	}
}
