<!DOCTYPE html>
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<html>
  <head>
    <title>星权办公助手</title>
    <link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />  
    <%@include file="/view/resource.jsp" %>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/css/main.css">
    <script type="text/javascript" src="<%=basePath%>/js/ux/main/main.js"></script>
  </head>
  <body class="easyui-layout">
 	<div class="ui-header" data-options="region:'north',split:true,border:false" style="height:40px;overflow: hidden;">
 	<h1>办公系统</h1>
 	<div  class="ui-login">
 		<div class="ui-login-info">
	 		欢迎 <span class="orange">${user.nickName}</span> 第[<span class="orange">${user.loginCount}</span>]次登录 |
	 		<a class="deskTop-btn dktop-icon" href="javascript:void(0);" style="padding-left: 20px;">桌面模式</a> |
	 		<a class="modify-pwd-btn"  href="javascript:void(0);">修改密码</a> |
 			<a class="logout-btn" href="<%=basePath%>/logout.shtml">退出</a>
 		</div>
 	</div>
 	</div>
	<!-- 树形菜单 -->
	<div data-options="region:'west',split:true,title:'功能导航'" style="width:140px;">
		<div id="tree-box" class="easyui-accordion" data-options="fit:true,border:false">
			<c:forEach var="item" items="${menuList}">
			<div title="${item.text}">
				<c:forEach var="node" items="${item.children}">
				<a class="menu-item" href="<%=basePath%>${node.url}">${node.text}</a>
				</c:forEach>
			</div>
			</c:forEach>
		</div>
	</div>
	<div data-options="region:'south',split:true,border:false" style="height: 30px;overflow:hidden;">
		<div class="panel-header" style="border: none;text-align: center;" >CopyRight &copy; 2020 dolphin-dragon 版权所有. &nbsp;&nbsp;官方网址: https://github.com/dolphin-dragon</div>
	</div>
	<!-- 中间内容页面 -->
	<div data-options="region:'center'" >
		<div class="easyui-tabs" id="tab-box" data-options="fit:true,border:false">
			<div title="工作台" id="dktop-box" style="padding:10px;">
			<!-- 根据菜单项创建桌面按钮 -->
			<c:forEach var="item" items="${menuList}">
			 	<div class="ftitle" >${item.text}</div>
				<%-- <p>${item.text}</p> --%>
				<div style="padding:0px 20px 20px 20px;">
				<c:forEach var="node" items="${item.children}">
				<a href="#" huref="<%=basePath%>${node.url}" class="easyui-linkbutton dktop-item" data-options="iconCls:'dktop-icon',size:'large',iconAlign:'left'">${node.text}</a>
				</c:forEach>
				</div>
			</c:forEach>
				<div style="margin-top:10px; color: red;">
					<div class="ftitle" >功能更新说明</div>
					<ul>
					    <li>1、修订流程功能，新建的流程优先显示。</li>
					    <li>2、修订工作台页面信息显示。</li>
					</ul>
				</div>
			</div>
		</div>	
	</div>
	<!--  modify password start -->
	<div id="modify-pwd-win"  class="easyui-dialog" buttons="#editPwdbtn" title="修改用户密码" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:350px;height:200px;">
		<form id="pwdForm" action="modifyPwd.do" class="ui-form" method="post">
     		 <input class="hidden" name="id">
     		 <input class="hidden" name="email">
     		 <div class="ui-edit">
	           <div class="fitem">  
	              <label>旧密码:</label>  
	              <input id="oldPwd" name="oldPwd" type="password" autocomplete="off" class="easyui-validatebox"  data-options="required:true"/>
	           </div>
	            <div class="fitem">  
	               <label>新密码:</label>  
	               <input id="newPwd" name="newPwd" type="password" autocomplete="off" class="easyui-validatebox" data-options="required:true" />
	           </div> 
	           <div class="fitem">  
	               <label>重复密码:</label>  
	              <input id="rpwd" name="rpwd" type="password" autocomplete="off" class="easyui-validatebox"   required="required" validType="equals['#newPwd']" />
	           </div> 
	         </div>
     	 </form>
     	 <div id="editPwdbtn" class="dialog-button" >  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-submit">保存</a>  
            <a href="javascript:void(0)" class="easyui-linkbutton" id="btn-pwd-close">关闭</a>  
         </div>
	</div>
	<!-- modify password end  -->
  </body>
</html>
