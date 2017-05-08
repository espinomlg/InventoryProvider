package ismael.com.inventory.DB;

import android.provider.BaseColumns;

/**
 * Created by espino on 20/04/17.
 */

public class DatabaseContract {

    private DatabaseContract(){}

    public static class ProductEntry implements BaseColumns{
        public static final String TABLE_NAME = "product",
                COLUMN_SERIAL = "serial",
                COLUMN_SHORTNAME = "code",
                COLUMN_DESCRIPTION = "description",
                COLUMN_CATEGORY = "category",
                COLUMN_SUBCATEGORY = "subcategory",
                COLUMN_PRODUCTCLASS = "productclass",

                SQL_CREATE_ENTRY = String.format("CREATE TABLE %s " +
                                "(%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "%s TEXT UNIQUE NOT NULL," +
                                "%s TEXT UNIQUE NOT NULL," +
                                "%s TEXT NOT NULL," +
                                "%s INT NOT NULL," +
                                "%s INT NOT NULL," +
                                "%s INT NOT NULL)",
                        TABLE_NAME,
                        BaseColumns._ID,
                        COLUMN_SERIAL,
                        COLUMN_SHORTNAME,
                        COLUMN_DESCRIPTION,
                        COLUMN_CATEGORY,
                        COLUMN_SUBCATEGORY,
                        COLUMN_PRODUCTCLASS),

                SQL_DELETE_ENTRY = String.format("DROP TABLE %s", TABLE_NAME);

        public static final String[] ALL_COLUMNS = {
                _ID, COLUMN_SERIAL, COLUMN_SHORTNAME, COLUMN_DESCRIPTION, COLUMN_CATEGORY, COLUMN_SUBCATEGORY,
                COLUMN_PRODUCTCLASS
        };


    }

    public static class CategoryEntry implements BaseColumns{
        public static final String TABLE_NAME = "category",
                COLUMN_NAME = "name",
                COLUMN_SORTNAME = "sortname",
                COLUMN_DESCRIPTION = "description",

                SQL_CREATE_ENTRY = String.format("CREATE TABLE %s " +
                                "(%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "%s TEXT UNIQUE NOT NULL," +
                                "%s TEXT UNIQUE NOT NULL," +
                                "%s TEXT NOT NULL)",
                        TABLE_NAME,
                        BaseColumns._ID,
                        COLUMN_NAME,
                        COLUMN_SORTNAME,
                        COLUMN_DESCRIPTION),

                SQL_DELETE_ENTRY = String.format("DROP TABLE %s", TABLE_NAME);
        public static final String[] ALL_COLUMNS = {
                _ID, COLUMN_NAME, COLUMN_SORTNAME, COLUMN_DESCRIPTION
        };
    }

    public static class SubCategoryEntry implements BaseColumns{
        public static final String TABLE_NAME = "subcategory",
                COLUMN_CATEGORYID = "categoryid",
                COLUMN_NAME = "name",
                COLUMN_SORTNAME = "sortname",
                COLUMN_DESCRIPTION = "description",

                SQL_CREATE_ENTRY = String.format("CREATE TABLE %s " +
                                "(%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "%s INTEGER NOT NULL," +
                                "%s TEXT UNIQUE NOT NULL," +
                                "%s TEXT UNIQUE NOT NULL," +
                                "%s TEXT NOT NULL)",
                        TABLE_NAME,
                        BaseColumns._ID,
                        COLUMN_CATEGORYID,
                        COLUMN_NAME,
                        COLUMN_SORTNAME,
                        COLUMN_DESCRIPTION),

                SQL_DELETE_ENTRY = String.format("DROP TABLE %s", TABLE_NAME);

        public static final String[] ALL_COLUMNS = {
                _ID, COLUMN_CATEGORYID, COLUMN_NAME, COLUMN_SORTNAME, COLUMN_DESCRIPTION
        };
    }

    public static class ProductClassEntry implements BaseColumns{
        public static final String TABLE_NAME = "productclass",
                COLUMN_DESCRIPTION = "description",

                SQL_CREATE_ENTRY = String.format("CREATE TABLE %s " +
                                "(%s INTEGER PRIMARY KEY AUTOINCREMENT," +
                                "%s TEXT NOT NULL)",
                        TABLE_NAME,
                        BaseColumns._ID,
                        COLUMN_DESCRIPTION),

                SQL_DELETE_ENTRY = String.format("DROP TABLE %s", TABLE_NAME);

        public static final String[] ALL_COLUMNS = {
                _ID, COLUMN_DESCRIPTION
        };
    }
}
