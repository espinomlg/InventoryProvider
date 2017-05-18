package ismael.com.inventory.provider;

import android.content.ContentProvider;
import android.content.ContentValues;
import android.content.UriMatcher;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;

import ismael.com.inventory.DB.DatabaseContract;
import ismael.com.inventory.DB.DatabaseHelper;

/**
 * Created by espino on 18/05/17.
 */

public class InventoryProvider extends ContentProvider {

    private static final int PRODUCT = 1;
    private static final int PRODUCT_ID = 2;
    private static final int CATEGORY = 3;
    private static final int CATEGORY_ID = 4;
    private static final int SUBCATEGORY = 5;
    private static final int SUBCATEGORY_ID = 6;

    private static final UriMatcher uriMatcher = new UriMatcher(UriMatcher.NO_MATCH);
    static{
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.ProductEntry.CONTENT_PATH, PRODUCT);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.ProductEntry.CONTENT_PATH + "/#", PRODUCT_ID);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.CategoryEntry.CONTENT_PATH, CATEGORY);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.CategoryEntry.CONTENT_PATH + "/#", CATEGORY_ID);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.SubCategoryEntry.CONTENT_PATH, SUBCATEGORY);
        uriMatcher.addURI(InventoryProviderContract.AUTHORITY, InventoryProviderContract.SubCategoryEntry.CONTENT_PATH + "/#", SUBCATEGORY_ID);
    }

    private SQLiteDatabase db;

    @Override
    public boolean onCreate() {
        db = DatabaseHelper.getInstance().openDatabase();
        return false;
    }

    @Nullable
    @Override
    public Cursor query(@NonNull Uri uri, @Nullable String[] strings, @Nullable String s, @Nullable String[] strings1, @Nullable String s1) {
        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();

        switch (uriMatcher.match(uri)){
            case PRODUCT:
                sqLiteQueryBuilder.setTables(DatabaseContract.ProductEntry.TABLE_NAME);
                sqLiteQueryBuilder.setProjectionMap(InventoryProviderContract.ProductEntry.productProjectionMap);
                break;
            case PRODUCT_ID:
                break;
            case CATEGORY:
                break;
            case CATEGORY_ID:
                break;
            case SUBCATEGORY:
                break;
            case SUBCATEGORY_ID:
                break;
        }

        return null;
    }

    @Nullable
    @Override
    public String getType(@NonNull Uri uri) {
        return null;
    }

    @Nullable
    @Override
    public Uri insert(@NonNull Uri uri, @Nullable ContentValues contentValues) {
        return null;
    }

    @Override
    public int delete(@NonNull Uri uri, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }

    @Override
    public int update(@NonNull Uri uri, @Nullable ContentValues contentValues, @Nullable String s, @Nullable String[] strings) {
        return 0;
    }
}
