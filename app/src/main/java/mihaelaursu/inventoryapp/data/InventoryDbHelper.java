package mihaelaursu.inventoryapp.data;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by ursum on 22/07/2017.
 */

public class InventoryDbHelper extends SQLiteOpenHelper {

    public final static String DB_NAME = "inventoryapp.db";
    public final static int DB_VERSION = 1;
    public final static String LOG_TAG = InventoryDbHelper.class.getCanonicalName();

    public InventoryDbHelper(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(Contract.ProviderEntry.CREATE_TABLE_STOCK);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public void insertItem(Item item) {
        SQLiteDatabase db = this.getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contract.ProviderEntry.COLUMN_NAME, item.getProductName());
        values.put(Contract.ProviderEntry.COLUMN_PRICE, item.getPrice());
        values.put(Contract.ProviderEntry.COLUMN_QUANTITY, item.getQuantity());
        values.put(Contract.ProviderEntry.COLUMN_PROVIDER_NAME, item.getProviderName());
        values.put(Contract.ProviderEntry.COLUMN_PROVIDER_PHONE, item.getProviderPhone());
        values.put(Contract.ProviderEntry.COLUMN_PROVIDER_EMAIL, item.getProviderEmail());
        values.put(Contract.ProviderEntry.COLUMN_IMAGE, item.getImage());
        long id = db.insert(Contract.ProviderEntry.TABLE_NAME, null, values);
    }

    public Cursor readStock() {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Contract.ProviderEntry._ID,
                Contract.ProviderEntry.COLUMN_NAME,
                Contract.ProviderEntry.COLUMN_PRICE,
                Contract.ProviderEntry.COLUMN_QUANTITY,
                Contract.ProviderEntry.COLUMN_PROVIDER_NAME,
                Contract.ProviderEntry.COLUMN_PROVIDER_PHONE,
                Contract.ProviderEntry.COLUMN_PROVIDER_EMAIL,
                Contract.ProviderEntry.COLUMN_IMAGE
        };
        Cursor cursor = db.query(
                Contract.ProviderEntry.TABLE_NAME,
                projection,
                null,
                null,
                null,
                null,
                null
        );
        return cursor;
    }

    public Cursor readItem(long itemId) {
        SQLiteDatabase db = getReadableDatabase();
        String[] projection = {
                Contract.ProviderEntry._ID,
                Contract.ProviderEntry.COLUMN_NAME,
                Contract.ProviderEntry.COLUMN_PRICE,
                Contract.ProviderEntry.COLUMN_QUANTITY,
                Contract.ProviderEntry.COLUMN_PROVIDER_NAME,
                Contract.ProviderEntry.COLUMN_PROVIDER_PHONE,
                Contract.ProviderEntry.COLUMN_PROVIDER_EMAIL,
                Contract.ProviderEntry.COLUMN_IMAGE
        };
        String selection = Contract.ProviderEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(itemId) };

        Cursor cursor = db.query(
                Contract.ProviderEntry.TABLE_NAME,
                projection,
                selection,
                selectionArgs,
                null,
                null,
                null
        );
        return cursor;
    }

    public void updateItem(long currentItemId, int quantity) {
        SQLiteDatabase db = getWritableDatabase();
        ContentValues values = new ContentValues();
        values.put(Contract.ProviderEntry.COLUMN_QUANTITY, quantity);
        String selection = Contract.ProviderEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(currentItemId) };
        db.update(Contract.ProviderEntry.TABLE_NAME,
                values, selection, selectionArgs);
    }

    public void sellOneItem(long itemId, int quantity) {
        SQLiteDatabase db = getWritableDatabase();
        int newQuantity = 0;
        if (quantity > 0) {
            newQuantity = quantity -1;
        }
        ContentValues values = new ContentValues();
        values.put(Contract.ProviderEntry.COLUMN_QUANTITY, newQuantity);
        String selection = Contract.ProviderEntry._ID + "=?";
        String[] selectionArgs = new String[] { String.valueOf(itemId) };
        db.update(Contract.ProviderEntry.TABLE_NAME,
                values, selection, selectionArgs);
    }
}
