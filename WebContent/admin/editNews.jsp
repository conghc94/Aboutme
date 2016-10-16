<%@page import="bean.News"%>
<%@page import="bean.Category"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp"%>
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
		<%
			if ("0".equals(request.getParameter("msg"))) {
		%>
		<p style="color: red">Sửa thất bại</p>
		<%
			}
		%>
		<%
			int nid = Integer.parseInt(request.getParameter("nid"));
			News objNews = (News) request.getAttribute("objNews");
		%>
		<div class="module-body">
			<form
				action="<%=request.getContextPath()%>/admin/editNews?nid=<%=nid%>&type=submit"
				enctype="multipart/form-data" method="post" id="frm">
				<p>
					<label>Tên tin</label> <input type="text" name="name"
						value="<%=objNews.getName()%>" class="input-medium" required="required" />
				</p>
				<p>
					<label>Danh mục tin</label> <select name="id_cat"
						class="input-short">
						<%
							ArrayList<Category> alCat = (ArrayList<Category>) request.getAttribute("alCat");
							for (Category objCat : alCat) {
								if (objCat.getIdCat() != objNews.getIdCat()) {
						%>
						<option value="<%=objCat.getIdCat()%>"><%=objCat.getName()%></option>
						<%
							} else {
						%>
						<option value="<%=objCat.getIdCat()%>" selected="selected"><%=objCat.getName()%></option>
						<%
							}
							}
						%>
					</select>
				</p>
				<p>
				<label>Hình ảnh</label> 
					<%
						if (objNews.getPicture() != null) {
					%>
					<img id="previewImg"
						src="<%=request.getContextPath()%>/files/<%=objNews.getPicture()%>"
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
					<label><a href="<%=request.getContextPath()%>/admin/editNews?nid=<%=objNews.getIdNews()%>&type=load&delImage=true" class="button">
						<span>Bỏ chọn <img src="<%=request.getContextPath()%>/templates/admin/images/plus-small.gif" alt="Bỏ chọn"></span>
					</a></label>
				</p>
				<br/>
				<p>
					<label>Mô tả</label>
					<textarea name="preview_text" rows="7" cols="90" class="preview_text"><%=objNews.getPreview_text()%></textarea>
				</p>
				<p>
					<label>Chi tiết</label>
					<textarea name="detail_text" rows="7" cols="90" class="ckeditor"><%=objNews.getDetail_text()%></textarea>
				</p>
				<fieldset>
					<input class="submit-green" name="submit" type="submit" value="Sửa" />
					<input class="submit-gray" name="reset" type="reset"
						value="Nhập lại" />
				</fieldset>
			</form>
		</div>
		<!-- End .module-body -->

	</div>
	<!-- End .module -->
	<div style="clear: both;"></div>
</div>
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
									preview_text : {
										required : function() {
											CKEDITOR.instances.preview_text
													.updateElement();
										},
										minlength : 10,
									},
									detail_text : {
										required : function() {
											CKEDITOR.instances.detail_text
													.updateElement();
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

	$("#imgInp").change(function() {
		readURL(this);
	});
</script>
<!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp"%>
