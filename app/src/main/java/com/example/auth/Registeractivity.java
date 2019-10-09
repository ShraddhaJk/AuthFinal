package com.example.auth;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;

public class Registeractivity extends AppCompatActivity {
    private EditText editText2;
    private EditText editText5;
    private EditText editText3;
    private EditText editText4;
    private Button button;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference evref = db.collection("Events");
    Register reg ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeractivity);
        editText2 = (EditText)findViewById(R.id.editText2);
        editText3 = (EditText)findViewById(R.id.editText3);
        editText4 = (EditText)findViewById(R.id.editText4);
        editText5 = (EditText)findViewById(R.id.editText5);
        button = (Button)findViewById(R.id.button);

        reg = new Register();
        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {

                Intent intent = getIntent();
                String id = intent.getStringExtra(Recycler.EXTRA_TEXT);
                reg.setName(editText2.getText().toString().trim());
                reg.setAge(editText3.getText().toString().trim());

                reg.setGender(editText4.getText().toString().trim());
                reg.setLocality(editText5.getText().toString().trim());

                evref.document(id).collection("registrations").add(reg);

            }
        });

    }
}
