package com.example.a15_recyclerview_foreground_and_background_cell_java;

import static androidx.recyclerview.widget.ItemTouchHelper.*;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.os.Bundle;

import com.example.a15_recyclerview_foreground_and_background_cell_java.adapter.CustomAdapter;
import com.example.a15_recyclerview_foreground_and_background_cell_java.helper.RecyclerItemTouchHelper;
import com.example.a15_recyclerview_foreground_and_background_cell_java.model.Member;
import com.google.android.material.shape.MarkerEdgeTreatment;

import org.chromium.base.Callback;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

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
        recyclerView = findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new GridLayoutManager(context,1));
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.addItemDecoration(new DividerItemDecoration(this,DividerItemDecoration.VERTICAL));

        SimpleCallback itemTouchHelperCallBack = new RecyclerItemTouchHelper(0, LEFT, new RecyclerItemTouchHelper.RecyclerItemTouchHelperListener() {
            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction, int position) {

            }
        });
        new ItemTouchHelper(itemTouchHelperCallBack).attachToRecyclerView(recyclerView);

    }

    private void refreshAdapter(List<Member> members) {
        CustomAdapter adapter = new CustomAdapter(context,members);
        recyclerView.setAdapter(adapter);
    }

    private List<Member> prepareMemberList() {
        List<Member> members = new ArrayList<>();
        for(int i = 0 ; i<15; i++){
            members.add(new Member("Sarvarbek"+i,"Khalmatov"+i));
        }
        return members;
    }
}
