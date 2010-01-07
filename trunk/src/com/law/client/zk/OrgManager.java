package com.law.client.zk;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;

import com.law.bean.Department;
import com.law.bean.Login;
import com.law.bean.SysUser;
import com.law.bean.Unit;
import com.law.service.DepartmentService;
import com.law.service.Service;
import com.law.service.SysUserService;
import com.law.service.UnitService;

public class OrgManager {
	private DepartmentService _deptService = null;
	private UnitService _unitService = null;
	private SysUserService _UserService = null;
	private List<Unit> _lstUnit = new ArrayList<Unit>();
	private Unit _unitObj = null;
	private String _deptId = "";
	private String _sysid = "";
	private String _UserId = "";
	
	public OrgManager(){
		this._deptService = new DepartmentService();
		this._unitService = new UnitService();
		this._UserService = new SysUserService();
		Login loginObj = Service.getCurrentSessionLogin();
		this._sysid = loginObj.getSysid();
		this._UserId = loginObj.getUserid();
	}
	
	public boolean addUnit(HashMap parmap){
		try {
			initInfo(parmap);
			return this._unitService.addUnits(_lstUnit);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}		
	}
	
	public boolean deleteSysUser(HashMap parmap){
		try {
			//取得部门ID
			this._deptId = parmap.get("DEPTID")==null?"":(String)parmap.get("DEPTID");
			//根据系统用户ID列表构建List<Unit>对象
			List list = (List)parmap.get("USERLST");
			for (int i = 0; i < list.size(); i++) {
				String userid = (String)list.get(i);
				this._unitService.removeSysUserFromUnit(this._sysid,this._deptId,userid);
			}
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	
	private void initInfo(HashMap parmap){
		this._lstUnit.clear();
		//取得部门ID
		this._deptId = parmap.get("DEPTID")==null?"":(String)parmap.get("DEPTID");
		//根据系统用户ID列表构建List<Unit>对象
		List list = (List)parmap.get("USERLST");
		for (int i = 0; i < list.size(); i++) {
			String userid = (String)list.get(i);			
			Unit unit = new Unit(this._sysid,this._deptId,userid);
			unit.setSdate(new Date());
			unit.setEdate(new Date());
			unit.setStatus("");
			unit.setSuperdepid(this._sysid);
			_lstUnit.add(unit);
		}
	}
	
	private void initLstUnit(){
		
	}
	
	public List<Department> getDepts(String sysid){
		return _deptService.getSysDepartment(sysid);
	}
	
	public List<Unit> getUsers(String sysid,String depid){
		return _unitService.getDepUser(sysid, depid);
	}
	
	public List<SysUser> getSystemUser(String sysid){
		return this._UserService.getSystemUser(sysid);
	}
}
