<%@page import="bean.AboutMe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">
<%

	if("0".equals(request.getParameter("msg"))){
		out.print("<p style='color:green; font-weight:bold'>Thực hiện sửa không thành công !</p>");
	}
	if("1".equals(request.getParameter("msg"))){
		out.print("<p style='color:green; font-weight:bold'>Thực hiện sửa  thành công !</p>");
	}


%>
	<div class="module">
		 <h2><span>Thêm tin tức</span></h2>
			
		 <div class="module-body">
		 	<%
		 		AboutMe aboutme=(AboutMe)request.getAttribute("aboutme");
		 	%>
			<form action="<%=request.getContextPath() %>/admin/gioithieu" method="post">
				<p>
					<label>Tiêu đề</label>
					<input type="text" name="tentin" value="<%=aboutme.getName() %>" class="input-medium" />
				</p>
				<p>
					<label>Chi tiết</label>
					<textarea  name="chitiet" rows="7"  class="ckeditor" cols="90" ><%=aboutme.getDetailText() %></textarea>
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