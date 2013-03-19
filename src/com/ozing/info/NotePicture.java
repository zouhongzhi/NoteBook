package com.ozing.info;

public class NotePicture {

	private int id = -1;
	private int noteId = -1;
	private String noteName = "";
	private String notePicture = "";
	private int xPosition = 0;
	private int yPosition = 0;
	private int width = 0;
	private int height = 0;
	private float scale = 0.0f;
	
	public NotePicture(){
		
	}
	
	public NotePicture(int id,int noteId,String noteName,String notePicture,int xPosition,
			int yPosition,int width,int height,float scale){
		this.id = id;
		this.noteId = noteId;
		this.noteName = noteName;
		this.notePicture = notePicture;
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		this.width = width;
		this.height = height;
		this.scale = scale;
	}
	
	public void setId(int id){
		this.id = id;
	}
	
	public int getId(){
		return this.id;
	}
	
	public void setNoteId(int noteId){
		this.noteId = noteId;
	}
	
	public int getNoteId(){
		return this.noteId;
	}
	
	public void setNoteName(String noteName){
		this.noteName = noteName;
	}
	
	public String getNoteName(){
		return this.noteName;
	}
	
	public void setNotePicture(String notePicture){
		this.notePicture = notePicture;
	}
	
	public String getNotePicture(){
		return this.notePicture;
	}
	
	public void setXPosition(int xPosition){
		this.xPosition = xPosition;
	}
	
	public int getXPositon(){
		return this.xPosition;
	}
	
	public void setYPosition(int yPosition){
		this.yPosition = yPosition;
	}
	
	public int getYPositon(){
		return this.yPosition;
	}
	
	public void setWidth(int width){
		this.width = width;
	}
	
	public int getWidth(){
		return this.width;
	}
		
	public void setHeight(int height){
		this.height = height;
	}
	
	public int getHeight(){
		return this.height;
	}
	
	public void setScale(float scale){
		this.scale = scale;
	}
	
	public float getScale(){
		return this.scale;
	}
}
