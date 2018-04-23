package com.david.africoin.Fragments;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.david.africoin.Adapters.BankListAdapter;
import com.david.africoin.AddBankActivity;
import com.david.africoin.MainActivity;
import com.david.africoin.R;

import java.util.ArrayList;
import java.util.List;

public class WithdrawSheetFragment extends BottomSheetDialogFragment{

    private MainActivity mActivity;
    private Button btnAddBank;
    private RecyclerView listViewBanks;
    private List<String> listBank;
    private BankListAdapter bankListAdapter;

    public WithdrawSheetFragment() {
        // Required empty public constructor
    }

    @SuppressLint("ValidFragment")
    public WithdrawSheetFragment(MainActivity mActivity) {
        this.mActivity = mActivity;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.withdraw_sheet, container, false);

        findViews(view);
        setInit();
        setEvents();
        return view;
    }

    private void findViews(View view) {
        btnAddBank = view.findViewById(R.id.btn_add_bank_wallet_sheet);
        listViewBanks= view.findViewById(R.id.list_withdraw_bank);
    }

    private void setInit() {
        listBank = new ArrayList<>();
        listBank.add("Nedbank x5274");

        bankListAdapter = new BankListAdapter(this, listBank);
        listViewBanks.setAdapter(bankListAdapter);
        listViewBanks.setLayoutManager(new LinearLayoutManager(mActivity, LinearLayoutManager.VERTICAL, false));
    }

    private void setEvents(){
        btnAddBank.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent= new Intent(mActivity, AddBankActivity.class);
                startActivity(intent);
            }
        });
    }

}
