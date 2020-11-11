package com.example.dz4_recyclerview_android1;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class My_Adapter extends RecyclerView.Adapter <My_Adapter.MyViewHolder> {
    Context context;
    List<Model_RV> list;

    public My_Adapter(Context context, List<Model_RV> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public My_Adapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.activity_recycler, parent, false);
        return new MyViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull My_Adapter.MyViewHolder holder, int position) {
        Model_RV model_rv = list.get(position);
        holder.textView.setText(model_rv.getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        private TextView textView;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);
            textView = itemView.findViewById(R.id.textViewName);
        }
    }
}
