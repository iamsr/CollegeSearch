package com.example.shubhamr.collegesearch.RecyclerViews.courseRecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shubhamr.collegesearch.R;
import com.example.shubhamr.collegesearch.RecyclerViews.clickListener;

import java.util.List;

import java.util.List;

public class courseRecyclerViewAdapter extends RecyclerView.Adapter<courseRecyclerViewAdapter.courseViewHolder> {

    private List<courseModelClass> courseList;
    private clickListener clickListeners = null;

    public class courseViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView courseName;

        public courseViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            courseName = (TextView)view.findViewById(R.id.courseName); //DEBUG
        }
        @Override
        public void onClick(View view){
            if(clickListeners!=null){
                clickListeners.itemClicked(view,getAdapterPosition());
            }
        }
    }

    public courseRecyclerViewAdapter(List<courseModelClass> courseList){
        this.courseList = courseList;
    }

    public void setClickListeners(clickListener clickListeners){
        this.clickListeners = clickListeners;
    }

    @Override
    @NonNull
    public courseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.course_recycler_view, parent, false);

        return new courseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull courseViewHolder holder, int position) {
        courseModelClass course = courseList.get(position);
        holder.courseName.setText(course.getCourseName());
    }

    @Override
    public int getItemCount() {
        return courseList.size();
    }


}
