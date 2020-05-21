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
			<label class="ui-label">文件名:</label><input name="filename" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">文件路径:</label><input name="filepath" class="easyui-box ui-text" style="width:100px;">
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
     <div id="edit-win" class="easyui-dialog" title="附件信息表" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:380px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id" id="id">
     		 <div class="ui-edit">
     		 		<input type="button" id="uploadAttach" value="上传文件" />
		     	  <!--  <div class="ftitle">附件信息表</div> -->
					<div class="fitem">
						<label>文件名</label>
						<input name="filename" id="filename" type="text" maxlength="120" class="easyui-validatebox" data-options="required:true" missingMessage="请填写文件名" readonly=true style="margin: 0px; width: 200px;">
					</div>
					<div class="fitem">
						<label>文件路径</label>
						<input name="filepath" id="filepath" type="text" maxlength="1024" class="easyui-validatebox" data-options="required:true" missingMessage="请填写文件路径" readonly=true style="margin: 0px; width: 200px;">
					</div>
					<div class="fitem hidden">
						<label>扩展名</label>
						<input name="ext" id="ext" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写扩展名">
					</div>
					<div class="fitem hidden">
						<label>fileType</label>
						<input name="filetype" id="filetype" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写文件类型">
					</div>
					<div class="fitem hidden">
						<label>fileSize</label>
						<input name="size" id="size" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="文件大小">
					</div>
					<div class="fitem">
						<label>说明</label>
						<!-- <input name="note" id="note" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写说明"> -->
						<textarea name="note" type="text" maxlength="1024" class="easyui-validatebox" placeholder="多被告换行分隔"  data-options="" missingMessage="请填写说明" style="margin: 0px; width: 200px; height: 60px;"></textarea>
					</div>
					<div class="fitem hidden">
						<label>创建时间</label>
						<input name="createdTime" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写创建时间">
					</div>
					<div class="fitem hidden">
						<label>上传者</label>
						<!-- <input name="createdBy" type="text" maxlength="32" class="easyui-validatebox" data-options="required:true" missingMessage="请填写上传者"> -->
						<input class="easyui-combobox" name="createdBy" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" editable="false" missingMessage="请填写上传者">
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-sysFileAttach.js"></script>

	<script type="text/javascript" src="<%=basePath%>/js/commons/upload/ajaxfileupload.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/commons/upload/commonfileupload.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/commons/upload/dgfileupload.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#uploadAttach").click(function() {
				commonAjaxFileUploadDG(function(data) {
					//data.url data.path
					$("#filename").val(data.fname)
					$("#filepath").val(data.path);
					$("#filetype").val(data.ftype);
					$("#ext").val(data.fext);
					$("#size").val(data.fsize);
				})
			});
		});
	</script>
</body>
</html>
