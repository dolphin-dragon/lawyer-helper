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
			<label class="ui-label">状态:</label><input name="status" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">机构编码:</label><input name="org" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">创建人:</label><input name="createdBy" class="easyui-box ui-text" style="width:100px;">
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
     		 <div class="ui-edit">
		     	   <div class="ftitle">用户信息设置</div>
					<div class="fitem">
						<label>状态</label>
						<input name="status" type="text" maxlength="11" class="easyui-numberbox" data-options="" missingMessage="请填写状态">
					</div>
					<div class="fitem">
						<label>机构编码</label>
						<input name="org" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写机构编码">
					</div>
					<div class="fitem">
						<label>创建人</label>
						<input name="createdBy" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写创建人">
					</div>
					<div class="fitem">
						<label>创建时间</label>
						<input name="createdTime" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写创建时间">
					</div>
					<div class="fitem">
						<label>更新人</label>
						<input name="updatedBy" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写更新人">
					</div>
					<div class="fitem">
						<label>更新时间</label>
						<input name="updatedTime" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写更新时间">
					</div>
					<div class="fitem">
						<label>用户id</label>
						<input name="uid" type="text" maxlength="11" class="easyui-numberbox" data-options="required:true" missingMessage="请填写用户id">
					</div>
					<div class="fitem">
						<label>姓名</label>
						<input name="name" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写姓名">
					</div>
					<div class="fitem">
						<label>性别</label>
						<input name="sex" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写性别">
					</div>
					<div class="fitem">
						<label>手机号</label>
						<input name="phone" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写手机号">
					</div>
					<div class="fitem">
						<label>联系电话</label>
						<input name="tel" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写联系电话">
					</div>
					<div class="fitem">
						<label>qq号码</label>
						<input name="qq" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写qq号码">
					</div>
					<div class="fitem">
						<label>职位类别</label>
						<input name="position" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写职位类别">
					</div>
					<div class="fitem">
						<label>入职时间</label>
						<input name="entryDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写入职时间">
					</div>
					<div class="fitem">
						<label>出生日期</label>
						<input name="birt" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写出生日期">
					</div>
					<div class="fitem">
						<label>备注</label>
						<input name="remark" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写备注">
					</div>
					<div class="fitem">
						<label>删除标记</label>
						<input name="delFlg" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写删除标记">
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-sysUserExt.js"></script>
  </body>
</html>
