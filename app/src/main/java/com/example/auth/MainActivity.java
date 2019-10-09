package com.example.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    EditText editTextEmail,edittextPassword;
    FirebaseAuth mAuth;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextEmail = (EditText)findViewById(R.id.MainEmail);
        edittextPassword= (EditText)findViewById(R.id.MainPassword);
        mAuth =FirebaseAuth.getInstance();
        findViewById(R.id.MainRegister).setOnClickListener(this);
        findViewById(R.id.MainLogin).setOnClickListener(this);

    }
    private void UserLogin()
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


        mAuth.signInWithEmailAndPassword(email,password).addOnCompleteListener(new OnCompleteListener<AuthResult>() {
            @Override
            public void onComplete(@NonNull Task<AuthResult> task) {
                if(task.isSuccessful())
                {
                    Toast.makeText(getApplicationContext(),"hi",Toast.LENGTH_SHORT).show();
                   Intent intent = new Intent(MainActivity.this,AccountActivity.class);
                    Toast.makeText(getApplicationContext(),"hey",Toast.LENGTH_SHORT).show();
                   intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                    Toast.makeText(getApplicationContext(),"hey2",Toast.LENGTH_SHORT).show();
                   startActivity(intent);

                }
                else
                {
                    Toast.makeText(getApplicationContext(),"Login is Unsuccessful",Toast.LENGTH_SHORT).show();
                }
            }
        });







    }

    public void onClick(View view)
    {
         switch (view.getId())
         {
             case R.id.MainRegister :
                 startActivity(new Intent(this,SignUp.class));
                 break;
             case R.id.MainLogin:
                 UserLogin();

         }
    }

}
