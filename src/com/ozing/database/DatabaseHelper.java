package com.ozing.database;



import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper implements NoteStringInterface{

	private  static final String CREATE_TABLE£ßNOTE = "create table "+
														DB_TABLE_NOTE+
														"("+
														ID+
														" integer primary key autoincrement,"+
														NOTE_NAME+
														" text,"+
														NOTE_TITLE+
														" text,"+
														NOTE_TEXT+
														" text,"+
														NOTE_PAINT+
														" text,"+
														SURVEY_IMG+
														" text,"+
														CREATE_TIME+
														" text,"+
														NOTE_SUM+
														" integer,"+
														PAGE_NUMBER+
														" text,"+
														CLASS+
														" integer,"+
														BOOK+
														" text"+
														");";
	
	private static final String CREATE_TABLE_NOTE_CHILD = "create table "+
															DB_TABLE_NOTE_CHILD+
															"("+
															ID+
															" integer primary key autoincrement,"+
															NOTE_ID+
															" integer,"+
															NOTE_NAME+
															" text,"+
															NOTE_TITLE+
															" text,"+
															NOTE_TEXT+
															" text,"+
															NOTE_PAINT+
															" text,"+
															SURVEY_IMG+
															" text,"+
															CREATE_TIME+
															" text,"+
															NOTE_SUM+
															" integer,"+
															PAGE_NUMBER+
															" text,"+
															CLASS+
															" integer,"+
															BOOK+
															" text"+
															");";
	private static final String CREATE_TABLE_NOTE_PICTURE = "create table "+
															DB_TABLE_NOTE_PICETURE+
															"("+
															ID+
															" integer primary key autoincrement,"+
															NOTE_ID+
															" integer,"+
															NOTE_NAME+
															" text,"+
															NOTE_PICTURE+
															" text,"+
															X_POSITION+
															" integer,"+
															Y_POSITION+
															" integer,"+
															WIDTH+
															" integer,"+
															HEIGHT+
															" integer,"+
															SCALE+
															" real"+													
															");";
	public DatabaseHelper(Context context) {
		super(context, DB_NAME, null, DB_VERSION);
		// TODO Auto-generated constructor stub
	}

	
	@Override
	public void onCreate(SQLiteDatabase db) {
		// TODO Auto-generated method stub
		db.execSQL(CREATE_TABLE£ßNOTE);
		db.execSQL(CREATE_TABLE_NOTE_CHILD);
		db.execSQL(CREATE_TABLE_NOTE_PICTURE);
	}

	
	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		// TODO Auto-generated method stub
		db.execSQL("drop table if  exists"+DB_TABLE_NOTE);
		db.execSQL("drop table if  exists"+DB_TABLE_NOTE_CHILD);
		db.execSQL("drop table if  exists"+DB_TABLE_NOTE_PICETURE);
		onCreate(db);
	}

}
