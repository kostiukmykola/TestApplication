package com.example.android.testapplication;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class ItemArrayAdapter extends ArrayAdapter<String[]> {

    private List<String[]> scoreList = new ArrayList<String[]>();

    static class ItemViewHolder{
        TextView colOpen;
        TextView colHigh;
        TextView colLow;
        TextView colClose;
    }

    public ItemArrayAdapter(Context context, int resourse){
        super(context, resourse);
    }

    public void add(String[] object){
        scoreList.add(object);
        super.add(object);
    }

    @Override
    public int getCount(){
        return this.scoreList.size();
    }

    @Override
    public String[] getItem(int position){
        return this.scoreList.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent){
        View row = convertView;
        ItemViewHolder viewHolder;
        if (row == null){
            LayoutInflater inflater = (LayoutInflater) this.getContext().getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            row = inflater.inflate(R.layout.list_item, parent, false);
            viewHolder = new ItemViewHolder();
            viewHolder.colOpen = (TextView) row.findViewById(R.id.colOpen);
            viewHolder.colHigh = (TextView) row.findViewById(R.id.colHigh);
            viewHolder.colLow = (TextView) row.findViewById(R.id.colLow);
            viewHolder.colClose = (TextView) row.findViewById(R.id.colClose);
            row.setTag(viewHolder);
        } else {
            viewHolder = (ItemViewHolder) row.getTag();
        }

        String[] stat = getItem(position);
        viewHolder.colOpen.setText(stat[0]);
        viewHolder.colHigh.setText(stat[1]);
        viewHolder.colLow.setText(stat[2]);
        viewHolder.colClose.setText(stat[3]);
        return row;
    }
}
