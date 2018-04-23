package com.david.africoin;

import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class AddBankActivity extends AppCompatActivity {

    private Spinner spnBanks;
    private Spinner spnTypes;

    private List<String> bankNames;
    private List<String> accountTypes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_bank);

        findViews();
        setInit();

    }

    private void findViews() {
        spnBanks = findViewById(R.id.spn_banks_add_bank);
        spnTypes = findViewById(R.id.spn_account_type_add_bank);
    }

    private void setInit() {

        bankNames = new ArrayList<>();
        accountTypes = new ArrayList<>();

        bankNames.add("Absa Bank");
        bankNames.add("BBB Bank");
        bankNames.add("CCC Bank");

        accountTypes.add("Current");
        accountTypes.add("type2");
        accountTypes.add("type3");

        spnBanks.setAdapter(new ArrayAdapter<String>(this, R.layout.spn_item_of_bank, bankNames) {
            @NonNull
            @Override
            public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
                View view= super.getView(position, convertView, parent);
                TextView txtName = view.findViewById(R.id.txt_name_one_bank);
                ImageView imgMark = view.findViewById(R.id.img_mark_one_bank);

                txtName.setText(bankNames.get(position));
                txtName.setTextColor(getResources().getColor(R.color.colorBlack));

                if (position % 2 == 0) {
                    imgMark.setImageDrawable(getResources().getDrawable(R.drawable.bank1));
                } else {
                    imgMark.setImageDrawable(getResources().getDrawable(R.drawable.bank2));
                }
                return view;
            }
        });

        spnBanks.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, accountTypes));
    }
}
