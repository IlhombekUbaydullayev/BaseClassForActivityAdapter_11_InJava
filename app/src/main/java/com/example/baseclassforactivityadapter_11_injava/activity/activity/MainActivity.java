package com.example.baseclassforactivityadapter_11_injava.activity.activity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.example.baseclassforactivityadapter_11_injava.R;
import com.example.baseclassforactivityadapter_11_injava.activity.adapter.MainAdapter;
import com.example.baseclassforactivityadapter_11_injava.activity.model.Member;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends BaseActivity {

    private Context context;
    private RecyclerView recyclerView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initViews();

        List<Member> members = prepareMemberList();
        refreshAdapter(members);
    }
    private void initViews() {
        context = this;
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
    }

    private void refreshAdapter(List<Member> members) {
        MainAdapter adapter = new MainAdapter(this,members);
        recyclerView.setAdapter(adapter);
    }

    public void openItemDetails(Member member) {
        Intent intent = new Intent(context,DetailsActivity.class);
        startActivity(intent);
    }
}