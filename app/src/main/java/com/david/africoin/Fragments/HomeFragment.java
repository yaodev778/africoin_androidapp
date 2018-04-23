package com.david.africoin.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.NavigationView;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageButton;

import com.david.africoin.BuyActivity;
import com.david.africoin.MainActivity;
import com.david.africoin.R;
import com.david.africoin.SendFirstActivity;

@SuppressLint("ValidFragment")
public class HomeFragment extends Fragment {

    private MainActivity mActivity;

    private ImageButton btnMenu;
    private Button btnSend;
    private Button btnBuy;
    private Button btnWithdraw;
    private Button btnMore;

    public HomeFragment(MainActivity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_home, container, false);

        findViews(view);
        setEvents();

        return view;
    }
    private void findViews(View view) {

        btnSend = view.findViewById(R.id.btn_send_main);
        btnBuy = view.findViewById(R.id.btn_buy_main);
        btnWithdraw = view.findViewById(R.id.btn_withdraw_main);
        btnMore = view.findViewById(R.id.btn_more_main);
        btnMenu = view.findViewById(R.id.btn_menu_home_frg);
    }

    private void setEvents() {

        btnSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity, SendFirstActivity.class));
            }
        });

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                startActivity(new Intent(mActivity, BuyActivity.class));
            }
        });

        btnWithdraw.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                WithdrawSheetFragment withdrawSheetFragment = new WithdrawSheetFragment(mActivity);
                withdrawSheetFragment.show(mActivity.getSupportFragmentManager(), withdrawSheetFragment.getTag());
            }
        });

        btnMore.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.drawer.openDrawer(GravityCompat.START);
            }
        });
    }


}
