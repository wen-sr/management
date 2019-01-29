<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
<head>
	<title>库存管理</title>

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
	<script type="text/javascript" src="inventory.js"></script>

</head>

<body>
<input type="hidden" id="currentType"/>
<div align="center">
	<h2 style="color:#0078CA">库存管理</h2>
</div>
<div align="center">
	期号：<input type="text" id="issuenumber" class="easyui-combobox" data-options="url: '/management/jc/issuenumber/tips',method: 'get',valueField: 'issuenumber',textField: 'issuenumber',
				panelWidth: 150,panelHeight: '100' "/>
	<input class="easyui-textbox" id="subcode" style="width:150px" ><a class="easyui-linkbutton" id="choosesubcode"  onclick="chooseSubcode()">选择征订代码</a>
	条码：<input class="easyui-textbox" id="barcode" style="width:150px"  />
	<a class="easyui-linkbutton" id='go' onclick="go()">&nbsp;查询&nbsp;</a>
</div>
<div align="center">
	<table width="100%"  id="data">
	</table>
</div>
<div id="tb3" style="text-align:center;display: none;">
	<a class="easyui-linkbutton" iconCls="icon-edit" id="split" onclick="tool.split()" >上架移库</a>
</div>
<div id="tb2" style="text-align: center;display: none;">
	<a class="easyui-linkbutton" iconCls="icon-edit" onclick="tool.yes()">确定</a>
	<a class="easyui-linkbutton" iconCls="icon-remove" onclick="tool.no()">取消</a>
</div>
<div id="tb4" style="text-align: center;display: none;">
	<a class="easyui-linkbutton" iconCls="icon-edit" onclick="tool.yes2()">确定</a>
	<a class="easyui-linkbutton" iconCls="icon-remove" onclick="tool.no2()">取消</a>
</div>
<div id="tb" style="text-align: center;display: none;">
	<a class="easyui-linkbutton" iconCls="icon-more" id="abcd" onclick="tool.detail()">查看明细</a>
</div>
<div id="showSubcode" class="easyui-window" title="选择征订代码" data-options="modal:true,closed:true,iconCls:'icon-save'"
	 style="width: 800px; height: 350px; padding: 10px;">
	<table id="c_subcode" >
	</table>
</div>
<div id="w-detail" class="easyui-window" title="库存明细" data-options="modal:true,closed:true,iconCls:'icon-save',maximized:true,minimizable: false, maximizable: false" >
	<table id="data-detail"></table>
</div>
<div id="w-detail-split" class="easyui-window" title="上架移库" data-options="modal:true,closed:true,iconCls:'icon-save'" style="width:auto;height:300px;padding:10px;" >
	<input type="hidden"  id="split_id"/>
	<h2 align="center">上架移库</h2>
	<table id="data-detail-split" align="center">
		<tr>
			<td>期号:</td><td><input type="text" class="easyui-combobox" id="split_issuenumber" data-options="url:'jc/issuenumber_info.action',method:'get',valueField:'issuenumber',textField:'issuenumber',panelHeight:'200',readonly:true" /></td>
			<td>征订代码：</td><td><input class="easyui-textbox" type="text" id="split_subcode" data-options="readonly:true" /></td>
			<td>捆扎：</td><td><input class="easyui-textbox" type="text" id="split_pack" data-options="readonly:true" /></td>
		</tr>
		<tr>
			<td>可移动数量：</td><td><input class="easyui-textbox" type="text" id="split_qtyfree" data-options="readonly:true"  /></td>
			<td>原储位：</td><td><input class="easyui-textbox" type="text" id="split_loc" data-options="readonly:true"  /></td>
			<td>原容器：</td><td><input class="easyui-textbox" type="text" id="split_containerId" data-options="readonly:true" /></td>
		</tr>
		<tr>
			<td>移动数量：</td><td><input class="easyui-textbox" type="text" id="split_qtysplit" data-options="required:true"/></td>
			<td>目的储位：</td><td><input class="easyui-textbox" type="text" id="split_toLoc" data-options="required:true"/></td>
			<td>目的容器：</td><td><input class="easyui-textbox" type="text" id="split_toContainerId"/></td>
		</tr>
		<tr>
			<td colspan='8' align="center">
				<a class="easyui-linkbutton" iconCls="icon-ok" id="splitInfo" onclick="move()">提交</a>
			</td>
		</tr>
	</table>
</div>
</body>
</html>
