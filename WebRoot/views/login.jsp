<%@ page language="java" import="java.util.*" pageEncoding="GB18030"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath%>">
		<title>ϵͳ��¼</title>
		<meta http-equiv="pragma" content="no-cache">
		<meta http-equiv="cache-control" content="no-cache">
		<meta http-equiv="expires" content="0">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>
		<link href="css/style.css" rel='stylesheet' type='text/css' />
		<script type="text/javascript" src="js/jquery-1.11.2.min.js"></script>
		<script type="text/javascript" src="js/app/login.js"></script>
	</head>
	<body>
		<section class="login-form-wrap">
		<h1>ѧ���ɼ�����ϵͳ</h1>
		<div class="login-form">
			<div class="head-info">
				<label class="lbl-1">
				</label>
				<label class="lbl-2">
				</label>
				<label class="lbl-3">
				</label>
			</div>
			<div class="clear">
			</div>
			<div class="avtar">
				<img src="images/login/avtar.png" />
			</div>
			<div style="color: white"></div>
			<form action="loginController.do?doLogin" method="post" check="loginController.do?doCheck">
				<input type="text" id="username" name="username" placeholder="�������û���">
				<input type="password" id="password" name="password" placeholder="����������">
				<input type="text" id="captcha" name="captcha" placeholder="��֤��">
				<div>
					<img style="float: right;" title="�������" id="img_captcha" onclick="javascript:refreshCaptcha();" src="captchaCode">
				</div>
				<br />
				<div id="errormsg" style="color: red"></div>
			</form>
			<div class="signin">
				<input id="login" type="button" value="��½">
			</div>
		</div>
		</section>
	</body>
</html>