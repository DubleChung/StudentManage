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
		<title>添加学生成绩</title>
		<!-- 引入公共网页头部 -->
		<jsp:include page="/views/include_common.jsp"/>
		<script type="text/javascript" src="scripts/jquery.autocomplete.js"></script>
		<style type="text/css">
			.autocomplete-suggestions { border: 1px solid #999; background: #FFF; overflow: auto; }
			.autocomplete-suggestion { padding: 2px 5px; white-space: nowrap; overflow: hidden; }
			.autocomplete-selected { background: #F0F0F0; }
			.autocomplete-suggestions strong { font-weight: normal; color: #3399FF; }
		</style>
		<script type="text/javascript">
			$(function(){
				$('#txtStuName').autocomplete({
				    serviceUrl: 'student?cmd=json_stulist&currentPage=1&stuName=' + $.trim($('#txtStuName').val()),//只用姓名条件
				    onSelect: function (data) {
				    	if(window.console && window.console.log)
				    		console.log(data);
				    	$('#hdStuNo').val(data.val);
       				}
				});
			});
		
			
			//表单检查 ，如果返回false则不会提交表单，true提交。
			function formCheck(){
			
				//检查姓名值 
				var stuName = $.trim($('#txtStuName').val());
				if(stuName.length < 1)
				{
					alert('姓名不能为空！');
					return false;
				}
				
				//检查课程值
				var course = $.trim($('#txtCourse').val());
				if(course.length < 1)
				{
					alert('课程不能为空！');
					return false;
				}
				
				//检查分数值 
				var score = $.trim($('#txtScore').val());
				if(score.length < 1)
				{
					alert('分数不能为空！');
					return false;
				}
				if(parseFloat(score) > 150.0)
				{
					alert('确认有这么高的分吗？');
					return false;
				}
				if(parseFloat(score) < 0.0)
				{
					alert('0分已经够惨烈的了，还需要给负分吗。');
					return false;
				}
				
				//正则检查检查分数值是否是数值( 正则表达式：^\d+(\.\d+)?$  检测浮点数  )
				if(!(/^\d+(\.\d+)?$/gi.test(score)))
				{
					alert('分数请填写正确数值！');
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
								<b>添加成绩</b>
							</div>
							<div class="module-body">
									<form action="student" class="form-horizontal row-fluid" method="post" onsubmit="return formCheck();">
										
										<div class="control-group">
											<label class="control-label"><span class="red">*</span>姓名：</label>
											<div class="controls">
												<input class="span4" type="text" id="txtStuName" name="stuName" placeholder="填写姓名，会自动搜索" autocomplete="off"/>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">课程：</label>
											<div class="controls">
												<input class="span4" type="text" id="txtCourse" name="Course" placeholder="填写课程"/>
											</div>
										</div>

										<div class="control-group">
											<label class="control-label" for="basicinput"><span class="red">*</span>成绩：</label>
											<div class="controls">
												<input class="span4" type="text" id="txtScore" name="Score" maxlength="3" placeholder="填写成绩"/>
											</div>
										</div>

										<div class="control-group">
											<div class="controls">
												<input type="hidden" name="cmd" value="addscore"/>
												<!-- 隐藏字段，用于保存学号 -->
												<input type="hidden" id="hdStuNo" name="stuNo" value=""/>
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