package mihaelaursu.inventoryapp.data;

import android.provider.BaseColumns;

/**
 * Created by ursum on 22/07/2017.
 */

public class Contract {

    public Contract() {
    }

    public static final class ProviderEntry implements BaseColumns {
//table structure
        public static final String TABLE_NAME = "stock";

        public static final String _ID = BaseColumns._ID;
        public static final String COLUMN_NAME = "name";
        public static final String COLUMN_PRICE = "price";
        public static final String COLUMN_QUANTITY = "quantity";
        public static final String COLUMN_PROVIDER_NAME = "provider_name";
        public static final String COLUMN_PROVIDER_PHONE = "provider_phone";
        public static final String COLUMN_PROVIDER_EMAIL = "provider_email";
        public static final String COLUMN_IMAGE = "image";

        public static final String CREATE_TABLE_STOCK = "CREATE TABLE " +
                ProviderEntry.TABLE_NAME + "(" +
                ProviderEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                ProviderEntry.COLUMN_NAME + " TEXT NOT NULL," +
                ProviderEntry.COLUMN_PRICE + " TEXT NOT NULL," +
                ProviderEntry.COLUMN_QUANTITY + " INTEGER NOT NULL DEFAULT 0," +
                ProviderEntry.COLUMN_PROVIDER_NAME + " TEXT NOT NULL," +
                ProviderEntry.COLUMN_PROVIDER_PHONE + " TEXT NOT NULL," +
                ProviderEntry.COLUMN_PROVIDER_EMAIL + " TEXT NOT NULL," +
                ProviderEntry.COLUMN_IMAGE + " TEXT NOT NULL" + ");";
    }
}
