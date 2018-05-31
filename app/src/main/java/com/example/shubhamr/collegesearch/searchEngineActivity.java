package com.example.shubhamr.collegesearch;

import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

import com.example.shubhamr.collegesearch.RecyclerViews.searchRecylerView.searchModelClass;
import com.example.shubhamr.collegesearch.RecyclerViews.searchRecylerView.searchRecyclerViewHolder;
import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.firebase.ui.database.FirebaseRecyclerOptions;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.Query;
import com.google.firebase.database.ValueEventListener;

public class searchEngineActivity extends AppCompatActivity {

    public String stateSelected;
    public String courseSelected;
    public RecyclerView searchRecyclerView;
    public WebView webView;
    public FirebaseRecyclerAdapter adapter;
    public DatabaseReference databaseReference;
    String queryState, queryCourse;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_engine);
        Bundle bundle = getIntent().getExtras();
        stateSelected = bundle.getString("stateSelected");
        courseSelected = bundle.getString("courseSelected");
        Log.e("arguments",stateSelected+courseSelected );
        makeQuery(stateSelected, courseSelected);
        searchRecyclerView = (RecyclerView) findViewById(R.id.searchRecyclerView);
        webView = (WebView) findViewById(R.id.webView);
        searchRecyclerView.setLayoutManager(new LinearLayoutManager(this, LinearLayoutManager.HORIZONTAL, false));
        setAdapter();
        searchRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.HORIZONTAL));
    }

    public void makeQuery(String q, String c) {
        queryState = q.replaceAll(" ", "-");
        queryState = queryState.toLowerCase();
        queryCourse = c.toLowerCase();

    }


    public void setAdapter() {
        Query query = FirebaseDatabase.getInstance().getReference().child("searchengines");
        FirebaseRecyclerOptions<searchModelClass> options = new FirebaseRecyclerOptions.Builder<searchModelClass>().setQuery(query, searchModelClass.class).build();
        adapter = new FirebaseRecyclerAdapter<searchModelClass, searchRecyclerViewHolder>(options) {

            @Override
            protected void onBindViewHolder(@NonNull searchRecyclerViewHolder holder, final int position, @NonNull searchModelClass model) {
                holder.setSiteImage(model.getImage());
                holder.setSiteName(model.getName());
                holder.setSiteURL(model.getUrl());
            }

            @NonNull
            @Override
            public searchRecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
                View view = LayoutInflater.from(parent.getContext())
                        .inflate(R.layout.search_recycler_view, parent, false);

                final searchRecyclerViewHolder viewHolder = new searchRecyclerViewHolder(view);
                viewHolder.setOnClickListener(new searchRecyclerViewHolder.ClickListener() {
                    @Override
                    public void onClick(View view, int position) {
                        databaseReference = adapter.getRef(position);
                        databaseReference = databaseReference.child(queryCourse);
                        databaseReference.addListenerForSingleValueEvent(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                String queryURL = dataSnapshot.getValue(String.class);
                                queryURL = queryURL.replaceAll("state", queryState);
                                webView.loadUrl(queryURL);

                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {

                            }
                        });
                    }
                });
                return viewHolder;
            }
        };
        searchRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onStart() {
        super.onStart();
       adapter.startListening();
    } //UPDATING RECYCLER VIEW REGULARLY FROM THE START OF FRAGMENT

}

