package com.example.dustin0128.recycleviewtest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    private GeneralMeetingAdapter generalMeetingAdapter;
    private RecyclerView mRecyclerView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<String> listStr = new ArrayList<>();
        for (int i=0 ; i<10 ;i++){
            listStr.add(Integer.toString(i));
        }

        RecyclerView recyclerView = (RecyclerView) findViewById(R.id.recycle_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        GeneralMeetingAdapter generalMeetingAdapter = new GeneralMeetingAdapter(listStr);
        recyclerView.setAdapter(generalMeetingAdapter);

    }


}
