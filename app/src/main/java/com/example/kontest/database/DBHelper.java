package com.example.kontest.database;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.widget.Toast;

import androidx.annotation.Nullable;

public class DBHelper extends SQLiteOpenHelper {

    private Context context;
    private static final String DATABASE_NAME = "BookLibrary.db";
    private static final int DATABASE_VERSION = 1;
    private static final String TABLE_NAME = "my_library";
    private static final String COLUMN_ID = "_id";
    private static final String COLUMN_name = "_NAME";
    private static final String COLUMN_url = "URL";
    private static final String COLUMN_start_time = "START_TIME";
    private static final String COLUMN_end_time = "END_TIME";
    private static final String COLUMN_duration = "DURATION";
    private static final String COLUMN_site = "SITE";
    private static final String COLUMN_in_24_hours = "IN_24_HOURS";
    private static final String COLUMN_status = "STATUS";




    public DBHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
        this.context = context;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {

        String query = "CREATE TABLE "+TABLE_NAME+
                " ("+COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT, "+
                COLUMN_name + " TEXT, "+
                COLUMN_url + " TEXT, "+
                COLUMN_start_time + " TEXT, "+
                COLUMN_end_time + " TEXT, "+
                COLUMN_duration + " TEXT, "+
                COLUMN_site + " TEXT, "+
                COLUMN_in_24_hours + " TEXT, "+
                COLUMN_status + " TEXT); ";

        sqLiteDatabase.execSQL(query);

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS "+TABLE_NAME);
        onCreate(sqLiteDatabase);
    }

    public void insertData (String name,String url,String start_time,String end_time,String duration,String site,String in_24_hours,String status) {
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(COLUMN_name,name);
        values.put(COLUMN_url,url);
        values.put(COLUMN_start_time,start_time);
        values.put(COLUMN_end_time,end_time);
        values.put(COLUMN_duration,duration);
        values.put(COLUMN_site,site);
        values.put(COLUMN_in_24_hours,in_24_hours);
        values.put(COLUMN_status,status);

        long result = database.insert(TABLE_NAME,null,values);

        if (result == -1) {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Saved", Toast.LENGTH_SHORT).show();
        }
    }

    public Cursor readAllData() {
        String query = "SELECT * FROM "+TABLE_NAME;
        SQLiteDatabase db = this.getReadableDatabase();

        Cursor cursor = null;

        if (db!=null) {
            cursor = db.rawQuery(query,null);
        }
        return cursor;
    }

    public void deleteDataOne(String row_id) {
        SQLiteDatabase database = this.getWritableDatabase();
        long result = database.delete(TABLE_NAME,"_id=?",new String[] {row_id});

        if(result == -1) {
            Toast.makeText(context, "Something went wrong", Toast.LENGTH_SHORT).show();
        } else {
            Toast.makeText(context, "Deleted the entry", Toast.LENGTH_SHORT).show();
        }
    }
}
