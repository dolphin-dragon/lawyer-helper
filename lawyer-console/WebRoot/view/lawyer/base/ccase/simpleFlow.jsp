<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include file="/view/resource.jsp" %>
   	<style type="text/css">
	.vimg_div {
		height: 100px;
		border: #000 solid 0px;
		margin: 5px auto;
		/* overflow: hidden; */
	}
	
	.vimg_div img {
		cursor: pointer;
		transition: all 0.6s;
	}
	
	.vimg_div img:hover {
		transform: scale(2);
	}
	</style>
  </head>
  <body class="easyui-layout">
 	 <!-- Search panel start -->
 	 <div class="ui-search-panel" region="north" style="height: 80px;" title="过滤条件" data-options="striped: true,collapsible:false,iconCls:'icon-search',border:false" >  
 	 <form id="searchForm">
        <p class="ui-fields">
			<label class="ui-label">审批事项:</label><input class="easyui-combobox" name="title" data-options="valueField:'itemValue',textField:'itemText',url:'<%=basePath %>/sysDictItem/listItems.do?dictCode=SIP_AUDIT_ITEM'" editable="false" missingMessage="请填审批事项类型">
			<label class="ui-label">事项内容:</label><input name="note" class="easyui-box ui-text" style="width:100px;">
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
     <div id="edit-win" class="easyui-dialog" title="流程信息" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:460px;height:400px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id" >
     		 <div class="ui-edit">
		     	  <!--  <div class="ftitle">简单流程信息表</div> -->
					<div class="fitem">
						<label>审批事项</label>
						<!-- <input name="title" type="text" maxlength="120" class="easyui-validatebox" data-options="required:true" missingMessage="请填写流程标题" style="margin: 0px; width: 200px;"> -->
						<input class="easyui-combobox" name="title" data-options="required:true,valueField:'itemValue',textField:'itemText',url:'<%=basePath %>/sysDictItem/listItems.do?dictCode=SIP_AUDIT_ITEM'" editable="false" missingMessage="请填写审批事项"  style="margin: 0px; width: 200px;">
					</div>
					<div class="fitem">
						<label>事项内容</label>
						<textarea name="note" type="text" maxlength="1024" class="easyui-validatebox" data-options="required:true" missingMessage="请填写流程说明" style="margin: 0px; width: 200px; height: 80px;"></textarea>
					</div>
					<div class="fitem">
						<label>文件类型/事项类型</label>
						<input class="easyui-combobox" name="ftype" data-options="required:true,valueField:'itemValue',textField:'itemText',url:'<%=basePath %>/sysDictItem/listItems.do?dictCode=SIP_AUDIT_TYPE'" editable="false" missingMessage="请填写流程业务类型"  style="margin: 0px; width: 200px;">
					</div>
					<div class="fitem">
						<div>
							<label>文件审核截图</label> 
							<input name="fileAckImg" type="text" id="fileAckImg" class="hidden" style="width: 200px;" readonly=true /> 
							<input type="button" id="uploadFileAckImgButton" value="上传截图" />
						</div>
					</div>
					<div class="fitem vimg_div">
						<!-- <div class="vimg_div"> -->
							<label></label>
							<img id="ck_fileAckImg" class="hidden"/>
					<!-- 	</div> -->
					</div>
					<div class="fitem">
						<div>
							<label>业务确认截图</label> 
							<input name="bizAckImg" type="text" id="bizAckImg" class="hidden" style="width: 200px;" readonly=true /> 
							<input type="button" id="uploadBizAckImgButton" value="上传截图" />
						</div>
					</div>
					<div class="fitem">
						<div class="vimg_div">
							<label></label>
							<img id="ck_bizAckImg" class="hidden" style="width:200px;height:100px;"/>
						</div>
					</div>
					<div class="fitem">
						<label>审批人</label>
						<input class="easyui-combobox" name="approver" data-options="required:true,valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatasByRoleId.do?roleId=27'" editable="false" missingMessage="请填写审批人"  style="margin: 0px; width: 200px;">
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
					<div class="fitem">
							<label>附件</label>
							<!-- <input class="hidden" name="attachs" id="attachs"> -->
							<div style="height:160px; width:200px;padding-left: 100px;">
								<table id="attachs-list"></table>
								<div name="v_attachs" id="v_attachs">
								</div>
							</div>
					</div>
					<div class="fitem">
						<label>备注</label>
						<textarea name="remark" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写备注" style="margin: 0px; width: 200px; height: 60px;"></textarea>
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-simpleFlow.js"></script>
  	 
  	 <script type="text/javascript" src="<%=basePath%>/js/commons/upload/ajaxfileupload.js"></script>
     <script type="text/javascript" src="<%=basePath%>/js/commons/upload/commonfileupload.js"></script> 
     <script type="text/javascript" src="<%=basePath%>/js/commons/upload/dgfileupload.js"></script>
	 <script type="text/javascript">
		$(function() {
			$("#uploadFileAckImgButton").click(function() {
				commonAjaxFileUploadDG(function(data) {
					//data.url data.path
					$("#fileAckImg").val(data.url)
					$("#ck_fileAckImg").attr('src',data.url);
					//style="width:200px;height:100px;"
					$("#ck_fileAckImg").css("opacity","1").css("width","200px").css("height","100px");
					$("#ck_fileAckImg").show();
				})
			});

			$("#uploadBizAckImgButton").click(function() {
				commonAjaxFileUploadDG(function(data) {
					//data.url data.path
					$("#bizAckImg").val(data.url)
					$("#ck_bizAckImg").attr('src',data.url);
					$("#ck_bizAckImg").css("opacity","1");
					$("#ck_bizAckImg").show();
				})
			});
		});
	 </script>
  </body>
</html>
