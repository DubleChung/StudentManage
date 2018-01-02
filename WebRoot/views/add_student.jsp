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
			function formCheck(){
				
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
									<form action="student" class="form-horizontal row-fluid" method="post">
										
										
										<div class="control-group">
											<label class="control-label" for="basicinput"><span class="red">*</span>姓名：</label>
											<div class="controls">
												<input class="span3" type="text" name="stuName" placeholder="填写姓名"/>
											</div>
										</div>

										<div class="control-group">
											<label class="control-label"><span class="red">*</span>性别：</label>
											<div class="controls">
												<label class="radio inline">
													<input type="radio" name="stuSex" value="1" checked="checked" />
													男
												</label> 
												<label class="radio inline">
													<input type="radio" name="stuSex" value="0" />
													女
												</label>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">年龄：</label>
											<div class="controls">
												<input class="span3" type="text" name="stuAge" placeholder="填写年龄"/>
											</div>
										</div>

										<div class="control-group">
											<label class="control-label" for="basicinput"><span class="red">*</span>学号：</label>
											<div class="controls">
												<input class="span3" type="text" name="stuNo" placeholder="填写学号"/>
											</div>
										</div>

										<div class="control-group">
											<label class="control-label" for="basicinput"><span class="red">*</span>班级：</label>
											<div class="controls">
												<input class="span3" type="text" name="cno" placeholder="选择班级"/>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput"><span class="red">*</span>年级：</label>
											<div class="controls">
												<input class="span3" type="text" name="gno" placeholder="填写年级"/>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">住址：</label>
											<div class="controls">
												<input class="span8" type="text" name="stuAddr" placeholder="填写住址" />
											</div>
										</div>

										<div class="control-group">
											<div class="controls">
												<input type="hidden" name="cmd" value="add"/>
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
        
        <jsp:include page="/views/message.jsp"></jsp:include>
	</body>

</html>