package ismael.com.inventory.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import ismael.com.inventory.InventoryApplication;

/**
 * Created by espino on 20/04/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 2;
    private static final String DATABASE_NAME = "inventory.db";
    private static DatabaseHelper instance;
    private SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getInstance(){
        if(instance == null)
            instance = new DatabaseHelper(InventoryApplication.getContext());

        return instance;
    }

    public SQLiteDatabase openDatabase(){
        db = getWritableDatabase();
        return db;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.beginTransaction();

        sqLiteDatabase.execSQL(DatabaseContract.CategoryEntry.SQL_CREATE_ENTRY);
        sqLiteDatabase.execSQL(DatabaseContract.SubCategoryEntry.SQL_CREATE_ENTRY);
        sqLiteDatabase.execSQL(DatabaseContract.ProductEntry.SQL_CREATE_ENTRY);
        sqLiteDatabase.execSQL(DatabaseContract.ProductClassEntry.SQL_CREATE_ENTRY);

        sqLiteDatabase.endTransaction();
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.beginTransaction();

        sqLiteDatabase.execSQL(DatabaseContract.CategoryEntry.SQL_DELETE_ENTRY);
        sqLiteDatabase.execSQL(DatabaseContract.SubCategoryEntry.SQL_DELETE_ENTRY);
        sqLiteDatabase.execSQL(DatabaseContract.ProductEntry.SQL_DELETE_ENTRY);
        sqLiteDatabase.execSQL(DatabaseContract.ProductClassEntry.SQL_DELETE_ENTRY);

        sqLiteDatabase.endTransaction();
        onCreate(sqLiteDatabase);

    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
        onUpgrade(db, newVersion, oldVersion);
    }
}
