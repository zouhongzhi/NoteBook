package com.ozing.provider;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.net.Uri;

import com.ozing.database.NoteStringInterface;
import com.ozing.info.Note;

public class NoteProvider implements BaseProvider<Note>,NoteStringInterface{

	private Context mContext = null;
	private ContentResolver mContentResolver = null;
	
	public NoteProvider(Context context){
		this.mContext = context;
		mContentResolver = context.getContentResolver();
	}
	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#selectById(int)
	 */
	@Override
	public Note selectById(int id) {
		// TODO Auto-generated method stub
		Note note = null;
		Cursor cursor = mContentResolver.query(NOTE_URI, null, ID+"="+id, null, null);
		if(cursor.moveToFirst()){
			note = new Note();
			note.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ID)));
			note.setNoteName(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_NAME)));
			note.setNoteTitle(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_TITLE)));
			note.setNoteText(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_TEXT)));
			note.setNotePaint(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_PAINT)));
			note.setSurveyImg(cursor.getString(cursor.getColumnIndexOrThrow(SURVEY_IMG)));
			note.setCreateTime(cursor.getString(cursor.getColumnIndexOrThrow(CREATE_TIME)));
			note.setNoteSum(cursor.getInt(cursor.getColumnIndexOrThrow(NOTE_SUM)));
		}
		return note;
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#selectAll()
	 */
	@Override
	public List<Note> selectAll() {
		// TODO Auto-generated method stub
		List<Note> list = new ArrayList<Note>();
		Note note = new Note();
		Cursor cursor = mContentResolver.query(NOTE_URI, null, null, null, null);
		if(cursor.moveToFirst()){
			while(cursor.moveToNext()){
				note.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ID)));
				note.setNoteName(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_NAME)));
				note.setNoteTitle(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_TITLE)));
				note.setNoteText(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_TEXT)));
				note.setNotePaint(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_PAINT)));
				note.setSurveyImg(cursor.getString(cursor.getColumnIndexOrThrow(SURVEY_IMG)));
				note.setCreateTime(cursor.getString(cursor.getColumnIndexOrThrow(CREATE_TIME)));
				note.setNoteSum(cursor.getInt(cursor.getColumnIndexOrThrow(NOTE_SUM)));
				list.add(note);
			}
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#selectByNoteTitle(java.lang.String)
	 */
	@Override
	public List<Note> selectByNoteTitle(String noteTitle) {
		// TODO Auto-generated method stub
		List<Note> list = new ArrayList<Note>();
		Note note = new Note();
		Cursor cursor = mContentResolver.query(NOTE_URI, null, noteTitle, null, null);
		if(cursor.moveToFirst()){
			while(cursor.moveToNext()){
				note.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ID)));
				note.setNoteName(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_NAME)));
				note.setNoteTitle(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_TITLE)));
				note.setNoteText(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_TEXT)));
				note.setNotePaint(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_PAINT)));
				note.setSurveyImg(cursor.getString(cursor.getColumnIndexOrThrow(SURVEY_IMG)));
				note.setCreateTime(cursor.getString(cursor.getColumnIndexOrThrow(CREATE_TIME)));
				note.setNoteSum(cursor.getInt(cursor.getColumnIndexOrThrow(NOTE_SUM)));
				list.add(note);
			}
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#selectByNoteId(int, int)
	 */
	@Override
	public List<Note> selectByNoteId(int noteId, int sort) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#insertData(java.lang.Object)
	 */
	@Override
	public boolean insertData(Note obj) {
		// TODO Auto-generated method stub
		ContentValues values = new ContentValues();
		values.put(NOTE_NAME, obj.getNoteName());
		values.put(NOTE_TITLE,obj.getNoteTitle());
		values.put(NOTE_TEXT,obj.getNoteText());
		values.put(NOTE_PAINT, obj.getNotePaint());
		values.put(SURVEY_IMG,obj.getSurveyImg());
		values.put(CREATE_TIME, obj.getCreateTiem());
		values.put(NOTE_SUM, obj.getNoteSum());
		if(mContentResolver.insert(NOTE_URI, values) != null){
			return true;
		}else{
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#updateDate(java.lang.Object)
	 */
	@Override
	public boolean updateDate(Note obj) {
		// TODO Auto-generated method stub
		ContentValues values = new ContentValues();
		values.put(NOTE_NAME, obj.getNoteName());
		values.put(NOTE_TITLE,obj.getNoteTitle());
		values.put(NOTE_TEXT,obj.getNoteText());
		values.put(NOTE_PAINT, obj.getNotePaint());
		values.put(SURVEY_IMG,obj.getSurveyImg());
		values.put(CREATE_TIME, obj.getCreateTiem());
		values.put(NOTE_SUM, obj.getNoteSum());
		if(mContentResolver.update(NOTE_URI, values,ID+"="+obj.getId(),null) != 0){
			return true;
		}else{
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#removeData(java.lang.Object)
	 */
	@Override
	public boolean removeData(Note obj) {
		// TODO Auto-generated method stub
		if(mContentResolver.delete(NOTE_URI,ID+"="+obj.getId(),null) != 0){
			return true;
		}else{
			return false;
		}
	}

}
