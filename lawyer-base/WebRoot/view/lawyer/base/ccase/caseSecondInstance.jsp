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
		     	   <div class="ftitle">案件二审阶段信息</div>
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
						<label>二审主办律师</label>
						<input name="lawyer" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写二审主办律师">
					</div>
					<div class="fitem">
						<label>二审开庭日期</label>
						<input name="sCourtDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写二审开庭日期">
					</div>
					<div class="fitem">
						<label>主办法官</label>
						<input name="judge" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写主办法官">
					</div>
					<div class="fitem">
						<label>联系方式</label>
						<input name="judgeContact" type="text" maxlength="128" class="easyui-validatebox" data-options="" missingMessage="请填写联系方式">
					</div>
					<div class="fitem">
						<label>二审判决生效日期</label>
						<input name="sJudgmentEffectiveDate" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写二审判决生效日期">
					</div>
					<div class="fitem">
						<label>是否致歉</label>
						<input name="isApology" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写是否致歉">
					</div>
					<div class="fitem">
						<label>一审被告赔偿总额</label>
						<input name="defendantCompensationTotal" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写一审被告赔偿总额">
					</div>
					<div class="fitem">
						<label>一审被告承担合理开支费用</label>
						<input name="defendantExpenses" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写一审被告承担合理开支费用">
					</div>
					<div class="fitem">
						<label>一审原告承担诉费</label>
						<input name="plaintiffCosts" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写一审原告承担诉费">
					</div>
					<div class="fitem">
						<label>一审被告承担诉费</label>
						<input name="defendantCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写一审被告承担诉费">
					</div>
					<div class="fitem">
						<label>是否结案</label>
						<input name="isClose" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写是否结案">
					</div>
					<div class="fitem">
						<label>执行截止日期</label>
						<input name="executionDeadline" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写执行截止日期">
					</div>
					<div class="fitem">
						<label>备注</label>
						<input name="remark" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写备注">
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-caseSecondInstance.js"></script>
  </body>
</html>
