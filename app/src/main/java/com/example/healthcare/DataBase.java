//
// Source code recreated from a .class file by IntelliJ IDEA
// (powered by FernFlower decompiler)
//

package com.example.healthcare;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;
import androidx.annotation.Nullable;
import java.util.ArrayList;
import java.util.LinkedHashMap;

public class DataBase extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "healthcare";

    public DataBase(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String qur2 = "create table cart(username text,product text,price float,otype text)";
        String qur1 = "create table user(username text,email text,password text)";
        sqLiteDatabase.execSQL(qur2);
        sqLiteDatabase.execSQL(qur1);
        String qur3 = "CREATE TABLE orderplace(username TEXT, fullname TEXT, address TEXT, contact TEXT, pincode INT, date TEXT, time TEXT, amount REAL, otype TEXT)";
        sqLiteDatabase.execSQL(qur3);
    }

    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
    }

    public void register(String username, String email, String password) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("email", email);
        cv.put("password", password);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("user", (String)null, cv);
        db.close();
    }

    public int login(String username, String password) {
        int result = 0;
        String[] str = new String[]{username, password};
        SQLiteDatabase db = this.getReadableDatabase();
        Cursor c = db.rawQuery("select * from user where username=? and password=?", str);
        if (c.moveToFirst()) {
            result = 1;
        }

        return result;
    }

    public void addcart(String username, String product, float price, String otype) {
        Log.d("addcart", "Adding to cart - Username: " + username + ", Product: " + product + ", Price: " + price + ", Order Type: " + otype);
        ContentValues cv1 = new ContentValues();
        cv1.put("username", username);
        cv1.put("product", product);
        cv1.put("price", price);
        cv1.put("otype", otype);
        SQLiteDatabase db = this.getWritableDatabase();
        long result = db.insert("cart", (String)null, cv1);
        db.close();
        if (result == -1L) {
            Log.e("addcart", "Error adding data to cart.");
        } else {
            Log.d("addcart", "Data added successfully to cart.");
        }

    }

    public int checkcart(String username, String product) {
        int result = 0;

        try {
            String[] str = new String[]{username, product};
            SQLiteDatabase db = this.getReadableDatabase();
            Cursor c = db.rawQuery("Select * from cart where username=? and product=?", str);
            if (c.moveToFirst()) {
                result = 1;
            }

            db.close();
        } catch (Exception var7) {
            Log.getStackTraceString(var7);
        }

        return result;
    }

    public void removecart(String username, String otype) {
        String[] str = new String[]{username, otype};
        SQLiteDatabase db = this.getWritableDatabase();
        db.delete("cart", "username=? and otype=?", str);
        db.close();
    }

    public LinkedHashMap<String, Float> getCartData(String username, String otype) {
        LinkedHashMap<String, Float> arr1 = new LinkedHashMap();
        float totalprice = 0.0F;
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            String[] str = new String[]{username, otype};
            Cursor c = db.rawQuery("select * from cart where username=? and otype=?", str);
            if (c.moveToFirst()) {
                Log.d("dbget1", "get" + username);

                do {
                    Log.d("dbget", "get" + otype);
                    String product = c.getString(c.getColumnIndex("product"));
                    float price = c.getFloat(c.getColumnIndex("price"));
                    (new StringBuilder()).append("Product: ").append(product).append(", Price: ").append(price).toString();
                    arr1.put(product, price);
                    totalprice += price;
                } while(c.moveToNext());
            }

            db.close();
        } catch (Exception var11) {
            Log.e("Fatal Exception", "Error details: " + Log.getStackTraceString(var11));
        }

        return arr1;
    }

    public ArrayList getOrder(String username) {
        ArrayList<String> arr = new ArrayList();
        SQLiteDatabase db = this.getReadableDatabase();

        try {
            String[] str = new String[]{username, null};
            Cursor c = db.rawQuery("select * from orderplace where username=?", str);
            if (c.moveToFirst()) {
                do {
                    arr.add(c.getString(1) + c.getString(2) + c.getString(3));
                } while(c.moveToNext());
            }
        } catch (Exception var6) {
            Log.d("catch", "error");
        }

        return arr;
    }

    public void addOrder(String username, String fullname, String address, String contact, int pincode, String date, String time, float price, String otype) {
        ContentValues cv = new ContentValues();
        cv.put("username", username);
        cv.put("fullname", fullname);
        cv.put("address", address);
        cv.put("contactno", contact);
        cv.put("pincode", pincode);
        cv.put("date", date);
        cv.put("time", time);
        cv.put("amount", price);
        cv.put("otype", otype);
        SQLiteDatabase db = this.getWritableDatabase();
        db.insert("orderplace", (String)null, cv);
        db.close();
    }
}
