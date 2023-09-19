package com.servlet;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.entities.Note;
import com.helper.FactoryProvider;
import java.io.IOException;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name="/SaveNoteServlet")
public class SaveNoteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public SaveNoteServlet() {
        super();
    }



	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String title = request.getParameter("title");
		String content	= request.getParameter("content");
		
		SessionFactory sf  =  FactoryProvider.getFactory();
		Session s = sf.openSession();
		Transaction tx = s.beginTransaction();
		
		Note note = new Note(title,content, new Date());
		
		s.save(note);
		tx.commit();
		s.close();
		sf.close();

		response.sendRedirect("show_all_notes.jsp");
		
		
	}

}