package ismael.com.inventory;

import android.app.Application;
import android.content.Context;

import ismael.com.inventory.DB.DatabaseHelper;
import ismael.com.inventory.DB.DatabaseManager;

/**
 * Created by espino on 20/04/17.
 */

public class InventoryApplication extends Application {

    private static InventoryApplication context;

    @Override
    public void onCreate() {
        super.onCreate();
        DatabaseHelper.getInstance().openDatabase();
        DatabaseManager.initialize(new DatabaseManager());
    }

    public InventoryApplication(){
        context = this;
    }

    public static Context getContext(){
        return context;
    }

}
