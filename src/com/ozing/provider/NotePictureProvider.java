package com.ozing.provider;

import java.util.ArrayList;
import java.util.List;

import android.content.ContentResolver;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;

import com.ozing.database.NoteStringInterface;
import com.ozing.info.NotePicture;

public class NotePictureProvider implements BaseProvider<NotePicture>,NoteStringInterface{

	private Context mContext = null;
	private ContentResolver mContentResolver = null;
	
	public NotePictureProvider(Context context){
		this.mContext = context;
		mContentResolver = context.getContentResolver();
	}
	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#selectById(int)
	 */
	@Override
	public NotePicture selectById(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#selectAll()
	 */
	@Override
	public List<NotePicture> selectAll() {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#selectByNoteTitle(java.lang.String)
	 */
	@Override
	public List<NotePicture> selectByNoteTitle(String noteTitle) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#selectByNoteId(int, int)
	 */
	@Override
	public List<NotePicture> selectByNoteId(int noteId, int sort) {
		// TODO Auto-generated method stub
		List<NotePicture> list = new ArrayList<NotePicture>();
		NotePicture notePicture = new NotePicture();
		Cursor cursor = null;
		switch(sort){
		case DEFAULT_ORDER:
			cursor = mContentResolver.query(NOTE_PICTURE_URI, null, NOTE_ID+"="+noteId, null, null);
			break;
		case CREATE_TIME_ORDER:
			cursor = mContentResolver.query(NOTE_PICTURE_URI, null, NOTE_ID+"="+noteId, null, CREATE_TIME+"ASC");
			break;
		case NOTE_INDEX_ORDER:
			cursor = mContentResolver.query(NOTE_PICTURE_URI, null, NOTE_ID+"="+noteId, null, NOTE_INDEX+"ASC");
			break;
		}
		if(cursor.moveToFirst()){
			while(cursor.moveToNext()){
				notePicture.setId(cursor.getInt(cursor.getColumnIndexOrThrow(ID)));
				notePicture.setNoteId(cursor.getInt(cursor.getColumnIndexOrThrow(NOTE_ID)));
				notePicture.setNoteName(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_NAME)));
				notePicture.setNotePicture(cursor.getString(cursor.getColumnIndexOrThrow(NOTE_PICTURE)));
				notePicture.setWidth(cursor.getInt(cursor.getColumnIndexOrThrow(WIDTH)));
				notePicture.setHeight(cursor.getInt(cursor.getColumnIndexOrThrow(HEIGHT)));
				notePicture.setXPosition(cursor.getInt(cursor.getColumnIndexOrThrow(X_POSITION)));
				notePicture.setYPosition(cursor.getInt(cursor.getColumnIndexOrThrow(Y_POSITION)));
				notePicture.setScale(cursor.getFloat(cursor.getColumnIndexOrThrow(SCALE)));
				list.add(notePicture);
			}
		}
		return list;
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#insertData(java.lang.Object)
	 */
	@Override
	public boolean insertData(NotePicture obj) {
		// TODO Auto-generated method stub
		ContentValues values = new ContentValues();
		values.put(NOTE_ID, obj.getNoteId());
		values.put(NOTE_NAME, obj.getNoteName());
		values.put(NOTE_PICTURE,obj.getNotePicture());
		values.put(WIDTH,obj.getWidth());
		values.put(HEIGHT, obj.getHeight());
		values.put(X_POSITION,obj.getXPositon());
		values.put(Y_POSITION, obj.getYPositon());
		values.put(SCALE, obj.getScale());
		if(mContentResolver.insert(NOTE_PICTURE_URI, values) != null){
			return true;
		}else{
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#updateDate(java.lang.Object)
	 */
	@Override
	public boolean updateDate(NotePicture obj) {
		// TODO Auto-generated method stub
		ContentValues values = new ContentValues();
		values.put(NOTE_ID, obj.getNoteId());
		values.put(NOTE_NAME, obj.getNoteName());
		values.put(NOTE_PICTURE,obj.getNotePicture());
		values.put(WIDTH,obj.getWidth());
		values.put(HEIGHT, obj.getHeight());
		values.put(X_POSITION,obj.getXPositon());
		values.put(Y_POSITION, obj.getYPositon());
		values.put(SCALE, obj.getScale());
		if(mContentResolver.update(NOTE_PICTURE_URI, values,ID+"="+obj.getId(),null) != 0){
			return true;
		}else{
			return false;
		}
	}

	/* (non-Javadoc)
	 * @see com.ozing.provider.BaseProvider#removeData(java.lang.Object)
	 */
	@Override
	public boolean removeData(NotePicture obj) {
		// TODO Auto-generated method stub
		if(mContentResolver.delete(NOTE_PICTURE_URI, ID+"="+obj.getId(), null) != 0){
			return true;
		}else{
			return false;
		}
	}

}
