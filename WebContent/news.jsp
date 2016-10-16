<%@page import="library.LibraryString"%>
<%@page import="java.text.SimpleDateFormat"%>
<%@page import="java.util.Date"%>
<%@page import="bean.News"%>
<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp" %>
	<%
		ArrayList<Category> alCat = (ArrayList<Category>) request.getAttribute("alCat");
		ArrayList<ArrayList<News>> alNews =(ArrayList<ArrayList<News>>)request.getAttribute("alNews");
		Date today=new Date(System.currentTimeMillis());
		SimpleDateFormat timeFormat= new SimpleDateFormat("hh:mm:ss dd/MM/yyyy");
		String s=timeFormat.format(today.getTime());
	%>
	<div id="body">
		<div class="section">
			<h2>Trang tin Chí Công</h2>
			
			<p class="ptop">
				Cập nhật các tin tức mới nhất về hoạt động xã hội của Chí Công hoặc những tin tức ngoài lề mà Chí Công quan tâm:
			</p>
			
			<!-- begin block -->
			
			<!-- end block -->
			<%
				if(alCat!=null){
					for(int i=0;i<alCat.size();i++){
			%>
			<!-- begin block -->
			<div class="project-wrap">
				<h3 class="title"><%=alCat.get(i).getName() %></h3>
				<div class="project-top">
					<a href="#"><img src="<%=request.getContextPath() %>/files/<%=alNews.get(i).get(0).getPicture() %>" alt=""></a>
					<div>
						<b><a href="<%=request.getContextPath() %>/tin-tuc/<%=LibraryString.createSlug(alNews.get(i).get(0).getName()) %>-<%=alNews.get(i).get(0).getIdNews() %>.html"><%=alNews.get(i).get(0).getName() %></a></b> 
						<small>Ngày đăng:<%=s %></small>
						<p class="preview_text">
							<%=alNews.get(i).get(0).getPreview_text()%>						
						</p>
					</div>
				</div>
				<ul class="article">
					<%	
						if(alNews!=null){
						for(int j=1; j<alNews.get(i).size(); j++){
					%>
					<li>
						<a href="#"><img src="<%=request.getContextPath() %>/files/<%=alNews.get(i).get(j).getPicture() %>" alt=""></a>
						 <b><a href="<%=request.getContextPath() %>/tin-tuc/<%=LibraryString.createSlug(alNews.get(i).get(j).getName()) %>-<%=alNews.get(i).get(j).getIdNews() %>.html"><%=alNews.get(i).get(j).getName() %></a></b> 
						<small>Ngày Đăng:<%=s %></small>
						<p>
							<%=alNews.get(i).get(j).getName() %>
						</p>
						
					</li>
					<%}} %>
				</ul>
				
				<div class="clr"></div>
			</div> <!-- end block -->
			<%}}%>
		
		</div>
		
	</div>
	
	
	<div id="footer">
		<%@include file="/templates/public/inc/footer.jsp" %>
	</div>
</body>
</html>