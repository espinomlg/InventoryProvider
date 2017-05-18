package ismael.com.inventory.provider;

import android.net.Uri;
import android.provider.BaseColumns;

import java.util.HashMap;

import ismael.com.inventory.DB.DatabaseContract;

/**
 * Created by espino on 18/05/17.
 */

public final class InventoryProviderContract {
    public static final String AUTHORITY = "ismael.com.inventory";
    public static final Uri AUTHORITY_URI = Uri.parse("content://" + AUTHORITY);

    private InventoryProviderContract(){}


    public static class ProductEntry implements BaseColumns{
        public static final String
                CONTENT_PATH = "category",
                SERIAL = "serial",
                SHORTNAME = "code",
                DESCRIPTION = "description",
                CATEGORY = "category",
                SUBCATEGORY = "subcategory",
                PRODUCTCLASS = "productclass";

        public static final String[] PROJECTION = {
                _ID, SERIAL, SHORTNAME, DESCRIPTION, CATEGORY, SUBCATEGORY,
                PRODUCTCLASS
        };

        public static final Uri CONTENT_URI = Uri.withAppendedPath(AUTHORITY_URI, CONTENT_PATH);
        public static final HashMap<String, String> productProjectionMap = new HashMap<>();
        static{
            productProjectionMap.put(DatabaseContract.ProductEntry._ID, ProductEntry._ID);
            productProjectionMap.put(DatabaseContract.ProductEntry.COLUMN_SERIAL, ProductEntry.SERIAL);
            productProjectionMap.put(DatabaseContract.ProductEntry.COLUMN_SHORTNAME, ProductEntry.SHORTNAME);
            productProjectionMap.put(DatabaseContract.ProductEntry.COLUMN_DESCRIPTION, ProductEntry.DESCRIPTION);
            productProjectionMap.put(DatabaseContract.ProductEntry.COLUMN_CATEGORY, ProductEntry.CATEGORY);
            productProjectionMap.put(DatabaseContract.ProductEntry.COLUMN_SUBCATEGORY, ProductEntry.SUBCATEGORY);
            productProjectionMap.put(DatabaseContract.ProductEntry.COLUMN_PRODUCTCLASS, ProductEntry.PRODUCTCLASS);
        }

    }

    public static class CategoryEntry implements BaseColumns{
        public static final String CONTENT_PATH = "category",
                NAME = "name",
                SORTNAME = "sortname",
                DESCRIPTION = "description";

        public static final String[] PROJECTION = {
                _ID, NAME, SORTNAME, DESCRIPTION
        };
    }

    public static class SubCategoryEntry implements BaseColumns{
        public static final String CONTENT_PATH = "subcategory",
                CATEGORYID = "categoryid",
                NAME = "name",
                SORTNAME = "sortname",
                DESCRIPTION = "description";

        public static final String[] PROJECTION = {
                _ID, CATEGORYID, NAME, SORTNAME, DESCRIPTION
        };
    }

    public static class ProductClassEntry implements BaseColumns {
        public static final String CONTENT_PATH = "productclass",
                DESCRIPTION = "description";

        public static final String[] PROJECTION = {
                _ID, DESCRIPTION
        };
    }
}
