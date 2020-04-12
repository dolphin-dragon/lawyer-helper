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
			<label class="ui-label">案源人:</label><input class="easyui-combobox" name="cpSupply" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请选择案源人">
			<label class="ui-label">当事人:</label><input name="caseLitigant" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">被告名称:</label><input name="caseDefendantName" class="easyui-box ui-text" style="width:100px;">
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
     <div id="edit-win" class="easyui-dialog" title="案件综合信息" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:380px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	   <div class="ftitle">案件综合信息</div>
					<div class="fitem">
						<label>案件来源</label>
						<input name="cpSrc" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写案件来源">
					</div>
					<div class="fitem">
						<label>案源人</label>
						<input name="cpSupply" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写案源人">
					</div>
					<div class="fitem">
						<label>申请公证日期</label>
						<input name="cpApplyDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写申请公证日期">
					</div>
					<div class="fitem">
						<label>公证书申请人</label>
						<input name="cpApplicant" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写公证书申请人">
					</div>
					<div class="fitem">
						<label>取证人</label>
						<input name="cpForensics" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写取证人">
					</div>
					<div class="fitem">
						<label>侵权类型</label>
						<input name="cpViolateType" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写侵权类型">
					</div>
					<div class="fitem">
						<label>侵权概况</label>
						<input name="cpViolateDesc" type="text" maxlength="3072" class="easyui-validatebox" data-options="" missingMessage="请填写侵权概况">
					</div>
					<div class="fitem">
						<label>案件可诉确认日期</label>
						<input name="cpActionDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写案件可诉确认日期">
					</div>
					<div class="fitem">
						<label>当事人确认日期</label>
						<input name="cpLitigantAcDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写当事人确认日期">
					</div>
					<div class="fitem">
						<label>案件可诉确认截图</label>
						<input name="cpActionImg" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写案件可诉确认截图">
					</div>
					<div class="fitem">
						<label>当事人确认截图</label>
						<input name="cpLitigantAcImg" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写当事人确认截图">
					</div>
					<div class="fitem">
						<label>当事人是否要求直接诉讼</label>
						<input name="cpIsDirectAction" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写当事人是否要求直接诉讼">
					</div>
					<div class="fitem">
						<label>状态</label>
						<input name="caseStatus" type="text" maxlength="11" class="easyui-numberbox" data-options="" missingMessage="请填写状态">
					</div>
					<div class="fitem">
						<label>删除标记</label>
						<input name="caseDelFlag" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写删除标记">
					</div>
					<div class="fitem">
						<label>机构编码</label>
						<input name="caseOrg" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写机构编码">
					</div>
					<div class="fitem">
						<label>创建人</label>
						<input name="caseCreatedBy" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写创建人">
					</div>
					<div class="fitem">
						<label>创建时间</label>
						<input name="caseCreatedTime" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写创建时间">
					</div>
					<div class="fitem">
						<label>更新人</label>
						<input name="caseUpdatedBy" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写更新人">
					</div>
					<div class="fitem">
						<label>更新时间</label>
						<input name="caseUpdatedTime" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写更新时间">
					</div>
					<div class="fitem">
						<label>当事人</label>
						<input name="caseLitigant" type="text" maxlength="128" class="easyui-validatebox" data-options="" missingMessage="请填写当事人">
					</div>
					<div class="fitem">
						<label>被告名称</label>
						<input name="caseDefendantName" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写被告名称">
					</div>
					<div class="fitem">
						<label>被告注册资本</label>
						<input name="caseDefendantRegCapital" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写被告注册资本">
					</div>
					<div class="fitem">
						<label>被告所在地</label>
						<input name="caseDefendantArea" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写被告所在地">
					</div>
					<div class="fitem">
						<label>律师函编号</label>
						<input name="prLetter" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写律师函编号">
					</div>
					<div class="fitem">
						<label>律师函主办人</label>
						<input name="prLetteror" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写律师函主办人">
					</div>
					<div class="fitem">
						<label>律师函发送日期</label>
						<input name="prSendDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写律师函发送日期">
					</div>
					<div class="fitem">
						<label>律师函送达日期</label>
						<input name="prDeliveryDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写律师函送达日期">
					</div>
					<div class="fitem">
						<label>是否结案</label>
						<input name="prIsClose" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写是否结案">
					</div>
					<div class="fitem">
						<label>是否诉讼</label>
						<input name="prIsDirectAction" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写是否诉讼">
					</div>
					<div class="fitem">
						<label>第一责任人</label>
						<input name="firFirstor" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写第一责任人">
					</div>
					<div class="fitem">
						<label>一审主办律师</label>
						<input name="firLawyer" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写一审主办律师">
					</div>
					<div class="fitem">
						<label>提交立案材料日期</label>
						<input name="firSubmitDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写提交立案材料日期">
					</div>
					<div class="fitem">
						<label>立案日期</label>
						<input name="firEstablishDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写立案日期">
					</div>
					<div class="fitem">
						<label>诉讼费用</label>
						<input name="firLitigationCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写诉讼费用">
					</div>
					<div class="fitem">
						<label>公告费用</label>
						<input name="firAnnouncementCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写公告费用">
					</div>
					<div class="fitem">
						<label>公证费用</label>
						<input name="firNotaryCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写公证费用">
					</div>
					<div class="fitem">
						<label>其它费用</label>
						<input name="firOtherCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写其它费用">
					</div>
					<div class="fitem">
						<label>受理法院</label>
						<input name="firAdjudicationCourt" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写受理法院">
					</div>
					<div class="fitem">
						<label>主办法官</label>
						<input name="firJudge" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写主办法官">
					</div>
					<div class="fitem">
						<label>联系方式</label>
						<input name="firJudgeContact" type="text" maxlength="128" class="easyui-validatebox" data-options="" missingMessage="请填写联系方式">
					</div>
					<div class="fitem">
						<label>一审开庭日期</label>
						<input name="firFCourtDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写一审开庭日期">
					</div>
					<div class="fitem">
						<label>一审判决书落款日期</label>
						<input name="firFVerdictDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写一审判决书落款日期">
					</div>
					<div class="fitem">
						<label>一审判决书收到日期</label>
						<input name="firFVerdictReceiveDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写一审判决书收到日期">
					</div>
					<div class="fitem">
						<label>是否致歉</label>
						<input name="firIsApology" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写是否致歉">
					</div>
					<div class="fitem">
						<label>被告赔偿总额</label>
						<input name="firDefendantCompensationTotal" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写被告赔偿总额">
					</div>
					<div class="fitem">
						<label>被告承担合理开支总额</label>
						<input name="firDefendantExpenses" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写被告承担合理开支总额">
					</div>
					<div class="fitem">
						<label>原告承担诉费</label>
						<input name="firPlaintiffCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写原告承担诉费">
					</div>
					<div class="fitem">
						<label>被告承担诉费</label>
						<input name="firDefendantCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写被告承担诉费">
					</div>
					<div class="fitem">
						<label>是否结案</label>
						<input name="firIsClose" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写是否结案">
					</div>
					<div class="fitem">
						<label>上诉截止日期</label>
						<input name="firAppealDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写上诉截止日期">
					</div>
					<div class="fitem">
						<label>是否诉前调解</label>
						<input name="firIsPreMediation" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写是否诉前调解">
					</div>
					<div class="fitem">
						<label>是否诉中调解</label>
						<input name="firIsActionMediation" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写是否诉中调解">
					</div>
					<div class="fitem">
						<label>调解书日期</label>
						<input name="firMediationDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写调解书日期">
					</div>
					<div class="fitem">
						<label>是否上诉</label>
						<input name="firIsAppeal" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写是否上诉">
					</div>
					<div class="fitem">
						<label>上诉人</label>
						<input name="firAppellant" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写上诉人">
					</div>
					<div class="fitem">
						<label>是否需要执行</label>
						<input name="firIsCarryOut" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写是否需要执行">
					</div>
					<div class="fitem">
						<label>二审主办律师</label>
						<input name="twoLawyer" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写二审主办律师">
					</div>
					<div class="fitem">
						<label>二审开庭日期</label>
						<input name="twoSCourtDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写二审开庭日期">
					</div>
					<div class="fitem">
						<label>主办法官</label>
						<input name="twoJudge" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写主办法官">
					</div>
					<div class="fitem">
						<label>联系方式</label>
						<input name="twoJudgeContact" type="text" maxlength="128" class="easyui-validatebox" data-options="" missingMessage="请填写联系方式">
					</div>
					<div class="fitem">
						<label>二审判决生效日期</label>
						<input name="twoSJudgmentEffectiveDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写二审判决生效日期">
					</div>
					<div class="fitem">
						<label>是否致歉</label>
						<input name="twoIsApology" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写是否致歉">
					</div>
					<div class="fitem">
						<label>一审被告赔偿总额</label>
						<input name="twoDefendantCompensationTotal" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写一审被告赔偿总额">
					</div>
					<div class="fitem">
						<label>一审被告承担合理开支费用</label>
						<input name="twoDefendantExpenses" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写一审被告承担合理开支费用">
					</div>
					<div class="fitem">
						<label>一审原告承担诉费</label>
						<input name="twoPlaintiffCosts" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写一审原告承担诉费">
					</div>
					<div class="fitem">
						<label>一审被告承担诉费</label>
						<input name="twoDefendantCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写一审被告承担诉费">
					</div>
					<div class="fitem">
						<label>是否结案</label>
						<input name="twoIsClose" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写是否结案">
					</div>
					<div class="fitem">
						<label>执行截止日期</label>
						<input name="twoExecutionDeadline" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写执行截止日期">
					</div>
					<div class="fitem">
						<label>是否需要执行</label>
						<input name="twoIsCarryOut" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写是否需要执行">
					</div>
					<div class="fitem">
						<label>执行主办律师</label>
						<input name="outLawyer" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写执行主办律师">
					</div>
					<div class="fitem">
						<label>执行申请日期</label>
						<input name="outAppDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写执行申请日期">
					</div>
					<div class="fitem">
						<label>申请执行总额</label>
						<input name="outAppTotal" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写申请执行总额">
					</div>
					<div class="fitem">
						<label>执行主办法官</label>
						<input name="outJudge" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写执行主办法官">
					</div>
					<div class="fitem">
						<label>联系方式</label>
						<input name="outJudgeContact" type="text" maxlength="128" class="easyui-validatebox" data-options="" missingMessage="请填写联系方式">
					</div>
					<div class="fitem">
						<label>实际执行总额</label>
						<input name="outActualTotal" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写实际执行总额">
					</div>
					<div class="fitem">
						<label>首位收款主体</label>
						<input name="outFCollectionSubject" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写首位收款主体">
					</div>
					<div class="fitem">
						<label>是否执行和解</label>
						<input name="outIsReconcile" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写是否执行和解">
					</div>
					<div class="fitem">
						<label>是否结案</label>
						<input name="outIsClose" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写是否结案">
					</div>
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-caseMInfo.js"></script>
  </body>
</html>
