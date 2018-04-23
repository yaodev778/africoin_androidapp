package com.david.africoin.Adapters;

import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.david.africoin.Fragments.WithdrawSheetFragment;
import com.david.africoin.MainActivity;
import com.david.africoin.R;

import java.util.List;

public class BankListAdapter extends RecyclerView.Adapter<BankListAdapter.ViewHolder>{

    private List<String> mBank;
    private WithdrawSheetFragment withdrawSheetFragment;

    public BankListAdapter(WithdrawSheetFragment withdrawSheetFragment, List<String> mBank) {
        this.withdrawSheetFragment = withdrawSheetFragment;
        this.mBank = mBank;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.list_item_of_withdraw_bank, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, final int position) {
        String name = mBank.get(position);
        holder.txtName.setText(name);
    }

    @Override
    public int getItemCount() {
        return mBank.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {

        public TextView txtName;

        public ViewHolder(View itemView) {
            super(itemView);
            txtName = itemView.findViewById(R.id.txt_name_one_withdraw_bank);
        }

    }
}
