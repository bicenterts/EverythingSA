package com.example.everythingsa;

import android.content.Intent;
import android.os.Bundle;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.Toast;

public class Event extends AppCompatActivity {

    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    EditText eventTitle;
    EditText eventEntranceFee;
    EditText eventDescription;
    Event event;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        FirebaseUtil.openFbReference("Events");
        mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;
        mDatabaseReference = FirebaseUtil.mDatabaseReference;

        eventTitle = (EditText) findViewById(R.id.Events);
        eventDescription = (EditText) findViewById(R.id.eventDescription);
        eventEntranceFee = (EditText) findViewById(R.id.eventEntranceFee);

        Intent intent = getIntent();
        Event event = (Event) intent.getSerializableExtra("Event");
        if (event==null) {
            event = new Event();
        }
        this.event = event;

        eventTitle.setText(event.getTitle());
        eventDescription.setText(event.getDescription());
        eventEntranceFee.setText(event.getEntranceFee());

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
    }



    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.save_menu:
                saveEvent();
                Toast.makeText(this, "Event Saved", Toast.LENGTH_LONG).show();
                clean();
                return true;

            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void saveEvent() {
        event.setTitle(eventTitle.getText().toString());
        event.setDescription(eventDescription.getText().toString());
        event.setEntranceFee(eventEntranceFee.getText().toString());

        EventsClass event = new EventsClass(title, description, fee, "");
        mDatabaseReference.push().setValue(event);
    }

    public void clean() {
        eventTitle.setText("");
        eventTitle.requestFocus();
        eventDescription.setText("");
        eventEntranceFee.setText("");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.save_menu, menu);
        return true;
    }
}