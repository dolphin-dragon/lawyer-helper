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
	    <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a><a href="#" id="btn-reset" class="easyui-linkbutton" iconCls="icon-reload">重置</a>
      </form>  
     </div> 
     <!--  Search panel end -->

     <!-- Data List -->
     <div region="center" border="false" >
     <table id="data-list"></table>
	 </div>
	 
     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="会议基本信息表" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:450px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit hidden">
		     	   <div class="ftitle">会议基本信息表</div>
					<div class="fitem">
						<label>状态</label>
						<input name="status" type="text" maxlength="11" class="easyui-numberbox" data-options="" missingMessage="请填写状态" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>删除标记</label>
						<input name="delFlag" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写删除标记" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>机构编码</label>
						<input name="org" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写机构编码" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>创建人</label>
						<input name="createdBy" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写创建人" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>创建时间</label>
						<input name="createdTime" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写创建时间" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>更新人</label>
						<input name="updatedBy" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写更新人" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>更新时间</label>
						<input name="updatedTime" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写更新时间" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>会议名称</label>
						<input name="mtName" type="text" maxlength="128" class="easyui-validatebox" data-options="" missingMessage="请填写会议名称" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>会议发起人</label>
						<input name="mtSponsor" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写会议发起人" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>会议参会人列表</label>
						<input name="mtMembers" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写会议参会人列表" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>会议议题</label>
						<input name="mtTopics" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写会议议题" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>会议室</label>
						<input name="mtrId" type="text" maxlength="11" class="easyui-numberbox" data-options="" missingMessage="请填写会议室" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>会议预定开始时间</label>
						<input name="mtStartTime" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写会议预定开始时间" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>会议预定结束时间</label>
						<input name="mtEndTime" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写会议预定结束时间" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>会议决议内容</label>
						<input name="mtResolution" type="text" maxlength="3072" class="easyui-validatebox" data-options="" missingMessage="请填写会议决议内容" style="margin: 0px; width: 300px;">
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-meetingInfo.js?var=<%=ot_ver%>"></script>
  </body>
</html>
