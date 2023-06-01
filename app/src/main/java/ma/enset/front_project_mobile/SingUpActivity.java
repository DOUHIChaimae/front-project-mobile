package ma.enset.front_project_mobile;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import ma.enset.front_project_mobile.R;

public class SingUpActivity extends AppCompatActivity {

    private Button registerButton;
    private TextView loginTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        registerButton = findViewById(R.id.button_register);
        loginTextView = findViewById(R.id.textView6);

        registerButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Afficher une alerte de succès d'opération
                showAlert("Success", "Registration successful!");

                // Rediriger vers la page de login après 3 secondes
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(SingUpActivity.this, SingInActivity.class);
                        startActivity(intent);
                    }
                }, 3000); // 3000 millisecondes = 3 secondes
            }
        });

        loginTextView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Rediriger vers la page de login
                Intent intent = new Intent(SingUpActivity.this, SingInActivity.class);
                startActivity(intent);
            }
        });
    }

    private void showAlert(String title, String message) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle(title)
                .setMessage(message)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    public void onClick(DialogInterface dialog, int id) {
                        // Code exécuté lorsque l'utilisateur clique sur OK
                        dialog.dismiss();
                    }
                });
        AlertDialog dialog = builder.create();
        dialog.show();

        // Fermer l'alerte après 3 secondes
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                if (dialog != null && dialog.isShowing()) {
                    dialog.dismiss();
                }
            }
        }, 3000); // 3000 millisecondes = 3 secondes
    }
}
