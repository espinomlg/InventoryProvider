package ismael.com.inventory.presenter;

import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;
import android.support.v4.content.Loader;

import ismael.com.inventory.DB.DatabaseManager;
import ismael.com.inventory.cursors.CategoryCursor;
import ismael.com.inventory.cursors.SubCategoryCursor;
import ismael.com.inventory.interfaces.ManageProductPresenter;
import ismael.com.inventory.models.Product;

/**
 * Created by espino on 8/05/17.
 */

public class ManageProductPresenterImpl implements ManageProductPresenter, LoaderManager.LoaderCallbacks<Cursor>{

    public static final int CATEGORYCURSOR_ID = 10,
                            SUBCATEGORYCURSOR_ID = 20;

    private ManageProductPresenter.View view;

    public ManageProductPresenterImpl(ManageProductPresenter.View view){
        this.view = view;
    }


    @Override
    public Loader<Cursor> onCreateLoader(int id, Bundle args) {
        switch (id){
            case 10:
                return new CategoryCursor(view.getContext());
            case 20:
                return  new SubCategoryCursor(view.getContext(), new String[]{args.getString("id")});
        }

        return null;
    }

    @Override
    public void onLoadFinished(Loader<Cursor> loader, Cursor data) {
        if(loader.getId() == CATEGORYCURSOR_ID)
            view.setCategorySpnAdapter(data);
        else
            view.setSubcategorySpnAdapter(data);
    }

    @Override
    public void onLoaderReset(Loader<Cursor> loader) {
        if(loader.getId() == CATEGORYCURSOR_ID)
            view.setCategorySpnAdapter(null);
        else
            view.setSubcategorySpnAdapter(null);
    }

    @Override
    public void getAllCategories(LoaderManager lm) {
        lm.initLoader(CATEGORYCURSOR_ID, null, this);
    }

    @Override
    public void getAllSubcategories(LoaderManager lm, Bundle args) {
        lm.restartLoader(SUBCATEGORYCURSOR_ID, args, this);
    }

    @Override
    public void addProduct(Product p) {
        DatabaseManager.getInstance().addProduct(p);
    }

    @Override
    public void editProduct(Product p) {
        DatabaseManager.getInstance().editProduct(p);
    }

}
