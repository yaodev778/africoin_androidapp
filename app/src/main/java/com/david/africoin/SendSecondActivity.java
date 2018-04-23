package com.david.africoin;

import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.EditText;
import android.widget.ExpandableListView;
import android.widget.TextView;

import com.david.africoin.Adapters.BuyListAdapter;
import com.david.africoin.Adapters.SendListAdapter;
import com.david.africoin.Adapters.WalletListAdapter;
import com.david.africoin.Models.Wallet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class SendSecondActivity extends AppCompatActivity {

    private String currencyName;

    private List<String> listDataHeader;
    private Map<String, List<String>> listDataChild;
    private SendListAdapter listAdapter;
    private ExpandableListView listViewSend;

    private TextView txtAddressLabel;
    private EditText edtAddress;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_second);
        findViews();
        setInit();
    }


    private void findViews() {
        listViewSend = findViewById(R.id.list_send);
        txtAddressLabel = findViewById(R.id.txt_address_label_send_second);
        edtAddress = findViewById(R.id.edt_address_send_second);
    }

    private void setInit() {

        currencyName = getIntent().getStringExtra("currency");

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setTitle("Send " + currencyName);
            actionBar.setDisplayHomeAsUpEnabled(true);
        }

        txtAddressLabel.setText("Send " + currencyName + " to");
        edtAddress.setHint("Send " + currencyName + " to");

        listDataHeader = new ArrayList<>();
        listDataChild = new HashMap<>();

        List<String> listContacs = new ArrayList<>();
        listContacs.add("078845522 Malamute");
        listContacs.add("1");
        listContacs.add("1950 Harley");
        listContacs.add("2");
        listContacs.add("2");
        listContacs.add("22 Kmbi");
        listContacs.add("2nd Hand Bike Tank");

        listDataChild.put("Contacts", listContacs);
        listDataHeader.add("Contacts");

        listAdapter = new SendListAdapter(this, listDataHeader, listDataChild);

        listViewSend.setAdapter(listAdapter);
        for (int i = 0; i < listAdapter.getGroupCount(); i++)
            listViewSend.expandGroup(i);
        listViewSend.setOnChildClickListener(new ExpandableListView.OnChildClickListener() {
            @Override
            public boolean onChildClick(ExpandableListView parent, View v, int groupPosition, int childPosition, long id) {
                return false;
            }
        });
    }


}
