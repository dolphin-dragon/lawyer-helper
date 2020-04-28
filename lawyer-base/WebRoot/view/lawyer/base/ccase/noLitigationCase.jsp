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
			<label class="ui-label">删除标记:</label><input name="delFlag" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">机构编码:</label><input name="org" class="easyui-box ui-text" style="width:100px;">
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
     <div id="edit-win" class="easyui-dialog" title="非诉业务信息表" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:380px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	   <div class="ftitle">非诉业务信息表</div>
					<div class="fitem">
						<label>状态</label>
						<input name="status" type="text" maxlength="11" class="easyui-numberbox" data-options="" missingMessage="请填写状态">
					</div>
					<div class="fitem">
						<label>删除标记</label>
						<input name="delFlag" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写删除标记">
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
						<label>委托人</label>
						<input name="client" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写委托人">
					</div>
					<div class="fitem">
						<label>被委托人</label>
						<input name="principal" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写被委托人">
					</div>
					<div class="fitem">
						<label>委托开始时间</label>
						<input name="commissionSdate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写委托开始时间">
					</div>
					<div class="fitem">
						<label>委托结束时间</label>
						<input name="commissionEdate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写委托结束时间">
					</div>
					<div class="fitem">
						<label>计费模式</label>
						<input name="billingModel" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写计费模式">
					</div>
					<div class="fitem">
						<label>计费标准</label>
						<input name="billingStandard" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写计费标准">
					</div>
					<div class="fitem">
						<label>需求接收日期</label>
						<input name="receiveDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写需求接收日期">
					</div>
					<div class="fitem">
						<label>接收途径</label>
						<input name="src" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写接收途径">
					</div>
					<div class="fitem">
						<label>工作内容</label>
						<input name="workContent" type="text" maxlength="3072" class="easyui-validatebox" data-options="" missingMessage="请填写工作内容">
					</div>
					<div class="fitem">
						<label>当事人底稿名称</label>
						<input name="partyDraftName" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写当事人底稿名称">
					</div>
					<div class="fitem">
						<label>合同相对放</label>
						<input name="contractParty" type="text" maxlength="128" class="easyui-validatebox" data-options="" missingMessage="请填写合同相对放">
					</div>
					<div class="fitem">
						<label>返稿日期</label>
						<input name="respDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写返稿日期">
					</div>
					<div class="fitem">
						<label>律师返稿文件名称</label>
						<input name="respFileName" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写律师返稿文件名称">
					</div>
					<div class="fitem">
						<label>核算用时</label>
						<input name="accountTime" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写核算用时">
					</div>
					<div class="fitem">
						<label>特殊情况备注</label>
						<input name="remark" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写特殊情况备注">
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-noLitigationCase.js"></script>
  </body>
</html>
