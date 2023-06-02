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

        productListRecyclerView = findViewById(R.id.productListRecyclerView);
        ImageButton backButton = findViewById(R.id.backButton);
        TextView orderStatusTextView = findViewById(R.id.orderStatusTextView);
        unpaidButtonsLayout = findViewById(R.id.unpaidButtonsLayout);
        Button cancelButton = findViewById(R.id.cancelButton);
        Button payNowButton = findViewById(R.id.payNowButton);
        totalValueTextView = findViewById(R.id.totalValueTextView);
        subtotalValueTextView=findViewById(R.id.subtotalValueTextView);

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(OrderDetailsActivity.this, MyOrdersActivity.class);
                startActivity(intent);
            }
        });

        String status = getOrderStatusFromIntent();

        orderStatusTextView.setText(status);

        if (status.equals("PAID") || status.equals("CANCELED")) {
            unpaidButtonsLayout.setVisibility(View.GONE);
        }

        List<ProductItem> productList = getProductListFromIntent();

        productOrderAdapter = new ProductOrderAdapter(productList);
        productListRecyclerView.setAdapter(productOrderAdapter);
        productListRecyclerView.setLayoutManager(new LinearLayoutManager(this));

        double totalPrice = getTotalPrice();
        totalValueTextView.setText(String.format("%.2f MAD", totalPrice));
        subtotalValueTextView.setText(String.format("%.2f MAD", totalPrice));

        cancelButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Perform cancel action here
                cancelOrder();
            }
        });

        payNowButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), PaymentActivity.class);
                v.getContext().startActivity(intent);
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
        String orderId = getIntent().getStringExtra("orderId");

        boolean isOrderCanceled = updateOrderStatus(orderId, "CANCELED");

        if (isOrderCanceled) {
            Toast.makeText(OrderDetailsActivity.this, "Order canceled.", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(OrderDetailsActivity.this, MyOrdersActivity.class);
            startActivity(intent);
            finish();
        } else {
            Toast.makeText(OrderDetailsActivity.this, "Failed to cancel the order.", Toast.LENGTH_SHORT).show();
        }
    }

    private boolean updateOrderStatus(String orderId, String status) {
        return true;
    }


}
