<%@page import="bean.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">
		<%
			if ("1".equals(request.getParameter("msg"))) {
		%>
			<p style="color: red; font-weight: bold">Không thể thêm khi trùng tên</p>
		<%
			}
		%>
	<div class="module">
		 <h2><span>Sửa người dùng</span></h2>
			<%
					Users objUser=(Users)request.getAttribute("objUser");
				%>
		 <div class="module-body">
			<form action="<%=request.getContextPath() %>/admin/editUsers?idU=<%=objUser.getIdUsers() %>" method="post" >
				
				<p>
					<label>Tên người dùng</label>
					<input type="text" name="tentin" value="<%=objUser.getUsername() %>" class="input-medium" required  />
				</p>
				<p>
					<label>PassWord</label>
					<input type="password" name="password" value="" class="input-medium" required  />
				</p>
				<p>
					<label>Fullname</label>
					<input type="text" name="fullname" value="<%=objUser.getFullname() %>" class="input-medium" required  />
				</p>
				<fieldset>
					<input class="submit-green" name="sua" type="submit" value="Sửa" /> 
					
				</fieldset>
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 