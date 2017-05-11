package ismael.com.inventory.presenter;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import ismael.com.inventory.DB.DatabaseManager;
import ismael.com.inventory.cursors.ListProductCursor;
import ismael.com.inventory.interfaces.ProductPresenter;
import ismael.com.inventory.models.Product;

/**
 * Created by espino on 24/04/17.
 */

public class ProductPresenterImpl implements ProductPresenter, LoaderManager.LoaderCallbacks<Cursor> {

    public static final int CURSOR_ID = 1;

    private Context context;
    private ProductPresenter.View view;

    public ProductPresenterImpl(Context context, ProductPresenter.View view){
        this.context = context;
        this.view = view;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        Loader<Cursor> loader = null;
        switch (id){
            case CURSOR_ID:
                loader = new ListProductCursor(context);
        }
        return loader;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        view.setCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        view.setCursor(null);
    }

    @Override
    public void getAllProducts(LoaderManager lm) {
        lm.restartLoader(CURSOR_ID, null, this);
    }

    @Override
    public void deleteProduct(Product p) {
        DatabaseManager.getInstance().deleteProduct(p);
    }
}
