package com.example.everythingsa;

import android.content.Context;
import android.content.Intent;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;

public class EventAdapter extends RecyclerView.Adapter<EventAdapter.EventViewHolder>{
    ArrayList<Event> events;
    private FirebaseDatabase mFirebaseDatabase;
    private DatabaseReference mDatabaseReference;
    private ChildEventListener mChildListener;

    public EventAdapter() {
        FirebaseUtil.openFbReference("Events");
        mFirebaseDatabase = FirebaseUtil.mFirebaseDatabase;
        mDatabaseReference = FirebaseUtil.mDatabaseReference;
        events = FirebaseUtil.mEvents;
        mChildListener = new ChildEventListener() {
            @Override
            public void onChildAdded(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {
                Event td = dataSnapshot.getValue(Event.class);
                Log.d("Event: ", td.getTitle());
                td.setId(dataSnapshot.getKey());
                events.add(td);
                notifyItemInserted(events.size()-1);
            }

            @Override
            public void onChildChanged(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onChildRemoved(@NonNull DataSnapshot dataSnapshot) {

            }

            @Override
            public void onChildMoved(@NonNull DataSnapshot dataSnapshot, @Nullable String s) {

            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        };
        mDatabaseReference.addChildEventListener(mChildListener);
    }


    @NonNull
    @Override
    public EventViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.event_row, parent, false);
        return new EventViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull EventViewHolder holder, int position) {
        Event event = events.get(position);
        holder.bind(event);
    }

    @Override
    public int getItemCount() { return events.size(); }

    public class EventViewHolder extends RecyclerView.ViewHolder
        implements View.OnClickListener {
        TextView eventTitle;
//        TextView eventDescription;
//        TextView eventEntranceFee;

        public EventViewHolder(@NonNull View itemView) {
            super(itemView);
            eventTitle = (TextView) itemView.findViewById(R.id.eventTitle);
//            eventDescription = (TextView) itemView.findViewById(R.id.eventDescription);
//            eventEntranceFee = (TextView) itemView.findViewById(R.id.eventEntranceFee);
            itemView.setOnClickListener(this);
        }

        public void bind(Event event) {
            eventTitle.setText(event.getTitle());
//            eventDescription.setText(event.getDescription());
//            eventEntranceFee.setText(event.getPrice());
        }

        @Override
        public void onClick(View view) {
            int position = getAdapterPosition();
            Log.d("Click", String.valueOf(position));
//            Event selectedEvent = events.get(position);
//            Intent intent = new Intent(view.getContext(), Event.class);
//            intent.putExtra("Event", selectedEvent);
//            view.getContext().startActivity(intent);
        }
    }
}
