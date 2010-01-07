package com.law.bean;
/**
 * 说明：存储空间类
 *
 */
public class Space {
	//存储空间标识，一般引用案件标识、案源标识、用户标识、部门标识
	private String id="";
	//存储空间名称
	private String name="";
	//存储空间创建者，如果是部门（部门负责人）、案件、案源、个人都是创建者
	private String creator="";
	//存储空间状态
	private String status = "";
	//存储空间类型
	private String type = "";
	
	private String sysid = "";
	
	public Space(String system,String spaceid){
		this.sysid = system;
		id = spaceid;
	}
	
	public String getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getCreator() {
		return creator;
	}
	public void setCreator(String creator) {
		this.creator = creator;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getSysid() {
		return sysid;
	}
}
