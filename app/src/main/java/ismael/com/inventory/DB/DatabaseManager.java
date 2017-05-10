package ismael.com.inventory.DB;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import ismael.com.inventory.models.Product;

/**
 * Created by espino on 20/04/17.
 */

public class DatabaseManager {

    private static DatabaseManager instance;
    private SQLiteDatabase db;

    public static synchronized DatabaseManager getInstance(){
        if(instance == null)
            throw new IllegalStateException("database manager is null, call initialize()");

        return instance;
    }

    public static synchronized void initialize(DatabaseManager dm){
        if(instance == null)
            instance = dm;
    }

    public DatabaseManager(){
        db = DatabaseHelper.getInstance().openDatabase();
    }

    public Cursor getAllProducts(){
        return db.query(DatabaseContract.ProductEntry.TABLE_NAME, DatabaseContract.ProductEntry.ALL_COLUMNS,
                null,null,null,null,null);
    }

    public Cursor getAllCategories(){
        return db.query(DatabaseContract.CategoryEntry.TABLE_NAME, DatabaseContract.CategoryEntry.ALL_COLUMNS,
                null,null,null,null,null);
    }

    public Cursor getAllSubcategoriesFrom(String[] args){
        return db.query(DatabaseContract.SubCategoryEntry.TABLE_NAME, DatabaseContract.SubCategoryEntry.ALL_COLUMNS,
                "categoryid = ?", args, null,null,null);
    }

    public void addProduct(Product p){
        ContentValues cv = new ContentValues();
        cv.put(DatabaseContract.ProductEntry.COLUMN_SERIAL, p.getSerial());
        cv.put(DatabaseContract.ProductEntry.COLUMN_SHORTNAME, p.getShortName());
        cv.put(DatabaseContract.ProductEntry.COLUMN_DESCRIPTION, p.getDescription());
        cv.put(DatabaseContract.ProductEntry.COLUMN_CATEGORY, p.getCategory());
        cv.put(DatabaseContract.ProductEntry.COLUMN_SUBCATEGORY, p.getSubcategory());
        cv.put(DatabaseContract.ProductEntry.COLUMN_PRODUCTCLASS, p.getProductClass());

        db.insert(DatabaseContract.ProductEntry.TABLE_NAME, null, cv);

    }

    public void editProduct(Product p){
        ContentValues cv = new ContentValues();
        cv.put(DatabaseContract.ProductEntry.COLUMN_SERIAL, p.getSerial());
        cv.put(DatabaseContract.ProductEntry.COLUMN_SHORTNAME, p.getShortName());
        cv.put(DatabaseContract.ProductEntry.COLUMN_DESCRIPTION, p.getDescription());
        cv.put(DatabaseContract.ProductEntry.COLUMN_CATEGORY, p.getCategory());
        cv.put(DatabaseContract.ProductEntry.COLUMN_SUBCATEGORY, p.getSubcategory());
        cv.put(DatabaseContract.ProductEntry.COLUMN_PRODUCTCLASS, p.getProductClass());

        db.update(DatabaseContract.ProductEntry.TABLE_NAME, cv, "_id=?", new String[]{String.valueOf(p.getId())});
    }

    public void deleteProduct(Product p){
        db.delete(DatabaseContract.ProductEntry.TABLE_NAME,"_id=?", new String[]{String.valueOf(p.getId())});
    }
}
