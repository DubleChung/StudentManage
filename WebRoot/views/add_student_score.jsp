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
		<title>���ѧ���ɼ�</title>
		<!-- ���빫����ҳͷ�� -->
		<jsp:include page="/views/include_common.jsp"/>
		
		<script type="text/javascript">
			function formCheck(){
				
			}
		</script>
	</head>

	<body>
		<!-- ���붥�� -->
		<jsp:include page="/views/top.jsp"/>

        <div class="wrapper">
            <div class="container">
                <div class="row">
                    <div class="span2">
                    	<!-- ������˵� -->
                    	<jsp:include page="/views/left.jsp"/>
                    </div>
                    <!--/.span3-->
                    <div class="span10">
                        <div class="content">
                        	<!-- ҳ���Ҳ����� -->
                        	
						<div class="module">
							<div class="module-head">
								<b>��ӳɼ�</b>
							</div>
							<div class="module-body">
									<form action="student" class="form-horizontal row-fluid" method="post">
										
										
										<div class="control-group">
											<label class="control-label" for="basicinput"><span class="red">*</span>������</label>
											<div class="controls">
												<input class="span3" type="text" name="stuName" placeholder="��д����"/>
											</div>
										</div>

										
										<div class="control-group">
											<label class="control-label" for="basicinput">�γ̣�</label>
											<div class="controls">
												<input class="span3" type="text" name="Course" placeholder="��д�γ�"/>
											</div>
										</div>

										<div class="control-group">
											<label class="control-label" for="basicinput"><span class="red">*</span>�ɼ���</label>
											<div class="controls">
												<input class="span3" type="text" name="stuNo" placeholder="��д�ɼ�"/>
											</div>
										</div>

										<div class="control-group">
											<div class="controls">
												<input type="hidden" name="cmd" value="addscore"/>
												<button type="submit" class="btn btn-small btn-info">����</button>
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
        
        <!-- ������ҳ����ҳ�� -->
        <jsp:include page="/views/footer.jsp"></jsp:include>
        
        <jsp:include page="/views/message.jsp"></jsp:include>
	</body>

</html>