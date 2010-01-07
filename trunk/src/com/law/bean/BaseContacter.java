package com.law.bean;

public abstract class BaseContacter implements IContacter{
	private String sysid = "";
	private String name = "";
	private String id = "";
	protected String type = "";
	public BaseContacter(String system,String id,String name){
		this.sysid = id;
		this.id = id;
		this.name = name;
	}
	
	public void setType(String soruce){
		this.type = soruce;
	}
	public String getType(){
		return type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSysid() {
		return sysid;
	}
	public String getId() {
		return id;
	}
	
}
