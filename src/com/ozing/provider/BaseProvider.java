package com.ozing.provider;

import java.util.List;

import com.ozing.database.DatabaseHelper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public interface  BaseProvider<T> {

	T selectById(int id);
	List<T> selectAll();
	List<T> selectByNoteTitle(String noteTitle);
	List<T> selectByNoteId(int noteId,int sort);
	
	boolean insertData(T obj);
	boolean updateDate(T obj);
	boolean removeData(T obj);
}
