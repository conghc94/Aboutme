<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE HTML>
<!-- Website Template by freewebsitetemplates.com -->
<html>
<head>
	<meta charset="UTF-8">
	<title>MyProject</title>
	<link rel="stylesheet" href="<%=request.getContextPath() %>/templates/public/css/style.css" type="text/css">
	
	<!--[if IE 7]>
		<link rel="stylesheet" href="css/ie7.css" type="text/css">
	<![endif]-->
	<script type="text/javascript" src="<%=request.getContextPath() %>/library/js/js1/jssor.js"></script>
    <script type="text/javascript" src="<%=request.getContextPath() %>/library/js/js1/jssor.slider.js"></script> 
    <script type="text/javascript" src="<%=request.getContextPath() %>/library/js/js1/jquery-1.9.1.min.js"></script>  
    
      
</head>
<body>
	<div id="header">
		<div>
			<div>
				<span>Hoàng Chí Công</span>
				<a href="<%=request.getContextPath()%>/home" class="logo"><img src="<%=request.getContextPath() %>/templates/public/images/logo.png" alt=""></a>
				<span class="tagline">Mỗi ngày là một món quà</span>
			</div>
			<ul>
				<%
                    	String setActiveAboutMe = "";
						String setActiveContact= "";
						String setActiveHome= "";
						String setActiveNews= "";
						String setActiveThanhVien= "";
						String setActiveProject= "";
						if(request.getAttribute("setActiveContact")!=null) setActiveContact= "class='selected'";
                    	if(request.getAttribute("setActiveAboutMe")!=null) setActiveAboutMe = "class='selected'";
                    	if(request.getAttribute("setActiveHome")!=null) setActiveHome="class='selected'";
                    	if(request.getAttribute("setActiveNews")!=null) setActiveNews="class='selected'";
                    	if(request.getAttribute("setActiveProject")!=null) setActiveProject="class='selected'";
                    	if(request.getAttribute("setActiveThanhVien")!=null) setActiveThanhVien="class='selected'";
                    %>
				<li <%=setActiveHome %>>
					<a href="<%=request.getContextPath()%>/home">Trang chủ</a>
				</li>
				<li  <%=setActiveAboutMe %>>
					<a href="<%=request.getContextPath()%>/aboutme">Giới thiệu</a>
				</li>
				<li <%=setActiveProject %>>
					<a  href="<%=request.getContextPath()%>/project">Dự án thực hiện</a>
				</li>
				<li <%=setActiveNews %>>
					<a href="<%=request.getContextPath()%>/News">Tin tức</a>
				</li>
				<li <%=setActiveContact %>>
					<a  href="<%=request.getContextPath() %>/contact">Liên hệ</a>
				</li>
			</ul>
		</div>
	</div>