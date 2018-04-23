package com.david.africoin;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetBehavior;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;

import com.david.africoin.Adapters.BankListAdapter;
import com.david.africoin.Adapters.WalletListAdapter;
import com.david.africoin.Fragments.HomeFragment;
import com.david.africoin.Fragments.WalletsFragment;
import com.david.africoin.Models.Wallet;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity {

    public DrawerLayout drawer;
    private NavigationView navMenu;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
//        ButterKnife.bind(this);

        findViews();
        setInit();
        setEvents();
    }

    private void findViews() {
        drawer = findViewById(R.id.drawer_layout);
        navMenu = findViewById(R.id.nav_menu);

    }

    private void setInit() {
        getSupportFragmentManager().beginTransaction().add(R.id.frg_main, new HomeFragment(this)).commit();
    }

    private void setEvents() {
        navMenu.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                // Handle navigation view item clicks here.
                int id = item.getItemId();

                if (id == R.id.nav_home) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frg_main, new HomeFragment(MainActivity.this)).commit();
                } else if (id == R.id.nav_wallets) {
                    getSupportFragmentManager().beginTransaction().replace(R.id.frg_main, new WalletsFragment(MainActivity.this)).commit();
                } else if (id == R.id.nav_transactions) {

                } else if (id == R.id.nav_promotions) {

                } else if (id == R.id.nav_exchange) {

                } else if (id == R.id.nav_settings) {

                } else if (id == R.id.nav_help) {

                }

                drawer.closeDrawer(GravityCompat.START);
                return true;
            }
        });

    }

    @Override
    public void onBackPressed() {
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }
}
