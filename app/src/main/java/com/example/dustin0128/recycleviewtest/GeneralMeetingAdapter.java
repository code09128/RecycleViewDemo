package com.example.dustin0128.recycleviewtest;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

/**
 * Created by dustin0128 on 2018/2/2.
 */

public class GeneralMeetingAdapter extends RecyclerView.Adapter<GeneralMeetingAdapter.ViewHolder>{

    private List<String> mdata;

    //建構子 用來接收外部資料
    public GeneralMeetingAdapter(List<String> data) {
        mdata = data;
    }

    //ViewHolder是把項目中所有view物件都包起來
    public class ViewHolder extends RecyclerView.ViewHolder{
        public TextView mtvdate,mtvmessage;
        public ViewHolder(View itemView) {
            super(itemView);
            mtvdate = (TextView)itemView.findViewById(R.id.general_date);
            mtvmessage = (TextView)itemView.findViewById(R.id.general_news_info);
        }
    }

    //RecyclerView會呼叫這個方法,我們必須建立好項目的ViewHolder物件,然後傳給RecyclerView
    @Override
    public GeneralMeetingAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_annual_general_meeting_view,parent,false);

        ViewHolder viewHolder = new ViewHolder(v);
        return viewHolder;
    }

    //RecyclerView會呼叫這個方法 我們必須把項目資料填入ViewHolder物件
    @Override
    public void onBindViewHolder(GeneralMeetingAdapter.ViewHolder holder,final int position) {

        holder.mtvdate.setText(mdata.get(position));
        holder.mtvmessage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(view.getContext(),"Item"+position+"is clicked",
                        Toast.LENGTH_SHORT).show();
            }
        });
        holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
            @Override
            public boolean onLongClick(View view) {
                Toast.makeText(view.getContext(),"Item"+position+"is long clicked",
                        Toast.LENGTH_SHORT).show();
                return true;
            }
        });

    }


    //RecyclerView會呼叫這個方法 我們要回傳的總共有幾項
    @Override
    public int getItemCount() {
        return mdata.size();
    }


}
