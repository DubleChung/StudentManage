<%@ page language="java" import="java.util.*,com.stu.model.*;"	pageEncoding="gbk"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://"
			+ request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
	
%>

<!DOCTYPE HTML PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN">
<html>
	<head>
		<base href="<%=basePath %>">
		<title>添加学生信息</title>
		<!-- 引入公共网页头部 -->
		<jsp:include page="/views/include_common.jsp"/>
		
		<script type="text/javascript">
		
			//表单检查 ，如果返回false则不会提交表单，true提交。
			function formCheck(){
			
				//检查原密码值 
				var uPassword = $.trim($('#txtUPassword').val());
				if(uPassword.length < 1)
				{
					alert('原密码不能为空！');
					return false;
				}
				//检查新密码值 
				var newUPassword = $.trim($('#txtNewUPassword').val());
				if(newUPassword.length < 1)
				{
					alert('新密码不能为空！');
					return false;
				}
				//检查确认新密码值 
				var reNewUPassword = $.trim($('#txtReNewUPassword').val());
				if(reNewUPassword.length < 1)
				{
					alert('确认新密码不能为空！');
					return false;
				}
				
				//默认返回true 
				return true;
			}
		</script>
	</head>

	<body>
		<!-- 引入顶部 -->
		<jsp:include page="/views/top.jsp"/>

        <div class="wrapper">
            <div class="container">
                <div class="row">
                    <div class="span2">
                    	<!-- 引入左菜单 -->
                    	<jsp:include page="/views/left.jsp"/>
                    </div>
                    <!--/.span3-->
                    <div class="span10">
                        <div class="content">
                        	<!-- 页面右侧内容 -->
                        	
						<div class="module">
							<div class="module-head">
								<b>添加学生</b>
							</div>
							<div class="module-body">
									<form action="admin" class="form-horizontal row-fluid" method="post" onsubmit="return formCheck();">
										
										<div class="control-group">
											<label class="control-label" for="basicinput"><span class="red">*</span>原密码：</label>
											<div class="controls">
												<input class="span3" type="text" id="txtUPassword" name="uPassword" placeholder="填写原密码"/>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">新密码：</label>
											<div class="controls">
												<input class="span3" type="text" id="txtNewUPassword" name="newUPassword" maxlength="2" placeholder="填写新密码"/>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">确认新密码：</label>
											<div class="controls">
												<input class="span3" type="text" id="txtReNewUPassword" name="newUPassword" maxlength="2" placeholder="填写确认新密码"/>
											</div>
										</div>

										<div class="control-group">
											<div class="controls">
												<input type="hidden" name="cmd" value="changpwd"/>
												<button type="submit" class="btn btn-small btn-info">保存</button>
											</div>
										</div>
										
									</form>
							</div>
						</div>
                        </div>
                        <!--/.content-->
                    </div>
                    <!--/.span9-->
                </div>
            </div>
            <!--/.container-->
        </div>
        <!--/.wrapper-->
        
        <!-- 引入网页公共页脚 -->
        <jsp:include page="/views/footer.jsp"></jsp:include>
        <!-- 引入消息脚本页面 -->
        <jsp:include page="/views/message.jsp"></jsp:include>
	</body>

</html>