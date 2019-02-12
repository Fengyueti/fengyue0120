package com.example.lenovo.fengyue0120.fragment;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.lenovo.fengyue0120.R;
import com.example.lenovo.fengyue0120.adapter.LeftAdapter;

import com.example.lenovo.fengyue0120.adapter.RightAdapter;
import com.example.lenovo.fengyue0120.api.UserApi;
import com.example.lenovo.fengyue0120.bean.LeftBean;
import com.example.lenovo.fengyue0120.bean.RightBean;
import com.example.lenovo.fengyue0120.contract.Contract;
import com.example.lenovo.fengyue0120.presenter.CPresenter;
import com.google.gson.Gson;

import java.util.HashMap;
import java.util.List;

public class FragmentOne extends Fragment implements Contract.CView {

    private RecyclerView leftrv;
    private RecyclerView rightrv;
    private LeftAdapter leftAdapter;
    private RightAdapter rightAdapter;
    private CPresenter presenter;
    private int cid;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragmentone, container, false);
        leftrv =view.findViewById(R.id.leftrv);
        rightrv =view.findViewById(R.id.rightrv);
        leftrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        rightrv.setLayoutManager(new LinearLayoutManager(getActivity()));
        leftAdapter = new LeftAdapter(getActivity());
        rightAdapter = new RightAdapter(getActivity());
        HashMap<String,String> params=new HashMap<>();
        params.put("cid",cid+"");
        presenter = new CPresenter(this);
        presenter.show(UserApi.LEFT_API,null);
        presenter.showright(UserApi.RIGHT_API,null);
        leftrv.setAdapter(leftAdapter);
        rightrv.setAdapter(rightAdapter);
        return view;
    }

    @Override
    public void onsuccess(String result) {
        final LeftBean leftBean = new Gson().fromJson(result, LeftBean.class);
        final List<LeftBean.Data> data = leftBean.getData();
        leftAdapter.setList(data);
    }

    @Override
    public void onsuccessright(String result) {
     final RightBean rightBean = new Gson().fromJson(result, RightBean.class);
        final List<RightBean.Data> data1 = rightBean.getData();
        rightAdapter.setList(data1);
    }

    @Override
    public void onfailure(String msg) {

    }
}
