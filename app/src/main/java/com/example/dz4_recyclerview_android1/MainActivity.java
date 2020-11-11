package com.example.dz4_recyclerview_android1;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private static final String MY_KEY = "key";
    private RecyclerView recyclerView;
    private EditText editText;
    private Button button;
    private My_Adapter my_adapter;
    private ArrayList<Model_RV> arrayList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();

    }

    private void init() {
        recyclerView = findViewById(R.id.recyclerView);
        editText = findViewById(R.id.etText);
        button = findViewById(R.id.btnButton);
        arrayList = new ArrayList<>();
        my_adapter = new My_Adapter(this, arrayList);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        recyclerView.setAdapter(my_adapter);
        buttonAdd();
    }

    private void buttonAdd() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                arrayList.add(new Model_RV(editText.getText().toString()));
                editText.setText("");
                my_adapter.notifyDataSetChanged();
            }
        });
    }

    @Override
    protected void onSaveInstanceState(@NonNull Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable(MY_KEY, arrayList);
    }

    @Override
    protected void onRestoreInstanceState(@NonNull Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);
        arrayList.addAll(savedInstanceState.getParcelableArrayList(MY_KEY));
    }
}