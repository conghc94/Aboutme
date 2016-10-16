<%@page import="bean.Users"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<!-- Form elements -->    
<div class="grid_12">
		
	<div class="module">
		 <h2><span>Đăng nhập</span></h2>
		 <div class="module-body">
			<form action="" method="post">
				<p>
					<label>Username</label>
					<input type="text" name="tentin" value="" class="input-medium" required  />
				</p>
				<p>
					<label>Password</label>
					<input type="password" name="password" value="" class="input-medium" required  />
				</p>
				<fieldset>
					<input class="submit-green" name="login" type="submit" value="Login" /> 
				</fieldset>
			</form>
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 