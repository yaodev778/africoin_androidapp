package com.david.africoin;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;

import com.david.africoin.Adapters.BuyListAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BuyActivity extends AppCompatActivity {

    private List<String> listDataHeader;
    private Map<String, List<String>> listDataChild;
    private BuyListAdapter listAdapter;
    private ExpandableListView listViewBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_buy);

        findViews();
        setInit();
    }

    private void findViews() {
        listViewBuy = findViewById(R.id.list_buy);
    }

    private void setInit(){

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);

        listDataHeader = new ArrayList<>();
        listDataChild= new HashMap<>();

        List<String> btcWith = new ArrayList<>();
        btcWith.add("ETH");
        btcWith.add("ZAR");

        List<String> ethWith = new ArrayList<>();
        ethWith.add("BTC");
        ethWith.add("ZAR");

        listDataChild.put("Bitcoin", btcWith);
        listDataChild.put("Ethereum", ethWith);
        listDataHeader.add("Bitcoin");
        listDataHeader.add("Ethereum");

        listAdapter = new BuyListAdapter(this, listDataHeader, listDataChild);


        listViewBuy.setAdapter(listAdapter);
        for (int i = 0; i< listAdapter.getGroupCount(); i++)
            listViewBuy.expandGroup(i);
        listViewBuy.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return false;
            }
        });
    }

}
