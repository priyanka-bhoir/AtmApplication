package com.priyanka.atmapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import java.util.ArrayList;

class AdapterMoney extends BaseAdapter {

    ArrayList<model> modelArrayList;
    Context context;

    public AdapterMoney(ArrayList<model> list, Context context) {
        this.modelArrayList = list;
        this.context = context;

    }


    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = LayoutInflater.from(context).inflate(R.layout.sub_layout, viewGroup, false);
        }
        TextView total = view.findViewById(R.id.totalamt);
        TextView _100rsnote = view.findViewById(R.id._100rsnote);
        TextView _200rsnote = view.findViewById(R.id._200rsnote);
        TextView _500rsnote = view.findViewById(R.id._500rsnote);
        TextView _2000rsnote = view.findViewById(R.id._2000rsnote);
        total.setText(modelArrayList.get(i).total);
        _100rsnote.setText(modelArrayList.get(i)._100rs);
        _200rsnote.setText(modelArrayList.get(i)._200rs);
        _500rsnote.setText(modelArrayList.get(i)._500rs);
        _2000rsnote.setText(modelArrayList.get(i)._2000rs);
        return view;
    }

    @Override
    public int getCount() {
        return modelArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }
}
