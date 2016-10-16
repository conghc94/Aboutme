<%@page import="bean.Contact"%>
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
		 <h2><span>Sửa liên hệ</span></h2>
			<%
					Contact alContact=(Contact)request.getAttribute("alContact");
				%>
		 <div class="module-body">
			<form action="<%=request.getContextPath() %>/admin/editContact?idC=<%=alContact.getIdContact() %>" method="POST" >
				
				<p>
					<label>Fullname</label>
					<input type="text" name="fullname" value="<%=alContact.getFullname() %>" class="input-medium" required pattern="^[\s a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$" />
				</p>
				<p>
					<label>Email</label>
					<input type="email" name="email" value="<%=alContact.getEmail() %>" class="input-medium" required  />
				</p>
				<p>
					<label>Address</label>
					<input type="text" name="address" value="<%=alContact.getAddress() %>" class="input-medium" required  />
				</p>
				<p>
					<label>Phone</label>
					<input type="text" name="phone" value="<%=alContact.getPhone() %>" class="input-medium" required pattern="[0-9]{0,13}" />
				</p>
				<p>
					<label>Content</label>
					<input type="text" name="content" value="<%=alContact.getContent() %>" class="input-medium" required  />
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