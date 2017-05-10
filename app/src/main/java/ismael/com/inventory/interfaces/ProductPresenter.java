package ismael.com.inventory.interfaces;

import android.database.Cursor;
import android.support.v4.app.LoaderManager;

import ismael.com.inventory.models.Product;

/**
 * Created by espino on 24/04/17.
 */

public interface ProductPresenter {

    void getAllProducts(LoaderManager lm);
    void deleteProduct(Product p);

    interface View{
        void setCursor(Cursor c);
    }

}
