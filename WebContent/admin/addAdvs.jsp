<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %> 
<!-- Form elements -->    
<div class="grid_12">

	<div class="module">
		 <h2><span>Thêm quảng cáo</span></h2>
			
		 <div class="module-body">
			<form action="<%=request.getContextPath() %>/admin/addAdvs?type=submit" enctype="multipart/form-data" method="post">
				<p>
					<label>Name</label>
					<input type="text" name="name" value="" class="input-medium" />
				</p>
		
				<p>
					<label>Banner</label>
					<input type="file"  name="bannner" value="" />
				</p>
				<p>
					<label>Link</label>
					<input type="text" name="link" value="" class="input-medium" />
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