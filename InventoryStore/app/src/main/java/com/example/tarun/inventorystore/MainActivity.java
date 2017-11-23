package com.example.tarun.inventorystore;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AbsListView;
import android.widget.ListView;
import android.support.design.widget.FloatingActionButton;

import com.example.tarun.inventorystore.Data.InventoryDbHelper;
import com.example.tarun.inventorystore.Data.StockItem;

public class MainActivity extends AppCompatActivity {

    private final static String LOG_TAG = MainActivity.class.getCanonicalName();
    InventoryDbHelper dbHelper;
    StockCursorAdapter adapter;
    int lastVisibleItem = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        final FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, DetailsActivity.class);
                startActivity(intent);
            }
        });

        dbHelper = new InventoryDbHelper(this);

        final ListView listView = (ListView) findViewById(R.id.list_view);
        View emptyView = findViewById(R.id.empty_view);
        listView.setEmptyView(emptyView);

        Cursor cursor = dbHelper.readStock();

        adapter = new StockCursorAdapter(this, cursor);
        listView.setAdapter(adapter);
        listView.setOnScrollListener(new AbsListView.OnScrollListener() {
            @Override
            public void onScrollStateChanged(AbsListView view, int scrollState) {
                if(scrollState == 0) return;
                final int currentFirstVisibleItem = view.getFirstVisiblePosition();
                if (currentFirstVisibleItem > lastVisibleItem) {
                    fab.show();
                } else if (currentFirstVisibleItem < lastVisibleItem) {
                    fab.hide();
                }
                lastVisibleItem = currentFirstVisibleItem;
            }

            @Override
            public void onScroll(AbsListView view, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        adapter.swapCursor(dbHelper.readStock());
    }

    public void clickOnViewItem(long id) {
        Intent intent = new Intent(this, DetailsActivity.class);
        intent.putExtra("itemId", id);
        startActivity(intent);
    }

    public void clickOnSale(long id, int quantity) {
        dbHelper.sellOneItem(id, quantity);
        adapter.swapCursor(dbHelper.readStock());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.action_add_dummy_data:
                // add dummy data for testing
                addDummyData();
                adapter.swapCursor(dbHelper.readStock());
        }
        return super.onOptionsItemSelected(item);
    }

    /**
     * Add data for demo purposes
     */
    private void addDummyData() {
        StockItem gummibears = new StockItem(
                "Gummibears",
                "10 Rs",
                45,
                "Tarun Bhardwaj",
                "+91 0000 000 0000",
                "tarun@sweet.com",
                "android.resource://com.example.tarun.inventorystore/drawable/gummibear");
        dbHelper.insertItem(gummibears);

        StockItem peaches = new StockItem(
                "Peaches",
                "10 RS",
                24,
                "Tarun Bhardwaj",
                "+91 0000 000 0000",
                "tarun@sweet.com",
                "android.resource://com.example.tarun.inventorystore/drawable/peach");
        dbHelper.insertItem(peaches);

        StockItem cherries = new StockItem(
                "Cherries",
                "11 Rs",
                74,
                "Tarun Bhardwaj",
                "+91 0000 000 0000",
                "tarun@sweet.com",
                "android.resource://com.example.tarun.inventorystore/drawable/cherry");
        dbHelper.insertItem(cherries);

        StockItem cola = new StockItem(
                "Cola",
                "13 Rs",
                44,
                "Tarun Bhardwaj",
                "+91 0000 000 0000",
                "tarun@sweet.com",
                "android.resource://com.example.tarun.inventorystore/drawable/cola");
        dbHelper.insertItem(cola);

        StockItem fruitSalad = new StockItem(
                "Fruit salad",
                "20 Rs",
                34,
                "Tarun Bhardwaj",
                "+91 0000 000 0000",
                "tarun@sweet.com",
                "android.resource://com.example.tarun.inventorystore/drawable/fruit_salad");
        dbHelper.insertItem(fruitSalad);

        StockItem smurfs = new StockItem(
                "Smurfs",
                "12 Rs",
                26,
                "Tarun Bhardwaj",
                "+91 0000 000 0000",
                "tarun@sweet.com",
                "android.resource://com.example.tarun.inventorystore/drawable/smurfs");
        dbHelper.insertItem(smurfs);

        StockItem hotChillies = new StockItem(
                "Hot chillies",
                "13 Rs",
                12,
                "Fiesta S.A.",
                "+34 000 000 0000",
                "fiesta@dulce.com",
                "android.resource://com.example.tarun.inventorystore/drawable/hot_chillies");
        dbHelper.insertItem(hotChillies);

        StockItem lolipopStrawberry = new StockItem(
                "Lolipop strawberry",
                "12 Rs",
                62,
                "Fiesta S.A.",
                "+34 000 000 0000",
                "fiesta@dulce.com",
                "android.resource://com.example.tarun.inventorystore/drawable/lolipop");
        dbHelper.insertItem(lolipopStrawberry);

        StockItem heartGummy = new StockItem(
                "Heart gummy jellies",
                "13 Rs",
                22,
                "Fiesta S.A.",
                "+34 000 000 0000",
                "fiesta@dulce.com",
                "android.resource://com.example.tarun.inventorystore/drawable/heart_gummy");
        dbHelper.insertItem(heartGummy);
    }
}
