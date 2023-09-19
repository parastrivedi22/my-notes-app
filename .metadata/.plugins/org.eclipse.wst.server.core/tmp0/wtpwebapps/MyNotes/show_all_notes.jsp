<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@page import="org.hibernate.Session, org.hibernate.Query"%>
<%@ page import="java.util.List"%>
<%@ page import="com.entities.*"%>
<%@ page import="com.helper.*"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<%@include file="all_js_css.jsp"%>
</head>
<body>
	<div class=container-fluid>
		<%@include file="navbar.jsp"%>
	</div>

	<div class="container w-75 mt-5">

		<%
		Session s = FactoryProvider.getFactory().openSession();
		Query q = s.createQuery("from Note");
		List<Note> notes = q.list();

		for (Note note : notes) {
		%>

		<div class="card w-100 mb-3">
			<div class="card-body">
				<h5 class="card-title"><%=note.getTitle()%></h5>
				<p class="card-text mb-5"><%=note.getContent()%></p>
				
				<a href="edit_note.jsp?noteId=<%=note.getNoteId() %>" class="btn btn-sm btn-primary">Update</a>
				<a href="DeleteNoteServlet?noteId=<%=note.getNoteId() %>" class="btn btn-sm btn-secondary">Delete</a>						
				<small "><%=note.getEditDate()%></small>
				
			</div>
		</div>


		<%
		}

		s.close();
		%>



	</div>
</body>
</html>