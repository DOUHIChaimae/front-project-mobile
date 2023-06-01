package ma.enset.front_project_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class OrderDetailsActivity extends AppCompatActivity {

    private RecyclerView productListRecyclerView;
    private ProductOrderAdapter productOrderAdapter;
    private LinearLayout unpaidButtonsLayout;
    private TextView totalValueTextView;
    private TextView subtotalValueTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_order_details);

        // Find the views
        productListRecyclerView = findViewById(R.id.productListRecyclerView);
        ImageButton backButton = findViewById(R.id.backButton);
        TextView orderStatusTextView = findViewById(R.id.orderStatusTextView);
        unpaidButtonsLayout = findViewById(R.id.unpaidButtonsLayout);
        Button cancelButton = findViewById(R.id.cancelButton);
        Button payNowButton = findViewById(R.id.payNowButton);
        totalValueTextView = findViewById(R.id.totalValueTextView);
        subtotalValueTextView=findViewById(R.id.subtotalValueTextView);

        // Set click listener for the back button
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderDetailsActivity.this, MyOrdersActivity.class);
                startActivity(intent);
            }
        });

        // Get the order status from the intent
        String status = getOrderStatusFromIntent();

        // Set the order status text
        orderStatusTextView.setText(status);

        // Hide the unpaid buttons if the order is PAID or CANCEL
        if (status.equals("PAID") || status.equals("CANCEL")) {
            unpaidButtonsLayout.setVisibility(View.GONE);
        }

        // Get the product list from the intent
        List<ProductItem> productList = getProductListFromIntent();

        // Create and set up the product adapter
        productOrderAdapter = new ProductOrderAdapter(productList);
        productListRecyclerView.setAdapter(productOrderAdapter);
        productListRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Calculate and display the total price
        double totalPrice = getTotalPrice();
        totalValueTextView.setText(String.format("%.2f MAD", totalPrice));
        subtotalValueTextView.setText(String.format("%.2f MAD", totalPrice));

        // Set click listener for the cancel button
        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform cancel action here
                cancelOrder();
            }
        });


        // Set click listener for the pay now button
        payNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform pay now action here
            }
        });
    }

    private String getOrderStatusFromIntent() {
        Intent intent = getIntent();
        String status = "";

        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey("status")) {
                status = extras.getString("status");
            }
        }

        return status;
    }

    private List<ProductItem> getProductListFromIntent() {
        Intent intent = getIntent();
        List<ProductItem> productList = new ArrayList<>();

        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey("productList")) {
                productList = (List<ProductItem>) extras.getSerializable("productList");
            }
        }

        return productList;
    }

    private double getTotalPrice() {
        Intent intent = getIntent();
        double totalPrice= 0.0;

        if (intent != null) {
            Bundle extras = intent.getExtras();
            if (extras != null && extras.containsKey("totalPrice")) {
                totalPrice = extras.getDouble("totalPrice");
            }
        }

        return totalPrice;
    }
    private void cancelOrder() {
        // Retrieve the orderId from the intent
        String orderId = getIntent().getStringExtra("orderId");

        // Perform the update operation to change the order status to "CANCELED"
        // In this example, we assume there is a method in your data source or backend to update the order status
        boolean isOrderCanceled = updateOrderStatus(orderId, "CANCELED");

        if (isOrderCanceled) {
            // Display a success message or perform any other necessary actions
            Toast.makeText(OrderDetailsActivity.this, "Order canceled.", Toast.LENGTH_SHORT).show();

            // Redirect to MyOrdersActivity or perform any other necessary navigation
            Intent intent = new Intent(OrderDetailsActivity.this, MyOrdersActivity.class);
            startActivity(intent);
            finish(); // Optional: Finish the current activity to prevent going back to it using the back button
        } else {
            // Display an error message or perform any other necessary actions
            Toast.makeText(OrderDetailsActivity.this, "Failed to cancel the order.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean updateOrderStatus(String orderId, String status) {
        // This is a mock implementation of updating the order status
        // Replace this with your actual implementation that communicates with your backend or data source

        // Simulate a successful update by returning true
        return true;
    }


}
