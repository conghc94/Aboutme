<%@page import="bean.Project"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <div class="float-left">
	  	<%
			if ("1".equals(request.getParameter("msg"))) {
		%>
		<p style="color: green; font-weight: bold">Thêm thành công</p>
		<%
			}
		%>
		<%
			if ("1".equals(request.getParameter("emsg"))) {
		%>
		<p style="color: green; font-weight: bold">Sửa thành công</p>
		<%
			}
		%>
		
		 <%
			if ("1".equals(request.getParameter("del"))) {
		%>
		<p style="color: green; font-weight: bold">Xóa thành công</p>
		<%
			}
		%>
		 <%
			if ("1".equals(request.getParameter("e"))) {
		%>
		<p style="color: red; font-weight: bold">Chỉ có admin mới có thể xóa </p>
		<%
			}
		%>
	
	
		  <a href="<%=request.getContextPath() %>/admin/addProject?type=load" class="button">
			<span>Thêm tin <img src="<%=request.getContextPath() %>/templates/admin/images/plus-small.gif" alt="Thêm tin"></span>
		  </a>
	  </div>
	  <div class="clear"></div>
</div>

<div class="grid_12">
	<!-- Example table -->
	<div class="module">
		<h2><span>Danh sách tin</span></h2>
		
		<div class="module-table-body">
			<form action="">
			<%
				ArrayList<Project> alProject=(ArrayList<Project>)request.getAttribute("alProject");
					
			%>
			<table id="myTable" class="tablesorter">
				<thead>
					
					<tr>
						<th style="width:4%; text-align: center;">ID</th>
						<th>Tên</th>
						<th style="width:20%">Mô tả</th>
						<th style="width:20%">Link</th>
						<th style="width:16%; text-align: center;">Hình ảnh</th>
						<th style="width:11%; text-align: center;">Chức năng</th>
					</tr>
				
				</thead>
				<tbody>
					<%
					if(alProject!=null){
						for(Project objProject: alProject){
					
					%>
					<tr>
						<td class="align-center"><%=objProject.getId_project() %></td>
						<td><a href=""><%=objProject.getName() %></a></td>
						<td><%=objProject.getPreview_text() %></td>
						<td><a href=""><%=objProject.getLink() %></a></td>
						<td align="center"><img src="<%=request.getContextPath() %>/files/<%=objProject.getPicture() %>" class="hoa" /></td>
						<td align="center">
							<a href="<%=request.getContextPath() %>/admin/editProject?idP=<%=objProject.getId_project()%>">Sửa <img src="<%=request.getContextPath() %>/templates/admin/images/pencil.gif" alt="edit" /></a>
							<a href="<%=request.getContextPath() %>/admin/delProject?idP=<%=objProject.getId_project()%>" onclick="return confirm('Are you sure?')">Xóa<img src="<%=request.getContextPath() %>/templates/admin/images/bin.gif" width="16" height="16" alt="delete" /></a>
						</td>
					</tr>
						<%}} %>
				</tbody>
			</table>
			</form>
		 </div> <!-- End .module-table-body -->
	</div> <!-- End .module -->
		 <div class="pagination">           
			<div class="numbers">
				<%
				int numberOfPage = (Integer) request.getAttribute("numberOfPage");
				int currentPage = (Integer) request.getAttribute("currentPage");
			%>
			<span>Trang:</span>
			<%
				for (int i = 1; i <= numberOfPage; i++) {
					if(i!=currentPage){
			%>
			<a href="<%=request.getContextPath()%>/admin/duanthuchien?page=<%=i%>"><%=i%></a> 
				<%if(i!=numberOfPage){ %>
				<span>|</span>
				<%} %>
			<%
				} else {
			%>
			<a href="<%=request.getContextPath()%>/admin/duanthuchien?page=<%=i%>" class="current"><%=i%></a> <span>|</span>
			<%}} %>
			</div> 
			<div style="clear: both;"></div> 
		 </div>
	
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 