package ismael.com.inventory.presenter;

import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import ismael.com.inventory.cursors.ListProductCursor;
import ismael.com.inventory.interfaces.ProductPresenter;

/**
 * Created by espino on 24/04/17.
 */

public class ProductPresenterImpl implements ProductPresenter, LoaderManager.LoaderCallbacks<Cursor> {

    private Context context;
    private ProductPresenter.View view;

    public ProductPresenterImpl(Context context, ProductPresenter.View view){
        this.context = context;
        this.view = view;
    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        return new ListProductCursor(context);
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        view.setCursor(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        view.setCursor(null);
    }
}
