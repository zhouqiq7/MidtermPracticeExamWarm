package com.qizhou.midtermpracticeexamwarm;

import android.os.Bundle;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.qizhou.midtermpracticeexamwarm.entities.Item;
import com.qizhou.midtermpracticeexamwarm.entities.ShoppingCar;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 * reference: https://velmurugan-murugesan.medium.com/edittext-in-listview-android-example-41064bae2841
 */
public class MainActivity extends AppCompatActivity {

    private List<ShoppingCar> shoppingCars;

    public void onCreate(Bundle b){
        super.onCreate(b);
        setContentView(R.layout.activity_main);

        shoppingCars = initShoppingCar();
        ListView listView = (ListView) findViewById(R.id.listview);
        listView.setItemsCanFocus(true);

        ListviewAdapter adapter = new ListviewAdapter(this, shoppingCars);
        listView.setAdapter(adapter);
        setTotalAmount(null);
    }

    private List<ShoppingCar> initShoppingCar() {
        List<ShoppingCar> shoppingCars = new ArrayList<>();
        shoppingCars.add(new ShoppingCar(new Item("Milk", 3.0)));
        shoppingCars.add(new ShoppingCar(new Item("Eggs", 2.0)));
        shoppingCars.add(new ShoppingCar(new Item("Beef", 23.0)));
        shoppingCars.add(new ShoppingCar(new Item("Soda", 1.0)));
        shoppingCars.add(new ShoppingCar(new Item("Biscuits", 2.5)));
        shoppingCars.add(new ShoppingCar(new Item("Fruit", 6.5)));
        shoppingCars.add(new ShoppingCar(new Item("Veges", 4.0)));
        return shoppingCars;
    }

    public void onSubmit(View view) {
        double totalAmount = 0.0;
        for (ShoppingCar s : shoppingCars) {
            if (s.getAdded() && Objects.nonNull(s.getQuantity())) {
                totalAmount += s.getQuantity() * s.getItem().getUnitPrice();
            }
        }
        setTotalAmount(totalAmount);
    }

    private void setTotalAmount(Double totalAmount) {
        TextView total = findViewById(R.id.total_amount);
        total.setText(String.format(getResources().getString(R.string.total_amount), totalAmount != null ? String.valueOf(totalAmount) : ""));
    }
}