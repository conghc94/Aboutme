<%@page import="bean.Saying"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">
	<%
			if ("0".equals(request.getParameter("msg"))) {
		%>
		<p style="color: red; font-weight: bold">Không thể thêm khi trùng tên</p>
		<%
			}
		%>
	<div class="module">
		 <h2><span>Sửa câu nói hay</span></h2>
		<%
			Saying al=(Saying)request.getAttribute("al");
		%>
		 <div class="module-body">
			<form action="<%=request.getContextPath() %>/admin/editSaying?idS=<%=al.getIdSaying() %>" method="POST" >
				<p>
					<label>Content</label>
					<input type="text" name="content" value="<%=al.getContent() %>" class="input-medium" required />
				</p>
				<p>
					<label>Author</label>
					<input type="text" name="author" value="<%=al.getAuthor() %>" class="input-medium" required  />
				</p>
				
				<fieldset>
					<input class="submit-green" name="sua" type="submit" value="Sửa" /> 
					<input class="submit-gray" name="reset" type="reset" value="Nhập lại" />
				</fieldset>
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 