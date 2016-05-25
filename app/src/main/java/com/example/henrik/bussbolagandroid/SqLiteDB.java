package com.example.henrik.bussbolagandroid;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import Objects.TravelSuggestions;

/**
 * Created by Henrik on 2016-05-23.
 */
public class SqLiteDB extends SQLiteOpenHelper {
    private static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "Travel_DB";

    public SqLiteDB(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL("CREATE TABLE if not exists Travel( " +
                "resid INTEGER INTEGER UNIQUE PRIMARY KEY, " +
                "week INTEGER, " +
                "seats INTEGER, " +
                "price INTEGER, " +
                "dayofweek TEXT, " +
                "departure TEXT, " +
                "arraival TEXT, " +
                "fromcity TEXT, " +
                "tocity TEXT, " +
                "seatsleft INTEGER);");
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS Travel");

        onCreate(db);
    }


    public void addTravel(TravelSuggestions travelSuggestions){

            SQLiteDatabase db = this.getWritableDatabase();
            ContentValues content = new ContentValues();
            content.put("seatsleft", travelSuggestions.getSeatsLeft());
            content.put("resid", travelSuggestions.getTravelid());
            content.put("week", travelSuggestions.getWeek());
            content.put("seats", travelSuggestions.getSeats());
            content.put("price", travelSuggestions.getPrice());
            content.put("dayofweek", travelSuggestions.getDayOfWeek());
            content.put("departure", travelSuggestions.getDeparture().toString());
            content.put("arraival", travelSuggestions.getArrival().toString());
            content.put("fromcity", travelSuggestions.getFrom());
            content.put("tocity", travelSuggestions.getTo());

            db.insert("Travel", null, content);


    }
    public void deleteAll(){
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("Travel", null, null);
        onCreate(db);
    }

   public List<TravelSuggestions> GetAllTravels(){
       List<TravelSuggestions> list = new ArrayList<>();
       SQLiteDatabase db = this.getReadableDatabase();
       Cursor cursor = db.rawQuery("SELECT * FROM Travel ", null);


       while (cursor.moveToNext()) {
           TravelSuggestions travelSuggestions = new TravelSuggestions(
                   cursor.getInt(cursor.getColumnIndex("resid")),
                   cursor.getInt(cursor.getColumnIndex("week")),
                   cursor.getInt(cursor.getColumnIndex("seats")),
                   cursor.getInt(cursor.getColumnIndex("price")),
                   cursor.getString(cursor.getColumnIndex("dayofweek")),
                   cursor.getString(cursor.getColumnIndex("departure")),
                   cursor.getString(cursor.getColumnIndex("arraival")),
                   cursor.getString(cursor.getColumnIndex("fromcity")),
                   cursor.getString(cursor.getColumnIndex("tocity")),
                   cursor.getInt(cursor.getColumnIndex("seatsleft"))
           );

           list.add(travelSuggestions);
       }

       db.close();
       cursor.close();

       return list;
    }

    public TravelSuggestions getOneTravel(int travelId){
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor cursor = db.rawQuery("SELECT * FROM Travel where resid = " + travelId+";", null);
        Log.v("hej", String.valueOf(travelId));
       cursor.moveToFirst();
            TravelSuggestions travelSuggestions = new TravelSuggestions(
                    travelId,
                    cursor.getInt(cursor.getColumnIndex("week")),
                    cursor.getInt(cursor.getColumnIndex("seats")),
                    cursor.getInt(cursor.getColumnIndex("price")),
                    cursor.getString(cursor.getColumnIndex("dayofweek")),
                    cursor.getString(cursor.getColumnIndex("departure")),
                    cursor.getString(cursor.getColumnIndex("arraival")),
                    cursor.getString(cursor.getColumnIndex("fromcity")),
                    cursor.getString(cursor.getColumnIndex("tocity")),
                    cursor.getInt(cursor.getColumnIndex("seatsleft"))
            );




        db.close();
        cursor.close();

        return travelSuggestions;

    }


}
