<%@page import="bean.Project"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp" %>
	
	<div id="body">
		<div class="content">
			
			<div id="blog">
				<h2>Các dự án đã thực hiện</h2>
				<%
					ArrayList<Project> alProject=(ArrayList<Project>)request.getAttribute("alProject");
						if(alProject!=null){
							for(Project objProject:alProject){
				%>
				<ul>
					<li>
						<div class="article">
							<h3><%=objProject.getName() %></h3>
							<p>
								<%=objProject.getPreview_text() %>
							</p>
							<a href="<%=objProject.getLink()%>" class="more" target="_blank">Truy cập trang này</a>
						</div>
						<div class="stats">
							<a href="http://vinaenter.edu.vn" class="more" target="_blank"><img src="<%=request.getContextPath() %>/files/<%=objProject.getPicture() %>" alt="" /></a>
						</div>
					</li>
					
				</ul>
				<%}} %>
				<ul class="paging">
					<%	
						String active="";
						int numberOfPage=(Integer)(request.getAttribute("numberOfPage"));
						int currentPage=(Integer)(request.getAttribute("currentPage"));
						for(int i=1;i<=numberOfPage;i++){
							if(currentPage==i){
								active="'return false;'";
							}else{
								active="";
								
							}
							if(i==1){
					%>
							<li>
								<a href=" <%=request.getContextPath()%>/project?page=1" onclick =<%=active %>>Đầu</a>
							</li>
							<li >
								<a href=" <%=request.getContextPath()%>/project?page=<%=currentPage-1%>" onclick=<%=active %> >Trước</a>
							</li>
							<%} %>
							<li>		
								<%
									if(i==currentPage){
								%>
										<a href="<%=request.getContextPath()%>/project?page=<%=i%>" onclick=<%=active %>><%=currentPage %></a>
								<%
									}
								%>	
							</li>
							<%if(i==numberOfPage) {%>
							<li >
								<a href="<%=request.getContextPath()%>/project?page=<%=currentPage+1%>" onclick=<%=active %>>Sau</a>
							</li>
							<li >
								<a href="<%=request.getContextPath()%>/project?page=<%=numberOfPage%>" onclick=<%=active %>>Cuối</a>
							</li>
					<%	
							}
						} 
					%>
				</ul>
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