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
     <div id="edit-win" class="easyui-dialog" title="一审信息记录表" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:450px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="caseId">
     		 <div class="ui-edit hidden">
		     	   <!-- <div class="ftitle">案件一审阶段信息</div>
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
						<textarea name="defendantName" type="text" maxlength="1024" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写被告名称" style="margin: 0px; width: 300px; height: 60px;"></textarea>
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
						<label>第一责任人</label>
						<input name="firstor" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写第一责任人" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>一审主办律师</label>
						<!-- <input name="lawyer" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写一审主办律师"> -->
						<input class="easyui-combobox" editable="false"  name="lawyer" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请填写一审主办律师" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>提交立案材料日期</label>
						<input name="submitDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写提交立案材料日期" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>是否诉前调解</label>
						<select class="easyui-combobox" editable="false"  name="isPreMediation" data-options="" missingMessage="请填写是否诉前调解" style="margin: 0px; width: 300px;">
                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
                   		</select>
					</div>
					<div class="fitem">
						<label>立案日期</label>
						<input name="establishDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写立案日期" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>是否诉中调解</label>
						<select class="easyui-combobox" editable="false"  name="isActionMediation" data-options="" missingMessage="请填写是否诉中调解" style="margin: 0px; width: 300px;">
                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
                   		</select>
					</div>
					<div class="fitem">
						<label>调解书日期</label>
						<input name="mediationDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写调解书日期" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>诉讼费用</label>
						<input name="litigationCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写诉讼费用" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>公告费用</label>
						<input name="announcementCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写公告费用" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>公证费用</label>
						<input name="notaryCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写公证费用" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>其它费用</label>
						<input name="otherCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写其它费用" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>受理法院</label>
						<textarea name="adjudicationCourt" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写受理法院" style="margin: 0px; width: 300px; height: 60px;"></textarea>
					</div>
					<div class="fitem">
						<label>主办法官</label>
						<input name="judge" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写主办法官" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>联系方式</label>
						<input name="judgeContact" type="text" maxlength="128" class="easyui-validatebox" data-options="" missingMessage="请填写联系方式" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>一审开庭日期</label>
						<input name="fcourtDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写一审开庭日期" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>一审判决书落款日期</label>
						<input name="fverdictDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写一审判决书落款日期" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>一审判决书收到日期</label>
						<input name="fverdictReceiveDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写一审判决书收到日期" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>是否致歉</label>
						<!-- <input name="isApology" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写是否致歉"> -->
						<select class="easyui-combobox" editable="false"  name="isApology" data-options="" missingMessage="请填写是否致歉" style="margin: 0px; width: 300px;">
                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
                   		</select>
					</div>
					<div class="fitem">
						<label>被告赔偿总额</label>
						<input name="defendantCompensationTotal" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写被告赔偿总额" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>被告承担合理开支总额</label>
						<input name="defendantExpenses" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写被告承担合理开支总额" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>原告承担诉费</label>
						<input name="plaintiffCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写原告承担诉费" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>被告承担诉费</label>
						<input name="defendantCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写被告承担诉费" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>是否结案</label>
						<!-- <input name="isClose" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写是否结案"> -->
						<select class="easyui-combobox" editable="false"  name="isClose" data-options="" missingMessage="请填写是否结案" style="margin: 0px; width: 300px;">
                    		<option value="1" selected="selected">&ensp;&ensp;是&ensp;&ensp;</option>
                    		<option value="2">&ensp;&ensp;否&ensp;&ensp;</option>
                   		</select>
					</div>
					<div class="fitem">
						<label>上诉截止日期</label>
						<input name="appealDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写上诉截止日期" style="margin: 0px; width: 300px;">
					</div>
					<div class="fitem">
						<label>是否上诉</label>
						<select class="easyui-combobox" editable="false"  name="isAppeal" data-options="" missingMessage="请填写是否上诉" style="margin: 0px; width: 300px;">
                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
                   		</select>
					</div>
					<div class="fitem">
						<label>上诉人</label>
						<textarea name="appellant" type="text" maxlength="1024" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写上诉人" style="margin: 0px; width: 300px; height: 60px;"></textarea>
					</div>
					<div class="fitem">
						<label>是否需要执行</label>
						<select class="easyui-combobox" editable="false"  name="isCarryOut" data-options="" missingMessage="请填写是否需要执行" style="margin: 0px; width: 300px;">
                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
                   		</select>
					</div>
					<div class="fitem">
						<label>备注</label>
						<textarea name="remark" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写备注" style="margin: 0px; width: 300px; height: 60px;"></textarea>
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-caseFirstInstance.js?var=<%=ot_ver%>"></script>
  </body>
</html>
