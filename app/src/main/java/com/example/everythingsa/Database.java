package com.example.everythingsa;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class Database {
    public static FirebaseDatabase mFirebaseDatabase;
    public static DatabaseReference mDatabaseReference;
    private static Database database;
    public static ArrayList<Event> esaEvents;

    private Database() {}

    public static void openDbReference(String ref) {
        if(database==null) {
            database = new Database();
            mFirebaseDatabase = FirebaseDatabase.getInstance();
            esaEvents = new ArrayList<Event>();
        }
        mDatabaseReference = mFirebaseDatabase.getReference().child(ref);
    }
}
