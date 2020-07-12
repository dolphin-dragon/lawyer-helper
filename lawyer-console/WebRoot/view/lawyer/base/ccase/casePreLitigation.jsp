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
     <div id="edit-win" class="easyui-dialog" title="诉前和解记录表" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:450px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="caseId">
     		 <div class="ui-edit hidden">
		     	   <!-- <div class="ftitle">案件诉前和解信息</div>
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
					</div> -->
					<div class="fitem">
						<label>当事人</label>
						<input name="litigant" type="text" maxlength="128" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写当事人" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>被告名称(全称)</label>
						<input name="defendantName" type="text" maxlength="1024" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写被告名称" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>被告注册资本</label>
						<input name="defendantRegCapital" type="text" maxlength="32" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写被告注册资本" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>被告所在地</label>
						<textarea name="defendantArea" type="text" maxlength="1024" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写被告所在地" style="margin: 0px; width: 300px; height: 60px;"></textarea>
					</div>
					<div class="fitem">
						<label>律师函编号</label>
						<input name="letter" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写律师函编号" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>律师函主办人</label>
						<!-- <input name="letteror" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写律师函主办人"> -->
						<input class="easyui-combobox" editable="false"  name="letteror" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请填写律师函主办人" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>律师函发送日期</label>
						<input name="sendDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写律师函发送日期" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>律师函送达日期</label>
						<input name="deliveryDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写律师函送达日期" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>是否结案</label>
						<select class="easyui-combobox" editable="false"  name="isClose" data-options="" missingMessage="请填写是否结案" style="margin: 0px; width: 300px;">
                    		<option value="1" selected="selected">&ensp;&ensp;是&ensp;&ensp;</option>
                    		<option value="2">&ensp;&ensp;否&ensp;&ensp;</option>
                   		</select>
					</div>
					<div class="fitem">
						<label>是否诉讼</label>
						<select class="easyui-combobox" editable="false"  name="isDirectAction" data-options="" missingMessage="请填写是否诉讼" style="margin: 0px; width: 300px;">
                    		<option value="1" selected="selected">&ensp;&ensp;是&ensp;&ensp;</option>
                    		<option value="2">&ensp;&ensp;否&ensp;&ensp;</option>
                   		</select>
					</div>
					<div class="fitem">
						<label>备注</label>
						<textarea name="remark" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写备注" style="margin: 0px; width: 300px; height: 60px;"></textarea>
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-casePreLitigation.js?var=<%=ot_ver%>"></script>
  </body>
</html>
