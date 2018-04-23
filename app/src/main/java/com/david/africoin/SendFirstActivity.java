package com.david.africoin;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;

public class SendFirstActivity extends AppCompatActivity {

    private LinearLayout layoutBitcoin;
    private LinearLayout layoutEhtereum;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_send_first);

        setInit();
        findViews();
        setEvents();
    }

    private void setInit(){
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.setDisplayHomeAsUpEnabled(true);
    }

    private void findViews() {
        layoutBitcoin = findViewById(R.id.layout_bitcoin_sendfirst);
        layoutEhtereum = findViewById(R.id.layout_ethereum_sendfirst);
    }

    private void setEvents() {
        layoutBitcoin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SendFirstActivity.this, SendSecondActivity.class);
                intent.putExtra("currency", "Bitcoin");
                startActivity(intent);
            }
        });

        layoutEhtereum.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(SendFirstActivity.this, SendSecondActivity.class);
                intent.putExtra("currency", "Ethereum");
                startActivity(intent);
            }
        });
    }

}
