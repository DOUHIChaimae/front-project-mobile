package ma.enset.front_project_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;

public class ProductListActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        ImageView panierLogo;
        ImageView profileLogo;
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productlist);
        panierLogo = findViewById(R.id.panierLogoProduct);
        profileLogo = findViewById(R.id.userProfile);
        panierLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToShoppingCart(view);
            }
        });
        profileLogo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToProfile(view);
            }
        });
    }

    public void goToShoppingCart(View view) {
        Intent intent = new Intent(this, ShoppingCartActivity.class);
        startActivity(intent);
    }

    public void goToProfile(View view) {
        Intent intent = new Intent(this, ProfileActivity.class);
        startActivity(intent);
    }
}
