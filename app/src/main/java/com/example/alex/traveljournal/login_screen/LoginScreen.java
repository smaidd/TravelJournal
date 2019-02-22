package com.example.alex.traveljournal.login_screen;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.alex.traveljournal.Drawer;
import com.example.alex.traveljournal.R;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignIn;
import com.google.android.gms.auth.api.signin.GoogleSignInAccount;
import com.google.android.gms.auth.api.signin.GoogleSignInClient;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.auth.api.signin.GoogleSignInResult;
import com.google.android.gms.common.api.ApiException;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthCredential;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.GoogleAuthProvider;

public class LoginScreen extends AppCompatActivity {
    private static final int REQ_ACCES = 177;
    private EditText mEmail;
    private EditText mPass;
    private FirebaseAuth mFireAuth;
    private GoogleSignInClient mGoogleApiClient;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        initView();
        mFireAuth = FirebaseAuth.getInstance();


        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
                .requestIdToken(getString(R.string.default_web_client_id))
                .requestEmail()
                .build();

        mGoogleApiClient = GoogleSignIn.getClient(this, gso);


    }

    private void initView() {
        mEmail = findViewById(R.id.edittext_mail);
        mPass = findViewById(R.id.edittext_pass);
    }


    public void btnRegister(View view) {
        String email = mEmail.getText().toString();
        String password = mPass.getText().toString();
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill the text", Toast.LENGTH_SHORT).show();
        }
        if (password.length() < 6) {
            Toast.makeText(this, "Chose a stronger pass", Toast.LENGTH_SHORT).show();
        }
        mFireAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    loginSucces();
                }
            }
        });
    }

    public void btnLogin(final View view) {
        String email = mEmail.getText().toString();
        String password = mPass.getText().toString();
        if (!email.isEmpty() && !password.isEmpty()) {
            mFireAuth.signInWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        loginSucces();
                    } else {
                        Snackbar.make(view, getString(R.string.snack_eror), Snackbar.LENGTH_LONG).show();
                    }
                }
            });
        } else {
            Toast.makeText(this, "Please fill the fields", Toast.LENGTH_SHORT).show();
        }

    }


    //neimplemenat
    private void authWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mFireAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(getApplicationContext(), Drawer.class));
                    finish();
                } else {
                    Toast.makeText(getApplicationContext(), "Auth Error", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }

    private void loginSucces() {
        Intent intent = new Intent(getApplicationContext(), Drawer.class);
        startActivity(intent);
        finish();
    }

}
