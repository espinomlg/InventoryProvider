package ismael.com.inventory.interfaces;


import android.content.Context;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v4.app.LoaderManager;

import ismael.com.inventory.models.Product;

/**
 * Created by espino on 8/05/17.
 */

public interface ManageProductPresenter {

    void getAllCategories(LoaderManager lm);
    void getAllSubcategories(LoaderManager lm, Bundle args);

    void addProduct(Product p);
    void editProduct(Product p);

    interface View{
        void setCategorySpnAdapter(Cursor c);
        void setSubcategorySpnAdapter(Cursor c);
        Context getContext();
    }
}
