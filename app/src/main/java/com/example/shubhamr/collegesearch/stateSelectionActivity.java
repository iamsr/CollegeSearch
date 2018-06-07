package com.example.shubhamr.collegesearch;

import android.content.Intent;
import android.os.Build;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.example.shubhamr.collegesearch.RecyclerViews.clickListener;
import com.example.shubhamr.collegesearch.RecyclerViews.stateRecyclerView.stateModelClass;
import com.example.shubhamr.collegesearch.RecyclerViews.stateRecyclerView.stateRecyclerViewHolder;

import java.util.ArrayList;
import java.util.List;

public class stateSelectionActivity extends AppCompatActivity implements clickListener {

   public RecyclerView stateRecyclerView;  //recycler view having state names
   public List<stateModelClass> stateList = new ArrayList<>();
   public stateRecyclerViewHolder adapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_state_selection);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        stateRecyclerView = (RecyclerView)findViewById(R.id.stateListRecyclerView);
       prepareStateList();
        adapter = new stateRecyclerViewHolder(stateList);
        stateRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        stateRecyclerView.setAdapter(adapter);
        adapter.setClickListeners(this);
        stateRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }


    @Override
    public void itemClicked(View v, int position){
        stateModelClass state = stateList.get(position); //getting selected state object
        String stateSelected = state.getStateName();
        Intent intent = new Intent(stateSelectionActivity.this,courseSelectionActivity.class);
        intent.putExtra("stateSelected",stateSelected); //selected state is put on extra
        startActivity(intent); //course activity called with arguments
    } //called when state is selected from the list.


    public void prepareStateList(){
        stateModelClass state = new stateModelClass("Andhra Pradesh");
        stateList.add(state);
        state = new stateModelClass("Arunachal Pradesh");
        stateList.add(state);
        state = new stateModelClass("Assam");
        stateList.add(state);
        state = new stateModelClass("Bihar");
        stateList.add(state);
        state = new stateModelClass("Chhattisgarh");
        stateList.add(state);
        state = new stateModelClass("Himanchal Pradesh");
        stateList.add(state);
        state = new stateModelClass("Jammu and Kashmir");
        stateList.add(state);
        state = new stateModelClass("Madhya Pradesh");
        stateList.add(state);
        state = new stateModelClass("Maharashtra");
        stateList.add(state);
        state = new stateModelClass("Manipur");
        stateList.add(state);
        state = new stateModelClass("Meghalaya");
        stateList.add(state);
        state = new stateModelClass("Mizoram");
        stateList.add(state);
        state = new stateModelClass("Nagaland");
        stateList.add(state);
        state = new stateModelClass("Sikkim");
        stateList.add(state);
        state = new stateModelClass("Tamil Nadu");
        stateList.add(state);
        state = new stateModelClass("Tripura");
        stateList.add(state);
        state = new stateModelClass("Goa");
        stateList.add(state);
        state = new stateModelClass("Gujarat");
        stateList.add(state);
        state = new stateModelClass("Haryana");
        stateList.add(state);
        state = new stateModelClass("Jharkhand");
        stateList.add(state);
        state = new stateModelClass("Karnataka");
        stateList.add(state);
        state = new stateModelClass("Kerala");
        stateList.add(state);
        state = new stateModelClass("Odisha");
        stateList.add(state);
        state = new stateModelClass("Rajasthan");
        stateList.add(state);
        state = new stateModelClass("Telagana");
        stateList.add(state);
        state = new stateModelClass("Uttarakhand");
        stateList.add(state);
        state = new stateModelClass("Uttar Pradesh");
        stateList.add(state);
        state = new stateModelClass("West Bengal");
        stateList.add(state);
    } //Preparing data for states

}
