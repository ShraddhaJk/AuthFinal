package com.example.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.firebase.client.Firebase;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class SignUp extends AppCompatActivity implements View.OnClickListener {
    EditText editTextEmail,edittextPassword;
    private FirebaseAuth mAuth;
    private Firebase mref;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sign_up);
        editTextEmail =(EditText)findViewById(R.id.SignEmail);
        edittextPassword =(EditText)findViewById(R.id.SignPassword);
        mAuth = FirebaseAuth.getInstance();
        findViewById(R.id.SignUp).setOnClickListener(this);
        Firebase.setAndroidContext(this);
        mref = new Firebase("https://sdl4-6fa58.firebaseio.com");

    }
     private void registerUser()
     {
         String email = editTextEmail.getText().toString();
         String password = edittextPassword.getText().toString();
         if(email.isEmpty())
         {
               editTextEmail.setError("Email is mandatory");
               editTextEmail.requestFocus();
               return;
         }
         if(!Patterns.EMAIL_ADDRESS.matcher(email).matches())
         {
             editTextEmail.setError("Email is not valid");
             editTextEmail.requestFocus();
             return;
         }
         if(password.isEmpty())
         {
             edittextPassword.setError("Password is mandatory");
             edittextPassword.requestFocus();
             return;
         }
         if(password.length() <6)
         {
             edittextPassword.setError("Password is too short");
             edittextPassword.requestFocus();
             return;
         }
         mAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
             @Override
             public void onComplete(@NonNull Task<AuthResult> task) {
                 if(task.isSuccessful())
                 {
                     Toast.makeText(getApplicationContext(),"User Registered Successfully",Toast.LENGTH_SHORT).show();
                 }

             }
         });

     }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.SignUp:
                registerUser();
          break;
            case R.id.Login:
                startActivity(new Intent(this,MainActivity.class));
        }

    }
}
