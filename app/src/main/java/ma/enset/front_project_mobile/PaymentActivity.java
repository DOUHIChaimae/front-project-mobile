package ma.enset.front_project_mobile;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;

import androidx.appcompat.app.AppCompatActivity;

public class PaymentActivity extends AppCompatActivity {
    private LinearLayout creditCardLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_payement);

        creditCardLayout = findViewById(R.id.creditCardLayout);

        RadioGroup radioGroupPaymentOptions = findViewById(R.id.radioGroupPaymentOptions);
        radioGroupPaymentOptions.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                if (checkedId == R.id.radioButtonPayPal) {
                    // PayPal selected, hide credit card fields
                    creditCardLayout.setVisibility(View.GONE);
                } else if (checkedId == R.id.radioButtonCreditCard) {
                    // Credit Card selected, show credit card fields
                    creditCardLayout.setVisibility(View.VISIBLE);
                }
            }
        });

        Button validationButton = findViewById(R.id.validationButton);
        validationButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Check which payment option is selected
                int selectedId = radioGroupPaymentOptions.getCheckedRadioButtonId();
                if (selectedId == R.id.radioButtonPayPal) {
                    // Open PayPal website
                    Uri paypalUri = Uri.parse("https://www.paypal.com");
                    Intent paypalIntent = new Intent(Intent.ACTION_VIEW, paypalUri);
                    startActivity(paypalIntent);
                } else if (selectedId == R.id.radioButtonCreditCard) {
                    // Show credit card fields
                    creditCardLayout.setVisibility(View.VISIBLE);
                }
            }
        });
    }
}
