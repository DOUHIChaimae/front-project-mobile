package ma.enset.front_project_mobile;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class EditProfileActivity extends AppCompatActivity {
    private EditText nameEditText;
    private EditText emailEditText;
    private EditText bioEditText;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_profile);

        nameEditText = findViewById(R.id.nameEditText);
        emailEditText = findViewById(R.id.emailEditText);
        bioEditText = findViewById(R.id.bioEditText);
        saveButton = findViewById(R.id.saveButton);
        ImageButton backButton = findViewById(R.id.backButton);

        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                saveProfile();
            }
        });
        backButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(EditProfileActivity.this, ProfileActivity.class);
                startActivity(intent);
            }
        });
    }

    private void saveProfile() {
        String name = nameEditText.getText().toString();
        String email = emailEditText.getText().toString();
        String bio = bioEditText.getText().toString();

        // TODO: Save the profile information

        // Example: Display a toast message
        Toast.makeText(this, "Profile saved successfully", Toast.LENGTH_SHORT).show();
    }
}

