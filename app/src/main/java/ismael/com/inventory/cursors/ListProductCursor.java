package ismael.com.inventory.cursors;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.content.CursorLoader;

import ismael.com.inventory.DB.DatabaseManager;

/**
 * Created by espino on 24/04/17.
 */

public class ListProductCursor extends CursorLoader {

    public ListProductCursor(Context context) {
        super(context);
    }

    @Override
    public Cursor loadInBackground() {
        return DatabaseManager.getInstance().getAllProducts();
    }
}
