package ismael.com.inventory.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import ismael.com.inventory.InventoryApplication;

/**
 * Created by espino on 20/04/17.
 */

public class DatabaseHelper extends SQLiteOpenHelper {

    private static final int DATABASE_VERSION = 4;
    private static final String DATABASE_NAME = "inventory.db";
    private static DatabaseHelper instance;
    private SQLiteDatabase db;

    public DatabaseHelper(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    public static DatabaseHelper getInstance() {
        if (instance == null)
            instance = new DatabaseHelper(InventoryApplication.getContext());

        return instance;
    }

    public SQLiteDatabase openDatabase() {
        db = getWritableDatabase();
        return db;
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        try {
            sqLiteDatabase.beginTransaction();

            sqLiteDatabase.execSQL(DatabaseContract.CategoryEntry.SQL_CREATE_ENTRY);
            sqLiteDatabase.execSQL(DatabaseContract.SubCategoryEntry.SQL_CREATE_ENTRY);
            sqLiteDatabase.execSQL(DatabaseContract.ProductEntry.SQL_CREATE_ENTRY);
            sqLiteDatabase.execSQL(DatabaseContract.ProductClassEntry.SQL_CREATE_ENTRY);

            sqLiteDatabase.execSQL("INSERT INTO product(serial,code,description,category,subcategory,productclass) VALUES " +
                    "('001', 'Monitor', 'Monitor del ordenador', 1, 1, 1), " +
                    "('002', 'Teclado', 'Teclado del ordenador', 1, 1, 1), " +
                    "('003', 'Ratón', 'Ratón del ordenador', 1, 1, 1);");

            sqLiteDatabase.setTransactionSuccessful();
        } catch (SQLiteException ex) {
            Log.e("DATABASE ERROR", ex.getLocalizedMessage());
        } finally {
            sqLiteDatabase.endTransaction();
        }

    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        try {
            sqLiteDatabase.beginTransaction();

            sqLiteDatabase.execSQL(DatabaseContract.CategoryEntry.SQL_DELETE_ENTRY);
            sqLiteDatabase.execSQL(DatabaseContract.SubCategoryEntry.SQL_DELETE_ENTRY);
            sqLiteDatabase.execSQL(DatabaseContract.ProductEntry.SQL_DELETE_ENTRY);
            sqLiteDatabase.execSQL(DatabaseContract.ProductClassEntry.SQL_DELETE_ENTRY);
            onCreate(sqLiteDatabase);
            sqLiteDatabase.setTransactionSuccessful();
        } catch (SQLiteException ex) {
            Log.e("DATABASE ERROR", ex.getLocalizedMessage());
        } finally {
            sqLiteDatabase.endTransaction();
        }
    }

    @Override
    public void onDowngrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        super.onDowngrade(db, oldVersion, newVersion);
        onUpgrade(db, newVersion, oldVersion);
    }
}
