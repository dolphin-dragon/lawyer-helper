package com.law.client.zk;

import java.util.Date;
import java.util.HashMap;
import java.util.List;

import org.zkoss.zk.ui.Sessions;

import com.law.bean.LinkMan;
import com.law.bean.Login;
import com.law.service.LinkManService;
import com.law.service.Service;

public class ContactManager {
	private String _SysId = "001";
	private String _UserId = "";
	private LinkManService _contactObj = null;
	private LinkMan _linkManObj = null;
	private String _id = "";
	private String _name = "";
	private String _sex = "";
	private String _sexName = "";
	private String _shenfen = "";
	private String _weihu = "";
	private String _fenzu = "";
	private String _dept = "";
	private String _ispub = "";
	private Date _birthday = null;
	private String _address = "";
	private String _email = "";
	private String _tel = "";
	private String _work = "";
	
	public ContactManager(){
		Login loginObj = Service.getCurrentSessionLogin();
		this._SysId = loginObj.getSysid();
		this._UserId = loginObj.getUserid();
		this._contactObj = new LinkManService();
	}
	
	public void addContacter(HashMap parMap){
		initInfo(parMap);
		setContacterInfo();
	}
	
	public boolean updateContacter(LinkMan lingkManObj){
		try {
			return this._contactObj.updateLinkMan(lingkManObj);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
	
	private void setContacterInfo(){
		try {
			this._linkManObj = _contactObj.createLinkMan(this._name, this._SysId);
			this._linkManObj.setSex(this._sex);
			this._linkManObj.setSexName(this._sexName);
			this._linkManObj.setEmail(this._email);
			this._linkManObj.setName(this._name);
			this._linkManObj.setPhone(this._tel);
			this._linkManObj.setCreator(this._UserId);
			
			this._contactObj.updateLinkMan(this._linkManObj);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initInfo(HashMap parMap){
		this._name = parMap.get("CNAME").toString();
		this._sex = parMap.get("SEX").toString();
		this._sexName = parMap.get("SEXNAME").toString();
		this._shenfen = parMap.get("SHENFEN")==null?"":parMap.get("SHENFEN").toString();
		this._weihu = parMap.get("WEIHU")==null?"":parMap.get("WEIHU").toString(); 
		this._fenzu = parMap.get("FENZU")==null?"":parMap.get("FENZU").toString();
		this._dept = parMap.get("DEPT")==null?"":parMap.get("DEPT").toString();
		this._ispub = parMap.get("ISPUB")==null?"":parMap.get("ISPUB").toString();
		this._birthday = parMap.get("BIRTHDAY")==null?null:(Date)parMap.get("BIRTHDAY");
		this._address = parMap.get("ADDRESS")==null?"":parMap.get("ADDRESS").toString();
		this._email = parMap.get("EMAIL")==null?"":parMap.get("EMAIL").toString();
		this._tel = parMap.get("TEL")==null?"":parMap.get("TEL").toString();
		this._work = parMap.get("WORK")==null?"":parMap.get("WORK").toString();			
	}
	
	public List getContacters(){
		List<LinkMan> list = this._contactObj.getUserLinkMan(this._SysId,this._UserId);		
		return list;
	}
	
	public LinkMan getLinkManObj(){
		return this._linkManObj;
	}
	
	public LinkMan getLinkManObj(String sysId,String contacterId){
		return this._contactObj.getLinkMan(sysId, contacterId);	
	}
	
	public boolean deleteContacter(String linkManID){
		try {
			return this._contactObj.deleteLinkMan(this._UserId, linkManID, this._SysId);
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}
}
