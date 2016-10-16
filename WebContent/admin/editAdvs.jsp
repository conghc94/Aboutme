<%@page import="bean.Advs"%>
<%@page import="bean.Project"%>
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
		 <h2><span>Sửa quảng cáo</span></h2>
		<%
			int idA = Integer.parseInt(request.getParameter("idA"));
			Advs oldAdvs = (Advs) request.getAttribute("oldAdvs");
		%>
		 <div class="module-body">
			<form
				action="<%=request.getContextPath()%>/admin/editAdvs?idA=<%=idA%>&type=submit"
				enctype="multipart/form-data" method="post" id="frm">
				<p>
					<label>Tên tin</label>
					<input type="text" name="name" value="<%=oldAdvs.getName() %>" class="input-medium" required pattern="^[\s a-zA-Z_ÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚĂĐĨŨƠàáâãèéêìíòóôõùúăđĩũơƯĂẠẢẤẦẨẪẬẮẰẲẴẶẸẺẼỀỀỂưăạảấầẩẫậắằẳẵặẹẻẽềềểỄỆỈỊỌỎỐỒỔỖỘỚỜỞỠỢỤỦỨỪễệỉịọỏốồổỗộớờởỡợụủứừỬỮỰỲỴÝỶỸửữựỳỵỷỹ]+$" />
				</p>
				<p>
					<label>Hình ảnh</label> 
					<%
						if (oldAdvs.getBanner() != null) {
					%>
					<img id="previewImg"
						src="<%=request.getContextPath()%>/files/<%=oldAdvs.getBanner()%>"
						alt="img" height="108" width="180" />
					<%
						} else {
					%>
					<img id="previewImg" src="#" alt="img" height="108" width="180" />
					<%
						}
					%>
					<br/>
					<input type="file" name="picture" value=""
						id="imgInp" style="margin-bottom: 10px"/>
					<label><a href="<%=request.getContextPath()%>/admin/editAdvs?idA=<%=idA%>&type=load&delImage=true" class="button">
						<span>Bỏ chọn <img src="<%=request.getContextPath()%>/templates/admin/images/plus-small.gif" alt="Bỏ chọn"></span>
					</a></label>
				</p>
				<br/>
				<p>
					<label>Link</label>
					<input type="text" name="link" value="<%=oldAdvs.getLink() %>" class="input-medium" required />
				</p>
				
				<fieldset>
					<input class="submit-green" name="submit" type="submit" value="Sửa" /> 
					<input class="submit-gray" name="reset" type="reset" value="Nhập lại" />
				</fieldset>
			</form>
			
		 </div> <!-- End .module-body -->

	</div>  <!-- End .module -->
	<div style="clear:both;"></div>
	<script>
	
	$(document)
			.ready(
					function() {
						$("#frm")
								.validate(
										{
											ignore : [],
											debug : false,
											rules : {
												name : {
													required : true,
												},
												mota : {
													required : function() {
														CKEDITOR.instances.preview_text
																.updateElement();
													},
													minlength : 10,
												},
											
											},
											messages : {
												name : {
													required : "<span style=\"color: red; font-weight: bold;\">Vui lòng nhập tên tin</span>",
												},
												mota : {
													required : "<span style=\"color: red; font-weight: bold;\">Vui lòng nhập mô tả</span>",
													minlength : "<span style=\"color: red; font-weight: bold;\">Độ dài ít nhất 10</span>"
												},
												
											}
										});
					});

	function readURL(input) {

		if (input.files && input.files[0]) {
			var reader = new FileReader();

			reader.onload = function(e) {
				$('#previewImg').attr('src', e.target.result);
			}

			reader.readAsDataURL(input.files[0]);
		}
	}

	$("#imgInp").change(function() {
		readURL(this);
	});
</script>
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 