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
		     	   <div class="ftitle">案件确立阶段信息</div>
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
						<label>案件序号</label>
						<input name="caseId" type="text" maxlength="11" class="easyui-numberbox" data-options="required:true" missingMessage="请填写案件序号">
					</div>
					<div class="fitem">
						<label>案件来源</label>
						<input name="src" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写案件来源">
					</div>
					<div class="fitem">
						<label>案源人</label>
						<input name="supply" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写案源人">
					</div>
					<div class="fitem">
						<label>申请公证日期</label>
						<input name="applyDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写申请公证日期">
					</div>
					<div class="fitem">
						<label>公证书申请人</label>
						<input name="applicant" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写公证书申请人">
					</div>
					<div class="fitem">
						<label>取证人</label>
						<input name="forensics" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写取证人">
					</div>
					<div class="fitem">
						<label>侵权类型</label>
						<input name="violateType" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写侵权类型">
					</div>
					<div class="fitem">
						<label>侵权概况</label>
						<input name="violateDesc" type="text" maxlength="3072" class="easyui-validatebox" data-options="" missingMessage="请填写侵权概况">
					</div>
					<div class="fitem">
						<label>案件可诉确认日期</label>
						<input name="actionDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写案件可诉确认日期">
					</div>
					<div class="fitem">
						<label>当事人确认日期</label>
						<input name="litigantAcDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写当事人确认日期">
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-caseApply.js"></script>
  </body>
</html>
