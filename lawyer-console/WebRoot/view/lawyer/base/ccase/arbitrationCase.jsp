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
			<label class="ui-label">序号:</label><input name="id" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">当事人:</label><input name="litigant" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">主办律师:</label><input class="easyui-combobox" name="cpSupply" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" editable="false" missingMessage="请选择主办律师">
	    </p>
	    <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a><a href="#" id="btn-reset" class="easyui-linkbutton" iconCls="icon-reload">重置</a>
      </form>  
     </div> 
     <!--  Search panel end -->

     <!-- Data List -->
     <div region="center" border="false" >
     <table id="data-list"></table>
	 </div>
	 
     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="仲裁案件信息表" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:450px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit hidden">
		     	  <!--  <div class="ftitle">仲裁案件信息表</div>
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
					</div> -->
					<div class="fitem">
						<label>案件来源</label>
						<input name="src" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写案件来源" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>案源人</label>
						<!-- <input name="supply" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写案源人"> -->
						<input class="easyui-combobox" name="supply" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" editable="false" missingMessage="请选择案源人" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>当事人</label>
						<input name="litigant" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写当事人" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>案由</label>
						<textarea name="cause" type="text" maxlength="3072" class="easyui-validatebox" data-options="" missingMessage="请填写案由" style="margin: 0px; width: 300px; height: 60px;"></textarea>
					</div>
					<div class="fitem">
						<label>申请人</label>
						<input name="applicant" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写申请人" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>被申请人</label>
						<input name="respondent" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写被申请人" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>反请求状况</label>
						<input name="request" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写反请求状况" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>委托协议日期</label>
						<input name="trustDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写委托协议日期" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>主办律师</label>
						<!-- <input name="lawyer" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写主办律师"> -->
						<input class="easyui-combobox" name="lawyer" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" editable="false" missingMessage="请填写主办律师" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>出庭代理人</label>
						<input name="agent" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写出庭代理人" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>首席仲裁员</label>
						<input name="chiefArbitrator" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写首席仲裁员" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>我方边裁</label>
						<input name="ourSide" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写我方边裁" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>对方边裁</label>
						<input name="otherSide" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写对方边裁" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>仲裁秘书</label>
						<input name="arbSecretary" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写仲裁秘书" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>仲裁秘书联系方式</label>
						<input name="secretaryContact" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写仲裁秘书联系方式" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>开庭次数</label>
						<input name="opCourtNums" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写开庭次数" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>开庭日期</label>
						<input name="opCourtDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写开庭日期" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>结案方式</label>
						<input name="closType" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写结案方式" style="margin: 0px; width: 300px;">
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-arbitrationCase.js?var=<%=ot_ver%>"></script>
  </body>
</html>
