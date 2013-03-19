package com.ozing.database;

import android.net.Uri;

public interface NoteStringInterface {
	//���ݿ�
	String DB_NAME = "NoteBook.db";//���ݿ�����
	int DB_VERSION = 1;//���ݿ�汾��
	String DB_TABLE_NOTE = "note";//�ʼǱ�����
	String DB_TABLE_NOTE_CHILD = "note_child";//�ʼǱ���ϸ����
	String DB_TABLE_NOTE_PICETURE = "note_picture";//�ʼǱ���ͼƬ����
	
	// �ʼ�����ֶ�����
	String ID = "_id";//id�ţ�Ψһ��ʶ���Զ�����
	String NOTE_NAME = "noteName";//�ʼ����ƣ�Ψһ��������ʱ��+�������
	String NOTE_TITLE = "noteTitle";//�ʼǱ���

	String NOTE_TEXT = "noteText";//�ʼ��ı�����
	String NOTE_PAINT = "notePaint";//�ʼ����ֻ�ͼ
	String SURVEY_IMG = "surveyImg";//�ʼ�����ͼ
	String CREATE_TIME = "createTime";//�ʼǴ���ʱ��
	String NOTE_SUM = "noteSum";//�ʼ���ҳ��
	String NOTE_INDEX = "noteIndex";//��ǰ�ʼǵ�����
	String NOTE_ID = "noteId";//��note�������id�ţ���note���е�id��
	
	// ͼƬ����ֶ�����
	String NOTE_PICTURE = "notePicture";//�ʼ��в����ͼƬ
	String X_POSITION = "xPosition";//ͼƬX����
	String Y_POSITION = "yPosition";//ͼƬY����
	String WIDTH = "width";//ͼƬ����
	String HEIGHT = "height";//ͼƬ�߶�
	String SCALE = "scale";//ͼƬ�Ŵ����
	
	
	// ��ý��α�ר��
	String PAGE_NUMBER = "pageNumber";
	String CLASS = "class";
	String BOOK = "book";
	
	//ContentProvider�ֶ�
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
