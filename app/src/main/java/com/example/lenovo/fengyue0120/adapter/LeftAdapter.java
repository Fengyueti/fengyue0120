package com.example.lenovo.fengyue0120.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.fengyue0120.R;
import com.example.lenovo.fengyue0120.bean.LeftBean;

import java.util.ArrayList;
import java.util.List;

public class LeftAdapter extends RecyclerView.Adapter<LeftAdapter.VH> {
    private Context context;
    private List<LeftBean.Data> list;

    public LeftAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<LeftBean.Data> list) {
        if(list!=null){
            this.list = list;
        }
     notifyDataSetChanged();
    }

    @NonNull
    @Override
    public LeftAdapter.VH onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(context).inflate(R.layout.leftitem, viewGroup, false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LeftAdapter.VH vh, int i) {
        vh.name.setText(list.get(i).getName());
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VH extends RecyclerView.ViewHolder {
        private TextView name;
        public VH(@NonNull View itemView) {
            super(itemView);
            name=itemView.findViewById(R.id.left_name);
        }
    }
}
