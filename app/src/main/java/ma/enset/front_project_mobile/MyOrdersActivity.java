package ma.enset.front_project_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MyOrdersActivity extends AppCompatActivity {

    private List<OrderItem> orderItems;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_orders);

        ImageButton backButton = findViewById(R.id.backButton);
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MyOrdersActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });

        // Prepare sample order items (replace with your actual data retrieval logic)
        orderItems = new ArrayList<>();
        List<ProductItem> productList = new ArrayList<>();
        productList.add(new ProductItem("LG Gram 17","it remains exceptionally light, making it ideal for those who prioritize portability.", 10000.00, 3, R.drawable.img4));
        productList.add(new ProductItem("Gaming Laptops｜ROG","It features a high-refresh-rate display, a powerful AMD Ryzen processor.", 9000.00, 2, R.drawable.img14));
        productList.add(new ProductItem("OG Zephyrus G14","known for its robust build quality and exceptional keyboard.", 14000.00, 1, R.drawable.img13));
        orderItems.add(new OrderItem("1", "UNPAID", productList ));

        List<ProductItem> productList2 = new ArrayList<>();
        productList2.add(new ProductItem("Product 3", "Product 3 description", 20.0, 3, R.drawable.img3));
        orderItems.add(new OrderItem("2", "PAID", productList2));
        List<ProductItem> productList3 = new ArrayList<>();
        productList3.add(new ProductItem("Product 4", "Product 4 description", 40.0, 3, R.drawable.img3));
        orderItems.add(new OrderItem("2", "CANCELED", productList2));

        // Add more order items as needed

        // Set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.orderlistrecycleview);
        OrderAdapter orderAdapter = new OrderAdapter(orderItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(orderAdapter);
    }

}
