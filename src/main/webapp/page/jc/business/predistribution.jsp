<%@ page language="java" import="java.util.*" pageEncoding="utf-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE>
<html>
  <head>
    <title>业务预分发</title>
    
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
	<script type="text/javascript" src="predistribution.js"></script>

  </head>
  
  <body>
	<div align="center">
		<h2 style="color:#0078CA">业务预分发</h2>
	</div>
	<input type="hidden" id="currentType">
	<!-- 查询 -->
	<div align="center">
		<select id="type" class="easyui-combobox" style="width:120px;">
			<option value="0">可分发品种</option>
			<option value="1">已分发品种</option>
		</select>
		期号：<input type="text" id="issuenumber" class="easyui-combobox" data-options="url: '/management/jc/issuenumber/tips',method: 'get',valueField: 'issuenumber',textField: 'issuenumber',
				panelWidth: 150,panelHeight: '100' "/>
		<input class="easyui-textbox" id="subcode" style="width:150px" ><a class="easyui-linkbutton" id="choosesubcode"  onclick="chooseSubcode()">选择征订代码</a>
		<a class="easyui-linkbutton" id='go' onclick="go()">&nbsp;查询&nbsp;</a>
	</div>
	<!-- 选择征订代码 -->
	<div id="showSubcode" class="easyui-window" title="选择征订代码" data-options="modal:true,closed:true,iconCls:'icon-save'"
			style="width: 800px; height: 350px; padding: 10px;">
		<table id="c_subcode" >
		</table>
	</div>
	<div id="tb2" style="text-align: center;display: none;" data-options="closed:true">
		<a class="easyui-linkbutton" iconCls="icon-edit" onclick="tool.yes()">确定</a>
		<a class="easyui-linkbutton" iconCls="icon-remove" onclick="tool.no()">取消</a>
	</div>
	<!-- 新增预分发信息窗口 -->
	<div id="w-addInfo" class="easyui-window" title="新增预分发信息"
			data-options="modal:false,closed:true,iconCls:'icon-save'"
			style="width: 700px; height: 400px; padding: 10px;">
		<form id="f1" name="f1">
			<input type="hidden" id="add_id" />
			<h2 align="center">新增预分发信息</h2>
			<table id="formtable" border="0px" align="center" cellpadding='2'width="100%">
				<tr>
					<td>期号:</td><td><select class="easyui-combobox" id="add_issuenumber" data-options="url:'/management/jc/issuenumber/tips',method:'get',valueField:'issuenumber',textField:'issuenumber',panelHeight:'200',readonly:true" ></select></td>
					<td>征订代码：</td><td><input class="easyui-textbox" type="text" id="add_subcode" data-options="readonly:true"/></td>
				</tr>
				<tr>
					<td>条码：</td><td><input class="easyui-textbox" type="text" id="add_barcode" data-options="readonly:true"/></td>
					<td>书名：</td><td><input class="easyui-textbox" type="text" id="add_descr" data-options="readonly:true"/></td>
				</tr>
				<tr>
					<td>出版社：</td><td><select class="easyui-combobox" id="add_publisher" data-options="url:'/management/jc/storer/tips?type=1',method:'get',valueField:'storerkey',textField:'shortname',panelHeight:'200',readonly:true" ></select></td>
					<td>定价：</td><td><input class="easyui-textbox" type="text" id="add_price" data-options="readonly:true"/></td>
				</tr>
				<tr>
					<td>分发店：</td><td><select class="easyui-combobox" id="add_code" data-options="url:'/management/jc/storer/tips?type=0',method:'get',valueField:'storerkey',textField:'shortname',panelHeight:'200',required:true" ></select></td>
					<td>分发数量：</td><td><input class="easyui-textbox" type="text" id="add_qtyallocated" data-options="required:true"/></td>
				</tr>
				<tr>
					<td>可分数量：</td><td><input class="easyui-textbox" type="text" id="add_qtyfree" data-options="readonly:true"/></td>
				</tr>
				<tr>
					<td colspan='8' align="center">
						<a class="easyui-linkbutton" onclick="submitgo()">提交</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 修改预分发信息窗口 -->
	<div id="w-editInfo" class="easyui-window" title="修改预分发信息"
			data-options="modal:false,closed:true,iconCls:'icon-save'"
			style="width: 700px; height: 400px; padding: 10px;">
		<form name="f1">
			<input type="hidden" id="edit_id" />
			<h2 align="center">修改预分发信息</h2>
			<table  border="0px" align="center" cellpadding='2'width="100%">
				<tr>
					<td>期号:</td><td><select class="easyui-combobox" id="edit_issuenumber" data-options="url:'/management/jc/issuenumber/tips',method:'get',valueField:'issuenumber',textField:'issuenumber',panelHeight:'200',readonly:true,width:155" ></select></td>
					<td>征订代码：</td><td><input class="easyui-textbox" type="text" id="edit_subcode" data-options="readonly:true" /></td>
				</tr>
				<tr>
					<td>条码：</td><td><input class="easyui-textbox" type="text" id="edit_barcode" data-options="readonly:true" /></td>
					<td>书名：</td><td><input class="easyui-textbox" type="text" id="edit_descr"  data-options="readonly:true"/></td>
				</tr>
				<tr>
					<td>出版社：</td><td><select class="easyui-combobox" id="edit_publisher" data-options="url:'/management/jc/storer/tips?type=1',method:'get',valueField:'storerkey',textField:'shortname',panelHeight:'200',readonly:true,width:155" ></select></td>
					<td>定价：</td><td><input class="easyui-textbox" type="text" id="edit_price" data-options="readonly:true" /></td>
				</tr>
				<tr>
					<td>分发店：</td><td><select class="easyui-combobox" id="edit_customer" data-options="url:'/management/jc/storer/tips?type=0',method:'get',valueField:'storerkey',textField:'shortname',panelHeight:'200',width:155" ></select></td>
					<td>分发数量：</td><td><input class="easyui-textbox" type="text" id="edit_qtyfenfa"/></td>
				</tr>
				<tr>
					<td colspan='8' align="center">&nbsp;&nbsp;&nbsp;
						<a class="easyui-linkbutton" iconCls="icon-ok" onclick="editInfo()">提交</a>
					</td>
				</tr>
			</table>
		</form>
	</div>
	<!-- 工具栏 -->
	<div id="tb" style="text-align:center">
    	<a class="easyui-linkbutton" iconCls="icon-add" onClick="tool.add();">添加</a>
    	<a class="easyui-linkbutton" iconCls="icon-edit" onClick="tool.edit();">修改</a>
    	<a class="easyui-linkbutton" iconCls="icon-remove" onClick="tool.remove();">删除</a>
    </div>
	<div align="center" style="padding-top:5px;">
		<form>
			<table id="data" class="easyui-datagrid" width='100%' data-options="collapsible:false,height:'auto',singleSelect:true,fitColumns: true,striped:true,rownumbers:true,
			border:true,pagination:true,pageSize:20,pageList:[10,15,20],pagePosition:'bottom',toolbar:'#tb'">
			</table>
		</form>
	</div>	
  </body>
</html>
