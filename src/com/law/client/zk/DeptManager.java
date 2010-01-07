package com.law.client.zk;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.law.bean.Department;
import com.law.bean.Login;
import com.law.service.DepartmentService;
import com.law.service.LinkManService;
import com.law.service.Service;

public class DeptManager {
	private String deptname = "";
	private String deptid = "";
	private Date cratetime = null;
	private String des = "";
	private DepartmentService _deptSerObj= null;
	private Department _deptBean = null;
	private String _sysid = "";
	private String _UserId = "";
	
	public DeptManager() {
		_deptSerObj = new DepartmentService();
		Login loginObj = Service.getCurrentSessionLogin();
		this._sysid = loginObj.getSysid();
		this._UserId = loginObj.getUserid();
	}

	public void addDept(HashMap parmap) {			
		initInfo(parmap);
		setDeptInfo();
	}
	
	public boolean updateDept(Department departmentObj) {
		try {
			return this._deptSerObj.updateDepartment(departmentObj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	public boolean deleteDept(String sysid,String deptid){
		try {
			return this._deptSerObj.delDepartment(sysid, deptid);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	//…Ë÷√Department∂‘œÛ
	private boolean setDeptInfo(){
		try {
			this._deptBean = this._deptSerObj.createDepartment(_sysid,this.deptname);			
			this._deptBean.setSdate(cratetime);
			this._deptBean.setEdate(cratetime);
			this._deptBean.setStatus("1");
			this._deptBean.setRemarks(des);
			this._deptBean.setPrincipal("");			
			return this._deptSerObj.updateDepartment(this._deptBean);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void initInfo(HashMap parmap){
		if (parmap.get("DEPTNAME") != null){
			this.deptname = String.valueOf(parmap.get("DEPTNAME"));
		}
		
		if(parmap.get("DEPTID") != null){
			this.deptid = String.valueOf(parmap.get("DEPTID"));
		}
		
		if(parmap.get("CTRATETIME")!=null){
			this.cratetime = (Date)parmap.get("CTRATETIME");
		}
		
		if(parmap.get("DES") != null){
			this.des = String.valueOf(parmap.get("DES"));
		}
	}
	
	public List getDepts(){
		try {
			return this._deptSerObj.getSysDepartment(this._sysid);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		
	}
	
	public Department getDepartment(){
		return this._deptBean;
	}
	
	public Department getDepartment(String sysid,String deptid){
		return this._deptSerObj.getDepartment(sysid, deptid);
	}
}
