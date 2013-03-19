package com.ozing.info;

public class NoteChild extends Note{

	private int noteId = -1;
	private int noteIndex = -1;
	public NoteChild(){
		
	}
	
	public NoteChild(int id,String noteName,String noteTitle,String noteText,String notePaint,
			String surveyImg,String createTime,int noteSum,int noteId,int noteIndex){
		super(id,noteName,noteTitle,noteText,notePaint,surveyImg,createTime,noteSum);
		this.noteId = noteId;
		this.noteIndex = noteIndex;
	}
	
	public int getNoteId(){
		return this.noteId;
	}
	
	public void setNoteId(int noteId){
		this.noteId = noteId;
	}
	
	public int getNoteIndex(){
		return this.noteIndex;
	}
	
	public void setNoteIndex(int noteIndex){
		this.noteIndex = noteIndex;
	}
}
