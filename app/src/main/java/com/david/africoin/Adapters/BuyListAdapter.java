package com.david.africoin.Adapters;

import android.content.Context;
import android.graphics.Typeface;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseExpandableListAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.david.africoin.R;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuyListAdapter extends BaseExpandableListAdapter {
    private Context mContext;
    private List<String> listDataHeader;
    private Map<String, List<String>> listDataChild;

    public BuyListAdapter(Context context, List<String> listDataHeader, Map<String, List<String>> listDataChild) {
        this.mContext = context;
        this.listDataHeader = listDataHeader;
        this.listDataChild = listDataChild;
    }

    @Override
    public int getGroupCount() {
        return this.listDataHeader.size();
    }

    @Override
    public int getChildrenCount(int groupPosition) {
        return this.listDataChild.get(this.listDataHeader.get(groupPosition)).size();
    }

    @Override
    public Object getGroup(int groupPosition) {
        return this.listDataHeader.get(groupPosition);
    }

    @Override
    public Object getChild(int groupPosition, int childPosition) {
        return  this.listDataChild.get(this.listDataHeader.get(groupPosition)).get(childPosition);
    }

    @Override
    public long getGroupId(int groupPosition) {
        return groupPosition;
    }

    @Override
    public long getChildId(int groupPosition, int childPosition) {
        return childPosition;
    }

    @Override
    public boolean hasStableIds() {
        return false;
    }

    @Override
    public View getGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
        String name = (String) getGroup(groupPosition);
        if (convertView == null) {
            LayoutInflater infalInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
            convertView = infalInflater.inflate(R.layout.list_header_of_buy, null);
        }
        TextView txtName = (TextView)convertView.findViewById(R.id.txt_name_one_buy_header);
        txtName.setTypeface(null, Typeface.BOLD);
        txtName.setText(name);

        ImageView imgMark = convertView.findViewById(R.id.img_mark_one_buy_header);

        switch (name) {
            case "Bitcoin":
                imgMark.setImageDrawable(mContext.getResources().getDrawable(R.drawable.bitcoin));
                break;
            case "Ethereum":
                imgMark.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ethereum));
                break;
        }

        ImageView imgIndicator = convertView.findViewById(R.id.img_indicator_one_buy_header);
        imgIndicator.setSelected(isExpanded);
        return convertView;
    }

    @Override
    public View getChildView(int groupPosition, int childPosition, boolean isLastChild, View convertView, ViewGroup parent) {
        String name = (String) getChild(groupPosition, childPosition);
        if (convertView == null) {
            convertView = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_child_of_buy, parent, false);
        }
        TextView txtName = convertView.findViewById(R.id.txt_name_one_buy_child);
        txtName.setText(name);

        ImageView imgMark = convertView.findViewById(R.id.img_mark_one_buy_child);

        switch (name) {
            case "BTC":
                imgMark.setImageDrawable(mContext.getResources().getDrawable(R.drawable.bitcoin));
                break;
            case "ETH":
                imgMark.setImageDrawable(mContext.getResources().getDrawable(R.drawable.ethereum));
                break;
            case "ZAR":
                imgMark.setImageDrawable(mContext.getResources().getDrawable(R.drawable.zar));
                break;
        }

        return convertView;
    }

    @Override
    public boolean isChildSelectable(int groupPosition, int childPosition) {
        return true;
    }
}
