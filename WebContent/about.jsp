<%@page import="bean.AboutMe"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp" %>
	<div id="body">
		<div class="content">
			<div id="section">
				<%
					AboutMe alAboutme=(AboutMe)request.getAttribute("alAboutme");
				%>
				<h2><%=alAboutme.getName() %></h2>
				<p>
					<%=alAboutme.getDetailText() %>
				</p>
				<img src="<%=request.getContextPath() %>/templates/public/images/biking.jpg" alt="" style="width: 570px;height: 347px;">
				<div class="article">
					<div>
						<h3>Vài nét về Chí Công</h3>
						<p>
						- Họ tên: Hoàng Chí Công<br />
						- Địa chỉ:Ba Thung-Cam Tuyền-Cam Lộ-Quảng Trị<br />
						- Email: conghc94@gmail.com - Phone: 0169.631.8915
						</p>
						
						<h3>Khả năng của tôi</h3>
						<p>
						- Phát triển web Front-End<br />
						- Phát triển Web Back-End<br />
						- Kỹ năng làm việc nhóm và thuyết trình tốt
						</p>
					</div>
					
					<div>
						<h3>Kỹ năng chuyên ngành</h3>
						<p>
						- Html, Css, Javascript, Jquery<br />
						- PHP, MySQL, Ajax<br />
						- Javacore, Jsp-servlet, Swing, .NET
						</p>
						
						<h3>Mục tiêu của tôi</h3>
						<p>
						- Làm việc trong môi trường chuyên nghiệp<br />
						- Nâng cao kỹ năng chuyên môn với nhiều dự án khó<br />
						- Góp phần phát triển phòng công nghệ của công ty
						</p>
					</div>
				</div>
			</div>
			
			<div id="sidebar">
				<%@include file="/templates/public/inc/right-bar.jsp" %>
			</div>
			
			
		</div>
	</div>
	
	
	<div id="footer">
	<%@include file="/templates/public/inc/footer.jsp" %>
	</div>
</body>
</html>