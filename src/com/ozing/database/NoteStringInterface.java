package com.ozing.database;

import android.net.Uri;

public interface NoteStringInterface {
	//数据库
	String DB_NAME = "NoteBook.db";//数据库名称
	int DB_VERSION = 1;//数据库版本号
	String DB_TABLE_NOTE = "note";//笔记本表名
	String DB_TABLE_NOTE_CHILD = "note_child";//笔记本详细表名
	String DB_TABLE_NOTE_PICETURE = "note_picture";//笔记本中图片表名
	
	// 笔记相关字段名称
	String ID = "_id";//id号，唯一标识，自动生成
	String NOTE_NAME = "noteName";//笔记名称，唯一，（生成时间+随机数）
	String NOTE_TITLE = "noteTitle";//笔记标题

	String NOTE_TEXT = "noteText";//笔记文本内容
	String NOTE_PAINT = "notePaint";//笔记中手绘图
	String SURVEY_IMG = "surveyImg";//笔记缩略图
	String CREATE_TIME = "createTime";//笔记创建时间
	String NOTE_SUM = "noteSum";//笔记中页数
	String NOTE_INDEX = "noteIndex";//当前笔记的索引
	String NOTE_ID = "noteId";//与note表关联的id号，即note表中的id号
	
	// 图片相关字段名称
	String NOTE_PICTURE = "notePicture";//笔记中插入的图片
	String X_POSITION = "xPosition";//图片X坐标
	String Y_POSITION = "yPosition";//图片Y坐标
	String WIDTH = "width";//图片长度
	String HEIGHT = "height";//图片高度
	String SCALE = "scale";//图片放大比例
	
	
	// 多媒体课本专用
	String PAGE_NUMBER = "pageNumber";
	String CLASS = "class";
	String BOOK = "book";
	
	//ContentProvider字段
	String AUTHORITH = "com.ozing.provider.notebook";
	Uri NOTE_URI = Uri.parse("content://"+AUTHORITH+"/note");
	Uri NOTE_CHILD_URI = Uri.parse("content://"+AUTHORITH+"/note_child");		
	Uri NOTE_PICTURE_URI = Uri.parse("content://"+AUTHORITH+"/note_picture");
	
	//UriMathcer
	int NOTE_TYPE = 0x0001;
	int NOTE_CHILD_TYPE = 0x0002;
	int NOTE_PICTURE_TYPE = 0x0003;
	
	//sortOrder
	int DEFAULT_ORDER = 0x0004;
	int CREATE_TIME_ORDER = 0x0005;
	int NOTE_INDEX_ORDER = 0x0006;
	
}
