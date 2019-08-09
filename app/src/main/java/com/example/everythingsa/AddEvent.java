package com.example.everythingsa;

import android.os.Bundle;

import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class AddEvent extends AppCompatActivity implements View.OnClickListener {
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private Button button;

    EditText eventTitle;
    EditText eventDescription;
    EditText eventEntranceFee;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_event);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        button = findViewById(R.id.btnSaveEvent);
        button.setOnClickListener(this);

        Database.openDbReference("Events");
        mFirebaseDatabase = Database.mFirebaseDatabase;
        mDatabaseReference = Database.mDatabaseReference;
        eventTitle = (EditText) findViewById(R.id.eventTitle);
        eventDescription = (EditText) findViewById(R.id.eventDescription);
        eventEntranceFee = (EditText) findViewById(R.id.eventEntranceFee);
    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btnSaveEvent:
                saveEvent();
                Toast.makeText(this, "Event saved", Toast.LENGTH_LONG).show();
                clean();

        }
    }

    private void saveEvent() {
        String title = eventTitle.getText().toString();
        String descriptiom = eventDescription.getText().toString();
        String fee = eventEntranceFee.getText().toString();
        Event event = new Event(title, descriptiom, fee, "");
        mDatabaseReference.push().setValue(event);
    }

    private void clean() {
        eventTitle.setText("");
        eventDescription.setText("");
        eventEntranceFee.setText("");
        eventTitle.requestFocus();
    }
}
