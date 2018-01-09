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
		<title>�ɼ����</title>
		<!-- ���빫����ҳͷ�� -->
		<jsp:include page="/views/include_common.jsp"/>
		<!-- �����Զ���ȫ��� -->
		<script type="text/javascript" src="scripts/jquery.autocomplete.min.js"></script>
		<style type="text/css">
			.autocomplete-suggestions { border: 1px solid #999; background: #FFF; overflow: auto; }
			.autocomplete-suggestion { padding: 2px 5px; white-space: nowrap; overflow: hidden; }
			.autocomplete-selected { background: #F0F0F0; }
			.autocomplete-suggestions strong { font-weight: normal; color: #3399FF; }
		</style>
		<script type="text/javascript">		
			
			//�ĵ�������ɣ�ִ���Զ���ȫ�����ʼ��
			$(function(){
			
				//�Զ���ȫ���
				//��������ѧ������
				$('#txtStuName').autocomplete({
				    serviceUrl: 'student?cmd=json_stulist&currentPage=1&stuName=' + $.trim($('#txtStuName').val()),//ֻ����������
				    onSelect: function (selData) {
				    	//��ѡ��һ������ʱ����ѧ�����õ������ֶ���
				    	$('#hdStuNo').val(selData.data);
       				}
				});
				
			});
		
			
			//����� ���������false�򲻻��ύ����true�ύ��
			function formCheck(){
			
				//�������ֵ 
				var stuName = $.trim($('#txtStuName').val());
				var stuNo = $.trim($('#hdStuNo').val());
				if(stuName.length < 1 || stuNo.length < 1)
				{
					alert('�޸�ѧ������δ����������ѧ����Ϣ������ӳɼ���');
					return false;
				}
				
				//���γ�ֵ
				var course = $.trim($('#txtCourse').val());
				if(course.length < 1)
				{
					alert('�γ̲���Ϊ�գ�');
					return false;
				}
				
				//������ֵ 
				var score = $.trim($('#txtScore').val());
				if(score.length < 1)
				{
					alert('��������Ϊ�գ�');
					return false;
				}
				if(parseFloat(score) > 150.0)
				{
					alert('ȷ������ô�ߵķ���');
					return false;
				}
				if(parseFloat(score) < 0.0)
				{
					alert('0���Ѿ������ҵ��ˣ�����Ҫ��������');
					return false;
				}
				
				//�����������ֵ�Ƿ�����ֵ( ������ʽ��^\d+(\.\d+)?$  ��⸡����  )
				if(!(/^\d+(\.\d+)?$/gi.test(score)))
				{
					alert('��������д��ȷ��ֵ��');
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
                        	<!-- ҳ���Ҳ�����  -->
                        	
						<div class="module">
							<div class="module-head">
								<b>�ɼ����</b>
							</div>
							<div class="module-body">
									<form action="score" class="form-horizontal row-fluid" method="post" onsubmit="return formCheck();">
										
										<div class="control-group">
											<label class="control-label"><span class="red">*</span>������</label>
											<div class="controls">
												<input class="span4" type="text" id="txtStuName" name="stuName" placeholder="��д���������Զ�����" autocomplete="off"/>
											</div>
										</div>
										
										<div class="control-group">
											<label class="control-label" for="basicinput">�γ̣�</label>
											<div class="controls">
												<input class="span4" type="text" id="txtCourse" name="Course" placeholder="��д�γ�" autocomplete="off"/>
											</div>
										</div>

										<div class="control-group">
											<label class="control-label" for="basicinput"><span class="red">*</span>�ɼ���</label>
											<div class="controls">
												<input class="span4" type="text" id="txtScore" name="Score" maxlength="3" placeholder="��д�ɼ�" autocomplete="off"/>
											</div>
										</div>

										<div class="control-group">
											<div class="controls">
												<input type="hidden" name="cmd" value="addscore"/>
												<!-- �����ֶΣ����ڱ���ѧ�� -->
												<input type="hidden" id="hdStuNo" name="stuNo" value=""/>
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
        
        <!-- ������ҳ����ҳ��ҳ�� -->
        <jsp:include page="/views/footer.jsp"></jsp:include>
        <!-- ������Ϣ�ű�ҳ�� -->
        <jsp:include page="/views/message.jsp"></jsp:include>
	</body>

</html>