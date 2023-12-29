package com.example.kiemtra.Database;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class DbHelper extends SQLiteOpenHelper {

    public DbHelper(@Nullable Context context) {
        super(context, "QLSanPham", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        String sql = "CREATE TABLE SanPham(MaSP INTEGER PRIMARY KEY AUTOINCREMENT, " + "TenSP TEXT, GiaTien REAL, Image TEXT)";
        db.execSQL(sql);
        String data = "INSERT INTO SanPham VALUES(1, 'Banh Mi Viet Nam', '110000', 'https://www.google.com/search?q=banh+m%C3%AC&sca_esv=594387602&rlz=1C1CHZN_viVN1084VN1084&sxsrf=AM9HkKkzz4F0fZTxEZPo-YBUvNw-7LbUZg:1703835572215&tbm=isch&source=iu&ictx=1&vet=1&fir=iBkTjgTTVjbIcM%252C4IJPaExVW0a5-M%252C_%253BB71uGrv2OynoeM%252CVWuIwLxztNPUCM%252C_%253BzSbx8sjoO9HO7M%252CurLzmO0IXO35zM%252C_%253BRsoEKYivUKeb6M%252CVNq_NOHvscq6yM%252C_&usg=AI4_-kRYM1wC9iKT_G7o6J9RvU_tS2eGfQ&sa=X&ved=2ahUKEwjwh6aQkrSDAxXYklYBHetQDJsQ_h16BAhGEAE#imgrc=zSbx8sjoO9HO7M')," +
                "(2, 'Pateso', '50000', 'https://www.google.com/imgres?imgurl=https%3A%2F%2Fimages.foody.vn%2Fres%2Fg18%2F177416%2Fprof%2Fs%2Ffoody-mobile-t1-jpg-825-635808414810430323.jpg&tbnid=_LQsD6REtXLAjM&vet=12ahUKEwid69z1kbSDAxVn1jQHHWNdBK8QMygGegQIARBh..i&imgrefurl=https%3A%2F%2Fwww.foody.vn%2Fcan-tho%2Fbanh-pateso-mai-anh&docid=IP78mBk6BfnBpM&w=800&h=500&q=pateso&ved=2ahUKEwid69z1kbSDAxVn1jQHHWNdBK8QMygGegQIARBh')," +
                "(3, 'Pho Sai Gon', '4600000', 'https://www.google.com/imgres?imgurl=https%3A%2F%2Fkenh14cdn.com%2F203336854389633024%2F2023%2F1%2F5%2Fphoto-18-16729028981771511767845.jpg&tbnid=kOKk85sHboPAlM&vet=12ahUKEwis_IevkrSDAxXIUvUHHbU6A0gQMygBegQIARBW..i&imgrefurl=https%3A%2F%2Fkenh14.vn%2Fdau-bep-tung-nau-to-pho-choc-troi-gan-1-trieu-dong-tren-landmark-81-mo-quan-pho-rieng-lieu-huong-vi-co-giong-20230105142451339.chn&docid=saZhl8iMcitrlM&w=640&h=640&q=pho%20%20landmark%2081&ved=2ahUKEwis_IevkrSDAxXIUvUHHbU6A0gQMygBegQIARBW')";
        db.execSQL(data);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int i, int i1) {
        if (i != i1){
            db.execSQL("DROP TABLE IF EXISTS SanPham");
            onCreate(db);
        }
    }
}