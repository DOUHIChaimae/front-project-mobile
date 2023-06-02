package ma.enset.front_project_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;

import androidx.appcompat.app.AppCompatActivity;

public class ProfileActivity extends AppCompatActivity {
    private Button orderButton;
    private Button editButton;
    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        orderButton = findViewById(R.id.MyOrdersButton);
        editButton = findViewById(R.id.editProfileButton);
        logout = findViewById(R.id.logoutButton);
        ImageButton backButton = findViewById(R.id.backButton);
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToOrderList();
            }
        });
        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToEditProfile();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, ProductListActivity.class);
                startActivity(intent);
            }
        });
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ProfileActivity.this, SingInActivity.class);
                startActivity(intent);
            }
        });

    }

    private void goToOrderList() {
        Intent intent = new Intent(this, MyOrdersActivity.class);
        startActivity(intent);
    }
    private void goToEditProfile() {
        Intent intent = new Intent(this, EditProfileActivity.class);
        startActivity(intent);
    }
}