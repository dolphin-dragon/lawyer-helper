<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include file="/view/resource.jsp" %>
  </head>
  <body class="easyui-layout">
 	 <!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
        <p class="ui-fields">
			<label class="ui-label">用户ID:</label><input name="uid" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">姓名:</label><input name="name" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">手机号码:</label><input name="phone" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">联系电话:</label><input name="tel" class="easyui-box ui-text" style="width:100px;">
	    </p>
	    <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a>
      </form>  
     </div> 
     <!--  Search panel end -->

     <!-- Data List -->
     <div region="center" border="false" >
     <table id="data-list"></table>
	 </div>
	 
     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="Basic window" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:380px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <input class="hidden" name="uid">
     		  
     		 <input class="hidden" name="createBy">
     		 <input class="hidden" name="createDate">
     		 <input class="hidden" name="updateBy">
     		 <input class="hidden" name="updateDate">
     		 <input class="hidden" name="delFlag">
     		 <div class="ui-edit">
		     	   <div class="ftitle">用户设置</div>
					<!-- <div class="fitem">
						<label>用户ID</label>
						<input name="uid" type="text" maxlength="11" class="easyui-numberbox" data-options="" missingMessage="请填写用户ID">
					</div> -->
					<div class="fitem">
						<label>姓名</label>
						<input name="name" type="text" maxlength="20" class="easyui-validatebox" data-options="" missingMessage="请填写姓名">
					</div>
					<div class="fitem">
						<label>性别</label>
						<input name="sex" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写性别">
					</div>
					<div class="fitem">
						<label>登录邮箱</label>
						<input name="email" type="text" maxlength="20" class="easyui-validatebox" data-options="" readonly="readonly" missingMessage="注册Email"  >
					</div>
					<div class="fitem">
						<label>手机号码</label>
						<input name="phone" type="text" maxlength="20" class="easyui-validatebox" data-options="" missingMessage="请填写手机号码">
					</div>
					<div class="fitem">
						<label>联系电话</label>
						<input name="tel" type="text" maxlength="20" class="easyui-validatebox" data-options="" missingMessage="请填写联系电话">
					</div>
					<div class="fitem">
						<label>QQ号码</label>
						<input name="qq" type="text" maxlength="20" class="easyui-validatebox" data-options="" missingMessage="请填写QQ号码">
					</div>
					<div class="fitem">
						<label>职位类别</label>
						<input name="position" type="text" maxlength="5" class="easyui-validatebox" data-options="" missingMessage="请填写职位类别">
					</div>
					<div class="fitem">
						<label>出生日期</label>
						<input name="birt" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写出生日期">
					</div>
					<div class="fitem">
						<label>入职时间</label>
						<input name="entrydate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写入职时间">
					</div>
					<!-- <div class="fitem">
						<label>创建者</label>
						<input name="createBy" type="text" maxlength="64" class="easyui-validatebox" data-options="required:true" missingMessage="请填写创建者">
					</div>
					<div class="fitem">
						<label>创建时间</label>
						<input name="createDate" type="text" maxlength="19" class="easyui-datetimebox" data-options="required:true" missingMessage="请填写创建时间">
					</div>
					<div class="fitem">
						<label>更新者</label>
						<input name="updateBy" type="text" maxlength="64" class="easyui-validatebox" data-options="required:true" missingMessage="请填写更新者">
					</div>
					<div class="fitem">
						<label>更新时间</label>
						<input name="updateDate" type="text" maxlength="19" class="easyui-datetimebox" data-options="required:true" missingMessage="请填写更新时间">
					</div> -->
					<div class="fitem">
						<label>备注信息</label>
						<input name="remarks" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写备注信息">
					</div>
					<!-- <div class="fitem">
						<label>删除标记</label>
						<input name="delFlag" type="text" maxlength="1" class="easyui-validatebox" data-options="required:true" missingMessage="请填写删除标记">
					</div> -->
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-sysUserExt.js"></script>
  </body>
</html>
