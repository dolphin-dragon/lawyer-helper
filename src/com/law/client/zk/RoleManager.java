package com.law.client.zk;

import java.util.HashMap;
import java.util.List;

import com.law.bean.Role;
import com.law.service.RoleService;

public class RoleManager {
	private String _roleName = "";
	private String _dsc = "";
	private String _isUsed = "";
	private RoleService _roleService = null;
	private Role _roleObj = null;
	private String _sysid = "001";
	
	public RoleManager(){
		_roleService = new RoleService();
	}
	
	public boolean addRole(HashMap parmap){
		initInfo(parmap);
		return setRoleInfo();
	}
	
	public boolean updateRole(String systemid,Role roleObj) {
		try {
			this._roleService.updateRole(systemid, roleObj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	} 
	
	public boolean deleteRole(String sysid,String roleid){
		try {
			this._roleService.deleteRole(sysid,this._roleService.getRole(sysid,roleid));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void initInfo(HashMap parmap) {
		this._roleName = parmap.get("ROLENAME") != null ? String.valueOf(parmap
				.get("ROLENAME")) : "";
		this._dsc = parmap.get("DSC") != null ? String
				.valueOf(parmap.get("DSC")) : "";
				
		this._isUsed = parmap.get("ISUSED") != null ? String.valueOf(parmap
				.get("ISUSED")) : "";
	}
	
	private boolean setRoleInfo() {
		try {
			if(this._roleService.checkRoleNameExist(this._sysid,this._roleName)){
				Messagebox.showExclamation("MSG", "117");
				return false;
			}
			this._roleObj = this._roleService.createRole(this._sysid,this._roleName);
			this._roleObj.setDescript(this._dsc);
			this._roleObj.setStatus(this._isUsed);

			this._roleService.updateRole(this._sysid,this._roleObj);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//返回Role对象
	public Role getRole(){
		return this._roleObj;
	}
	
	//根据系统ID、角色ID，返回Role对象
	public Role getRole(String sysid,String roleid) {
		return this._roleService.getRole(sysid,roleid);		
	}
	
	//根据系统ID获得Role对象集合
	public List<Role> getRoles(String systemid) {
		return this._roleService.getSystemRole(systemid);		
	}	
}
