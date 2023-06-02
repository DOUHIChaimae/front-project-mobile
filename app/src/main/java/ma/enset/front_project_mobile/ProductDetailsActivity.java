package ma.enset.front_project_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductDetailsActivity extends AppCompatActivity {
    private TextView quantityTextView;
    private int quantity = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_product_details);

        Button addToCartButton = findViewById(R.id.button_add_to_cart);
        ImageButton backButton = findViewById(R.id.backButton);
        Button plusButton = findViewById(R.id.button_plus);
        Button minusButton = findViewById(R.id.button_minus);
        quantityTextView = findViewById(R.id.text_quantity);

        addToCartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(v.getContext(), ShoppingCartActivity.class);
                v.getContext().startActivity(intent);
            }
        });

        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProductDetailsActivity.this, ProductListActivity.class);
                startActivity(intent);
            }
        });

        plusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                incrementQuantity();
            }
        });

        minusButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                decrementQuantity();
            }
        });
    }

    private void incrementQuantity() {
        quantity++;
        updateQuantityTextView();
    }

    private void decrementQuantity() {
        if (quantity > 1) {
            quantity--;
            updateQuantityTextView();
        }
    }

    private void updateQuantityTextView() {
        quantityTextView.setText("x" + quantity);
    }
}
