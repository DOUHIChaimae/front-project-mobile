package ma.enset.front_project_mobile;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import ma.enset.front_project_mobile.EditProfileActivity;
import ma.enset.front_project_mobile.R;

public class ProfileActivity extends AppCompatActivity {
    private static final int EDIT_PROFILE_REQUEST_CODE = 1;

    private TextView nameText;
    private TextView emailText;
    private TextView bioText;
    private Button editButton;

    private Button orderButton;

    private Button logout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);

        nameText = findViewById(R.id.nameText);
        emailText = findViewById(R.id.emailtext);
        bioText = findViewById(R.id.bioText);
        editButton = findViewById(R.id.editProfileButton);
        orderButton = findViewById(R.id.MyOrdersButton);
        logout = findViewById(R.id.logoutButton);
        ImageButton backButton = findViewById(R.id.backButton);

        editButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openEditProfileActivity();
            }
        });
        orderButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                goToOrderList();
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

    private void openEditProfileActivity() {
        Intent intent = new Intent(ProfileActivity.this, EditProfileActivity.class);
        startActivityForResult(intent, EDIT_PROFILE_REQUEST_CODE);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == EDIT_PROFILE_REQUEST_CODE && resultCode == RESULT_OK && data != null) {
            String name = data.getStringExtra("name");
            String email = data.getStringExtra("email");
            String bio = data.getStringExtra("bio");

            // Update the profile information in ProfileActivity
            updateProfile(name, email, bio);
        }
    }


    private void goToOrderList() {
        Intent intent = new Intent(this, MyOrdersActivity.class);
        startActivity(intent);
    }
    private void updateProfile(String name, String email, String bio) {
        nameText.setText(name);
        emailText.setText(email);
        bioText.setText(bio);
    }
}
