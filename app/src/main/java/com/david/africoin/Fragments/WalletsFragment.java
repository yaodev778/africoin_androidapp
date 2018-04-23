package com.david.africoin.Fragments;

import android.annotation.SuppressLint;
import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.GravityCompat;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;

import com.david.africoin.Adapters.WalletListAdapter;
import com.david.africoin.MainActivity;
import com.david.africoin.Models.Wallet;
import com.david.africoin.R;

import java.util.ArrayList;
import java.util.List;

@SuppressLint("ValidFragment")
public class WalletsFragment extends Fragment {

    private MainActivity mActivity;
    private RecyclerView listViewWallets;
    private List<Wallet> listWallet;
    private WalletListAdapter walletListAdapter;

    private ImageButton btnMenu;
    private ImageButton btnAdd;

    public WalletsFragment(MainActivity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_wallets, container, false);

        findViews(view);
        setInit();
        setEvents();

        return view;
    }

    private void findViews(View view) {
        listViewWallets = view.findViewById(R.id.list_wallet);
        btnMenu = view.findViewById(R.id.btn_menu_wallets_frg);
        btnAdd = view.findViewById(R.id.btn_add_wallets_frg);
    }

    private void setInit() {
        listWallet = new ArrayList<>();
        listWallet.add(new Wallet("BTC", 0.0, 0.0));
        listWallet.add(new Wallet("ETH", 0.0, 0.0));
        listWallet.add(new Wallet("ZAR", 0.0, 0.0));

        walletListAdapter = new WalletListAdapter(this, listWallet);
        listViewWallets.setAdapter(walletListAdapter);
        listViewWallets.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
    }

    private void setEvents() {
        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mActivity.drawer.openDrawer(GravityCompat.START);
            }
        });

        btnAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

    }

}
