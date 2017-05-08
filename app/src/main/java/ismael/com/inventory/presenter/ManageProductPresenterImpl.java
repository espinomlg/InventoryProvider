package ismael.com.inventory.presenter;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import ismael.com.inventory.cursors.CategoryCursor;
import ismael.com.inventory.cursors.SubCategoryCursor;
import ismael.com.inventory.interfaces.ManageProductPresenter;

/**
 * Created by espino on 8/05/17.
 */

public class ManageProductPresenterImpl implements ManageProductPresenter, LoaderManager.LoaderCallbacks<Cursor>{

    private static final int CATEGORYCURSOR_ID = 10,
                            SUBCATEGORYCURSOR_ÏD = 20;

    private ManageProductPresenter.View view;

    public ManageProductPresenterImpl(ManageProductPresenter.View view){
        this.view = view;
    }

    @Override
    public void getAllCategories() {

    }

    @Override
    public void getAllSubcategories() {

    }

    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id){
            case 10:
                return new CategoryCursor(view.getContext());
            case 20:
                return  new SubCategoryCursor(view.getContext(), null);
        }

        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {

    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {

    }
}
