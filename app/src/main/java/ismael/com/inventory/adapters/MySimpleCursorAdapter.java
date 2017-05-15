package ismael.com.inventory.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.SimpleCursorAdapter;
import android.util.Log;

import static android.content.ContentValues.TAG;

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

    public int findPosition(int category){
        if(getCursor().moveToFirst()){
            do{
                if(category == getCursor().getInt(0))
                    return getCursor().getPosition();
            }while(getCursor().moveToNext());
        }

        return -1;
    }

    public void show(){
        if(getCursor().moveToFirst()){
            do{
                Log.e(TAG, "show: " + getCursor().getInt(0));

            }while(getCursor().moveToNext());
        }

    }
}

