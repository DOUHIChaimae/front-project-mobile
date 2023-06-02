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
        productList.add(new ProductItem("LG Gram 17"," Despite its large screen, it remains exceptionally light, making it ideal for those who prioritize portability.  " , 10000, 0, R.drawable.img4));
        productList.add(new ProductItem("Gaming Laptops｜ROG"," It features a high-refresh-rate display, a powerful AMD Ryzen processor. " , 9000, 0, R.drawable.img14));
        productList.add(new ProductItem("OG Zephyrus G14","known for its robust build quality and exceptional keyboard.", 14000, 0, R.drawable.img13));
        productList.add(new ProductItem("N1707VNB5620EMEA01 Vostro"," Despite its large screen, it remains exceptionally light, making it ideal for those who prioritize portability.  " , 8900, 0, R.drawable.img1));
        productList.add(new ProductItem("Notebook 15.6 Laptop", "It offers a stunning 4K display, powerful processors, and a built-in stylus for creative tasks.", 8000 , 0, R.drawable.img2));
        productList.add(new ProductItem("ROG Strix G17 (2022)", "It offers a vibrant touchscreen display, long battery life, and a comfortable keyboard.", 15000, 0, R.drawable.img3));
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

