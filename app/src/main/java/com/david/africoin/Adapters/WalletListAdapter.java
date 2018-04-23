package com.david.africoin.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.david.africoin.Fragments.WalletsFragment;
import com.david.africoin.Models.Wallet;
import com.david.africoin.R;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.List;

public class WalletListAdapter extends RecyclerView.Adapter<WalletListAdapter.ViewHolder>{

    private List<Wallet> mWallets;
    private WalletsFragment mFragment;

    public WalletListAdapter(WalletsFragment mFragment, List<Wallet> mWallets) {
        this.mWallets = mWallets;
        this.mFragment = mFragment;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_of_wallets, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String currencyName = mWallets.get(position).getCurrencyName();
        holder.txtName1.setText(currencyName);
        holder.txtName2.setText(currencyName);
        holder.txtName3.setText(currencyName);

        DecimalFormat df = new DecimalFormat("0.00");
        df.setRoundingMode(RoundingMode.DOWN);
        holder.txtBalance.setText(df.format(mWallets.get(position).getBalance()));
        holder.txtAvailable.setText(df.format(mWallets.get(position).getAvailable()));

        switch(currencyName) {
            case "BTC":
                holder.imgMark.setImageDrawable(mFragment.getResources().getDrawable(R.drawable.bitcoin));
                break;
            case "ETH":
                holder.imgMark.setImageDrawable(mFragment.getResources().getDrawable(R.drawable.ethereum));
                break;
            case "ZAR":
                holder.imgMark.setImageDrawable(mFragment.getResources().getDrawable(R.drawable.zar));
                break;
        }
    }

    @Override
    public int getItemCount() {
        return mWallets.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtName1;
        public TextView txtName2;
        public TextView txtName3;
        public ImageView imgMark;
        public TextView txtBalance;
        public TextView txtAvailable;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName1 = itemView.findViewById(R.id.txt_name_1_one_wallet);
            txtName2 = itemView.findViewById(R.id.txt_name_2_one_wallet);
            txtName3 = itemView.findViewById(R.id.txt_name_3_one_wallet);
            txtBalance = itemView.findViewById(R.id.txt_balance_one_wallet);
            txtAvailable = itemView.findViewById(R.id.txt_available_one_wallet);
            imgMark = itemView.findViewById(R.id.img_mark_one_wallet);
        }

    }
}
