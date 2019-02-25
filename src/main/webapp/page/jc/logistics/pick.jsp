<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <title>拣货</title>
    
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">    
	<meta http-equiv="keywords" content="keyword1,keyword2,keyword3">
	<meta http-equiv="description" content="This is my page">
	<!--
	<link rel="stylesheet" type="text/css" href="styles.css">
	-->
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/easyui/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/base.css">
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/jquery.easyui.min.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/easyui/locale/easyui-lang-zh_CN.js"></script>
	<script type="text/javascript" src="${pageContext.request.contextPath}/js/base.js"></script>
	<script type="text/javascript" src="pick.js"></script>

  </head>
  
  <body>
	<div align="center">
		<h2 style="color:#0078CA">拣货</h2>
	</div>
	<input type="hidden" id="currentType" />
	<div align="center">
	<form id="f">
		<select id="type" class="easyui-combobox" style="width:100px;">
			<option value="0">需拣品种</option>
			<option value="1">已拣品种</option>
		</select>
		<select id="picktype" class="easyui-combobox" style="width:100px;">
			<option value="">所有</option>
			<option value="0">整件拣货</option>
			<option value="1">零件拣货</option>
		</select>
		期号：<input type="text" id="issuenumber" class="easyui-combobox"
			data-options="url:'/management/jc/issuenumber/tips',method:'get',valueField:'issuenumber',textField:'issuenumber',panelHeight:200" />
		<input class="easyui-textbox" id="subcode" style="width:150px" ><a class="easyui-linkbutton" id="choosesubcode"  onclick="chooseSubcode()">选择征订代码</a>
		条码：<input class="easyui-textbox" id="barcode" style="width:150px" />
		<a class="easyui-linkbutton" id='go' onclick="go()">&nbsp;查询&nbsp;</a>
	</form>
	</div>
	<div>
		<table id="data">
		</table>
	</div>
	
	<div id="showSubcode" class="easyui-window" title="选择征订代码" data-options="modal:true,closed:true,iconCls:'icon-save'"
			style="width: 800px; height: 350px; padding: 10px;">
		<table id="c_subcode" class="easyui-datagrid" data-options="collapsible:false,height:'auto',singleSelect:true,fitColumns: true,striped:true,rownumbers:true,
			toolbar:'#tb2'" width='100%'>
		</table>
	</div>
	<div id="w_detail" class="easyui-window" title="查看明细" data-options="modal:true,closed:true,iconCls:'icon-save',maximized:true,minimizable: false, maximizable: false" >
		<table id="data_detail"></table>
	</div>
	<div id="tb3" style="text-align: center;display:none">
		选中总册数：<input class="easyui-textbox" id="t_sumQty" style="width:80px" />
		<a class="easyui-linkbutton" iconCls="icon-edit" onclick="addPickno()">开始拣货</a>
		<a class="easyui-linkbutton" iconCls="icon-edit" onclick="pick()">拣货确认</a>
		<a class="easyui-linkbutton" iconCls="icon-edit" onclick="backTo()">拣货确认</a>
		<a class="easyui-linkbutton" iconCls="icon-edit" onclick="moveTo()">拣货确认</a>
		拣货流水号：<input class="easyui-textbox" id="t_pickno" style="width:120px" />
		<a class="easyui-linkbutton" iconCls="icon-print" onclick="pickList()">打印</a>
	</div>
	<div id="tb" style="text-align: center;display:none">
		<a class="easyui-linkbutton" iconCls="icon-edit" onclick="detail()">查看明细</a>
	</div>
	<div id="tb2" style="text-align: center;display:none">
		<a class="easyui-linkbutton" iconCls="icon-edit" onclick="tool.yes()">确定</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" onclick="tool.no()">取消</a>
	</div>
  </body>
</html>
