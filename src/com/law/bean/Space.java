package com.law.bean;
/**
 * ˵�����洢�ռ���
 *
 */
public class Space {
	//�洢�ռ��ʶ��һ�����ð�����ʶ����Դ��ʶ���û���ʶ�����ű�ʶ
	private String id="";
	//�洢�ռ�����
	private String name="";
	//�洢�ռ䴴���ߣ�����ǲ��ţ����Ÿ����ˣ�����������Դ�����˶��Ǵ�����
	private String creator="";
	//�洢�ռ�״̬
	private String status = "";
	//�洢�ռ�����
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
