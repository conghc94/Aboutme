<%@page import="bean.Category"%>
<%@page import="model.ModelCategory"%>
<%@page import="bean.News"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <div class="float-left">
		  <a href="<%=request.getContextPath() %>/admin/addNews?type=load" class="button">
			<span>Thêm tin <img src="<%=request.getContextPath() %>/templates/admin/images/plus-small.gif" alt="Thêm tin"></span>
		  </a>
	  </div>
	  <div class="clear"></div>
</div>
<form id="frmTimKiem" action="<%=request.getContextPath() %>/admin/searchNews" method="POST">
	<%
				ArrayList<News> alNews=(ArrayList<News>)request.getAttribute("alNews");
				ModelCategory mc = new ModelCategory();
				Category cat;
				String searchActive="";
				if(request.getAttribute("searchActive")!=null){
					searchActive=(String)request.getAttribute("searchActive");	
				}
				String searchName=(String)request.getAttribute("searchName");
				String searchDM = "";
				if(request.getAttribute("searchDM")!=null){
					searchDM=(String)request.getAttribute("searchDM");
				}
				if(searchName==null){
	%>
		Tiêu đề: 	
		<input type="search" name="searchName" placeholder="Từ khóa tin tức" size="34" value="" />
	<%}else{ %>
		<input type="search" name="searchName" placeholder="Từ khóa tin tức" size="34" value="<%=searchName %>" />
	<%} %>
	Danh mục: 
	<select name="searchDM" style="max-width:200px">
		<option value="">Tất cả danh mục</option>
		
				<%
					
					int al=0;
					if(!"".equals(searchDM)){
						al=Integer.parseInt(searchDM);
					}
					ArrayList<Category> listCat=(ArrayList<Category>)request.getAttribute("listCat");
							for(Category objCategory:listCat){
								if((objCategory.getIdCat())==al){
								
				%>
				<option value="<%=objCategory.getIdCat()%>" selected="selected" ><%=objCategory.getName() %></option>
				
				<%}else{%>
					<option value="<%=objCategory.getIdCat()%>" ><%=objCategory.getName() %></option>
				<%}} %>
		
			 </select>
	Trạng thái: 
	<select name="searchActive">
			<option value="">Tất cả</option>
			<option value="0" <%if("0".equals(searchActive)) out.print("selected='selected'");%> >Không kích hoạt</option>
			<option value="1" <%if("1".equals(searchActive)) out.print("selected='selected'");%> >Kích hoạt</option>
			
		 </select>
	<input type="submit" id="btnSearch" name="search" value="Tìm kiếm" /> 
	<input type="submit" id="showall" name="showall" value="Hiển thị tất cả" />
	<br /><br />
</form>
  <%
			if ("1".equals(request.getParameter("msg"))) {
		%>
		<p style="color: red; font-weight: bold">Không tìm thấy thông tin </p>
		<%
			}
		%>
	 <%
			if ("1".equals(request.getParameter("msge"))) {
		%>
		<p style="color: green; font-weight: bold">Thêm thành công </p>
		<%
			}
		%>
		<%
			if ("1".equals(request.getParameter("emsg"))) {
		%>
		<p style="color: green; font-weight: bold">Sửa thành công </p>
		<%
			}
		%>
		<%
			if ("1".equals(request.getParameter("suss"))) {
		%>
		<p style="color: green; font-weight: bold">Xóa thành công </p>
		<%
			}
		%>

