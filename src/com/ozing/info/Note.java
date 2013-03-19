package com.ozing.info;

public class Note {

	private int id = -1;
	private String noteName = "";
	private String noteTitle = "";
	private String noteText = "";
	private String notePaint = "";
	private String surveyImg = "";
	private String createTime = "";
	private int noteSum = 0;
	
	public Note(){
		
	}
	
	public Note(int id,String noteName,String noteTitle,String noteText,String notePaint,
			String surveyImg,String createTime,int noteSum){
		this.id = id;
		this.noteName = noteName;
		this.noteTitle = noteTitle;
		this.noteText = noteText;
		this.notePaint = notePaint;
		this.surveyImg = surveyImg;
		this.createTime = createTime;
		this.noteSum = noteSum;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setId(int id){
		this.id = id;
	}

	public String getNoteName(){
		return this.noteName;
	}
	
	public void setNoteName(String noteName){
		this.noteName = noteName;
	}
	
	public String getNoteTitle(){
		return this.noteTitle;
	}
	
	public void setNoteTitle(String noteTitle){
		this.noteTitle = noteTitle;
	}
	
	public String getNoteText(){
		return this.noteText;
	}
	
	public void setNoteText(String noteText){
		this.noteText = noteText;
	}
	
	public String getNotePaint(){
		return this.notePaint;
	}
	
	public void setNotePaint(String notePaint){
		this.notePaint = notePaint;
	}
	
	public String getSurveyImg(){
		return this.surveyImg;
	}
	
	public void setSurveyImg(String surveyImg){
		this.surveyImg = surveyImg;
	}
	
	public String getCreateTiem(){
		return this.createTime;
	}
	
	public void setCreateTime(String creatTime){
		this.createTime = creatTime;
	}
	
	public int getNoteSum(){
		return this.noteSum;
	}
	
	public void setNoteSum(int noteSum){
		this.noteSum = noteSum;
	}
}
