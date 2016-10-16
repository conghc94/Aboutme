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
		 <h2><span>Thêm Thành Viên</span></h2>
			
		 <div class="module-body">
			<form action="<%=request.getContextPath() %>/admin/addThanhVien?type=submit" method="POST" enctype="multipart/form-data">
				<p>
					<label>NickName</label>
					<input type="text" name="nickname" value="" class="input-medium" required pattern="^[\s a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$" />
				</p>
				<p>
					<label>FullName</label>
					<input type="text" name="fullname" value="" class="input-medium" required pattern="^[\s a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$" />
				</p>
				<p>
					<label>Địa chỉ</label>
					<input type="text" name="diachi" value="" class="input-medium" required />
				<p>
					<label>Địện thoại</label>
					<input type="text" name="dienthoai" value="" class="input-medium" required  />
				</p>
				<p>
					<label>Công việc</label>
					<input type="text" name="congviec" value="" class="input-medium" required  />
				</p>
				<p>
					<label>Hình ảnh</label>
					<input type="file"  name="picture" value="" />
				</p>
				<p>
					<label>Email</label>
					<input type="text" name="email" value="" class="input-medium" required />
				</p>
				<p>
					<label>Link</label>
					<input type="text" name="link" value="" class="input-medium" required />
				</p>
				
				
				<fieldset>
					<input class="submit-green" name="them" type="submit" value="Thêm" /> 
					<input class="submit-gray" name="reset" type="reset" value="Nhập lại" />
				</fieldset>
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 