package com.example.myapplication.Fregments;

import static com.google.firebase.auth.PhoneAuthProvider.getCredential;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.view.inputmethod.InputMethodManager;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import com.chaos.view.PinView;
import com.example.myapplication.Dashboard;
import com.example.myapplication.R;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthOptions;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.Objects;
import java.util.concurrent.TimeUnit;

public class otpsetter extends AppCompatActivity {
    PinView pinview;
    AppCompatButton opt_bt;
    String phoneAuth, otp_id;
    FirebaseAuth mAuth;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otpsetter);

        phoneAuth = getIntent().getStringExtra("mobile");

        pinview = findViewById(R.id.firstPinView);
        opt_bt = findViewById(R.id.verify_bt);
        mAuth = FirebaseAuth.getInstance();


        pinview.requestFocus();

        InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(INPUT_METHOD_SERVICE);
        inputMethodManager.toggleSoftInput(InputMethodManager.SHOW_FORCED, InputMethodManager.HIDE_IMPLICIT_ONLY);


        initiate_otp();

        opt_bt.setOnClickListener(v -> {
            if (Objects.requireNonNull(pinview.getText()).toString().isEmpty()) {
                Toast.makeText(otpsetter.this, "Blank Field can not be Process", Toast.LENGTH_SHORT).show();
            }
            else if (pinview.getText().toString().length() != 6) {
                Toast.makeText(otpsetter.this, "Invalid OTP ", Toast.LENGTH_SHORT).show();
            }
            else
            {
                PhoneAuthCredential credential = getCredential(otp_id, pinview.getText().toString());
                signInWithPhoneAuthCredential(credential);
            }
        });

    }

    private void initiate_otp() {


        PhoneAuthOptions.newBuilder(mAuth).setPhoneNumber(phoneAuth)       // Phone number to verify
                .setTimeout(60L, TimeUnit.SECONDS) // Timeout and unit
                .setActivity(this)                 // (optional) Activity for callback binding
                // If no activity is passed, reCAPTCHA verification can not be used.
                .setCallbacks(new PhoneAuthProvider.OnVerificationStateChangedCallbacks() {
                    @Override
                    public void onCodeSent(@NonNull String s, @NonNull PhoneAuthProvider.ForceResendingToken forceResendingToken) {
                        super.onCodeSent(s, forceResendingToken);
                        otp_id = s;
                    }

                    @Override
                    public void onVerificationCompleted(@NonNull PhoneAuthCredential phoneAuthCredential) {

                        signInWithPhoneAuthCredential(phoneAuthCredential);

                    }

                    @Override
                    public void onVerificationFailed(@NonNull FirebaseException e) {

                        Toast.makeText(getApplicationContext(), e.getMessage(), Toast.LENGTH_SHORT).show();

                    }
                })          // OnVerificationStateChangedCallbacks
                .build();

    }

    private void signInWithPhoneAuthCredential(PhoneAuthCredential credential) {
        mAuth.signInWithCredential(credential).addOnCompleteListener(this, task -> {
            if (task.isSuccessful()) {
                Intent intent = new Intent(otpsetter.this, Dashboard.class);
                startActivity(intent);
                finish();
            }
            else
            {
                Toast.makeText(otpsetter.this, "SignIn Code Error", Toast.LENGTH_SHORT).show();
            }
        });
    }
}