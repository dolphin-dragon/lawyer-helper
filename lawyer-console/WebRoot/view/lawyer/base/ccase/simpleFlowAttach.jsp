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
			<label class="ui-label">流程id:</label><input name="sflowId" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">附件id:</label><input name="sfileAttachId" class="easyui-box ui-text" style="width:100px;">
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
     <div id="edit-win" class="easyui-dialog" title="简单流程关联附件信息表" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:450px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit hidden">
		     	   <div class="ftitle">简单流程关联附件信息表</div>
					<div class="fitem">
						<label>流程id</label>
						<input name="sflowId" type="text" maxlength="11" class="easyui-numberbox" data-options="" missingMessage="请填写流程id">
					</div>
					<div class="fitem">
						<label>附件id</label>
						<input name="sfileAttachId" type="text" maxlength="11" class="easyui-numberbox" data-options="" missingMessage="请填写附件id">
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-simpleFlowAttach.js?var=<%=ot_ver%>"></script>
  </body>
</html>
