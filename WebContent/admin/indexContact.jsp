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
		  <a href="<%=request.getContextPath() %>/admin/addContact" class="button">
			<span>Thêm liên hệ <img src="<%=request.getContextPath() %>/templates/admin/images/plus-small.gif" alt="Thêm tin"></span>
		  </a>
	  </div>
	  <div class="clear"></div>
</div>

<div class="grid_12">
	<!-- Example table -->
	<div class="module">
		<h2><span>Danh sách liên hệ</span></h2>
		
		<div class="module-table-body">
			<form action="" method="post">
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID_Contact</th>
						<th>Fullname</th>
						<th>Email</th>
						<th>Address</th>
						<th>Phone</th>
						<th>Content</th>
						<th style="width:11%; text-align: center;">Chức năng</th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<Contact> alContact=(ArrayList<Contact>)request.getAttribute("alContact");
							if(alContact!=null){
								for(Contact objContact: alContact){
										
					%>
					<tr>
						<td class="align-center"><%=objContact.getIdContact() %></td>
						<td><a href="<%=request.getContextPath() %>/admin/editContact?idC=<%=objContact.getIdContact() %>"><%=objContact.getFullname() %></a></td>
						<td class="align-center"><%=objContact.getEmail() %></td>
						<td class="align-center"><%=objContact.getAddress() %></td>
						<td class="align-center"><%=objContact.getPhone() %></td>
						<td class="align-center"><%=objContact.getContent() %></td>
						<td align="center">
							<a href="<%=request.getContextPath() %>/admin/editContact?idC=<%=objContact.getIdContact() %>">Sửa <img src="<%=request.getContextPath() %>/templates/admin/images/pencil.gif" alt="edit" /></a>
							<a href="<%=request.getContextPath() %>/admin/delContact?idC=<%=objContact.getIdContact() %>" onclick="return confirm('Are you sure?')" >Xóa <img src="<%=request.getContextPath() %>/templates/admin/images/bin.gif" width="16" height="16" alt="delete" /></a>
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
			<a href="<%=request.getContextPath()%>/admin/contact?page=<%=i%>"><%=i%></a> 
				<%if(i!=numberOfPage){ %>
				<span>|</span>
				<%} %>
			<%
				} else {
			%>
			<a href="<%=request.getContextPath()%>/admin/contact?page=<%=i%>" class="current"><%=i%></a> <span>|</span>
			<%}} %>
			</div> 
			<div style="clear: both;"></div> 
		 </div>
	
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 