package ismael.com.inventory.adapters;

import android.content.Context;
import android.database.Cursor;
import android.support.v4.widget.CursorAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import ismael.com.inventory.R;
import ismael.com.inventory.models.Product;

/**
 * Created by espino on 24/04/17.
 */

public class ListProductAdapter extends CursorAdapter {

    public ListProductAdapter(Context context, Cursor c) {
        super(context, c, CursorAdapter.FLAG_REGISTER_CONTENT_OBSERVER);
    }

    @Override
    public View newView(Context context, Cursor cursor, ViewGroup parent) {
        View v = LayoutInflater.from(context).inflate(R.layout.listitem_product, parent, false);
        ProductHolder holder = new ProductHolder();
        holder.serial = (TextView) v.findViewById(R.id.productitem_serial);
        holder.shortName = (TextView) v.findViewById(R.id.productitem_shortname);
        holder.category = (TextView) v.findViewById(R.id.productitem_category);
        holder.subcategory = (TextView) v.findViewById(R.id.productitem_subcategory);
        v.setTag(holder);
        return v;
    }

    @Override
    public void bindView(View view, Context context, Cursor cursor) {
        ProductHolder holder = (ProductHolder) view.getTag();
        holder.serial.setText(cursor.getString(1));
        holder.shortName.setText(cursor.getString(2));
        holder.category.setText(cursor.getString(4));
        holder.subcategory.setText(cursor.getString(5));
    }

    @Override
    public Product getItem(int position) {
        getCursor().moveToPosition(position);

        Product p = new Product(getCursor().getInt(0),
                getCursor().getString(1),
                getCursor().getString(2),
                getCursor().getString(3),
                String.valueOf(getCursor().getInt(4)),
                String.valueOf(getCursor().getInt(5)),
                String.valueOf(getCursor().getInt(6)));

        return p;
    }

    class ProductHolder{
        TextView serial, shortName, category, subcategory;
    }
}
