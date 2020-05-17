<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include file="/view/resource.jsp" %>
   	<style type="text/css">
	.vimg_div {
		width: 200px;
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
     <div id="edit-win" class="easyui-dialog" title="Basic window" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:380px;visibility:hidden">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit">
		     	   <div class="ftitle">案件基础信息</div>
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
						<label>当事人</label>
						<input name="litigant" type="text" maxlength="128" class="easyui-validatebox" data-options="" missingMessage="请填写当事人">
					</div>
					<div class="fitem">
						<label>被告名称</label>
						<input name="defendantName" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写被告名称">
					</div>
					<div class="fitem">
						<label>被告注册资本</label>
						<input name="defendantRegCapital" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写被告注册资本">
					</div>
					<div class="fitem">
						<label>被告所在地</label>
						<input name="defendantArea" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写被告所在地">
					</div>
  			</div>
     	</form>
  	 </div>
  	 
  	 <!-- 审核窗口 -->
  	  <div id="sp-edit-win" class="easyui-dialog" title="案件审批" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:600px;visibility:hidden"> 
  	  	<div id="sp-tabs" class="easyui-tabs" style="fit:true;">
  	  		<div title="基本信息">
  	  		     <form id="base_Form" class="ui-form" method="post">  
		     		 <input class="hidden" name="id">
		     		 <input class="hidden" name="typeIds" id="typeIds">
		     		 <div class="ui-edit">
							<div class="fitem">
								<label>当事人</label>
								<input name="litigant" type="text" maxlength="128" class="easyui-validatebox" data-options="" missingMessage="请填写当事人" style="margin: 0px; width: 200px;">
							</div>
							<div class="fitem">
								<label>被告名称</label>
								<textarea name="defendantName" type="text" maxlength="1024" class="easyui-validatebox" placeholder="多被告换行分隔"  data-options="required:true" missingMessage="请填写被告名称" style="margin: 0px; width: 200px; height: 40px;"></textarea>
							</div>
							<div class="fitem">
								<label>被告注册资本</label>
								<input name="defendantRegCapital" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写被告注册资本">
							</div>
							<div class="fitem">
								<label>被告所在地</label>
								<textarea name="defendantArea" type="text" maxlength="1024" class="easyui-validatebox" placeholder="多被告换行分隔"  data-options="required:true" missingMessage="请填写被告所在地" style="margin: 0px; width: 200px; height: 60px;"></textarea>
							</div>
						<!-- 	<div class="fitem">
								<label>状态</label>
								<input name="status" type="text" maxlength="11" class="easyui-numberbox" data-options="" missingMessage="请填写状态">
							</div>
							<div class="fitem">
								<label>机构编码</label>
								<input name="org" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写机构编码">
							</div> -->
							<div class="fitem">
								<label>创建人</label>
								<!-- <input name="createdBy" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写创建人"> -->
								<input class="easyui-combobox" editable="false"  name="createdBy" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请填写创建人">
							</div>
							<div class="fitem">
								<label>创建时间</label>
								<input name="createdTime" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写创建时间">
							</div>
							<div class="fitem">
								<label>更新人</label>
								<!-- <input name="updatedBy" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写更新人"> -->
								<input class="easyui-combobox" editable="false"  name="updatedBy" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请填写更新人">
							</div>
						    <div class="fitem">
								<label>更新时间</label>
								<input name="updatedTime" type="text" maxlength="19" class="easyui-datetimebox" data-options="" missingMessage="请填写更新时间">
							</div>

		  			</div>
		     	</form>
  	  		</div>
			<div title="确立信息" >
				<form id="app_Form" class="ui-form" method="post">  
	     		  <input class="hidden" name="caseId">
     		 		<div class="ui-edit">
					<div class="fitem">
						<label>当事人</label>
						<input name="litigant" type="text" maxlength="128" class="easyui-validatebox" data-options="required:true" missingMessage="请填写当事人" missingMessage="请填写当事人" style="margin: 0px; width: 200px;">
					</div>
					<div class="fitem">
						<label>被告名称(全称)</label>
						<textarea name="defendantName" type="text" maxlength="1024" class="easyui-validatebox" placeholder="多被告换行分隔"  data-options="required:true" missingMessage="请填写被告名称" style="margin: 0px; width: 200px; height: 40px;"></textarea>
					</div>
					<div class="fitem">
						<label>被告注册资本</label>
						<input name="defendantRegCapital" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写被告注册资本">
					</div>
					<div class="fitem">
						<label>被告所在地</label>
						<textarea name="defendantArea" type="text" maxlength="1024" class="easyui-validatebox" placeholder="多被告换行分隔"  data-options="required:true" missingMessage="请填写被告所在地" style="margin: 0px; width: 200px; height: 60px;"></textarea>
					</div>
					<div class="fitem">
						<label>案件来源</label>
						<select class="easyui-combobox" editable="false"  name="src" data-options="" missingMessage="请填写案件来源">
                    		<option value="1" selected="selected">当事人提供</option>
                    		<option value="2">所内自行搜证</option>
                    		<option value="3">律师个人案源</option>
                   		</select>
					</div>
					<div class="fitem">
						<label>案源人</label>
						<input class="easyui-combobox" editable="false"  name="supply" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请选择案源人">
					</div>
					<div class="fitem">
						<label>是否公证</label>
						<select class="easyui-combobox" editable="false"  name="isApply" data-options="" missingMessage="请选择是否公证">
                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
                   		</select>
					</div>
					<div class="fitem">
						<label>申请公证日期</label>
						<input name="applyDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写申请公证日期">
					</div>
					<div class="fitem">
						<label>公证书申请人</label>
						<input class="easyui-combobox" editable="false"  name="applicant" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请填写公证书申请人">
					</div>
					<div class="fitem">
						<label>取证人</label>
						<input class="easyui-combobox" editable="false"  name="forensics" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请填写取证人">
					</div>
					<div class="fitem">
						<label>侵权类型</label>
						<select class="easyui-combobox" editable="false"  name="violateType" id="violateType" data-options="" missingMessage="请填写侵权类型">
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
						<textarea name="violateDesc" type="text" maxlength="3072" placeholder="请填写线上侵权链接数量、图片数量及线下侵权图片数量、载体。" class="easyui-validatebox" data-options="" missingMessage="请填写侵权概况" style="margin: 0px; width: 200px; height: 100px;"></textarea>
					</div>
					<div class="fitem">
						<label>案件可诉确认日期</label>
						<input name="actionDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写案件可诉确认日期">
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
							<img id="ck_actionImg" style="width:200px;height:100px;"/>
						</div>
					</div>
				    <div class="fitem">
						<label>当事人确认日期</label>
						<input name="litigantAcDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写当事人确认日期">
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
							<img id="ck_litigantAcImg" style="width:200px;height:100px;"/>
						</div>
					</div>
                    <div class="fitem">
						<label>当事人是否要求直接诉讼</label>
						<select class="easyui-combobox" editable="false"  name="isDirectAction" data-options="" missingMessage="当事人是否要求直接诉讼">
                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
                   		</select>
					</div>
  				</div>
	     		</form>
			</div>
			<div title="诉前信息">
				<form id="pre_Form" class="ui-form" method="post">  
		     		 <input class="hidden" name="caseId">
		     		 <div class="ui-edit">
							<div class="fitem">
								<label>当事人</label>
								<input name="litigant" type="text" maxlength="128" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写当事人">
							</div>
							<div class="fitem">
								<label>被告名称(全称)</label>
								<input name="defendantName" type="text" maxlength="1024" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写被告名称">
							</div>
							<div class="fitem">
								<label>被告注册资本</label>
								<input name="defendantRegCapital" type="text" maxlength="32" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写被告注册资本">
							</div>
							<div class="fitem">
								<label>被告所在地</label>
								<textarea name="defendantArea" type="text" maxlength="1024" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写被告所在地"></textarea>
							</div>
							<div class="fitem">
								<label>律师函编号</label>
								<input name="letter" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写律师函编号">
							</div>
							<div class="fitem">
								<label>律师函主办人</label>
								<!-- <input name="letteror" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写律师函主办人"> -->
								<input class="easyui-combobox" editable="false"  name="letteror" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请填写律师函主办人">
							</div>
							<div class="fitem">
								<label>律师函发送日期</label>
								<input name="sendDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写律师函发送日期">
							</div>
							<div class="fitem">
								<label>律师函送达日期</label>
								<input name="deliveryDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写律师函送达日期">
							</div>
							<div class="fitem">
								<label>是否结案</label>
								<select class="easyui-combobox" editable="false"  name="isClose" data-options="" missingMessage="请填写是否结案">
		                    		<option value="1" selected="selected">&ensp;&ensp;是&ensp;&ensp;</option>
		                    		<option value="2">&ensp;&ensp;否&ensp;&ensp;</option>
		                   		</select>
							</div>
							<div class="fitem">
								<label>是否诉讼</label>
								<select class="easyui-combobox" editable="false"  name="isDirectAction" data-options="" missingMessage="请填写是否诉讼">
		                    		<option value="1" selected="selected">&ensp;&ensp;是&ensp;&ensp;</option>
		                    		<option value="2">&ensp;&ensp;否&ensp;&ensp;</option>
		                   		</select>
							</div>
							<div class="fitem">
								<label>备注</label>
								<textarea name="remark" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写备注"></textarea>
							</div>
		  			</div>
		     	</form>
			</div>
			<div title="一审信息">
				<form id="first_Form" class="ui-form" method="post">  
		     		 <input class="hidden" name="caseId">
		     		 <div class="ui-edit">
							<div class="fitem">
								<label>当事人</label>
								<input name="litigant" type="text" maxlength="128" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写当事人">
							</div>
							<div class="fitem">
								<label>被告名称(全称)</label>
								<input name="defendantName" type="text" maxlength="1024" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写被告名称">
							</div>
							<div class="fitem">
								<label>被告注册资本</label>
								<input name="defendantRegCapital" type="text" maxlength="32" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写被告注册资本">
							</div>
							<div class="fitem">
								<label>被告所在地</label>
								<textarea name="defendantArea" type="text" maxlength="1024" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写被告所在地"></textarea>
							</div>
							
							<div class="fitem">
								<label>第一责任人</label>
								<input name="firstor" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写第一责任人">
							</div>
							<div class="fitem">
								<label>一审主办律师</label>
								<input class="easyui-combobox" editable="false"  name="lawyer" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请填写一审主办律师">
							</div>
							<div class="fitem">
								<label>提交立案材料日期</label>
								<input name="submitDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写提交立案材料日期">
							</div>
							<div class="fitem">
								<label>是否诉前调解</label>
								<select class="easyui-combobox" editable="false"  name="isPreMediation" data-options="" missingMessage="请填写是否诉前调解">
		                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
		                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
		                   		</select>
							</div>
							<div class="fitem">
								<label>立案日期</label>
								<input name="establishDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写立案日期">
							</div>
							<div class="fitem">
								<label>是否诉中调解</label>
								<select class="easyui-combobox" editable="false"  name="isActionMediation" data-options="" missingMessage="请填写是否诉中调解">
		                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
		                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
		                   		</select>
							</div>
							<div class="fitem">
								<label>调解书日期</label>
								<input name="mediationDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写调解书日期">
							</div>
							<div class="fitem">
								<label>诉讼费用</label>
								<input name="litigationCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写诉讼费用">
							</div>
							<div class="fitem">
								<label>公告费用</label>
								<input name="announcementCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写公告费用">
							</div>
							<div class="fitem">
								<label>公证费用</label>
								<input name="notaryCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写公证费用">
							</div>
							<div class="fitem">
								<label>其它费用</label>
								<input name="otherCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写其它费用">
							</div>
							<div class="fitem">
								<label>受理法院</label>
								<input name="adjudicationCourt" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写受理法院">
							</div>
							<div class="fitem">
								<label>主办法官</label>
								<input name="judge" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写主办法官">
							</div>
							<div class="fitem">
								<label>联系方式</label>
								<input name="judgeContact" type="text" maxlength="128" class="easyui-validatebox" data-options="" missingMessage="请填写联系方式">
							</div>
							<div class="fitem">
								<label>一审开庭日期</label>
								<input name="fcourtDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写一审开庭日期">
							</div>
							<div class="fitem">
								<label>一审判决书落款日期</label>
								<input name="fverdictDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写一审判决书落款日期">
							</div>
							<div class="fitem">
								<label>一审判决书收到日期</label>
								<input name="fverdictReceiveDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写一审判决书收到日期">
							</div>
							<div class="fitem">
								<label>是否致歉</label>
								<select class="easyui-combobox" editable="false"  name="isApology" data-options="" missingMessage="请填写是否致歉">
		                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
		                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
		                   		</select>
							</div>
							<div class="fitem">
								<label>被告赔偿总额</label>
								<input name="defendantCompensationTotal" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写被告赔偿总额">
							</div>
							<div class="fitem">
								<label>被告承担合理开支总额</label>
								<input name="defendantExpenses" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写被告承担合理开支总额">
							</div>
							<div class="fitem">
								<label>原告承担诉费</label>
								<input name="plaintiffCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写原告承担诉费">
							</div>
							<div class="fitem">
								<label>被告承担诉费</label>
								<input name="defendantCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写被告承担诉费">
							</div>
							<div class="fitem">
								<label>是否结案</label>
								<select class="easyui-combobox" editable="false"  name="isClose" data-options="" missingMessage="请填写是否结案">
		                    		<option value="1" selected="selected">&ensp;&ensp;是&ensp;&ensp;</option>
		                    		<option value="2">&ensp;&ensp;否&ensp;&ensp;</option>
		                   		</select>
							</div>
							<div class="fitem">
								<label>上诉截止日期</label>
								<input name="appealDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写上诉截止日期">
							</div>
							<div class="fitem">
								<label>是否上诉</label>
								<select class="easyui-combobox" editable="false"  name="isAppeal" data-options="" missingMessage="请填写是否上诉">
		                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
		                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
		                   		</select>
							</div>
							<div class="fitem">
								<label>上诉人</label>
								<input name="appellant" type="text" maxlength="1024" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写上诉人">
							</div>
							<div class="fitem">
								<label>是否需要执行</label>
								<select class="easyui-combobox" editable="false"  name="isCarryOut" data-options="" missingMessage="请填写是否需要执行">
		                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
		                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
		                   		</select>
							</div>
							<div class="fitem">
								<label>备注</label>
								<input name="remark" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写备注">
							</div>
		  			</div>
		     	</form>
			</div>
			<div title="二审信息">
			     <form id="second_Form" class="ui-form" method="post">  
		     		 <input class="hidden" name="caseId">
		     		 <div class="ui-edit">
							<div class="fitem">
								<label>当事人</label>
								<input name="litigant" type="text" maxlength="128" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写当事人">
							</div>
							<div class="fitem">
								<label>被告名称(全称)</label>
								<input name="defendantName" type="text" maxlength="1024" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写被告名称">
							</div>
							<div class="fitem">
								<label>被告注册资本</label>
								<input name="defendantRegCapital" type="text" maxlength="32" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写被告注册资本">
							</div>
							<div class="fitem">
								<label>被告所在地</label>
								<textarea name="defendantArea" type="text" maxlength="1024" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写被告所在地"></textarea>
							</div>
							
							<div class="fitem">
								<label>二审主办律师</label>
								<input class="easyui-combobox" editable="false"  name="lawyer" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请填写二审主办律师">
							</div>
							<div class="fitem">
								<label>二审开庭日期</label>
								<input name="scourtDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写二审开庭日期">
							</div>
							<div class="fitem">
								<label>主办法官</label>
								<input name="judge" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写主办法官">
							</div>
							<div class="fitem">
								<label>联系方式</label>
								<input name="judgeContact" type="text" maxlength="128" class="easyui-validatebox" data-options="" missingMessage="请填写联系方式">
							</div>
							<div class="fitem">
								<label>二审判决生效日期</label>
								<input name="sjudgmentEffectiveDate" type="text" maxlength="32" class="easyui-datebox" data-options="" missingMessage="请填写二审判决生效日期">
							</div>
							<div class="fitem">
								<label>是否致歉</label>
								<select class="easyui-combobox" editable="false"  name="isApology" data-options="" missingMessage="请填写是否致歉">
		                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
		                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
		                   		</select>
							</div>
							<div class="fitem">
								<label>一审被告赔偿总额</label>
								<input name="defendantCompensationTotal" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写一审被告赔偿总额">
							</div>
							<div class="fitem">
								<label>一审被告承担合理开支费用</label>
								<input name="defendantExpenses" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写一审被告承担合理开支费用">
							</div>
							<div class="fitem">
								<label>一审原告承担诉费</label>
								<input name="plaintiffCosts" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写一审原告承担诉费">
							</div>
							<div class="fitem">
								<label>一审被告承担诉费</label>
								<input name="defendantCosts" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写一审被告承担诉费">
							</div>
							<div class="fitem">
								<label>是否结案</label>
								<select class="easyui-combobox" editable="false"  name="isClose" data-options="" missingMessage="请填写是否结案">
		                    		<option value="1" selected="selected">&ensp;&ensp;是&ensp;&ensp;</option>
		                    		<option value="2">&ensp;&ensp;否&ensp;&ensp;</option>
		                   		</select>
							</div>
							<div class="fitem">
								<label>执行截止日期</label>
								<input name="executionDeadline" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写执行截止日期">
							</div>
							<div class="fitem">
								<label>是否需要执行</label>
								<select class="easyui-combobox" editable="false"  name="isCarryOut" data-options="" missingMessage="是否需要执行">
		                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
		                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
		                   		</select>
							</div>
							<div class="fitem">
								<label>备注</label>
								<textarea name="remark" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写备注"></textarea>
							</div>
		  			</div>
		     	</form>
			</div>
			<div title="执行信息">
			     <form id="out_Form" class="ui-form" method="post">  
		     		 <input class="hidden" name="caseId">
		     		 <div class="ui-edit">
							<div class="fitem">
								<label>当事人</label>
								<input name="litigant" type="text" maxlength="128" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写当事人">
							</div>
							<div class="fitem">
								<label>被告名称(全称)</label>
								<input name="defendantName" type="text" maxlength="1024" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写被告名称">
							</div>
							<div class="fitem">
								<label>被告注册资本</label>
								<input name="defendantRegCapital" type="text" maxlength="32" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写被告注册资本">
							</div>
							<div class="fitem">
								<label>被告所在地</label>
								<textarea name="defendantArea" type="text" maxlength="1024" class="easyui-validatebox" readonly="true" data-options="" missingMessage="请填写被告所在地"></textarea>
							</div>
							
							<div class="fitem">
								<label>执行主办律师</label>
								<input class="easyui-combobox" editable="false"  name="lawyer" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请填写执行主办律师">
							</div>
							<div class="fitem">
								<label>执行申请日期</label>
								<input name="appDate" type="text" maxlength="10" class="easyui-datebox" data-options="" missingMessage="请填写执行申请日期">
							</div>
							<div class="fitem">
								<label>申请执行总额</label>
								<input name="appTotal" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写申请执行总额">
							</div>
							<div class="fitem">
								<label>执行主办法官</label>
								<input name="judge" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写执行主办法官">
							</div>
							<div class="fitem">
								<label>联系方式</label>
								<input name="judgeContact" type="text" maxlength="128" class="easyui-validatebox" data-options="" missingMessage="请填写联系方式">
							</div>
							<div class="fitem">
								<label>实际执行总额</label>
								<input name="actualTotal" type="text" maxlength="34" class="easyui-numberbox" data-options="precision:2,groupSeparator:','" missingMessage="请填写实际执行总额">
							</div>
							<div class="fitem">
								<label>首位收款主体</label>
								<textarea name="fcollectionSubject" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写首位收款主体"></textarea>
							</div>
							<div class="fitem">
								<label>是否执行和解</label>
								<select class="easyui-combobox" editable="false"  name="isReconcile" data-options="" missingMessage="是否执行和解">
		                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
		                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
		                   		</select>
							</div>
							<div class="fitem">
								<label>是否结案</label>
								<select class="easyui-combobox" editable="false"  name="isClose" data-options="" missingMessage="是否结案">
		                    		<option value="1">&ensp;&ensp;是&ensp;&ensp;</option>
		                    		<option value="2" selected="selected">&ensp;&ensp;否&ensp;&ensp;</option>
		                   		</select>
							</div>
							<div class="fitem">
								<label>备注</label>
								<textarea name="remark" type="text" maxlength="1024" class="easyui-validatebox" data-options="" missingMessage="请填写备注"></textarea>
							</div>
		  			</div>
		     	</form>
			</div>
		</div>
  	 </div>

  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-caseAuditInfo.js"></script>
  </body>
</html>