package com.entities;
import java.util.Date;
import java.util.Random;

import javax.persistence.*;
@Entity
@Table(name="Notes")
public class Note {
	@Id
	private int noteId;
	private String title;
	private String content;
	private Date editDate;
	
	
	
	public Note() {
		super();
	}
	
	
	
	
	
	
	public Note(  String title, String content, Date editDate) {
		super();
		this.noteId =  new Random().nextInt(100000);
		this.title = title;
		this.content = content;
		this.editDate = editDate;
	}




	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
	public int getNoteId() {
		return noteId;
	}
	public void setNoteId(int noteId) {
		this.noteId = noteId;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public Date getEditDate() {
		return editDate;
	}
	public void setEditDate(Date editDate) {
		this.editDate = editDate;
	}
	
	
	
}
