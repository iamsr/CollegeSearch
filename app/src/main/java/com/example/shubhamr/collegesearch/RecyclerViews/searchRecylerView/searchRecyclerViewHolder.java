package com.example.shubhamr.collegesearch.RecyclerViews.searchRecylerView;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.shubhamr.collegesearch.R;
import com.squareup.picasso.Picasso;

import org.w3c.dom.Text;

public class searchRecyclerViewHolder extends RecyclerView.ViewHolder {

    public ImageView siteImage;
    public TextView siteName;
    public TextView siteURL;

    public searchRecyclerViewHolder(View view){
        super(view);
        siteImage=(ImageView)view.findViewById(R.id.siteImage);
        siteName=(TextView)view.findViewById(R.id.siteName);
        siteURL =(TextView)view.findViewById(R.id.siteURL);

        view.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickListener.onClick(v,getAdapterPosition());
            }
        });
    }

    public void setSiteImage(String path){
        Picasso.get().load(path).into(siteImage);
    }

    public void setSiteName(String name){
        siteName.setText(name);
    }

    public void setSiteURL(String url){
        siteURL.setText(url);
    }

    //ONCLICK LISTENER INTERFACE AND VARIABLE SETUP
    private searchRecyclerViewHolder.ClickListener mClickListener;

    //Interface to send callbacks...
    public interface ClickListener{
        public void onClick(View view, int position);
        }

    public void setOnClickListener(searchRecyclerViewHolder.ClickListener clickListener){
        mClickListener = clickListener;
    }

}
