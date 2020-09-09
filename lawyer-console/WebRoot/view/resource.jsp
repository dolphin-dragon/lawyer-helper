<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    String ot_ver = "202009090900";//System.currentTimeMillis()+"";
    //String ot_ver = System.currentTimeMillis()+"";
%>
<!-- 公共资源CSS,JS  -->
<!--Css -->
<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/jquery-easyui/themes/bootstrap/easyui.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/jquery-easyui/themes/icon.css">
<link rel="stylesheet" type="text/css" href="<%=basePath%>/css/base.css">
<!-- ** Javascript ** -->
<script type="text/javascript" src="<%=basePath%>/js/commons/jquery.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/commons/jquery.form.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/commons/package.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery-easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/commons/urls.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/commons/base.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/commons/YDataGrid.js"></script>
<script type="text/javascript" src="<%=basePath%>/js/jquery-easyui/locale/easyui-lang-zh_CN.js"></script>

<script type="text/javascript">
var urls= {
		'msUrl':'<%=basePath%>',
		'easyuiUrl':'/js/jquery-easyui'
}
</script>