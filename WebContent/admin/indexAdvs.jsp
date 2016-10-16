<%@page import="bean.Advs"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/admin/inc/header.jsp" %>
<div class="bottom-spacing">
	  <!-- Button -->
	  <div class="float-left">
		  <a href="<%=request.getContextPath() %>/admin/addAdvs?type=load" class="button">
			<span>Thêm quảng cáo <img src="<%=request.getContextPath() %>/templates/admin/images/plus-small.gif" alt="ThÃªm tin"></span>
		  </a>
	  </div>
	  <div class="clear"></div>
</div>

<div class="grid_12">
	<!-- Example table -->
	<div class="module">
		<h2><span>Danh sách quảng cáo</span></h2>
		
		<div class="module-table-body">
			<form action="" >
			<table id="myTable" class="tablesorter">
				<thead>
					<tr>
						<th style="width:4%; text-align: center;">ID</th>
						<th>Name</th>
						<th style="width:16%; text-align: center;">Banner</th>
						<th>Link</th>
						<th style="width:11%; text-align: center;">Chức năng</th>
					</tr>
				</thead>
				<tbody>
					<%
						ArrayList<Advs> alAdvs=(ArrayList<Advs>)request.getAttribute("alAdvs");
							if(alAdvs!=null){
								for(Advs objAdvs: alAdvs){
						
					%>
					<tr>
						<td class="align-center"><%=objAdvs.getId_advs() %></td>
						<td><a href=""><%=objAdvs.getName() %></a></td>
						
						<td align="center"><img src="<%=request.getContextPath() %>/files/<%=objAdvs.getBanner() %>" class="hoa" /></td>
						<td><a href=""><%=objAdvs.getLink() %></a></td>
						<td align="center">
							<a href="<%=request.getContextPath()%>/admin/editAdvs?idA=<%=objAdvs.getId_advs()%>">Sửa <img src="<%=request.getContextPath() %>/templates/admin/images/pencil.gif" alt="edit" /></a>
							<a href="<%=request.getContextPath()%>/admin/delAdvs?idA=<%=objAdvs.getId_advs()%>" onclick="return confirm('Are you sure?')">Xóa <img src="<%=request.getContextPath() %>/templates/admin/images/bin.gif" width="16" height="16" alt="delete" /></a>
						</td>
						<%}} %>
					</tr>  
				</tbody>
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
			<a href="<%=request.getContextPath()%>/admin/advs?page=<%=i%>"><%=i%></a> 
				<%if(i!=numberOfPage){ %>
				<span>|</span>
				<%} %>
			<%
				} else {
			%>
			<a href="<%=request.getContextPath()%>/admin/advs?page=<%=i%>" class="current"><%=i%></a> <span>|</span>
			<%}} %>
			</div> 
			<div style="clear: both;"></div> 
		 </div>
	
</div> <!-- End .grid_12 -->
<%@include file="/templates/admin/inc/footer.jsp" %> 