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
     <div id="edit-win" class="easyui-dialog" title="案件确立信息登记表" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:460px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="caseId">
     		 <div class="ui-edit">
		     	   <!-- <div class="ftitle">案件确立阶段信息</div> -->
<!-- 					<div class="fitem">
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
					</div> -->
					<div class="fitem">
						<label>当事人</label>
						<input name="litigant" type="text" maxlength="128" class="easyui-validatebox" data-options="" missingMessage="请填写当事人">
					</div>
					<div class="fitem">
						<label>被告名称(全称)</label>
						<input name="defendantName" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写被告名称">
					</div>
					<div class="fitem">
						<label>被告注册资本</label>
						<input name="defendantRegCapital" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写被告注册资本">
					</div>
					<div class="fitem">
						<label>被告所在地</label>
						<textarea name="defendantArea" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写被告所在地" style="margin: 0px; width: 150px; height: 60px;"></textarea>
					</div>
					<div class="fitem">
						<label>案件来源</label>
						<!-- <input name="src" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写案件来源"> -->
						<select class="easyui-combobox" name="src" data-options="required:true" missingMessage="请填写案件来源">
                    		<option value="1" selected="selected">当事人提供</option>
                    		<option value="2">所内自行搜证</option>
                    		<option value="3">律师个人案源</option>
                   		</select>
					</div>
					<div class="fitem">
						<label>案源人</label>
						<!-- <input name="supply" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写案源人"> -->
						<input class="easyui-combobox" name="supply" data-options="required:true,valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请选择案源人">
					</div>
					<div class="fitem">
						<label>申请公证日期</label>
						<input name="applyDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写申请公证日期">
					</div>
					<div class="fitem">
						<label>公证书申请人</label>
						<!-- <input name="applicant" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写公证书申请人"> -->
						<input class="easyui-combobox" name="applicant" data-options="required:true,valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请填写公证书申请人">
					</div>
					<div class="fitem">
						<label>取证人</label>
						<!-- <input name="forensics" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写取证人"> -->
						<input class="easyui-combobox" name="forensics" data-options="required:true,valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请填写取证人">
					</div>
					<div class="fitem">
						<label>侵权类型</label>
						<!-- <input name="violateType" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写侵权类型"> -->
						<select class="easyui-combobox" name="violateType" data-options="required:true" missingMessage="请填写侵权类型">
                    		<option value="1" selected="selected">肖像权</option>
                    		<option value="2">肖像权(含名誉权)</option>
                    		<option value="3">肖像权(含姓名权)</option>
                    		<option value="4">肖像权(含姓名权、名誉权)</option>
                    		<option value="5">名誉权</option>
                   		</select>
					</div>
					<div class="fitem">
						<label>侵权概况</label>
						<textarea name="violateDesc" type="text" maxlength="3072" placeholder="请填写线上侵权链接数量、图片数量及线下侵权图片数量、载体。" class="easyui-validatebox" data-options="" missingMessage="请填写侵权概况" style="margin: 0px; width: 150px; height: 60px;"></textarea>
					</div>
					<div class="fitem">
						<label>案件可诉确认日期</label>
						<input name="actionDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写案件可诉确认日期">
					</div>
					<div class="fitem">
						<div>
							<label>案件可诉确认截图</label> 
							<input name="actionImg" type="text" id="actionImg" style="width: 150px;" readonly=true /> 
							<input type="button" id="uploadActionImgButton" value="上传截图" />
						</div>
					</div>
				    <div class="fitem">
						<label>当事人确认日期</label>
						<input name="litigantAcDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写当事人确认日期">
					</div>
					<div class="fitem">
                        <div>
                            <label>当事人确认截图</label> 
                            <input name="litigantAcImg" type="text" id="litigantAcImg" style="width: 150px;" readonly=true /> 
                            <input type="button" id="uploadLitigantAcImgButton" value="上传截图" />
                        </div>
                    </div>
                    <div class="fitem">
						<label>当事人是否要求直接诉讼</label>
						<select class="easyui-combobox" name="isDirectAction" data-options="" missingMessage="当事人是否要求直接诉讼">
                    		<option value="1">直接诉讼</option>
                    		<option value="2" selected="selected">不直接诉讼</option>
                   		</select>
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-caseApply.js"></script>

  	 <script type="text/javascript" src="<%=basePath%>/js/commons/upload/ajaxfileupload.js"></script>
     <script type="text/javascript" src="<%=basePath%>/js/commons/upload/commonfileupload.js"></script> 
     <script type="text/javascript" src="<%=basePath%>/js/commons/upload/dgfileupload.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#uploadActionImgButton").click(function() {
				commonAjaxFileUploadDG(function(data) {
					//data.url data.path
					console.log(data)
					$("#actionImg").val(data.url)
				})
			});

			$("#uploadLitigantAcImgButton").click(function() {
				commonAjaxFileUploadDG(function(data) {
					//data.url data.path
					console.log(data)
					$("#litigantAcImg").val(data.url)
				})
			});
		})
	</script>
</body>
</html>
