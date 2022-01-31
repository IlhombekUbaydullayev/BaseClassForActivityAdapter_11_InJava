package com.example.baseclassforactivityadapter_11_injava.activity.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.example.baseclassforactivityadapter_11_injava.R;
import com.example.baseclassforactivityadapter_11_injava.activity.model.Member;
import com.example.baseclassforactivityadapter_11_injava.activity.network.BaseServer;

import java.util.ArrayList;
import java.util.List;

public class BaseActivity extends AppCompatActivity implements BaseServer {


    protected String getServer(){
        if(IS_TESTER) {
            return SERVER_DEVELOPMENT;
        }
        return  SERVER_DEPLOYMENT;
    }

    protected List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();
        for (int i = 0; i < 30; i++){
            members.add(new Member("Ilhombek" + i, "Ubaydullayev" + i));
        }
        return members;
    }

    protected static boolean isEmpty(final String s) {
        return  s == null || s.trim().isEmpty();
    }
}