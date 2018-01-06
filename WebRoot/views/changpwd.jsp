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
		<title>���ѧ����Ϣ</title>
		<!-- ���빫����ҳͷ�� -->
		<jsp:include page="/views/include_common.jsp"/>
		
		<script type="text/javascript">
		
			//����� ���������false�򲻻��ύ����true�ύ��
			function formCheck(){
			
				//���ԭ����ֵ 
				var uPassword = $.trim($('#txtUPassword').val());
				if(uPassword.length < 1)
				{
					alert('ԭ���벻��Ϊ�գ�');
					return false;
				}
				//���������ֵ 
				var newUPassword = $.trim($('#txtNewUPassword').val());
				if(newUPassword.length < 1)
				{
					alert('�����벻��Ϊ�գ�');
					return false;
				}
				//���ȷ��������ֵ 
				var reNewUPassword = $.trim($('#txtReNewUPassword').val());
				if(reNewUPassword.length < 1)
				{
					alert('ȷ�������벻��Ϊ�գ�');
					return false;
				}
				
				//Ĭ�Ϸ���true 
				return true;
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
								<b>���ѧ��</b>
							</div>
							<div class="module-body">
									<form action="admin" class="form-horizontal row-fluid" method="post" onsubmit="return formCheck();">
										
										<div class="control-group">
											<label class="control-label" for="basicinput"><span class="red">*</span>ԭ���룺</label>
											<div class="controls">
												<input class="span3" type="text" id="txtUPassword" name="uPassword" placeholder="��дԭ����"/>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">�����룺</label>
											<div class="controls">
												<input class="span3" type="text" id="txtNewUPassword" name="newUPassword" maxlength="2" placeholder="��д������"/>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">ȷ�������룺</label>
											<div class="controls">
												<input class="span3" type="text" id="txtReNewUPassword" name="newUPassword" maxlength="2" placeholder="��дȷ��������"/>
											</div>
										</div>

										<div class="control-group">
											<div class="controls">
												<input type="hidden" name="cmd" value="changpwd"/>
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
        <!-- ������Ϣ�ű�ҳ�� -->
        <jsp:include page="/views/message.jsp"></jsp:include>
	</body>

</html>