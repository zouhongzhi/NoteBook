package com.ozing.provider;

import java.util.ArrayList;
import java.util.List;


import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.ozing.database.NoteStringInterface;
import com.ozing.info.Note;
import com.ozing.info.NoteChild;

public class NoteChildProvider implements BaseProvider<NoteChild>,NoteStringInterface{

	private Context mContext = null;
	private ContentResolver mContentResolver = null;
	
	public NoteChildProvider(Context context){
		this.mContext = context;
		mContentResolver = context.getContentResolver();
	}
	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#selectById(int)
	 */
	@Override
	public NoteChild selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#selectAll()
	 */
	@Override
	public List<NoteChild> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#selectByNoteTitle(java.lang.String)
	 */
	@Override
	public List<NoteChild> selectByNoteTitle(String noteChildTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#selectByNoteId(int, int)
	 */
	@Override
	public List<NoteChild> selectByNoteId(int noteId, int sort) {
		// TODO Auto-generated method stub
		List<NoteChild> list = new ArrayList<NoteChild>();
		NoteChild noteChild = new NoteChild();
		Cursor cursor = null;
		switch(sort){
		case DEFAULT_ORDER:
			cursor = mContentResolver.query(NOTE_CHILD_URI, null, NOTE_ID+"="+noteId, null, null);
			break;
		case CREATE_TIME_ORDER:
			cursor = mContentResolver.query(NOTE_CHILD_URI, null, NOTE_ID+"="+noteId, null, CREATE_TIME+"ASC");
			break;
		case NOTE_INDEX_ORDER:
			cursor = mContentResolver.query(NOTE_CHILD_URI, null, NOTE_ID+"="+noteId, null, NOTE_INDEX+"ASC");
			break;
		}
		if(cursor.moveToFirst()){
			while(cursor.moveToNext()){
				noteChild.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ID)));
				noteChild.setNoteId(cursor.getInt(cursor.getColumnIndexOrThrow(NOTE_ID)));
				noteChild.setNoteIndex(cursor.getInt(cursor.getColumnIndexOrThrow(NOTE_INDEX)));
				noteChild.setNoteName(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_NAME)));
				noteChild.setNoteTitle(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_TITLE)));
				noteChild.setNoteText(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_TEXT)));
				noteChild.setNotePaint(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_PAINT)));
				noteChild.setSurveyImg(cursor.getString(cursor.getColumnIndexOrThrow(SURVEY_IMG)));
				noteChild.setCreateTime(cursor.getString(cursor.getColumnIndexOrThrow(CREATE_TIME)));
				noteChild.setNoteSum(cursor.getInt(cursor.getColumnIndexOrThrow(NOTE_SUM)));
				list.add(noteChild);
			}
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#insertData(java.lang.Object)
	 */
	@Override
	public boolean insertData(NoteChild obj) {
		// TODO Auto-generated method stub
		ContentValues values = new ContentValues();
		values.put(NOTE_ID, obj.getNoteId());
		values.put(NOTE_INDEX, obj.getNoteIndex());
		values.put(NOTE_NAME, obj.getNoteName());
		values.put(NOTE_TITLE,obj.getNoteTitle());
		values.put(NOTE_TEXT,obj.getNoteText());
		values.put(NOTE_PAINT, obj.getNotePaint());
		values.put(SURVEY_IMG,obj.getSurveyImg());
		values.put(CREATE_TIME, obj.getCreateTiem());
		values.put(NOTE_SUM, obj.getNoteSum());
		if(mContentResolver.insert(NOTE_CHILD_URI, values) != null){
			return true;
		}else{
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#updateDate(java.lang.Object)
	 */
	@Override
	public boolean updateDate(NoteChild obj) {
		// TODO Auto-generated method stub
		ContentValues values = new ContentValues();
		values.put(NOTE_ID, obj.getNoteId());
		values.put(NOTE_INDEX, obj.getNoteIndex());
		values.put(NOTE_NAME, obj.getNoteName());
		values.put(NOTE_TITLE,obj.getNoteTitle());
		values.put(NOTE_TEXT,obj.getNoteText());
		values.put(NOTE_PAINT, obj.getNotePaint());
		values.put(SURVEY_IMG,obj.getSurveyImg());
		values.put(CREATE_TIME, obj.getCreateTiem());
		values.put(NOTE_SUM, obj.getNoteSum());
		if(mContentResolver.update(NOTE_CHILD_URI, values,ID+"="+obj.getId(),null) != 0){
			return true;
		}else{
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#removeData(java.lang.Object)
	 */
	@Override
	public boolean removeData(NoteChild obj) {
		// TODO Auto-generated method stub
		if(mContentResolver.delete(NOTE_CHILD_URI,ID+"="+obj.getId(),null) != 0){
			return true;
		}else{
			return false;
		}
	}
	
	public boolean removeData(int noteId){
		if(mContentResolver.delete(NOTE_CHILD_URI,NOTE_ID+"="+noteId,null) != 0){
			return true;
		}else{
			return false;
		}
	}

}
