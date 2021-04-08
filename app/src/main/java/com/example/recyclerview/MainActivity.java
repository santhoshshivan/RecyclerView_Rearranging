package com.example.recyclerview;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recyclerview.adapter.ListAdapter;
import com.example.recyclerview.model.List1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    RecyclerView recyclerView;
    List<List1> list;
    LinearLayoutManager linearLayoutManager;
    ListAdapter listAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initData();
        initRecyclerView();
    }


    private void initData() {
        list = new ArrayList<>();
        list.add(new List1(R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,"1","2"));
        list.add(new List1(R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_background,"3","4"));
        list.add(new List1(R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,"5","6"));
       list.add(new List1(R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,"7","8"));
        list.add(new List1(R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_background,"9","10"));
        list.add(new List1(R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,"11","12"));
        list.add(new List1(R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_background,"13","14"));
        list.add(new List1(R.drawable.ic_launcher_background,R.drawable.ic_launcher_foreground,"15","16"));
        list.add(new List1(R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_background,"17","18"));
        list.add(new List1(R.drawable.ic_launcher_foreground,R.drawable.ic_launcher_background,"19","20"));



    }

    private void initRecyclerView() {
        recyclerView = findViewById(R.id.recyclerview);
        listAdapter = new ListAdapter(list, this);
        linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.VERTICAL);
        recyclerView.setLayoutManager(linearLayoutManager);
        recyclerView.setAdapter(listAdapter);

        DividerItemDecoration dividerItemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        recyclerView.addItemDecoration(dividerItemDecoration);
        ItemTouchHelper itemTouchHelper = new ItemTouchHelper(simpleCallback);
        itemTouchHelper.attachToRecyclerView(recyclerView);
    }

        ItemTouchHelper.SimpleCallback simpleCallback = new ItemTouchHelper.SimpleCallback(ItemTouchHelper.UP|ItemTouchHelper.DOWN|
                ItemTouchHelper.LEFT|ItemTouchHelper.RIGHT| ItemTouchHelper.START|ItemTouchHelper.END,9) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                int fromPosition = viewHolder.getLayoutPosition();
                int toPosition = target.getLayoutPosition();
                Collections.swap(list,fromPosition,toPosition);
                recyclerView.getAdapter().notifyItemMoved(fromPosition,toPosition);
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {

            }
        };

}