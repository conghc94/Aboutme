<%@page import="library.LibraryString"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="bean.News"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp" %>
		<%
			News obj=(News)request.getAttribute("obj");
		Date today=new Date(System.currentTimeMillis());
		SimpleDateFormat timeFormat= new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
		String s=timeFormat.format(today.getTime());
		%>
	<div id="body">
		
		<div class="content">
			<div id="blog" class="blogdt">
				
				<div class="news_detail">
					<h1><%=obj.getName() %></h1>
					<p class="date">Ngày đăng:<%=s %> - Lượt đọc: 10</p>
					<div class="news_content">
						<p><%=obj.getDetail_text() %></p>
						
					</div>
				</div>
				
				<h4 class="relate">Tin liên quan</h4>
				<%
					ArrayList<News> alNews=(ArrayList<News>)request.getAttribute("alNews");
						if(alNews!=null){
							for(News objNews:alNews){
						
				%>
				<ul>
					<li>
						<div class="article">
							<h3><a href="<%=request.getContextPath() %>/chi-tiet/<%=LibraryString.createSlug(objNews.getName()) %>-<%=objNews.getIdNews() %>.html" class="more"><%=objNews.getName() %></a></h3>
							<p><%=objNews.getDetail_text() %></p>
								
							
						</div>
						<div class="stats">
							<a href="http://vinaenter.edu.vn" class="more" target="_blank"><img src="<%=request.getContextPath() %>/files/<%=objNews.getPicture() %>" alt="" /></a>
						</div>
					</li>
					
				</ul>
				<%}} %>
			</div>
			
			<div id="sidebar">
				<%@include file="/templates/public/inc/right-bar.jsp" %>
			</div>
			
			
		</div>
	</div>
	
	
	<div id="footer">
		<%@include file="/templates/public/inc/footer.jsp" %>
	</div>
</body>
</html>