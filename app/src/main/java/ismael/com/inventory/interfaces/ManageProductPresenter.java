package ismael.com.inventory.interfaces;

import android.content.Context;

/**
 * Created by espino on 8/05/17.
 */

public interface ManageProductPresenter {

    void getAllCategories();
    void getAllSubcategories();

    interface View{
        void setSpinnersAdapters();
        Context getContext();
    }
}
