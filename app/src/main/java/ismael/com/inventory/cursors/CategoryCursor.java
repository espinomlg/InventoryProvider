package ismael.com.inventory.cursors;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;

import ismael.com.inventory.DB.DatabaseManager;

/**
 * Created by espino on 8/05/17.
 */

public class CategoryCursor extends CursorLoader {

    public CategoryCursor(Context context) {
        super(context);
    }

    @Override
    public Cursor loadInBackground() {
        return DatabaseManager.getInstance().getAllCategories();
    }
}