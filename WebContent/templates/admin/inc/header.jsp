<%@page import="bean.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Strict//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-strict.dtd">
<html xmlns="http://www.w3.org/1999/xhtml">
	<head>
		<meta http-equiv="content-type" content="text/html; charset=utf-8" />
		<title>AboutMe_Hoàng Chí Công</title>
        <link rel="stylesheet" type="text/css" href="<%=request.getContextPath() %>/templates/admin/css/styles.css" media="screen" />
		 <script type="text/javascript" src="<%=request.getContextPath() %>/library/js/jquery-2.1.4.min.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/library/js/jquery.validate.js"></script>
		<script type="text/javascript" src="<%=request.getContextPath() %>/library/js/ckeditor/ckeditor.js"></script>
	</head>
	<body>
    	<!-- Header -->
        <div id="header">
            <!-- Header. Status part -->
            <div id="header-status">
                <div class="container_12">
                    <div class="grid_4">
                    	<ul class="user-pro">
							<%
                    			Users objSUser=(Users)session.getAttribute("objSUser");
                    			if(objSUser!=null){
                    		%>
							<li><a href="<%=request.getContextPath()%>/admin/logout">Logout</a></li>
							<li>Chào<a href="<%=request.getContextPath()%>/admin/editUsers?idU=<%=objSUser.getIdUsers()%>"><%=objSUser.getFullname()%></a></li>
							<%}else{ %>
								<li><a href="<%=request.getContextPath()%>/admin/logout">Logout</a></li>
								<li>Chào khách <a href="<%=request.getContextPath()%>/admin/login">login</a></li>
							<%} %>
                    	</ul>
                    </div>
                </div>
                <div style="clear:both;"></div>
            </div> <!-- End #header-status -->
            
            <!-- Header. Main part -->
            <div id="header-main">
                <div class="container_12">
                    <div class="grid_12">
                        <div id="logo">
                            <ul id="nav">
                                <li id="current"><a href="<%=request.getContextPath()%>/admin/index">Quản trị</a></li>
                                <li><a href="<%=request.getContextPath()%>/admin/profile">Tài khoản</a></li>
                            </ul>
                        </div><!-- End. #Logo -->
                    </div><!-- End. .grid_12-->
                    <div style="clear: both;"></div>
                </div><!-- End. .container_12 -->
            </div> <!-- End #header-main -->
            <div style="clear: both;"></div>
            <!-- Sub navigation -->
            <div id="subnav">
                <div class="container_12">
                    <div class="grid_12">
                    
                        <ul>
                       		 <li><a href="<%=request.getContextPath()%>/admin/gioithieu">Giới thiệu</a></li>
                       		 <li><a href="<%=request.getContextPath()%>/admin/duanthuchien">Dự án thực hiện</a></li>
                            <li><a href="<%=request.getContextPath()%>/admin/news">Tin tức</a></li>
                            <li><a href="<%=request.getContextPath()%>/admin/category">Danh mục</a></li>
                            <li><a href="<%=request.getContextPath()%>/admin/indexUsers">Người dùng</a></li>
                            <li><a href="<%=request.getContextPath()%>/admin/contact">Liên hệ</a></li>
                            <li><a href="<%=request.getContextPath()%>/admin/saying">Câu nói hay</a></li>
                            <li><a href="<%=request.getContextPath()%>/admin/advs">Quảng cáo</a></li>
                        </ul>
                        
                    </div><!-- End. .grid_12-->
                </div><!-- End. .container_12 -->
                <div style="clear: both;"></div>
            </div> <!-- End #subnav -->
        </div> <!-- End #header -->
        
		<div class="container_12">