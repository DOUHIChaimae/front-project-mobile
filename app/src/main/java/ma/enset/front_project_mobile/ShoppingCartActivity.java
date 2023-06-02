package ma.enset.front_project_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.List;

public class ShoppingCartActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductShoppingAdapter productShoppingAdapter;
    private List<ProductItem> productList;
    private Button payNowButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shopping_cart);

        // Initialize product list
        productList = generateProductList();

        // Initialize RecyclerView
        recyclerView = findViewById(R.id.productListRecyclerViewShopping);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        productShoppingAdapter = new ProductShoppingAdapter(productList);
        recyclerView.setAdapter(productShoppingAdapter);

        // Pay Now Button
        payNowButton = findViewById(R.id.payNowButton);
        payNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PaymentActivity.class);
                v.getContext().startActivity(intent);
            }
        });
        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ShoppingCartActivity.this, ProductListActivity.class);
                startActivity(intent);
            }
        });

    }

    // Method to generate sample product list
    private List<ProductItem> generateProductList() {
        List<ProductItem> productList = new ArrayList<>();
        productList.add(new ProductItem("LG Gram 17", 10000.00, 3, R.drawable.img4));
        productList.add(new ProductItem("Gaming Laptops｜ROG", 9000.00, 2, R.drawable.img14));
        productList.add(new ProductItem("OG Zephyrus G14", 14000.00, 1, R.drawable.img13));
        return productList;
    }
}