package com.example.auth;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import androidx.appcompat.app.AppCompatActivity;

import com.firebase.client.DataSnapshot;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;
import com.firebase.client.ValueEventListener;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentReference;
import com.google.firebase.firestore.FirebaseFirestore;


public class Postactivity extends AppCompatActivity {
    private Button button;
    private EditText editText2;
    private Firebase mref;
    private EditText loc;
    private EditText desc;
    private EditText name;
    private EditText email;
    long maxid = 0;
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    //db.collection("events").document("first event ");
    private DocumentReference noteref = db.document("Events/first event");
    private CollectionReference evref = db.collection("Events");

    DatabaseReference ref;

    //  DateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
    //Date dateobject;
    // DatabaseReference ref;
    Event event;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_postactivity);
        //Firebase("https://auth-6b3a3.firebaseio.com/");

        Firebase.setAndroidContext(this);
        //mref = new Firebase("https://auth-6b3a3.firebaseio.com/");
        button = (Button) findViewById(R.id.button2);
        desc = (EditText)findViewById(R.id.desc);
       // editText3 = (EditText)findViewById(R.id.);
        email = (EditText)findViewById(R.id.email);
        loc = (EditText)findViewById(R.id.location);
        name = (EditText)findViewById(R.id.name);
        event = new Event();
        // mref = FirebaseDatabase.getInstance().getReference().child("Event");
       // mref.child("Event");



        button.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                //int volunteers = Integer.parseInt(editText3.getText().toString().trim());
                event.setName(name.getText().toString().trim());
                event.setDesc(desc.getText().toString().trim());
                //event.setVolunteers(volunteers);
                event.setEmail(email.getText().toString().trim());
                event.setLocation(loc.getText().toString().trim());
                //event.setAdinfo(editText5.getText().toString().trim());
evref.add(event);
                //mref.child(String.valueOf(maxid+1)).setValue(event);
                // mref.push().setValue(event);
                //   Firebase mrefchild = mref.child("Name");
                // mrefchild.setValue("tanisha");
            }
        });
    }

}
