package ismael.com.inventory;

import android.app.Application;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

import ismael.com.inventory.DB.DatabaseHelper;

/**
 * Created by espino on 20/04/17.
 */

public class InventoryApplication extends Application {

    private static InventoryApplication context;

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseHelper.getInstance().openDatabase();

    }

    public InventoryApplication(){
        context = this;
    }

    public static Context getContext(){
        return context;
    }

}
