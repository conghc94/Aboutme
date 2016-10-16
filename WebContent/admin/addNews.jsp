<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %> 
<script type="text/javascript"
	src="<%=request.getContextPath()%>/templates/admin/js/jquery-2.1.4.min.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/templates/admin/js/jquery.validate.js"></script>
<script type="text/javascript"
	src="<%=request.getContextPath()%>/templates/admin/js/ckeditor/ckeditor.js"></script>
<!-- Form elements -->
<div class="grid_12">

	<div class="module">
		<h2>
			<span>Thêm tin tức</span>
		</h2>

		<div class="module-body">
			<form action="<%=request.getContextPath()%>/admin/addNews?type=submit" enctype="multipart/form-data" method="post" id="frm">
				<p>
					<label>Tên tin</label> 
					<input type="text" name="name" value="" class="input-medium" />
						
				</p>
				<p>
					<label>Danh mục tin</label> <select name="id_cat"
						class="input-short">
						<%
							ArrayList<Category> alCat = (ArrayList<Category>) request.getAttribute("alCat");
							for (Category objCat : alCat) {
						%>
						<option value="<%=objCat.getIdCat()%>"><%=objCat.getName()%></option>
						<%
							}
						%>
					</select>
				</p>
				<p>
					<label>Mô tả</label>
					<textarea name="preview_text" rows="7" cols="90" class="preview_text"></textarea>
				</p>
				<p>
					<label>Chi tiết</label>
					<textarea name="detail_text" rows="7" cols="90" class="ckeditor"></textarea>
				</p>
				<div id="divPreviewImg">
					<img id="previewImg" src="#" alt="img" height="108" width="180"  hidden="hidden"/>
				</div>
				<p>
					<label>Hình ảnh</label> <input type="file" name="picture" value="" id="imgInp" style="margin-bottom: 5px"/>
					<label id="unselectButton"></label>
				</p>
				<br/>
				
				<fieldset>
					<input class="submit-green" name="submit" type="submit"
						value="Thêm" /> <input class="submit-gray" name="reset"
						type="reset" value="Nhập lại" />
				</fieldset>
			</form>
		</div>
		<!-- End .module-body -->
	</div>
	<!-- End .module -->
	<div style="clear: both;"></div>
</div>
<!-- End .grid_12 -->
<script>
$(document).ready(function() {
	$("#frm").validate({
		ignore: [],
		debug: false, 
		rules: {
			name : {
				required : true,
			},
			preview_text : {
				required : function(){
					CKEDITOR.instances.preview_text.updateElement();
				},
				minlength : 10,
			},
			detail_text : {
				required : function() {
					CKEDITOR.instances.detail_text.updateElement();
				},
				minlength : 50,
			}
		},
		messages : {
			name : {
				required : "<span style=\"color: red; font-weight: bold;\">Vui lòng nhập tên tin</span>",
			},
			preview_text : {
				required : "<span style=\"color: red; font-weight: bold;\">Vui lòng nhập mô tả</span>",
				minlength : "<span style=\"color: red; font-weight: bold;\">Độ dài ít nhất 10</span>"
			},
			detail_text : {
				required : "<span style=\"color: red; font-weight: bold;\">Vui lòng nhập chi tiết</span>",
				minlength : "<span style=\"color: red; font-weight: bold;\">Độ dài ít nhất 50</span>"
			}
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
function unSelect(){
	document.getElementById("divPreviewImg").innerHTML = "";
	document.getElementById("unselectButton").innerHTML = " ";
	document.getElementById("imgInp").value = "";
}
$("#imgInp").change(function() {
	document.getElementById("divPreviewImg").innerHTML = "<img id=\"previewImg\" src=\"#\" alt=\"img\" height=\"108\" width=\"180\"/>";
	document.getElementById("unselectButton").innerHTML = "<a href=\"#\" class=\"button\" onclick=\"unSelect()\"> <span>Bỏ chọn <img src=\"<%=request.getContextPath()%>/templates/admin/images/plus-small.gif\" alt=\"Bỏ chọn\"></span> </a>";
	readURL(this);
});
	
</script>
<%@include file="/templates/admin/inc/footer.jsp"%>
