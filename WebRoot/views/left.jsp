<%@ page language="java" import="java.util.*" pageEncoding="gbk"%>

<div class="sidebar">
    <ul class="widget widget-menu unstyled">
        <li>
	        <a href="student?cmd=stulist">
	        	<i class="menu-icon icon-search"></i>学生查询
	        </a>
        </li>
        <li class="active">
			<a href="views/add_student.jsp">
				<i class="menu-icon icon-edit"></i>学生注册
			</a>
        </li>
        <li>
	        <a href="score?cmd=scorelist">
	        	<i class="menu-icon icon-link"></i>成绩查询
	        </a>
        </li>
        <li>
	        <a href="views/add_student_score.jsp">
	        	<i class="menu-icon icon-link"></i>成绩添加
	        </a>
        </li>
	</ul>
    <!--/.widget-nav-->
</div>
<!--/.sidebar-->