<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
   <%@ page import="com.helper.*" %>
   <%@ page import="org.hibernate.Session" %>
   <%@ page import ="org.hibernate.Transaction" %>
   <%@ page import="com.entities.*" %>
   <%@include file="all_js_css.jsp" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>MyNote: Update Note</title>
</head>
<body>
  <% int noteId = Integer.parseInt(request.getParameter("noteId")); 
  	
     Session s = FactoryProvider.getFactory().openSession();
     Transaction tx = s.beginTransaction();
     
     Note note = s.get(Note.class, noteId);
     
     
  
  %>
  
  
<div class=container-fluid>
  	<%@include file="navbar.jsp" %>
  </div>
  
  	<div class="container">
  	<h2 class="mt-1 mb-3">Take a note</h2>
  	
  	<form action="UpdateNoteServlet" method="post">
  	
  	<input type="hidden" value="<%=noteId %>" name="noteId"/>
  	
  <div class="mb-3">
    <label for="title" class="form-label">Title</label>
    <input type="text" name="title" class="form-control border border-1 border-white" id="title" aria-describedby="emailHelp" value="<%=note.getTitle() %>" required >
   
  </div>
  
  <div class="mb-3">
    <label for="content" class="form-label">Write here</label>
    <textarea name="content" class="form-control border border-1 border-white " id="content"  style="height:200px;"  required> <%=note.getContent() %> </textarea>
    
  </div>

  <button type="submit" class="btn btn-primary">Update</button>
</form>
  	</div>
  
</body>
</html>