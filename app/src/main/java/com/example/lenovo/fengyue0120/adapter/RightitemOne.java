package com.example.lenovo.fengyue0120.adapter;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.lenovo.fengyue0120.R;
import com.example.lenovo.fengyue0120.bean.RightBean;

import java.util.List;

public class RightitemOne extends RecyclerView.Adapter<RightitemOne.MM> {
    private Context context;
    private List<RightBean.Data.LL> list;

    public RightitemOne(Context context, List<RightBean.Data.LL> list) {
        this.context = context;
        this.list = list;
    }

    @NonNull
    @Override
    public RightitemOne.MM onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        final View view = LayoutInflater.from(context).inflate(R.layout.rightitemone, viewGroup, false);
        return new MM(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RightitemOne.MM mm, int i) {
        mm.name.setText(list.get(i).getName());
        Glide.with(context).load(list.get(i).getIcon()).into(mm.img);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class MM extends RecyclerView.ViewHolder {
        private ImageView img;
        private TextView name;
        public MM(@NonNull View itemView) {
            super(itemView);
            img=itemView.findViewById(R.id.item_img);
            name=itemView.findViewById(R.id.item_name);
        }
    }
}
