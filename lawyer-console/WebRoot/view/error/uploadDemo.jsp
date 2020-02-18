<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
   <%@include file="/view/resource.jsp" %>
  </head>
  <body class="easyui-layout">
	
     <!-- Data List -->
     <div region="center" border="false" >
     <form id="editForm" class="ui-form" method="post">  
	<input class="hidden" id="reqWebUrl">
	<div id="upimg" >
		<div class="fitem">
			<div>
				<label>待上传文件</label> 
						<input name="logoUrl" type="text" id="logoUrl" style="width:150px;" readonly=true />
			    		<input type="button" id="uploadButton" value="上传LOGO图" />
			</div>
		</div>
	</div>
	</form>
	 </div>
   
  	 <script type="text/javascript" src="<%=basePath%>/js/commons/upload/ajaxfileupload.js"></script>
	 <script type="text/javascript" src="<%=basePath%>/js/commons/upload/commonfileupload.js"></script> 
	 <script type="text/javascript" src="<%=basePath%>/js/commons/upload/dgfileupload.js"></script>
	 
  	 <script type="text/javascript">
 	$(function(){
        $("#uploadButton").click(function () {
       	 commonAjaxFileUploadDG(function(data){
       		 //data.url data.path
       		  console.log(data)
       		 $("#logoUrl").val(data.url)
       	 })
        });
 	})
  	 </script>
  </body>
</html>
