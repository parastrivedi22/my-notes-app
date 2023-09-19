package com.servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.helper.FactoryProvider;
import com.entities.*;

public class DeleteNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    public DeleteNoteServlet() {
        super();
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		int noteId = Integer.parseInt(request.getParameter("noteId"));
		Session s = FactoryProvider.getFactory().openSession();
		Transaction tx = s.beginTransaction();
		
		Note note = s.get(Note.class, noteId);
		
		s.delete(note);
		tx.commit();
		s.close();
		response.sendRedirect("show_all_notes.jsp");
		
		
		
	}

	

}
