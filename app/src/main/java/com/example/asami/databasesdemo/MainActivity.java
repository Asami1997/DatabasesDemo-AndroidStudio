package com.example.asami.databasesdemo;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
   /*
      try{

          //open or create menas if there is one , it will open it , if there is not , it will create it.
          //Users here is the name of the Database

          SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);
          //now add a table to the database usimg sql command
          // create users table if it dosent exist , and add two attributes to it , name varchar and age int whoch contains ma threed digits
          sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR ,age INT(3))");

          ///inserting to my relative database

          sqLiteDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Ahmad',19) ");

          sqLiteDatabase.execSQL("INSERT INTO users (name,age) VALUES ('Zaina',8) ");

          //now getting data from the database

          //cursor object allows us to loop through the results of a query and do something with it

          //here we are selecting everything
          Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users",null);




          //you need to get them here unlike web
          int nameIndex = cursor.getColumnIndex("name");
          int ageIndex = cursor.getColumnIndex("age");

 //means move to the first result  ie : ('Ahmad',19);
          cursor.moveToFirst();

          while(cursor != null)
             {
                 Log.i("name",cursor.getString(nameIndex));
                 Log.i("age", String.valueOf(cursor.getInt(ageIndex)));

                 //move to next result
                 cursor.moveToNext();

             }


      }catch (Exception e)
         {

           e.printStackTrace();
         }

         */

   try
      {
          SQLiteDatabase sqLiteDatabase = this.openOrCreateDatabase("Users",MODE_PRIVATE,null);

          /*
          sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS users (name VARCHAR age Int(3))");
         */

          //the id will increament with ecach row automatically


          sqLiteDatabase.execSQL("CREATE TABLE IF NOT EXISTS newUSERS (name VARCHAR ,id  INTEGER PRIMARY KEY)");

          sqLiteDatabase.execSQL("INSERT INTO  newUSERS (name) VALUES('Ahmad',19)");

          sqLiteDatabase.execSQL("INSERT INTO  newUSERS(name) VALUES('Sara',16)");


          /*
          Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users",null);
          */

          /*
          Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE age < 18",null);
          */

          /*
          Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE  name = 'Sara' ",null);
          */

          /*
          Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE  name = 'Sara' AND age < 20 ",null);
          */

           /*
        Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE  name = 'Sara' AND age < 20 ",null);
         */

          //if we want just to get the names that starts with S or Z for example where the percent symbol means anything

          /*
          Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE name LIKE 'S%'",null);
           */

          //anything a anything

          /*
          Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE  name  LIKE '%a%' ",null);
           */

          //we are limiting the number of results
          /*
          Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM users WHERE  name  LIKE '%a%' LIMIT 1 ",null);
           */

          /*
          sqLiteDatabase.execSQL("DELETE FROM users WHERE name in (SELECT name from users WHERE name = 'Ahmad' LIMIT 1)");
          */

          //updating data in DB

          /*
          sqLiteDatabase.execSQL("UPDATE users SET age = 20 WHERE name = 'Sara' ");
          */


          Cursor cursor = sqLiteDatabase.rawQuery("SELECT * FROM  newUSERS",null);

          int nameIndex = cursor.getColumnIndex("name");
          //int ageIndex = cursor.getColumnIndex("age");
          int idIndex = cursor.getColumnIndex("id");


          cursor.moveToFirst();

          while (cursor!=null)
          {

              //get everything in column name 
              Log.i("nameResult",cursor.getString(nameIndex));
             // Log.i("ageResult",cursor.getString(ageIndex));
              Log.i("Id",cursor.getString(idIndex));
              cursor.moveToNext();

          }

      }catch (Exception e)
             {
               e.printStackTrace();
             }




    }
}
