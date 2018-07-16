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
			<label class="ui-label">案源编码:</label><input name="code" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">案源名称:</label><input name="title" class="easyui-box ui-text" style="width:100px;">
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
		     	   <div class="ftitle">案源信息收集数据表</div>
					<div class="fitem">
						<label>案源编码</label>
						<input name="code" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写案源编码">
					</div>
					<div class="fitem">
						<label>案源名称</label>
						<input name="title" type="text" maxlength="120" class="easyui-validatebox" data-options="required:true" missingMessage="请填写案源名称">
					</div>
					<div class="fitem">
						<label>案源描述</label>
						<input name="cDesc" type="text" maxlength="900" class="easyui-validatebox" data-options="" missingMessage="请填写案源描述">
					</div>
					<div class="fitem">
						<label>案源接收日期</label>
						<input name="recordDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写案源接收日期">
					</div>
					<div class="fitem">
						<label>结案日期</label>
						<input name="closeDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写结案日期">
					</div>
					<div class="fitem">
						<label>回款日期</label>
						<input name="receiveDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写回款日期">
					</div>
					<div class="fitem">
						<label>主办律师</label>
						<input name="mLawyer" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写主办律师">
					</div>
					<div class="fitem">
						<label>案源提供者</label>
						<input name="provider" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写案源提供者">
					</div>
					<div class="fitem">
						<label>处理状态</label>
						<input name="status" type="text" maxlength="2" class="easyui-validatebox" data-options="required:true" missingMessage="请填写处理状态">
					</div>
					<div class="fitem">
						<label>创建者ID</label>
						<input name="createBy" type="text" maxlength="64" class="easyui-validatebox" data-options="required:true" missingMessage="请填写创建者ID">
					</div>
					<div class="fitem">
						<label>创建人</label>
						<input name="createName" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写创建人">
					</div>
					<div class="fitem">
						<label>创建时间</label>
						<input name="createDate" type="text" maxlength="19" class="easyui-datetimebox" data-options="required:true" missingMessage="请填写创建时间">
					</div>
					<div class="fitem">
						<label>修改人ID</label>
						<input name="updateBy" type="text" maxlength="64" class="easyui-validatebox" data-options="required:true" missingMessage="请填写修改人ID">
					</div>
					<div class="fitem">
						<label>修改人</label>
						<input name="updateName" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写修改人">
					</div>
					<div class="fitem">
						<label>修改时间</label>
						<input name="updateDate" type="text" maxlength="19" class="easyui-datetimebox" data-options="required:true" missingMessage="请填写修改时间">
					</div>
					<div class="fitem">
						<label>备注信息</label>
						<input name="remarks" type="text" maxlength="255" class="easyui-validatebox" data-options="" missingMessage="请填写备注信息">
					</div>
					<div class="fitem">
						<label>删除标记</label>
						<input name="delFlag" type="text" maxlength="1" class="easyui-validatebox" data-options="required:true" missingMessage="请填写删除标记">
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-lawCaseSource.js"></script>
  </body>
</html>
