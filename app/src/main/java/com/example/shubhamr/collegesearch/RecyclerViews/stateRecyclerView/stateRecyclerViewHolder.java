package com.example.shubhamr.collegesearch.RecyclerViews.stateRecyclerView;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.shubhamr.collegesearch.R;
import com.example.shubhamr.collegesearch.RecyclerViews.clickListener;

import java.util.List;

public class stateRecyclerViewHolder extends RecyclerView.Adapter<stateRecyclerViewHolder.stateViewHolder> {

    private List<stateModelClass> stateList;
    private clickListener clickListeners = null;

    public class stateViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        public TextView stateName;

        public stateViewHolder(View view) {
            super(view);
            view.setOnClickListener(this);
            stateName = (TextView)view.findViewById(R.id.stateName);
        }
        @Override
        public void onClick(View view){
            if(clickListeners!=null){
                clickListeners.itemClicked(view,getAdapterPosition());
            }
        }
    }

    public stateRecyclerViewHolder(List<stateModelClass> stateList){
        this.stateList = stateList;
    }

    public void setClickListeners(clickListener clickListeners){
        this.clickListeners = clickListeners;
    }

    @Override
    @NonNull
    public stateViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.state_recycler_view, parent, false);

        return new stateViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull stateViewHolder holder, int position) {
          stateModelClass state = stateList.get(position);
          holder.stateName.setText(state.getStateName());
    }

    @Override
    public int getItemCount() {
        return stateList.size();
    }


    }
