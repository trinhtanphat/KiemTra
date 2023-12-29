package com.example.kiemtra.DAO;

import static androidx.constraintlayout.helper.widget.MotionEffect.TAG;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import com.example.kiemtra.Database.DbHelper;
import com.example.kiemtra.Model.Product;

import java.util.ArrayList;

public class ProductDAO {
    private final DbHelper dbHelper;
    public ProductDAO(Context context){
        dbHelper = new DbHelper(context);
    }

    public ArrayList<Product> getListProduct() {
        ArrayList<Product> list = new ArrayList<>();
        SQLiteDatabase database = dbHelper.getReadableDatabase();
        database.beginTransaction();
        try {
            Cursor cursor = database.rawQuery("SELECT * FROM Product", null);
            if(cursor.getCount() > 0) {
                cursor.moveToFirst();
                do {
                    list.add(new Product(cursor.getInt(0),
                            cursor.getString(1),
                            cursor.getFloat(2),
                            cursor.getString(3)));
                } while (cursor.moveToNext());
                database.setTransactionSuccessful();
            }
        } catch (Exception e) {
            Log.e(TAG, "getListProduct" + e);
        } finally {
            database.endTransaction();
        }
        return list;
    }

    public boolean deleteSP(int MaSP) {
        SQLiteDatabase db = dbHelper.getWritableDatabase();
        int affectedRows = db.delete("Product", "MaSP=?", new String[]{String.valueOf(MaSP)});
        return affectedRows > 0;
    }
}