package com.example.lenovo.fengyue0120.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.lenovo.fengyue0120.R;
import com.example.lenovo.fengyue0120.bean.RightBean;

import java.util.ArrayList;
import java.util.List;

public class RightAdapter extends RecyclerView.Adapter<RightAdapter.VV> {
    private Context context;
    private List<RightBean.Data> list;

    public RightAdapter(Context context) {
        this.context = context;
        list=new ArrayList<>();
    }

    public void setList(List<RightBean.Data> list) {
        if(list!=null) {
            this.list = list;
        }
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public RightAdapter.VV onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(context).inflate(R.layout.rightitem, viewGroup, false);
        return new VV(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RightAdapter.VV vv, int i) {
        vv.iname.setText(list.get(i).getName());
        vv.irv.setLayoutManager(new GridLayoutManager(context,3,GridLayoutManager.HORIZONTAL,false));
        vv.irv.setAdapter(new RightitemOne(context,list.get(i).list));
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class VV extends RecyclerView.ViewHolder {
        private TextView iname;
        private RecyclerView irv;
        public VV(@NonNull View itemView) {
            super(itemView);
            iname=itemView.findViewById(R.id.rightitem_name);
            irv=itemView.findViewById(R.id.rightitem_rv);
        }
    }
}
