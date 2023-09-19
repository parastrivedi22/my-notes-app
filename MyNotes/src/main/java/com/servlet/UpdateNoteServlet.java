package com.servlet;

import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;

public class UpdateNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    
    public UpdateNoteServlet() {
        super();
    }


	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		try {
			Session session  = FactoryProvider.getFactory().openSession();
			Transaction tx = session.beginTransaction();
			
			int noteId = Integer.parseInt(request.getParameter("noteId"));
			String title = request.getParameter("title");
			String content = request.getParameter("content");
			

			Note note = session.get(Note.class, noteId);
			note.setTitle(title);
			note.setContent(content);
			note.setEditDate(new Date());
			
			session.update(note);
			tx.commit();
			session.close();
			
			
		
		}catch(Exception e) {
			e.printStackTrace();
		}

		response.sendRedirect("show_all_notes.jsp");
		
		
	}

}
