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
import com.example.shubhamr.collegesearch.RecyclerViews.courseRecyclerView.courseModelClass;
import com.example.shubhamr.collegesearch.RecyclerViews.courseRecyclerView.courseRecyclerViewAdapter;

import java.util.ArrayList;
import java.util.List;

public class courseSelectionActivity extends AppCompatActivity implements clickListener {

    public RecyclerView courseRecyclerView;
    public List<courseModelClass> courseList = new ArrayList<>();
    public courseRecyclerViewAdapter adapter;
    public String stateName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_course_selection);

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
            Window window = getWindow();
            window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
            window.setStatusBarColor(getResources().getColor(R.color.colorPrimaryDark));
        }
        Intent i = getIntent(); //getting intent which started this activity
        stateName = i.getStringExtra("stateSelected"); //state selected in previous activity
        courseRecyclerView = (RecyclerView)findViewById(R.id.courseRecyclerView);
        prepareCourseData();
        adapter = new courseRecyclerViewAdapter(courseList);
        courseRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        courseRecyclerView.setAdapter(adapter);
        adapter.setClickListeners(this);
        courseRecyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

    }

    public void prepareCourseData(){
        courseModelClass course = new courseModelClass("ba","Bachelor Of Arts");
        courseList.add(course);
        course = new courseModelClass("bca","Bachelor Of Computer Application");
        courseList.add(course);
        course = new courseModelClass("bams","Bachelor Of Ayurvedic Medicine and Surgery");
        courseList.add(course);
        course = new courseModelClass("bba","Bachelor Of Buisness Administration");
        courseList.add(course);
        course = new courseModelClass("bed","Bachelor Of Education");
        courseList.add(course);
        course = new courseModelClass("btech","Bachelor Of Technology");
        courseList.add(course);
        course = new courseModelClass("bfa","Bachelor Of Fine Arts");
        courseList.add(course);
        course = new courseModelClass("llb","Bachelor Of Laws");
        courseList.add(course);
        course = new courseModelClass("bmc","Bachelor Of Mass Communication");
        courseList.add(course);
        course = new courseModelClass("bsc","Bachelor Of Science");
        courseList.add(course);
        course = new courseModelClass("bcom","Bachelor Of Commerce");
        courseList.add(course);
        course = new courseModelClass("bhms","Bachelor Of Homeopathic Medicine And Surgery");
        courseList.add(course);
        course = new courseModelClass("bpt","Bachelor Of Physiotherapy");
        courseList.add(course);

    } //Preparing data for courses

    @Override
    public void itemClicked(View view, int position){
        courseModelClass course = courseList.get(position);
        String courseName = course.getCourseShortName();
        Intent intent = new Intent(courseSelectionActivity.this,searchEngineActivity.class);
        Bundle bundle = new Bundle();
        bundle.putString("stateSelected",stateName); //sending state selected to search activity
        bundle.putString("courseSelected",courseName); //sending course selected to search activity
        intent.putExtras(bundle);
        startActivity(intent);
    }



}
