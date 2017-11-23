/**
 * IMPORTANT: Add your package below. Package name can be found in the project's AndroidManifest.xml file.
 * This is the package name our example uses:
 */
package com.example.android.justjava;


import android.content.Intent;
import android.icu.text.NumberFormat;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.StringDef;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {
    int quantity=2;
    boolean isWhippedCream = false;
    boolean isChocolate = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


    public void increase(View view) {

        quantity = quantity+ 1;
        if(quantity > 100) {
            Toast.makeText(getApplicationContext(),"Sorry we can't serve more than 100 Coffee at a time",Toast.LENGTH_SHORT).show();
            quantity--;
        }
        display(quantity);
    }

    public void decrease(View view) {
        quantity = quantity - 1;
        if(quantity<1) {
            Toast.makeText(getApplicationContext(),"Sorry, Please enter correct value",Toast.LENGTH_SHORT).show();
            quantity++;
        }
        display(quantity);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitOrder(View view) {
        int price = calculatePrice();
        displayMessage(createOrderSummary(price));
    }

    private String createOrderSummary (int price) {
        EditText nameText = (EditText) findViewById(R.id.name_edit_text);
        String str = "Name : " + nameText.getText() + "\nAdd Whipped Cream? " + isWhippedCream + "\nAdd Chocolate? " + isChocolate +"\nQuantity : " + quantity + "\nTotal : $" + (quantity*price) + "\nThank You!";
        return str;
    }

    private int calculatePrice() {
        int price = 5;
        CheckBox whippedCreamCheckBox = (CheckBox) findViewById(R.id.whipped_cream_checkBox);
        isWhippedCream = whippedCreamCheckBox.isChecked();
        CheckBox chocolateCheckBox = (CheckBox) findViewById(R.id.chocolate_checkBox);
        isChocolate = chocolateCheckBox.isChecked();
        if(isWhippedCream)
            price++;
        if(isChocolate)
            price+=2;
        return  price;
    }



    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Just java order Details");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }
}