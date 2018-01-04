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
			
				//检查学生姓名值 
				var stuName = $.trim($('#txtStuName').val());
				if(stuName.length < 1)
				{
					alert('姓名不能为空！');
					return false;
				}
				
				//检查年龄值是否是数值
				var stuAge = $.trim($('#txtStuAge').val());
				if(/[^\d+]/gi.test(stuAge))
				{
					alert('年龄填写整数值！');
					return false;
				}
			
				//检查学生学号值 
				var stuNo = $.trim($('#txtStuNo').val());
				if(stuNo.length < 1)
				{
					alert('学号不能为空！');
					return false;
				}
				
				//检查班级值
				var cno = $.trim($('#txtCno').val());
				if(cno.length < 1)
				{
					alert('班级不能为空！');
					return false;
				}
				
				//检查年级值
				var gno = $.trim($('#txtGno').val());
				if(gno.length < 1)
				{
					alert('年级不能为空！');
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
									<form action="student" class="form-horizontal row-fluid" method="post" onsubmit="return formCheck();">
										
										
										<div class="control-group">
											<label class="control-label" for="basicinput"><span class="red">*</span>姓名：</label>
											<div class="controls">
												<input class="span3" type="text" id="txtStuName" name="stuName" placeholder="填写姓名"/>
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
												<input class="span3" type="text" id="txtStuAge" name="stuAge" maxlength="2" placeholder="填写年龄"/>
											</div>
										</div>

										<div class="control-group">
											<label class="control-label" for="basicinput"><span class="red">*</span>学号：</label>
											<div class="controls">
												<input class="span3" type="text" id="txtStuNo" name="stuNo" placeholder="填写学号"/>
											</div>
										</div>

										<div class="control-group">
											<label class="control-label" for="basicinput"><span class="red">*</span>班级：</label>
											<div class="controls">
												<input class="span3" type="text" id="txtCno" name="cno" placeholder="选择班级"/>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput"><span class="red">*</span>年级：</label>
											<div class="controls">
												<input class="span3" type="text" id="txtGno" name="gno" placeholder="填写年级"/>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">住址：</label>
											<div class="controls">
												<input class="span8" type="text" id="txtStuAddr" name="stuAddr" placeholder="填写住址" />
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