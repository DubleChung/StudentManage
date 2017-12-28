<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%@page import="com.sun.mail.iap.Response"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
  <head>
    <base href="<%=basePath%>">
    <title></title>
	<meta http-equiv="pragma" content="no-cache">
	<meta http-equiv="cache-control" content="no-cache">
	<meta http-equiv="expires" content="0">
  </head>
  <body>
		<table width="300" height="121" border="1" align="center"
			cellpadding="0" cellspacing="0" bordercolor="#ffffff"
			bordercolordark="#D1E2D6" bordercolorlight="#FFFFFF">
			<form action="/admin" method="post" name="form1">
			<tr align="center" valign="middle" bgcolor="#F7F3EF">
				<td height="30" colspan="2">
					<span class="style1">管理员登录</span>
				</td>
			</tr>
			<tr>
				<td height="30" align="center" valign="middle">
					审批员代码:
				</td>
				<td width="172" align="left" valign="middle">
					<input name="name" type="text" style="width: 120pt;">
				</td>
			</tr>
			<tr>
				<td height="30" align="center" valign="middle">
					密&nbsp;&nbsp;&nbsp;&nbsp;&nbsp;码:
				</td>
				<td height="30" align="left" valign="middle">
					<input name="password" type="password" style="width: 120pt;">
				</td>
			</tr>
			<tr align="center" bgcolor="#F7F3EF">
				<td height="30" colspan="2" valign="middle">
					<input type="submit" name="Submit" value="提交"
						onClick="return check()">
					<input type="reset" name="Submit2" value="重置">
				</td>
			</tr>
			</form>
		</table>
  </body>
</html>