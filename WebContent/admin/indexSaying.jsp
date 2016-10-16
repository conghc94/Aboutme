<%@page import="bean.Saying"%>
<%@page import="bean.Contact"%>
<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <%
			if ("1".equals(request.getParameter("msg"))) {
		%>
		<p style="color: green; font-weight: bold">Thêm thành công</p>
		<%
			}
		%>
		
		<%
			if ("1".equals(request.getParameter("msge"))) {
		%>
		<p style="color: green; font-weight: bold">Xoá thành công</p>
		<%
			}
		%>
		  <%
			if ("1".equals(request.getParameter("mseg"))) {
		%>
		<p style="color: green; font-weight: bold">Sửa thành công</p>
		<%
			}
		%>
	  <div class="float-left">
		  <a href="<%=request.getContextPath() %>/admin/addSaying" class="button">
			<span>Thêm câu nói hay <img src="<%=request.getContextPath() %>/templates/admin/images/plus-small.gif" alt="Thêm tin"></span>
		  </a>
	  </div>
	  <div class="clear"></div>
</div>

<div class="grid_12">
	<!-- Example table -->
	<div class="module">
		<h2><span>Danh sách câu nói hay</span></h2>
		
		<div class="module-table-body">
			<form action="" method="post">
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID_Saying</th>
						<th>Content</th>
						<th>Author</th>
						<th style="width:11%; text-align: center;">Chức năng</th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<Saying> alSaying=(ArrayList<Saying>)request.getAttribute("alSaying");
							if(alSaying!=null){
								for(Saying objSaying: alSaying){
										
					%>
					<tr>
						<td class="align-center"><%=objSaying.getIdSaying() %></td>
						<td><a href="<%=request.getContextPath() %>/admin/editSaying?idS=<%=objSaying.getIdSaying() %>"><%=objSaying.getContent() %></a></td>
						<td class="align-center"><%=objSaying.getAuthor() %></td>
						
						<td align="center">
							<a href="<%=request.getContextPath() %>/admin/editSaying?idS=<%=objSaying.getIdSaying() %>">Sửa <img src="<%=request.getContextPath() %>/templates/admin/images/pencil.gif" alt="edit" /></a>
							<a href="<%=request.getContextPath() %>/admin/delSaying?idS=<%=objSaying.getIdSaying() %>" onclick="return confirm('Are you sure?')" >Xóa <img src="<%=request.getContextPath() %>/templates/admin/images/bin.gif" width="16" height="16" alt="delete" /></a>
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
			<a href="<%=request.getContextPath()%>/admin/saying?page=<%=i%>"><%=i%></a> 
				<%if(i!=numberOfPage){ %>
				<span>|</span>
				<%} %>
			<%
				} else {
			%>
			<a href="<%=request.getContextPath()%>/admin/saying?page=<%=i%>" class="current"><%=i%></a> <span>|</span>
			<%}} %>
			</div> 
			<div style="clear: both;"></div> 
		 </div>
	
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 