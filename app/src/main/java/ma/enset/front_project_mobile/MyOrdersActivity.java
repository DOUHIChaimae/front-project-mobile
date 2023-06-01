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
        List<ProductItem> productList1 = new ArrayList<>();
        productList1.add(new ProductItem("Product 1", "Product 1 description", 10.0, 2, R.drawable.img1));
        productList1.add(new ProductItem("Product 2", "Product 2 description", 15.0, 1, R.drawable.img2));
        orderItems.add(new OrderItem("1", "UNPAID", productList1 ));

        List<ProductItem> productList2 = new ArrayList<>();
        productList2.add(new ProductItem("Product 3", "Product 3 description", 20.0, 3, R.drawable.img3));
        orderItems.add(new OrderItem("2", "PAID", productList2));

        // Add more order items as needed

        // Set up the RecyclerView
        RecyclerView recyclerView = findViewById(R.id.orderlistrecycleview);
        OrderAdapter orderAdapter = new OrderAdapter(orderItems);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(orderAdapter);
    }

}
