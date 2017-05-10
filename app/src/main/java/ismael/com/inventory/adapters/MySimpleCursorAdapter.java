package ismael.com.inventory.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;

/**
 * Created by espino on 10/05/17.
 */

public class MySimpleCursorAdapter extends SimpleCursorAdapter {


    public MySimpleCursorAdapter(Context context, int layout, Cursor c, String[] from, int[] to, int flags) {
        super(context, layout, c, from, to, flags);
    }

    @Override
    public String getItem(int position) {
        getCursor().moveToPosition(position);
        return getCursor().getString(0);
    }
}

