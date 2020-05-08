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
			<label class="ui-label">字典名称:</label><input name="dictName" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">字典编码:</label><input name="dictCode" class="easyui-box ui-text" style="width:100px;">
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
     <div id="edit-win" class="easyui-dialog" title="字典信息表" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:380px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	   <!-- <div class="ftitle">字典信息表</div> -->
					<div class="fitem">
						<label>字典名称</label>
						<input name="dictName" type="text" maxlength="100" class="easyui-validatebox" data-options="" missingMessage="请填写字典名称">
					</div>
					<div class="fitem">
						<label>字典编码</label>
						<input name="dictCode" type="text" maxlength="100" class="easyui-validatebox" data-options="" missingMessage="请填写字典编码">
					</div>
					<div class="fitem">
						<label>描述</label>
						<input name="description" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写描述">
					</div>
					<!-- <div class="fitem">
						<label>删除标记 1删除 0正常</label>
						<input name="delFlag" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写删除标记 1删除 0正常">
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
						<label>字典类型0为string,1为number</label>
						<input name="type" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写字典类型0为string,1为number">
					</div> -->
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-sysDict.js"></script>
  </body>
</html>
