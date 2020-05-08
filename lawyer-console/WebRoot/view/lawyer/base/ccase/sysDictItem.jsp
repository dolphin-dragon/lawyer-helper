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
			<label class="ui-label">字典id:</label><input name="dictId" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">字典项文本:</label><input name="itemText" class="easyui-box ui-text" style="width:100px;">
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
     <div id="edit-win" class="easyui-dialog" title="字典项目信息表" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:300px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	<!--    <div class="ftitle">字典项目信息表</div> -->
					<div class="fitem">
						<label>字典标识</label>
						<input name="dictId" id="dictId" type="text" maxlength="11" class="easyui-validatebox" data-options="" missingMessage="请填写字典id">
					</div>
					<div class="fitem">
						<label>字典名称</label>
						<input name="dictName" id="dictName" type="text" maxlength="100" class="easyui-validatebox" data-options="" missingMessage="请填写字典名称">
					</div>
					<div class="fitem">
						<label>字典编码</label>
						<input name="dictCode" id="dictCode" type="text" maxlength="100" class="easyui-validatebox" data-options="" missingMessage="请填写字典编码">
					</div>
					<div class="fitem">
						<label>字典项名称</label>
						<input name="itemText" type="text" maxlength="100" class="easyui-validatebox" data-options="" missingMessage="请填写字典项文本">
					</div>
					<div class="fitem">
						<label>字典项编码</label>
						<input name="itemValue" type="text" maxlength="100" class="easyui-validatebox" data-options="" missingMessage="请填写字典项值">
					</div>
					<div class="fitem">
						<label>描述</label>
						<input name="description" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写描述">
					</div>
					<!-- <div class="fitem">
						<label>排序</label>
						<input name="sortOrder" type="text" maxlength="10" class="easyui-numberbox" data-options="" missingMessage="请填写排序">
					</div>
					<div class="fitem">
						<label>状态（1启用 0不启用）</label>
						<input name="status" type="text" maxlength="11" class="easyui-numberbox" data-options="" missingMessage="请填写状态（1启用 0不启用）">
					</div>
					<div class="fitem">
						<label>删除标记 1删除 0正常</label>
						<input name="delFlag" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写删除标记 1删除 0正常">
					</div>
					<div class="fitem">
						<label>created_by</label>
						<input name="createdBy" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写created_by">
					</div>
					<div class="fitem">
						<label>created_time</label>
						<input name="createdTime" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写created_time">
					</div>
					<div class="fitem">
						<label>updated_by</label>
						<input name="updatedBy" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写updated_by">
					</div>
					<div class="fitem">
						<label>updated_time</label>
						<input name="updatedTime" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写updated_time">
					</div> -->
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-sysDictItem.js"></script>
  </body>
</html>
