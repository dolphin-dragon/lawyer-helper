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
			<label class="ui-label">案源编号:</label><input name="scode" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">案件案号:</label><input name="code" class="easyui-box ui-text" style="width:100px;">
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
     <div id="edit-win" class="easyui-dialog" title="案件信息登记数据表" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:380px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 
     		 <input class="hidden" name="createBy">
     		 <input class="hidden" name="createName">
     		 <input class="hidden" name="createDate">
     		 <input class="hidden" name="updateBy">
     		 <input class="hidden" name="updateName">
     		 <input class="hidden" name="updateDate">
     		 <input class="hidden" name="delFlag">
     		 <div class="ui-edit">
		     	  <!--  <div class="ftitle">案件信息登记数据表</div> -->
					<div class="fitem">
						<label>案源编号</label>
						<input name="scode" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写案源编号">
					</div>
					<div class="fitem">
						<label>案件案号</label>
						<input name="code" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写案件案号">
					</div>
					<div class="fitem">
						<label>案由</label>
						<input name="cause" type="text" maxlength="300" class="easyui-validatebox" data-options="" missingMessage="请填写案由">
					</div>
					<div class="fitem">
						<label>原告</label>
						<input name="plaintiff" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写原告">
					</div>
					<div class="fitem">
						<label>被告</label>
						<input name="defendant" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写被告">
					</div>
					<div class="fitem">
						<label>适用程序</label>
						<input name="cprocedure" type="text" maxlength="30" class="easyui-validatebox" data-options="" missingMessage="请填写适用程序">
					</div>
					<div class="fitem">
						<label>立案日期</label>
						<input name="caseDate" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写立案日期">
					</div>
					<div class="fitem">
						<label>开庭日期</label>
						<input name="openDate" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写开庭日期">
					</div>
					<div class="fitem">
						<label>案源编号</label>
						<input name="caseSourceId" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写案源编号">
					</div>
					<div class="fitem">
						<label>承办法官</label>
						<input name="judge" type="text" maxlength="20" class="easyui-validatebox" data-options="" missingMessage="请填写承办法官">
					</div>
					<div class="fitem">
						<label>承办律师</label>
						<input name="lawyer" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写承办律师">
					</div>
					<div class="fitem">
						<label>案件情况</label>
						<input name="cdesc" type="text" maxlength="600" class="easyui-validatebox" data-options="" missingMessage="请填写案件情况">
					</div>
					<!-- <div class="fitem">
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
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-lawCaseLegal.js"></script>
  </body>
</html>
