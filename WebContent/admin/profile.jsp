<%@page import="bean.Users"%>
<%@page import="bean.Category"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">


	<div class="module">
		 <h2><span>Sửa Users</span></h2>
		
		 <div class="module-body">
			<form action="" method="POST">
				
				<p>
					<label>Users name</label>
					<input type="text" name="ten" value="<%=objSUser.getUsername() %>" class="input-medium"  readonly/>
				</p>
				
				<p>
					<label>Password</label>
					<input type="password" name="password" value="" class="input-medium"  />
				</p>
				<p>
					<label>FullName</label>
					<input type="text" name="fullname" value="<%=objSUser.getFullname() %>" class="input-medium" required pattern="^[a-zA-Z'-'\sáàảãạăâắằấầặẵẫậéèẻ ẽẹếềểễệóòỏõọôốồổỗộ ơớờởỡợíìỉĩịđùúủũụưứ�� �ửữựÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠ ƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼ� ��ỀỂỄỆỈỊỌỎỐỒỔỖỘỚỜỞ ỠỢỤỨỪỬỮỰỲỴÝỶỸửữựỵ ỷỹ]*$" />
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