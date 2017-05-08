package ismael.com.inventory.cursors;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;

import ismael.com.inventory.DB.DatabaseManager;

/**
 * Created by espino on 8/05/17.
 */

public class SubCategoryCursor extends CursorLoader {


    public SubCategoryCursor(Context context, String[] args)
    {
        super(context);
        super.setSelectionArgs(args);
    }

    @Override
    public Cursor loadInBackground() {
        return DatabaseManager.getInstance().getAllSubcategoriesFrom(super.getSelectionArgs());
    }


}