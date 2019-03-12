package edu.wit.mobileapp.mysqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
// Set the path and database name
            String path = "/data/data/" + getPackageName() + "/sample.db";
// Open the database. If it doesn't exist, create it.
            SQLiteDatabase db;
            db = SQLiteDatabase.openOrCreateDatabase(path, null);
// Create a table - people
            String sql = "CREATE TABLE IF NOT EXISTS people" +
                    "(_id INTEGER PRIMARY KEY AUTOINCREMENT, name TEXT);";
            db.execSQL(sql);
// Drop the table
//db.execSQL("DROP TABLE IF EXISTS people");
// Add Data
//ContentValues values = new ContentValues();
//values.put("name", "jones");
//db.insert("people", null, values);
// Update Data
//ContentValues newValues = new ContentValues();
//newValues.put("name", "david");
//String[] args = {"1"};
//db.update("people", newValues, "_id=?", args);
// Delete Data
//String[] deleteArgs = {"1"};
//db.delete("people", "_id=?", deleteArgs);
// Change Table Structure
            db.execSQL("ALTER TABLE people ADD COLUMN age INTEGER");
            // Add Data
            ContentValues values = new ContentValues();
            String[] nameData = {"jones","david","cat","baby","max"};
            int[] ageData = {30,25,40,2,1};
            for(int i=0;i<5;i++){
                values.put("name", nameData[i]);
                values.put("age", ageData[i]);
                db.insert("people", null, values); }
// Search for data that satisfy the query requirement
            String[] columns = {"name", "age"};
            String where = "age >= ?";
            String[] where_args = {"5"};
            String having = null;
            String group_by = null;
            String order_by = "age";
            Cursor cursor = db.query("people", columns, where, where_args, group_by, having, order_by);
            while(cursor.moveToNext()){
                String name = cursor.getString(cursor.getColumnIndex("name"));
                int age = cursor.getInt(cursor.getColumnIndex("age"));
                Log.v("myApp", "name = " + name + ", age = " + age);
            }
            Log.v("myApp", "end the printing");
//Close the database
            db.close();
        }
    }

