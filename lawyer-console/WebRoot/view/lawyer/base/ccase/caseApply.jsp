<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
  	<%@include file="/view/resource.jsp" %>
	<style type="text/css">
	.vimg_div {
/* 		width: 200px;
		height: 100px; */
		border: #000 solid 0px;
		margin: 5px auto;
		/* overflow: hidden; */
	}
	
	.vimg_div img {
		cursor: pointer;
		width: auto;
		height: auto;
		max-width: 50%;
		max-height: 50%;
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
			<label class="ui-label">当事人:</label><input name="litigant" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">被告名称:</label><input name="defendantName" class="easyui-box ui-text" style="width:100px;">
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
     <div id="edit-win" class="easyui-dialog" title="案件确立信息登记表" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:450px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="caseId">
     		 <div class="ui-edit hidden">
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
						<input name="litigant" type="text" maxlength="128" class="easyui-validatebox" data-options="required:true" missingMessage="请填写当事人" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>被告名称(全称)</label>
						<textarea name="defendantName" type="text" maxlength="1024" class="easyui-validatebox" placeholder="多被告换行分隔"  data-options="required:true" missingMessage="请填写被告名称" style="margin: 0px; width: 300px; height: 60px;"></textarea>
					</div>
					<div class="fitem">
						<label>被告注册资本</label>
						<input name="defendantRegCapital" type="text" maxlength="32" class="easyui-validatebox" placeholder="多被告空格分隔,如:20万 300万 " data-options="" missingMessage="请填写被告注册资本" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>被告所在地</label>
						<textarea name="defendantArea" type="text" maxlength="1024" class="easyui-validatebox" placeholder="多被告换行分隔"  data-options="required:true" missingMessage="请填写被告所在地" style="margin: 0px; width: 300px; height: 60px;"></textarea>
					</div>
					<div class="fitem">
						<label>案件来源</label>
						<!-- <input name="src" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写案件来源"> -->
						<select class="easyui-combobox" name="src" data-options="" editable="false" missingMessage="请填写案件来源" style="margin: 0px; width: 300px;">
                    		<option value="1" selected="selected">当事人提供</option>
                    		<option value="2">所内自行搜证</option>
                    		<option value="3">律师个人案源</option>
                   		</select>
					</div>
					<div class="fitem">
						<label>案源人</label>
						<!-- <input name="supply" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写案源人"> -->
						<input class="easyui-combobox" name="supply" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" editable="false" missingMessage="请选择案源人" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>是否公证</label>
						<select class="easyui-combobox" name="isApply" data-options="" editable="false" missingMessage="请选择是否公证" style="margin: 0px; width: 300px;">
                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
                   		</select>
					</div>
					<div class="fitem">
						<label>申请公证日期</label>
						<input name="applyDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写申请公证日期" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>公证书申请人</label>
						<input name="applicant" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写公证书申请人" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>取证人</label>
						<!-- <input name="forensics" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写取证人"> -->
						<input class="easyui-combobox" name="forensics" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" editable="false" missingMessage="请填写取证人" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>侵权类型</label>
						<!-- <input name="violateType" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写侵权类型"> -->
						<select class="easyui-combobox" name="violateType" id="violateType" data-options="" editable="false" missingMessage="请填写侵权类型" style="margin: 0px; width: 300px;">
                    		<option value="1" selected="selected">肖像权</option>
                    		<option value="2">肖像权(含名誉权)</option>
                    		<option value="3">肖像权(含姓名权)</option>
                    		<option value="4">肖像权(含姓名权、名誉权)</option>
                    		<option value="5">名誉权</option>
                    		<option value="6">不当得利纠纷</option>
                    		<option value="7">合同纠纷</option>
                   		</select>
					</div>
					<div class="fitem">
						<label>侵权概况</label>
						<textarea name="violateDesc" type="text" maxlength="3072" placeholder="请填写线上侵权链接数量、图片数量及线下侵权图片数量、载体。" class="easyui-validatebox" data-options="" missingMessage="请填写侵权概况" style="margin: 0px; width: 300px; height: 120px;"></textarea>
					</div>
					<div class="fitem">
						<label>案件可诉确认日期</label>
						<input name="actionDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写案件可诉确认日期" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<div>
							<label>案件可诉确认截图</label> 
							<input name="actionImg" type="text" id="actionImg" class="hidden" style="width: 150px;" readonly=true /> 
							<input type="button" id="uploadActionImgButton" value="上传截图" />
						</div>
					</div>
					<div class="fitem">
						<div class="vimg_div">
							<label></label>
							<img id="ck_actionImg" class="hidden"/>
						</div>
					</div>
				    <div class="fitem">
						<label>当事人确认日期</label>
						<input name="litigantAcDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写当事人确认日期" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
                        <div>
                            <label>当事人确认截图</label> 
                            <input name="litigantAcImg" type="text" id="litigantAcImg" class="hidden" style="width: 150px;" readonly=true /> 
                            <input type="button" id="uploadLitigantAcImgButton" value="上传截图" />
                        </div>
                    </div>
                    <div class="fitem">
						<div class="vimg_div">
							<label></label> 
							<img id="ck_litigantAcImg" class="hidden"/>
						</div>
					</div>
                    <div class="fitem">
						<label>当事人是否要求直接诉讼</label>
						<select class="easyui-combobox" name="isDirectAction" data-options="" editable="false" missingMessage="当事人是否要求直接诉讼" style="margin: 0px; width: 300px;">
                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
                   		</select>
					</div>
  			</div>
     	</form>
     	
     	<!-- 用于图片预览的dialog -->
	<div id="view_dialog" class="easyui-dialog" title="图片预览" data-options="resizable:true,modal:false,closed:true,closeOnEscape:false" >
   		<img id="img_id" alt="">
	</div>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-caseApply.js?var=<%=ot_ver%>"></script>

  	 <script type="text/javascript" src="<%=basePath%>/js/commons/upload/ajaxfileupload.js"></script>
     <script type="text/javascript" src="<%=basePath%>/js/commons/upload/commonfileupload.js"></script> 
     <script type="text/javascript" src="<%=basePath%>/js/commons/upload/dgfileupload.js"></script>
	<script type="text/javascript">
		$(function() {
			$("#uploadActionImgButton").click(function() {
				commonAjaxFileUploadDG(function(data) {
					//data.url data.path
					//console.log(data)
					$("#actionImg").val(data.url)
					$("#ck_actionImg").attr('src',data.url);
					$("#ck_actionImg").css("opacity","1");
					$("#ck_actionImg").show();
				})
			});

			$("#uploadLitigantAcImgButton").click(function() {
				commonAjaxFileUploadDG(function(data) {
					//data.url data.path
					//console.log(data)
					$("#litigantAcImg").val(data.url)
					$("#ck_litigantAcImg").attr('src',data.url);
					$("#ck_litigantAcImg").css("opacity","1");
					$("#ck_litigantAcImg").show();
				})
			});
		});
	</script>
</body>
</html>
