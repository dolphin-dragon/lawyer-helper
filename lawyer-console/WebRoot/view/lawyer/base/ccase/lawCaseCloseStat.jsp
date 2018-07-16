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
			<label class="ui-label">案件编号:</label><input name="ccode" class="easyui-box ui-text" style="width:100px;">
			<label class="ui-label">原告:</label><input name="plaintiff" class="easyui-box ui-text" style="width:100px;">
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
     <div id="edit-win" class="easyui-dialog" title="Basic window" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:380px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 
     		 <input class="hidden" name="createBy">
     		 <input class="hidden" name="createDate">
     		 <input class="hidden" name="updateBy">
     		 <input class="hidden" name="updateDate">
     		 <input class="hidden" name="delFlag">
     		 <div class="ui-edit">
		     	   <div class="ftitle">结案统计数据表</div>
					<div class="fitem">
						<label>案件编号</label>
						<input name="ccode" type="text" maxlength="64" class="easyui-validatebox" data-options="" missingMessage="请填写案件编号">
					</div>
					<div class="fitem">
						<label>原告</label>
						<input name="plaintiff" type="text" maxlength="90" class="easyui-validatebox" data-options="" missingMessage="请填写原告">
					</div>
					<div class="fitem">
						<label>被告</label>
						<input name="defendant" type="text" maxlength="600" class="easyui-validatebox" data-options="" missingMessage="请填写被告">
					</div>
					<div class="fitem">
						<label>结案方式</label>
						<input name="closeType" type="text" maxlength="12" class="easyui-validatebox" data-options="" missingMessage="请填写结案方式">
					</div>
					<div class="fitem">
						<label>结案时间</label>
						<input name="closeDate" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写结案时间">
					</div>
					<div class="fitem">
						<label>赔偿金额</label>
						<input name="compensationAmont" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写赔偿金额">
					</div>
					<div class="fitem">
						<label>公证费用</label>
						<input name="fairFee" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写公证费用">
					</div>
					<div class="fitem">
						<label>差旅费</label>
						<input name="travelExpenses" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写差旅费">
					</div>
					<div class="fitem">
						<label>被告负担诉费</label>
						<input name="defendantLegalFare" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写被告负担诉费">
					</div>
					<div class="fitem">
						<label>实际垫付公证费</label>
						<input name="advanceFairFee" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写实际垫付公证费">
					</div>
					<div class="fitem">
						<label>实际垫付诉讼费/公告费</label>
						<input name="advanceLegalFare" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写实际垫付诉讼费/公告费">
					</div>
					<div class="fitem">
						<label>应退诉费</label>
						<input name="refundFee" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写应退诉费">
					</div>
					<div class="fitem">
						<label>实退诉费</label>
						<input name="returnFee" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写实退诉费">
					</div>
					<div class="fitem">
						<label>公证费</label>
						<input name="costFairFee" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写公证费">
					</div>
					<div class="fitem">
						<label>诉讼费</label>
						<input name="costLegalFare" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写诉讼费">
					</div>
					<div class="fitem">
						<label>应收总计</label>
						<input name="receiveDue" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写应收总计">
					</div>
					<div class="fitem">
						<label>到账时间</label>
						<input name="receiveDate" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写到账时间">
					</div>
					<div class="fitem">
						<label>实收总计</label>
						<input name="receiveAccount" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写实收总计">
					</div>
					<div class="fitem">
						<label>律师费计算基数</label>
						<input name="lawyerPayBase" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写律师费计算基数">
					</div>
					<div class="fitem">
						<label>总律师费</label>
						<input name="lawyerPay" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写总律师费">
					</div>
					<div class="fitem">
						<label>主办律师</label>
						<input name="masterLawyer" type="text" maxlength="16" class="easyui-validatebox" data-options="" missingMessage="请填写主办律师">
					</div>
					<div class="fitem">
						<label>协办律师1</label>
						<input name="slaveLawyerOne" type="text" maxlength="16" class="easyui-validatebox" data-options="" missingMessage="请填写协办律师1">
					</div>
					<div class="fitem">
						<label>协办律师2</label>
						<input name="slaveLawyerTwo" type="text" maxlength="16" class="easyui-validatebox" data-options="" missingMessage="请填写协办律师2">
					</div>
					<div class="fitem">
						<label>协办律师3</label>
						<input name="slaveLawyerThree" type="text" maxlength="16" class="easyui-validatebox" data-options="" missingMessage="请填写协办律师3">
					</div>
					<div class="fitem">
						<label>账户信息</label>
						<input name="accountInfo" type="text" maxlength="120" class="easyui-validatebox" data-options="" missingMessage="请填写账户信息">
					</div>
					<div class="fitem">
						<label>绩效</label>
						<input name="achievement" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写绩效">
					</div>
					<div class="fitem">
						<label>应支付给艺人</label>
						<input name="due" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写应支付给艺人">
					</div>
					<div class="fitem">
						<label>成本回款</label>
						<input name="cost" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写成本回款">
					</div>
					<div class="fitem">
						<label>案件分类</label>
						<input name="ctype" type="text" maxlength="1" class="easyui-validatebox" data-options="" missingMessage="请填写案件分类">
					</div>
					<div class="fitem">
						<label>线索人</label>
						<input name="provider" type="text" maxlength="16" class="easyui-validatebox" data-options="" missingMessage="请填写线索人">
					</div>
					<div class="fitem">
						<label>线索费</label>
						<input name="providerFee" type="text" maxlength="21" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写线索费">
					</div>
					<!-- <div class="fitem">
						<label>创建者</label>
						<input name="createBy" type="text" maxlength="64" class="easyui-validatebox" data-options="required:true" missingMessage="请填写创建者">
					</div>
					<div class="fitem">
						<label>创建时间</label>
						<input name="createDate" type="text" maxlength="19" class="easyui-datetimebox" data-options="required:true" missingMessage="请填写创建时间">
					</div>
					<div class="fitem">
						<label>更新者</label>
						<input name="updateBy" type="text" maxlength="64" class="easyui-validatebox" data-options="required:true" missingMessage="请填写更新者">
					</div>
					<div class="fitem">
						<label>更新时间</label>
						<input name="updateDate" type="text" maxlength="19" class="easyui-datetimebox" data-options="required:true" missingMessage="请填写更新时间">
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
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-lawCaseCloseStat.js"></script>
  </body>
</html>
