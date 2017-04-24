package ismael.com.inventory.interfaces;

import android.database.Cursor;

/**
 * Created by espino on 24/04/17.
 */

public interface ProductPresenter {

    interface View{
        void setCursor(Cursor c);
    }

}
