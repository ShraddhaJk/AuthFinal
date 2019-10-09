package com.example.auth;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.view.View;
import com.firebase.ui.firestore.FirestoreRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.Query;


import android.os.Bundle;
import android.widget.Toast;

import java.util.*;

public class Recycler extends AppCompatActivity {
    private FirebaseFirestore db = FirebaseFirestore.getInstance();
    private CollectionReference notebookRef = db.collection("Events");
    private MyAdapter adapter;
public static final String EXTRA_TEXT = " com.example.auth.EXTRA_TEXT";
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler);
        setUpRecyclerView();
        adapter.setOnItemClickListener(new MyAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(DocumentSnapshot documentSnapshot, int position) {
                Profile prof = documentSnapshot.toObject(Profile.class);
                String id =documentSnapshot.getId();
                Toast.makeText(Recycler.this,"Position" + position + "ID:" + id,Toast.LENGTH_SHORT).show();
               Intent intent = new Intent(Recycler.this,Registeractivity.class);
               intent.putExtra(EXTRA_TEXT,id);
               startActivity(intent);


            }
        });
    }
    private void setUpRecyclerView(){
        Query query = notebookRef.orderBy("name", Query.Direction.DESCENDING);
        FirestoreRecyclerOptions<Profile> options = new FirestoreRecyclerOptions.Builder<Profile>()
                .setQuery(query, Profile.class)
                .build();
        adapter = new MyAdapter(options);

        RecyclerView recyclerView = findViewById(R.id.myRecycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(adapter);


    }
    @Override
    protected void onStart() {
        super.onStart();
        adapter.startListening();
    }

    @Override
    protected void onStop() {
        super.onStop();
        adapter.stopListening();
    }

}