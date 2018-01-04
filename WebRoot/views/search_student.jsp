<%@ page language="java" import="java.util.*,com.stu.model.*;"	pageEncoding="gbk"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/functions" prefix="fn" %>
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
		<title>ѧ����ѯ</title>
		<!-- ���빫����ҳͷ�� -->
		<jsp:include page="/views/include_common.jsp"/>
		<script type="text/javascript">
			function pageClick(pageIndex){
				window.location.href = '<%=basePath %>student?cmd=stulist&currentPage=' + pageIndex 
										+ '&stuName=' + $.trim($('txtStuName').val()) 
										+ '&stuNo=' + $.trim($('txtStuNo').val());
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
								<b>ѧ����ѯ</b>
							</div>
							<div class="module-body table">
								<div class="dataTables_length">
									<form action="student" method="get" class="form-horizontal row-fluid">
										<div class="control-group" style="height:35px;">
											<input type="hidden" name="cmd" value="stulist"/>
											<label class="control-label" style="width:65px;"><span class="red">*</span>������</label>
											<input class="span3" style="float:left;" type="text" id="txtStuName" name="stuName" value="${requestScope.stuName}" placeholder="��д����"/>
											<label class="control-label"  style="width:65px;"><span class="red">*</span>ѧ�ţ�</label>
											<input class="span3" style="float:left;" type="text" id="txtStuNo" name="stuNo" value="${requestScope.stuNo}" placeholder="��дѧ��"/>
											<button type="submit left" class="btn btn-small btn-info icon-search" style="height:auto;margin-left:10px;">��ѯ</button>
										</div>
									</form>
								</div>
								<table cellpadding="0" cellspacing="0" border="0" class="datatable-1 table table-bordered table-striped	 display" width="100%">
									<thead>
										<tr>
											<th>��ʶID</th>
											<th>����</th>
											<th>ѧ��</th>
											<th>�༶���</th>
											<th>�꼶���</th>
											<th>����</th>
											<th>סַ</th>
											<th>�Ա�</th>
										</tr>
									</thead>
									<%--<tbody>
										<c:forEach items="${requestScope.stuList}"  var="li" >
											<tr>
										        <td>${li.stuid}</td>
										        <td>${li.stuName}</td>
										        <td>${li.stuNo}</td>
										        <td>${li.cno}</td>
										        <td>${li.gno}</td>
										        <td>${li.stuAge}</td>
										        <td>${li.stuAddr}</td>
										        <td>${li.stuSex}</td>
										    </tr>
										</c:forEach>
									</tbody>
									--%>
									<!-- �������� -->
									<tbody>
							         
							                  <c:forEach var="li" items="${requestScope.pageBean.pageData}">
							                      <tr>
											        <td>${li.stuid}</td>
											        <td>${li.stuName}</td>
											        <td>${li.stuNo}</td>
											        <td>${li.cno}</td>
											        <td>${li.gno}</td>
											        <td>${li.stuAge}</td>
											        <td>${li.stuAddr}</td>
											        <td>${li.stuSex}</td>
							                      </tr>
							                  </c:forEach>
						          </tbody>
						          <tfoot>
							          <tr>
							              <td colspan="8" align="center">
							              		ÿҳ${requestScope.pageBean.pageSize}�� , ��ǰ${requestScope.pageBean.currentPage}
							                  /${requestScope.pageBean.totalPage}
							                  	ҳ     &nbsp;&nbsp;
							                  <a href="javascript:pageClick(1)">��ҳ</a>
							                  <a href="javascript:pageClick(${requestScope.pageBean.prevPage})">��һҳ </a>
							                  <a href="javascript:pageClick(${requestScope.pageBean.nextPage})">��һҳ </a>
							                  <a href="javascript:pageClick(${requestScope.pageBean.lastPage})">ĩҳ</a>
							              </td>
							          </tr>
						          </tfoot>
								</table>
							</div>
						</div><!--/.module-->
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
        
	</body>
</html>