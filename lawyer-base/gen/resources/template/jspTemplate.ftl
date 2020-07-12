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
#foreach($po in $!{columnDatas})
#if  ($po.propertyName !='id' && $velocityCount  < 4)
			<label class="ui-label">${po.columnComment}:</label><input name="${po.propertyName}" class="easyui-box ui-text" style="width:100px;">
#end
#end
	    </p>
	    <a href="#" id="btn-search" class="easyui-linkbutton" iconCls="icon-search">查询</a><a href="#" id="btn-reset" class="easyui-linkbutton" iconCls="icon-reload">重置</a>
      </form>  
     </div> 
     <!--  Search panel end -->

     <!-- Data List -->
     <div region="center" border="false" >
     <table id="data-list"></table>
	 </div>
	 
     <!-- Edit Win&Form -->
     <div id="edit-win" class="easyui-dialog" title="${codeName}" data-options="closed:true,iconCls:'icon-save',modal:true" style="width:500px;height:450px;">  
     	<form id="editForm" class="ui-form" method="post">  
     		 <input class="hidden" name="id">
     		 <div class="ui-edit hidden">
		     	   <div class="ftitle">${codeName}</div>
#foreach($po in $!{columnDatas})
#if  ($po.propertyName !='id')     	   
					<div class="fitem">
						<label>${po.columnComment}</label>
						<input name="${po.propertyName}" type="text" maxlength="${po.charmaxLength}" class="${po.classType}" data-options="${po.optionType}" missingMessage="请填写${po.columnComment}" style="margin: 0px; width: 300px;">
					</div>
#end
#end
  			</div>
     	</form>
  	 </div>
  	 <script type="text/javascript" src="<%=basePath%>/${webJsPackage}/${bussPackageWebPath}/${entityPackageWebPath}/page-${lowerName}.js?var=<%=ot_ver%>"></script>
  </body>
</html>
