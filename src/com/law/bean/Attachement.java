package com.law.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * 说明：对附件进行描述，一个附件的主体标识、附件标识、附件中关联的文档ID列表、
 * 附件文档的描述列表、附件文档序号列表
 *
 */
public class Attachement {
	//附件依赖的主体的标识
	private String subjectID = "";
	//附件中每个条目的内容
	private List<AttachementItem> items = null;
	
	public Attachement(String subjectid) {
		subjectID = subjectid;
		items = new ArrayList<AttachementItem>();
	}
	
	public void addItems(AttachementItem source){
		items.add(source);
	}
	
	public String getSubjectID() {
		return subjectID;
	}

	public List<AttachementItem> getAttacheItems() {
		return items;
	}
}