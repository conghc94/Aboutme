<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@include file="/templates/public/inc/header.jsp" %>
	<div id="body">
		<div class="content">
			<div id="section">
				<h2>Liên hệ với Chí Công</h2>
				<img src="<%=request.getContextPath() %>/templates/public/images/biking.jpg" alt="" style="width: 573px;height: 301px;" />
				<form action="<%=request.getContextPath()%>/contact">
					<b>Gửi liên hệ trực tuyển</b> 
					<span>Vui lòng điền đầy đủ thông tin để liên hệ trực tuyến đến Chí Công. Tôi sẽ phản hồi sớm nhất có thể!</span>
					<input type="text" name="name" id="name" value="" placeholder="Họ và tên" required="required"/>
					<input type="text" name="email" id="email" value=""  placeholder="Email" required="required" />
					<input type="text" name="address" id="address" value=""  placeholder="Địa chỉ" required="required"/>
					<input type="text" name="phone" id="phone" value=""  placeholder="Số phone" required="required"/>
					<textarea name="message" id="message" cols="30" rows="10" placeholder="Nội dung" required="required"></textarea>
					<input type="submit" name="send" id="send" value="Gửi liên hệ">
				</form>
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