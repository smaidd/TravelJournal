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
import com.google.android.gms.tasks.OnFailureListener;
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
    private GoogleSignInOptions mSignInOpt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login_screen);
        initView();


//        GoogleSignInOptions gso = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
//                .requestIdToken(getString(R.string.default_web_client_id))
//                .requestEmail()
//                .build();

//        mGoogleApiClient = GoogleSignIn.getClient(this, gso);

        mFireAuth = FirebaseAuth.getInstance();


    }

    @Override
    protected void onStart() {
        super.onStart();
        GoogleSignInAccount acc = GoogleSignIn.getLastSignedInAccount(this);
        if (acc != null) {

        }
    }

    private void initView() {
        mEmail = findViewById(R.id.edittext_mail);
        mPass = findViewById(R.id.edittext_pass);
    }


    public void btnRegister(final View view) {
        String email = mEmail.getText().toString();
        String password = mPass.getText().toString();
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill the text", Toast.LENGTH_SHORT).show();
<<<<<<< HEAD
        } else {
            mFireAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
                @Override
                public void onComplete(@NonNull Task<AuthResult> task) {
                    if (task.isSuccessful()) {
                        loginSucces();
                    }

        }
        if (password.length() < 6) {
            Toast.makeText(this, "Chose a stronger pass", Toast.LENGTH_SHORT).show();
        }
        mFireAuth.createUserWithEmailAndPassword(email, password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {

                    loginSucces();
                } else {
                    Snackbar.make(view, getString(R.string.error_snak), Snackbar.LENGTH_LONG).show();

                }
            });

        }
    }

    public void btnLogin(final View view) {
        String email = mEmail.getText().toString();
        String password = mPass.getText().toString();
        if (email.isEmpty() || password.isEmpty()) {
            Toast.makeText(this, "Please fill the fields", Toast.LENGTH_SHORT).show();
        } else {
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

        }
    }

    private void authWithGoogle(GoogleSignInAccount account) {
        AuthCredential credential = GoogleAuthProvider.getCredential(account.getIdToken(), null);
        mFireAuth.signInWithCredential(credential).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if (task.isSuccessful()) {
                    startActivity(new Intent(LoginScreen.this, Drawer.class));

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

    //inca nu functioneaza
    public void btnGoogleSignIn(View view) {
        signIn();
    }

    private void signIn() {
        Intent signInIntent = mGoogleApiClient.getSignInIntent();
        startActivityForResult(signInIntent, REQ_ACCES);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == REQ_ACCES) {
            Task<GoogleSignInAccount> task = GoogleSignIn.getSignedInAccountFromIntent(data);
            handleSignInResult(task);

        }
    }

    private void handleSignInResult(Task<GoogleSignInAccount> completedTask) {
        try {
            GoogleSignInAccount account = completedTask.getResult(ApiException.class);
            authWithGoogle(account);
        } catch (ApiException e) {
            e.printStackTrace();
        }
    }
}
