package com.example.baseclassforactivityadapter_11_injava.activity.adapter;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.baseclassforactivityadapter_11_injava.R;
import com.example.baseclassforactivityadapter_11_injava.activity.activity.MainActivity;
import com.example.baseclassforactivityadapter_11_injava.activity.model.Member;

import java.util.List;

public class MainAdapter extends BaseAdapter{

    private MainActivity activity;
    private List<Member> members;

    public MainAdapter(MainActivity activity,List<Member> members) {
        this.activity = activity;
        this.members = members;
    }

    @Override
    public int getItemCount() {
        return members.size();
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_custom_layout,viewGroup,false);
        return new CustomViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {

        Member member = members.get(position);

        if (holder instanceof CustomViewHolder) {
            LinearLayout lay_click = ((CustomViewHolder)holder).lay_click;
            TextView first_name = ((CustomViewHolder) holder).first_name;
            TextView last_name = ((CustomViewHolder) holder).last_name;

            first_name.setText(member.getFirstName());
            last_name.setText(member.getLastName());

            lay_click.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    activity.openItemDetails(member);
                }
            });
        }
    }

    public class CustomViewHolder extends RecyclerView.ViewHolder{
        public View view;
        private LinearLayout lay_click;
        public TextView first_name,last_name;

        public CustomViewHolder(View itemView) {
            super(itemView);
            view = itemView;
            lay_click = view.findViewById(R.id.lay_click);
            first_name = view.findViewById(R.id.first_name);
            last_name = view.findViewById(R.id.last_name);
        }
    }
}
