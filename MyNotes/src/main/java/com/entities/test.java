package com.entities;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

public class test {

	public static void main(String[] args) {
		
		Note n1 = new Note();
		n1.setNoteId(101);
		n1.setTitle("Padhai Karo");
		
		SessionFactory sf = new Configuration().configure("hibernate.cfg.xml").buildSessionFactory();
		Session s1 = sf.openSession();
		Transaction tx = s1.beginTransaction();
		
		s1.save(n1);
		tx.commit();
	}

}
