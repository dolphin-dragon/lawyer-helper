package com.law.client.zk;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.law.bean.Login;
import com.law.bean.SysUser;
import com.law.service.Service;
import com.law.service.SysUserService;

public class UserManager {
	private String _userIDStr = "";
	private String _userNameStr = "";
	private String _sexStr = "";
	private Date _birthdayDate = null;
	private String _adressStr = "";
	private String _mailStr = "";
	private String _telStr = "";
	private Date _entryDate = null;
	private String _jiaoyuStr = "";
	private String _MSNStr = "";
	private String _QQStr = "";
	private String _dutyStr = "";
	private SysUserService _UserService = null;
	private SysUser _sysuserObj = null;
	private String _sysid = "";
	private String _UserId = "";

	public UserManager() {
		_UserService = new SysUserService();
		Login loginObj = Service.getCurrentSessionLogin();
		this._sysid = loginObj.getSysid();
		this._UserId = loginObj.getUserid();
	}

	public boolean addUser(HashMap parmap) {
		initInfo(parmap);
		return setUserInfo();
	}

	public boolean updateUser(SysUser sysuserObj) {
		try {
			return this._UserService.updateSysuse(sysuserObj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteUser(String sysid,String userid){
		try {
			return this._UserService.deleteSysUser(getSysUser(sysid,userid));
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	private boolean setUserInfo() {
		try {
			this._sysuserObj = this._UserService.createSysUser(
					this._userNameStr, _sysid);
			this._sysuserObj.setSex(this._sexStr);
			this._sysuserObj.setBirthday(this._birthdayDate);
			this._sysuserObj.setAddress(this._adressStr);
			this._sysuserObj.setEmail(this._mailStr);
			this._sysuserObj.setPhone(this._telStr);
			this._sysuserObj.setWorkeDate(this._birthdayDate);
			this._sysuserObj.setWorksDate(this._birthdayDate);
			this._sysuserObj.setStatus("");

			return this._UserService.updateSysuse(this._sysuserObj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	public SysUser getSysUser(String sysid,String userid) {
		return this._UserService.querySysUserByID(sysid,userid);
	}

	public SysUser getSysUser() {
		return this._sysuserObj;
	}

	public List<SysUser> getSystemUser() {
		return this._UserService.getSystemUser(this._sysid);
	}

	private void initInfo(HashMap parmap) {
		this._userIDStr = parmap.get("USERID") != null ? String.valueOf(parmap
				.get("USERID")) : "";
		this._userNameStr = parmap.get("USERNAME") != null ? String
				.valueOf(parmap.get("USERNAME")) : "";
		this._sexStr = parmap.get("SEX") != null ? String.valueOf(parmap
				.get("SEX")) : "";
		this._birthdayDate = parmap.get("BIRTHDAY") != null ? (Date) parmap
				.get("BIRTHDAY") : null;
		this._adressStr = parmap.get("ADDRESS") != null ? String.valueOf(parmap
				.get("ADDRESS")) : "";
		this._mailStr = parmap.get("EMAIL") != null ? String.valueOf(parmap
				.get("EMAIL")) : "";
		this._telStr = parmap.get("TEL") != null ? String.valueOf(parmap
				.get("TEL")) : "";
		this._entryDate = parmap.get("ENTRY") != null ? (Date) parmap
				.get("ENTRY") : null;
		this._jiaoyuStr = parmap.get("JIAOYU") != null ? String.valueOf(parmap
				.get("JIAOYU")) : "";
		this._MSNStr = parmap.get("MSN") != null ? String.valueOf(parmap
				.get("MSN")) : "";
		this._QQStr = parmap.get("QQ") != null ? String.valueOf(parmap
				.get("QQ")) : "";
		_dutyStr = parmap.get("DUTY") != null ? String.valueOf(parmap
				.get("DUTY")) : "";
	}
}
