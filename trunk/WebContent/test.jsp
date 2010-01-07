<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%@page import="com.law.service.LoginService"%>
<%@page import="com.law.bean.Login"%>
<%@page import="com.law.service.SysUserService"%>
<%@page import="com.law.bean.SysUser"%>
<%@page import="java.util.Date"%>
<%@page import="com.law.service.Service"%>
<%@page import="com.law.service.DepartmentService"%>
<%@page import="com.law.bean.Department"%>
<%@page import="java.util.List"%>
<%@page import="com.law.service.RoleService"%>
<%@page import="com.law.bean.Role"%>
<%@page import="com.law.bean.CaseSource"%>
<%@page import="com.law.service.CaseSourceService"%>
<%@page import="com.law.service.DossierService"%>
<%@page import="com.law.bean.Dossier"%><html>

<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
String system = "001";
String loginid ="login001";

/*
SysUserService _userService = new SysUserService();
SysUser _user = _userService.createSysUser("test user 001",system);
String userid = _user.get_ID();
out.write("Create user :"+userid+" user name :"+_user.getName()+"\r\t");

_user.setAddress("sdafasdfasdfasdfa");
_user.setBirthday(new Date());
_user.setEducation("doctor");
_user.setEmail("dfasf@163.com");
_user.setName("test_user_001");
_user.setPhone("13800000000");
_user.setSex("1");
_user.setStatus("1");
_user.setWorkeDate(new Date());
_user.setWorksDate(new Date());
_userService.updateSysuse(_user);
out.write("Update user :"+userid+" user name :"+_user.getName()+"\r\t");
*/


/*
LoginService _loginService = new LoginService();
Login _login = new Login(system,loginid);
_login.setName("test user");
_login.setPw("123456");
_login.setUserid(userid);
_login.setEdate(new Date());
_login.setSdate(new Date());
_login.setStatus("1");
_login.setRole(null);
_loginService.saveLogin(_login);
out.write("Create Login :"+_login.getId()+" Login name :"+_login.getName()+"\r\t");
*/

/*
Service _service = new Service();
boolean exist = _service.checkExistUser(system,loginid);
out.write("Check Login :"+loginid+" exist :"+exist+" \r\t");
boolean isloging = _service.ckeckLogin(system,loginid,"123456");
out.write("Check Login :"+loginid+" has loging :"+isloging+" \r\t");
*/


/*
DepartmentService depServer = new DepartmentService();
Department dep = depServer.createDepartment(system,"test department 001");
dep.setEdate(new Date());
dep.setName("department 0001");
dep.setPrincipal("SU_0000001");
dep.setRemarks("asfasdfasdfasdfasdfasdfasdfawetgasyhzxvasdyewryasdfasd");
dep.setSdate(new Date());
dep.setStatus("1");
depServer.updateDepartment(dep);

List<Department> list = depServer.getSysDepartment(system);
for(int i = 0 ;i <list.size();i++){
	out.write("</p>");
	out.write(" --- "+list.get(i).getName());
}
*/

/*
RoleService roleserver = new RoleService();
Role role = roleserver.createRole(system,"role001");
role.setDescript("test role 001");
role.setName("role 002");
role.setStatus("1");
roleserver.updateRole(system,role);

List<Role> list = roleserver.getSystemRole(system);
for(int i = 0 ;i <list.size();i++){
	out.write("</p>");
	out.write(" --- "+list.get(i).getName());
}
*/

/*
//TODO:
CaseSourceService caseService = new CaseSourceService();
CaseSource caseSource = caseService.createNewCaseSoruce(system,"test case source","SU_0000001");
caseSource.setContacter("L_asdfasdfas");
caseSource.setContacterid("L_000000001");
caseSource.setCreator("testsetst");
caseSource.setCreatorid("L_000000001");
caseSource.setDesc("asdfasdfasdfasdfaxcvasdtgweat");
caseSource.setUndertaker("asfasdfa");
caseService.updateCaseSource(caseSource);

List<CaseSource> list = caseService.getCaseSources("L_000000001");
for(int i = 0 ;i <list.size();i++){
	out.write("</p>");
	out.write(" --- "+list.get(i).getName());
}
*/

DossierService dossierService = new DossierService();
Dossier dossier = dossierService.createDossier(system,"","dossier 002");				
				dossier.setName("NAME");
				dossier.setCreator("SU_0000001");
				dossier.setcDate(new java.util.Date());
				dossier.setModify("SU_0000001");
				dossier.setmDate(null);
				dossier.setDependcase("");
				dossier.seteDate(null);
				dossier.setType("1");
				dossier.setParty("L_00000001");
				dossier.setParty_status("1");				
				dossier.setMlawyer("SU_0000001");
				dossier.setSlawyer("SU_0000002");
				dossier.setStatus("1");
				dossier.setAdmissionType("2");
				dossier.setArchiveDate(null);
				dossier.setBrief("asdfasdfasdfasdfasdf");
				dossier.setIsaid("1");
				dossier.setIsforeign("1");
				dossier.setJudge("2");
				dossier.setJudicialtype("1");
				dossier.setSummary("sdafasdfasdfasdxc111111111111111111111111111111");
				dossier.setTaget(2000);
				dossier.setCharge(200);
				
dossierService.updateDossier(dossier);

List<Dossier> list = dossierService.getUserDossier(system,"SU_0000001");





for(int i = 0 ;i <list.size();i++){
	out.write("</p>");
	out.write(" --- "+list.get(i).getName());
}


%>
</body>
</html>