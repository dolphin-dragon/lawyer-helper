package com.law.bean;

import java.util.ArrayList;
import java.util.List;

/**
 * ˵�����Ը�������������һ�������������ʶ��������ʶ�������й������ĵ�ID�б�
 * �����ĵ��������б������ĵ�����б�
 *
 */
public class Attachement {
	//��������������ı�ʶ
	private String subjectID = "";
	//������ÿ����Ŀ������
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