<div class="grid_12">
	<!-- Example table -->
	<div class="module">
		<h2><span>Danh sách tin</span></h2>
		
		<div class="module-table-body">
		<form action="<%=request.getContextPath() %>/admin/delChoose" method="post">
			
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID</th>
						<th>Tên</th>
						<th style="width:20%">Danh mục</th>
						<th style="width:4%">Trạng thái</th>
						<th style="width:16%; text-align: center;">Hình ảnh</th>
						<th style="width:11%; text-align: center;">Chức năng</th>
						<th style="width:8%; text-align: center;">
							Chọn: <input type="checkbox" name="chkAll" id="chkAll" value="" />
							<input type="submit" name="dels" id="dels" onclick="return valDels();" value="Xóa" />
						</th>
					</tr>
				</thead>
				<tbody>
					
						<%
							for (News objNews : alNews) {
								cat=mc.getIdCat(objNews.getIdCat());
						%>
					<tr>
						<td class="align-center"><%=objNews.getIdNews() %></td>
						<td><a href="<%=request.getContextPath()%>/admin/editNews?nid=<%=objNews.getIdNews()%>"><%=objNews.getName() %></a></td>
						<td><%=cat.getName()%></td>
						<td align="center" class="active-<%=objNews.getIdNews()%>">
							<a href="javascript:void(0)" onclick="setActive(<%=objNews.getIsActive()%>, <%=objNews.getIdNews()%>)" title="">
							<%if (objNews.getIsActive() == 1){%>
							<img alt="" src="<%=request.getContextPath()%>/templates/admin/images/tick-circle.gif">
							<%} else {%>
							<img alt="" src="<%=request.getContextPath()%>/templates/admin/images/minus-circle.gif">
							<%}%>
						</a>
						</td>
						<td align="center"><img src="<%=request.getContextPath() %>/files/<%=objNews.getPicture() %>" class="hoa" /></td>
						<td align="center">
							<a href="<%=request.getContextPath()%>/admin/editNews?nid=<%=objNews.getIdNews()%>">Sửa <img src="<%=request.getContextPath() %>/templates/admin/images/pencil.gif" alt="edit" /></a>
							<a href="<%=request.getContextPath()%>/admin/delNews?nid=<%=objNews.getIdNews()%>" onclick="return confirm('Are you sure?')">Xóa <img src="<%=request.getContextPath() %>/templates/admin/images/bin.gif" width="16" height="16" alt="delete" /></a>
						</td>
						<td align="center"><input type="checkbox" name="check" value="<%=objNews.getIdNews() %>" /></td>
					</tr>
				<%}%>
			</table>
			</form>
		 </div> <!-- End .module-table-body -->
	</div> <!-- End .module -->
		 <div class="pagination">           
			<div class="numbers">
			<%
				int numberOfPage = (Integer) request.getAttribute("numberOfPage");
				int currentPage = (Integer) request.getAttribute("currentPage");
			%>
			<span>Trang:</span>
			<%
				for (int i = 1; i <= numberOfPage; i++) {
					if(i!=currentPage){
			%>
			<a href="<%=request.getContextPath()%>/admin/news?page=<%=i%>"><%=i%></a> 
				<%if(i!=numberOfPage){ %>
				<span>|</span>
				<%} %>
			<%
				} else {
			%>
			<a href="<%=request.getContextPath()%>/admin/news?page=<%=i%>" class="current"><%=i%></a> <span>|</span>
			<%}} %> 
			</div> 
			<div style="clear: both;"></div> 
		 </div>
	
</div> <!-- End .grid_12 -->
<script type="text/javascript">
function valDels()
{

    var checkedAtLeastOne = false;
    $('input[type="checkbox"][name="check"]').each(function() {
        if ($(this).is(":checked")) {
            checkedAtLeastOne = true;
        }
    });
    
    if (checkedAtLeastOne == true){
		return confirm('Bạn có muốn xóa các mẫu tin đã chọn?');
    } else {
    	alert('Vui lòng chọn ít nhất 1 tin để xóa');
    	return false;
    }
}

$('#chkAll').click(function(event) {
  if(this.checked) {
      // Iterate each checkbox
      $(':checkbox').each(function() {
          this.checked = true;
      });
  }
  else {
    $(':checkbox').each(function() {
          this.checked = false;
      });
  }
});

function setActive(active, idnews){
	$.ajax({
		url: '<%=request.getContextPath()%>/admin/activeNews',
		type: 'POST',
		cache: false,
		data: {
			news_active: active,
			news_id: idnews,
		},
		success: function(data){
			$('.active-' + idnews).html(data);
		},
		error: function (){
			alert('Có lỗi xảy ra');
		}
	});
	return false;
}

</script>
<%@include file="/templates/admin/inc/footer.jsp" %> 