package com.law.bean;
/**
 * 说明：联系人，将联系人主要分为普通人(person)、联系单位(organization)、系统内用户(sysuser)三大类
 * 
 * @author user
 */
public interface IContacter {
	enum USER_TYPE{PERSON,ORGANIZATION,SYSUSER};
}