package com.example.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class AccountActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_account);
        findViewById(R.id.Post).setOnClickListener(this);
        findViewById(R.id.Events).setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.Post:
                Toast.makeText(getApplicationContext(),"Onto ",Toast.LENGTH_SHORT).show();

                Intent intent = new Intent(AccountActivity.this,Postactivity.class);
                intent.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
                Toast.makeText(getApplicationContext(),"Onto POSTING events",Toast.LENGTH_SHORT).show();
                startActivity(intent);

                break;
            case R.id.Events:
                startActivity(new Intent(this,Recycler.class));
        }
    }
}
