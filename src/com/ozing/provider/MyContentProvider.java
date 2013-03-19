package com.ozing.provider;

import com.ozing.database.DatabaseHelper;
import com.ozing.database.NoteStringInterface;

import android.content.ContentProvider;
import android.content.ContentUris;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.net.Uri;

public class MyContentProvider extends ContentProvider implements NoteStringInterface{

	private DatabaseHelper mDatabaseHelper = null;
	private static final UriMatcher mUriMatcher;
	
	static{
		mUriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
		mUriMatcher.addURI(AUTHORITH, DB_TABLE_NOTE, NOTE_TYPE);
		mUriMatcher.addURI(AUTHORITH, DB_TABLE_NOTE_CHILD, NOTE_CHILD_TYPE);
		mUriMatcher.addURI(AUTHORITH, DB_TABLE_NOTE_PICETURE, NOTE_PICTURE_TYPE);
	}
	
	/* (non-Javadoc)
	 * @see android.content.ContentProvider#onCreate()
	 */
	@Override
	public boolean onCreate() {
		// TODO Auto-generated method stub
		mDatabaseHelper = new DatabaseHelper(this.getContext());
		return true;
	}

	/* (non-Javadoc)
	 * @see android.content.ContentProvider#query(android.net.Uri, java.lang.String[], java.lang.String, java.lang.String[], java.lang.String)
	 */
	@Override
	public Cursor query(Uri uri, String[] projection, String selection,
			String[] selectionArgs, String sortOrder) {
		// TODO Auto-generated method stub
		SQLiteDatabase  mSQLiteDatabase = mDatabaseHelper.getWritableDatabase();
		Cursor c = null;
		switch(mUriMatcher.match(uri)){
		case NOTE_TYPE:
			c = mSQLiteDatabase.query(DB_TABLE_NOTE, projection, selection, selectionArgs, null, null, sortOrder);
			break;
		case NOTE_CHILD_TYPE:
			c = mSQLiteDatabase.query(DB_TABLE_NOTE_CHILD, projection, selection, selectionArgs, null, null, sortOrder);
			break;
		case NOTE_PICTURE_TYPE:
			c = mSQLiteDatabase.query(DB_TABLE_NOTE_PICETURE, projection, selection, selectionArgs, null, null, sortOrder);
			break;
		default:
			throw new IllegalArgumentException("Unknown uri:"+uri);
		}
		c.setNotificationUri(getContext().getContentResolver(), uri);
		return c;
	}

	/* (non-Javadoc)
	 * @see android.content.ContentProvider#getType(android.net.Uri)
	 */
	@Override
	public String getType(Uri uri) {
		// TODO Auto-generated method stub
		return null;
	}

	/* (non-Javadoc)
	 * @see android.content.ContentProvider#insert(android.net.Uri, android.content.ContentValues)
	 */
	@Override
	public Uri insert(Uri uri, ContentValues values) {
		// TODO Auto-generated method stub
		SQLiteDatabase  mSQLiteDatabase = mDatabaseHelper.getWritableDatabase();
		ContentValues contentValues = null;
		long rowId = -1;
		if(values != null){
			contentValues = new ContentValues(values);
		}else{
			contentValues = new ContentValues();
		}
		switch(mUriMatcher.match(uri)){
		case NOTE_TYPE:
			rowId = mSQLiteDatabase.insert(DB_TABLE_NOTE, null, contentValues);
			break;
		case NOTE_CHILD_TYPE:
			rowId = mSQLiteDatabase.insert(DB_TABLE_NOTE_CHILD, null, contentValues);
			break;
		case NOTE_PICTURE_TYPE:
			rowId = mSQLiteDatabase.insert(DB_TABLE_NOTE_PICETURE, null, contentValues);
			break;
		default:
			throw new IllegalArgumentException("Unknown uri:"+uri);
		}
		if(rowId > 0){
			Uri noteUri = ContentUris.withAppendedId(uri, rowId);
			getContext().getContentResolver().notifyChange(noteUri, null);
			return noteUri;
		}
		throw new SQLException("Failed to insert row into "+uri);
	}

	/* (non-Javadoc)
	 * @see android.content.ContentProvider#delete(android.net.Uri, java.lang.String, java.lang.String[])
	 */
	@Override
	public int delete(Uri uri, String selection, String[] selectionArgs) {
		// TODO Auto-generated method stub
		SQLiteDatabase  mSQLiteDatabase = mDatabaseHelper.getWritableDatabase();
		int count = 0;
		switch(mUriMatcher.match(uri)){
		case NOTE_TYPE:
			count = mSQLiteDatabase.delete(DB_TABLE_NOTE, selection, selectionArgs);
			break;
		case NOTE_CHILD_TYPE:
			count = mSQLiteDatabase.delete(DB_TABLE_NOTE_CHILD, selection, selectionArgs);
			break;
		case NOTE_PICTURE_TYPE:
			count = mSQLiteDatabase.delete(DB_TABLE_NOTE_PICETURE, selection, selectionArgs);
			break;
		default:
			throw new IllegalArgumentException("Unknown uri:"+uri);
		}
		if(count > 0){
			getContext().getContentResolver().notifyChange(uri, null);
			return count;
		}
		throw new SQLException("Failed to delete rows into "+uri);
	}

	/* (non-Javadoc)
	 * @see android.content.ContentProvider#update(android.net.Uri, android.content.ContentValues, java.lang.String, java.lang.String[])
	 */
	@Override
	public int update(Uri uri, ContentValues values, String selection,
			String[] selectionArgs) {
		// TODO Auto-generated method stub
		SQLiteDatabase  mSQLiteDatabase = mDatabaseHelper.getWritableDatabase();
		int count = 0;
		switch(mUriMatcher.match(uri)){
		case NOTE_TYPE:
			count = mSQLiteDatabase.update(DB_TABLE_NOTE, values, selection, selectionArgs);
			break;
		case NOTE_CHILD_TYPE:
			count = mSQLiteDatabase.update(DB_TABLE_NOTE_CHILD, values, selection, selectionArgs);
			break;
		case NOTE_PICTURE_TYPE:
			count = mSQLiteDatabase.update(DB_TABLE_NOTE_PICETURE, values, selection, selectionArgs);
			break;
		default:
			throw new IllegalArgumentException("Unknown uri:"+uri);
		}
		if(count > 0){
			getContext().getContentResolver().notifyChange(uri, null);
			return count;
		}
		throw new SQLException("Failed to delete rows into "+uri);
	}

}
