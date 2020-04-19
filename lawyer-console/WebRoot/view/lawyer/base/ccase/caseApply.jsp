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
     <div id="edit-win" class="easyui-dialog" title="案件确立信息登记表" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:400px;height:450px;">  
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
						<input name="litigant" type="text" maxlength="128" class="easyui-validatebox" data-options="required:true" missingMessage="请填写当事人" style="margin: 0px; width: 200px;">
					</div>
					<div class="fitem">
						<label>被告名称(全称)</label>
						<textarea name="defendantName" type="text" maxlength="1024" class="easyui-validatebox" placeholder="多被告换行分隔"  data-options="required:true" missingMessage="请填写被告名称" style="margin: 0px; width: 200px; height: 40px;"></textarea>
					</div>
					<div class="fitem">
						<label>被告注册资本</label>
						<input name="defendantRegCapital" type="text" maxlength="32" class="easyui-validatebox" placeholder="多被告空格分隔,如:20万 300万 " data-options="" missingMessage="请填写被告注册资本" style="margin: 0px; width: 200px;">
					</div>
					<div class="fitem">
						<label>被告所在地</label>
						<textarea name="defendantArea" type="text" maxlength="1024" class="easyui-validatebox" placeholder="多被告换行分隔"  data-options="required:true" missingMessage="请填写被告所在地" style="margin: 0px; width: 200px; height: 60px;"></textarea>
					</div>
					<div class="fitem">
						<label>案件来源</label>
						<!-- <input name="src" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写案件来源"> -->
						<select class="easyui-combobox" name="src" data-options="" missingMessage="请填写案件来源">
                    		<option value="1" selected="selected">当事人提供</option>
                    		<option value="2">所内自行搜证</option>
                    		<option value="3">律师个人案源</option>
                   		</select>
					</div>
					<div class="fitem">
						<label>案源人</label>
						<!-- <input name="supply" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写案源人"> -->
						<input class="easyui-combobox" name="supply" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请选择案源人">
					</div>
					<div class="fitem">
						<label>是否公证</label>
						<select class="easyui-combobox" name="isApply" data-options="" missingMessage="请选择是否公证">
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
						<input name="applicant" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写公证书申请人">
					</div>
					<div class="fitem">
						<label>取证人</label>
						<!-- <input name="forensics" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写取证人"> -->
						<input class="easyui-combobox" name="forensics" data-options="valueField:'uid',textField:'name',url:'<%=basePath %>/sysUserExt/listDatas.do'" missingMessage="请填写取证人">
					</div>
					<div class="fitem">
						<label>侵权类型</label>
						<!-- <input name="violateType" type="text" maxlength="32" class="easyui-validatebox" data-options="" missingMessage="请填写侵权类型"> -->
						<select class="easyui-combobox" name="violateType" id="violateType" data-options="" missingMessage="请填写侵权类型">
                    		<option value="1" selected="selected">肖像权</option>
                    		<option value="2">肖像权(含名誉权)</option>
                    		<option value="3">肖像权(含姓名权)</option>
                    		<option value="4">肖像权(含姓名权、名誉权)</option>
                    		<option value="5">名誉权</option>
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
							<input name="actionImg" type="text" id="actionImg" style="width: 150px;" readonly=true /> 
							<input type="button" id="uploadActionImgButton" value="上传截图" />
						</div>
					</div>
					<div class="fitem">
						<div>
							<label></label>
							<img id="ck_actionImg" οnmοuseοver="bigImg(this)" οnmοuseοut="closeImgWin()" style="width:200px;height:100px;"/>
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
						<div>
							<label></label> 
							<img id="ck_litigantAcImg" οnmοuseοver="bigImg(this)" οnmοuseοut="closeImgWin()" style="width:200px;height:100px;"/>
						</div>
					</div>
                    <div class="fitem">
						<label>当事人是否要求直接诉讼</label>
						<select class="easyui-combobox" name="isDirectAction" data-options="" missingMessage="当事人是否要求直接诉讼">
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
  	 <script type="text/javascript" src="<%=basePath%>/js/lawyer/base/ccase/page-caseApply.js"></script>

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
				})
			});

			$("#uploadLitigantAcImgButton").click(function() {
				commonAjaxFileUploadDG(function(data) {
					//data.url data.path
					//console.log(data)
					$("#litigantAcImg").val(data.url)
					$("#ck_litigantAcImg").attr('src',data.url);
				})
			});
		});
		//οnmοuseοver="bigImg(this)" οnmοuseοut="closeImgWin()"
			function bigImg(imgObj){
				/**
				 * dialog预览图片
				* @param imgObj img的jquery对象
				 **/
					// 若imgObj为空或imgObj的[src]为【Þ】时，图片无法打开
				    if ((imgObj == undefined || imgObj == null || imgObj.length == 0)
				    		|| ($(imgObj).attr("src") == "" || /Þ$/i.test($(imgObj).attr("src")))) {
				    	$.messager.alert('提示', "该图片无法打开！");
				    	return;
				    }
				    var img = new Image();   
					img.src = $(imgObj).attr("src");
					
					var imgWidth = "";
					var imgHeight = "";
					var imgProportion="";
						// 当<img>的class中配置了"img-width-**px"或"img-height-**px"或"img-proportion-**%"时（仅支持整数），使用对应的图片大小
					var imgClassNames = $(imgObj).prop("class");
					if (imgClassNames != undefined && imgClassNames != "") {
						var imgClassNameArray = imgClassNames.split(" ");
						var imgClassName;
						for (var index in imgClassNameArray) {
							imgClassName = imgClassNameArray[index];
							// 图片宽度
							if (/^(img-width-\d+px)/i.test(imgClassName)) {
								imgWidth = imgClassName.substring(10,imgClassName.length-2);
								
							// 图片高度
							} else if (/^(img-height-\d+px)/i.test(imgClassName)) {
								imgHeight = imgClassName.substring(11,imgClassName.length-2);
								
							// 图片显示比例
							} else if (/^(img-proportion-\d+%)/i.test(imgClassName)) {
								imgProportion = imgClassName.substring(15,imgClassName.length);
							}
						}
					}
					// 显示宽度
					if (imgWidth != null && imgWidth != "") {
						img.width = imgWidth;
					}
					// 显示高度
					if (imgHeight != null && imgHeight != "") {
						img.height = imgHeight;
					}
					// 显示比例设置
					if (imgProportion != null && imgProportion != "") {
						img.width  = img.width * parseFloat(imgProportion)/100;
						img.height  = img.height * parseFloat(imgProportion)/100;
					}
					// 保持图片纵横比的情况下，取得能够在$(window)中放得下的大小
					var heightWidthPropor = img.height/img.width;
					var width = $(window).width()*0.8 >= img.width ? img.width:$(window).width()*0.8;
					var height;
					if ($(window).height()*0.8 < width*heightWidthPropor) {
						height = $(window).height()*0.8;
						width = height/heightWidthPropor;
					} else {
						height = width*heightWidthPropor;
					}
					
					// 防止因用户拖动边框而导致dialog宽高固定不变
					$("#view_dialog").parent().css("width","auto");
					$("#view_dialog").parent().css("height","auto");
					
					$("#img_id").css("height",height + "px");
					$("#img_id").css("max-height",height + "px");
					if (imgWidth != null && imgWidth != "") {
						$("#img_id").css("width",width + "px");
						$("#img_id").css("max-width",width + "px");
					}
					
					$("#view_dialog").css("width",width + "px");
					$("#view_dialog").css("height",height + 5 + "px");
					
					$("#img_id").css("overflow","hidden");
					$("#img_id").attr('src',img.src); 
					$("#view_dialog").window('center');
					// 解决关闭按钮位置问题
					$("div.panel-header.panel-header-noborder.window-header").css("width","auto");
				 	$("#view_dialog").dialog("open");
			}
			
			function closeImgWin(){
				$("#view_dialog").dialog("close");
			}
	</script>
</body>
</html>
