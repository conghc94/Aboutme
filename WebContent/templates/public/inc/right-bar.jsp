<%@page import="bean.Saying"%>
<%@page import="bean.Advs"%>
<%@page import="java.util.ArrayList"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
	<div class="testimonials">
					<h3>Những câu nói hay</h3>
					<%
						ArrayList<Saying> alSaying=(ArrayList<Saying>)request.getAttribute("alSaying");
							if(alSaying!=null){
								for(Saying objSaying:alSaying){
					
					%>
					<ul>
						<li>
							<p>
								<%=objSaying.getContent() %>
							</p>
							<span class="author">-<%=objSaying.getAuthor() %></span>
						</li>
						
					</ul>
					<%}} %>
				</div>
				<div class="awards">
					<h3>Quảng cáo</h3>
					<%
						ArrayList<Advs> alAdvs=(ArrayList<Advs> )request.getAttribute("alAdvs");
						if(alAdvs!=null){
							for(Advs objAdvs:alAdvs){
					
					%>
					<a href="#" class="first">
						<img src="<%=request.getContextPath() %>/files/<%=objAdvs.getBanner() %>" alt="" />
					</a>
					
					<%}} %>
				</div>