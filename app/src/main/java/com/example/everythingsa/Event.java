package com.example.everythingsa;

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

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_event);

        FirebaseUtil.openFbReference("Events");
        mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;
        mDatabaseReference = FirebaseUtil.mDatabaseReference;

        eventTitle = (EditText) findViewById(R.id.Events);
        eventEntranceFee = (EditText) findViewById(R.id.eventEntranceFee);
        eventDescription = (EditText) findViewById(R.id.eventDescription);

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
        String title = eventTitle.getText().toString();
        String description = eventDescription.getText().toString();
        String price = eventEntranceFee.getText().toString();
        EventsClass event = new EventsClass(title, description, price, "");
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