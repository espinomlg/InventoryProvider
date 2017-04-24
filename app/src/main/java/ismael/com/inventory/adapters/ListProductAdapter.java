package ismael.com.inventory.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ismael.com.inventory.R;

/**
 * Created by espino on 24/04/17.
 */

public class ListProductAdapter extends CursorAdapter {

    public ListProductAdapter(Context context, Cursor c, int flags) {
        super(context, c, flags);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.fragment_listproducts, parent, false);
        ProductHolder holder = new ProductHolder();
        holder.serial = (TextView) v.findViewById(R.id.wrap);
        holder.shortName = (TextView) v.findViewById(R.id.wrap);
        v.setTag(holder);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ProductHolder holder = (ProductHolder) view.getTag();
        //holder.serial.setText();
        //holder.shortName.setText();
    }

    @Override
    public Object getItem(int position) {
        getCursor().moveToPosition(position);
        return super.getItem(position);
    }



    class ProductHolder{
        TextView serial, shortName;
    }
}
