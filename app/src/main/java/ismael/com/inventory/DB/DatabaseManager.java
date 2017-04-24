package ismael.com.inventory.DB;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

/**
 * Created by espino on 20/04/17.
 */

public class DatabaseManager {

    private static DatabaseManager instance;
    private SQLiteDatabase db;

    public static DatabaseManager getInstance(){
        if(instance == null)
            instance = new DatabaseManager();

        return instance;
    }

    private DatabaseManager(){
        db = DatabaseHelper.getInstance().openDatabase();
    }

    public Cursor getAllProducts(){
        return db.query(DatabaseContract.ProductEntry.TABLE_NAME, DatabaseContract.ProductEntry.ALL_COLUMNS,
                null,null,null,null,null);
    }
}
