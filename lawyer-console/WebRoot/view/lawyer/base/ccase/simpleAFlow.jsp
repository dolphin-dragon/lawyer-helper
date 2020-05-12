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
        	<label class="ui-label">流程号:</label><input name="id" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">流程名称:</label><input name="title" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">流程说明:</label><input name="note" class="easyui-box ui-text" style="width:100px;">
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
     <div id="edit-win" class="easyui-dialog" title="流程信息" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:380px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <input class="hidden" name="typeIds" id="typeIds">
     		 <div class="ui-edit">
		     	  <!--  <div class="ftitle">简单流程信息表</div> -->
					<div class="fitem">
						<label>名称</label>
						<input name="title" type="text" maxlength="120" class="easyui-validatebox" data-options="required:true" missingMessage="请填写流程标题" style="margin: 0px; width: 200px;">
					</div>
					<div class="fitem">
						<label>说明</label>
						<textarea name="note" type="text" maxlength="1024" class="easyui-validatebox" data-options="required:true" missingMessage="请填写流程说明" style="margin: 0px; width: 200px; height: 60px;"></textarea>
					</div>
					<div class="fitem">
						<label>流程类型</label>
						<!-- 
						<input name="ftype" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写流程业务类型"> 
						-->
						<input class="easyui-combobox" name="ftype" data-options="required:true,valueField:'itemValue',textField:'itemText',url:'<%=basePath %>/sysDictItem/listItems.do?dictCode=SIMPLE_FLOW'" missingMessage="请填写流程业务类型"  style="margin: 0px; width: 200px;">
					</div>
					<div class="fitem">
						<label>审批人</label>
						<!-- <input name="approver" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写审批人"> -->
						<input class="easyui-combobox" name="approver" data-options="required:true,valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请填写审批人"  style="margin: 0px; width: 200px;">
					</div>
					<!--
					<div class="fitem">
						<label>创建时间</label>
						<input name="createdTime" type="text" maxlength="19" class="easyui-datetimebox" data-options="required:true" missingMessage="请填写创建时间">
					</div>
					<div class="fitem">
						<label>发起人</label>
						<input name="createdBy" type="text" maxlength="32" class="easyui-validatebox" data-options="required:true" missingMessage="请填写发起人">
					</div>
					<div class="fitem">
						<label>删除标记 1删除 0正常</label>
						<input name="delFlag" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写删除标记 1删除 0正常">
					</div>
					<div class="fitem">
						<label>状态（0草稿 1待审批 2审批通过 9驳回）</label>
						<input name="status" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写状态（0草稿 1待审批 2审批通过 9驳回）">
					</div>
					-->
					<div class="fitem">
						<label>备注</label>
						<textarea name="remark" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写备注" style="margin: 0px; width: 200px; height: 60px;"></textarea>
					</div>
					<!-- 
					<div class="fitem">
						<label>更新人</label>
						<input name="updatedBy" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写更新人">
					</div>
					<div class="fitem">
						<label>更新时间</label>
						<input name="updatedTime" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写更新时间">
					</div>
					-->
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-simpleAFlow.js"></script>
  </body>
</html>
