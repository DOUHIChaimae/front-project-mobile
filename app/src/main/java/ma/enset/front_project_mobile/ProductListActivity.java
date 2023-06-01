package ma.enset.front_project_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class ProductListActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private ProductAdapter productAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productlist);

        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        List<ProductItem> productList = getProductList();
        productAdapter = new ProductAdapter(productList);
        recyclerView.setAdapter(productAdapter);

        ImageView panierLogo = findViewById(R.id.panierLogoProduct);
        ImageView profileLogo = findViewById(R.id.userProfile);

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

    private List<ProductItem> getProductList() {
        List<ProductItem> productList = new ArrayList<>();
        // Add your product items here
        productList.add(new ProductItem("Notebook 15.6 Laptop", "GeForce MX110 Dedicated Card English Win 10 Laptop", 10.99 , 0, R.drawable.img2));
        productList.add(new ProductItem("ROG Strix G17 (2022)", "- Republic of Gamers｜ROG Global", 10.99, 0, R.drawable.img3));
        productList.add(new ProductItem("Gaming Laptops｜ROG", getString(R.string.subtext), 10.99, 0, R.drawable.img2));
        productList.add(new ProductItem("Gaming Laptops｜ROG", getString(R.string.subtext), 10.99, 0, R.drawable.img3));
        return productList;
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

