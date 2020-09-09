<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort() + request.getContextPath();
    String ot_ver = "202009090900";//System.currentTimeMillis()+"";
    //String ot_ver = System.currentTimeMillis()+"";
%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"  %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"  %>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
	<title>星权办公助手</title>
	<link rel="shortcut icon" href="favicon.ico" type="image/x-icon" />  
	<%--  <%@include file="/view/resource.jsp" %> --%>
    <link rel="stylesheet" type="text/css" href="<%=basePath%>/js/jquery-easyui-desktop/jquery-easyui/themes/material-teal/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/jquery-easyui-desktop/jquery-easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=basePath%>/js/jquery-easyui-desktop/desktop.css">
	<script type="text/javascript" src="<%=basePath%>/js/jquery-easyui-desktop/jquery-easyui/jquery.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/jquery-easyui-desktop/jquery-easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/jquery-easyui-desktop/jquery.desktop.js"></script>

	<script type="text/javascript" src="<%=basePath%>/js/commons/package.js"></script>
	<script type="text/javascript" src="<%=basePath%>/js/commons/base.js"></script>
</head>
<body>
	<div id="buttons">
		<a href="javascript:;" class="easyui-linkbutton" outline="true" plain="true" onclick="settings()">设置</a>
	</div>
	<script type="text/javascript">
		$(function(){
			$('body').desktop({
				apps: [
					<c:forEach var="item" items="${menuList}">
						<c:forEach var="node" items="${item.children}">
						{
							name: '${node.text}',
							icon: '<%=basePath%>/js/jquery-easyui-desktop/images/imac-on.png',
							width: 800,
							height: 500,
							left: 200,
							top: 20,
							content:"<iframe src='<%=basePath%>${node.url}' width='100%' height='99%' frameborder='0' scrolling='no'></iframe>"
						},
						</c:forEach>
					</c:forEach>
					],
				menus: [
					<c:forEach var="item" items="${menuList}">
					{
					text: '${item.text}',
					menus: [
						<c:forEach var="node" items="${item.children}">
						{
							text: '${node.text}',
							//iconCls: 'icon-lock',
							handler: function(){
								var content = '<iframe src="<%=basePath%>${node.url}" width="100%" height="99%" frameborder="0" scrolling="no"></iframe>';
								$('body').desktop('openApp', {
									icon: '<%=basePath%>/js/jquery-easyui-desktop/images/win.png',
									name: '${node.text}',
									width: 800,
									height: 500,
									left: 200,
									top: 20,
									content: content
								})
							}
						},
						</c:forEach>
					]
					},
					</c:forEach>
					{
					text: '浏览器模式',
					handler: function(){
						setTimeout("window.location.href='main.shtml'", 100);
					}
				},{
					text: '退出',
					//iconCls: 'icon-lock',
					handler: function(){
						otter.confirm("提示","确认退出系统?",function(r){
							if(r){
								setTimeout("window.location.href='<%=basePath%>/logout.shtml'", 100);
							}
						});
					}
				}],
				buttons: '#buttons'
			})
		});
		settingsApp = null;
		function settings(){
			if (settingsApp){
				$('body').desktop('openApp', settingsApp);
				return;
			}
			settingsApp = {
				id: 'settings',
				name: '设置',
				width: 600,
				height: 400,
				onBeforeClose: function(){
					settingsApp = null;
				}
			};
			$('body').desktop('openApp', settingsApp);
			var template = '<div>' +
				'<div region="north" style="padding:5px;height:45px;text-align:right"></div>' +
				'<div region="south" style="text-align:right;height:45px;padding:5px"></div>' +
				'<div region="west" title="桌面背景" split="true" style="width:200px"><table id="settings-dl"></table></div>' +
				'<div region="center" title="预览"><img id="settings-img" style="border:0;width:100%;height:100%"></div>' +
				'</div>';
			var layout = $(template).appendTo('#settings');
			layout.layout({
				fit: true
			});
			var combo = $('<input>').appendTo(layout.layout('panel','north'));
			combo.combobox({
				data: [
					{value:'default',text:'Default',group:'Base'},
					{value:'gray',text:'Gray',group:'Base'},
					{value:'metro',text:'Metro',group:'Base'},
					{value:'material',text:'Material',group:'Base'},
					{value:'material-teal',text:'Material Teal',group:'Base'},
					{value:'bootstrap',text:'Bootstrap',group:'Base'},
					{value:'black',text:'Black',group:'Base'},
				],
				width: 300,
				label: '主题: ',
				value: 'material-teal',
				editable:false,
				panelHeight: 'auto',
				onChange: function(theme){
					var link = $('head').find('link:first');
					link.attr('href', 'https://www.jeasyui.com/easyui/themes/'+theme+'/easyui.css');
				}
			});
			$('#settings-dl').datalist({
				fit: true,
				data: [
					{"text":"图0","img":"<%=basePath%>/js/jquery-easyui-desktop/images/bg0.jpg"},
					{"text":"图1","img":"<%=basePath%>/js/jquery-easyui-desktop/images/bg.jpg"},
					{"text":"图2","img":"<%=basePath%>/js/jquery-easyui-desktop/images/bg2.jpg"},
					{"text":"图3","img":"<%=basePath%>/js/jquery-easyui-desktop/images/bg3.jpg"},
					{"text":"图4","img":"<%=basePath%>/js/jquery-easyui-desktop/images/bg4.jpg"}
				],
				onLoadSuccess:function(){
					$(this).datalist('selectRow', 2);
				},
				onSelect:function(index,row){
					$('#settings-img').attr('src', row.img)
				}
			});
			$('<a style="margin-right:10px"></a>').appendTo(layout.layout('panel','south')).linkbutton({
				text: 'Ok',
				width: 80,
				onClick: function(){
					$('body').desktop('setWallpaper', $('#settings-dl').datalist('getSelected').img);
					$('#settings').window('close');
				}
			})
			$('<a></a>').appendTo(layout.layout('panel','south')).linkbutton({
				text: 'Cancel',
				width: 80,
				onClick: function(){
					$('#settings').window('close');
				}
			})
		}
	</script>
</body>
</html>