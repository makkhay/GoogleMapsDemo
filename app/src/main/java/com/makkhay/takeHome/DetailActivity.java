package com.makkhay.takeHome;


import android.content.SharedPreferences;
import android.os.Bundle;


import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;

import android.view.MenuItem;

import android.widget.TextView;
import android.support.v7.widget.Toolbar;

/**
 * This activity displays the resturant information when user clicks the marker
 */

public class DetailActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        setActionbar();
        tv = (TextView) findViewById(R.id.detailTextView);

        // receiving data from MapsActivity
        SharedPreferences prefs = getSharedPreferences("lado", MODE_PRIVATE);
        String name = prefs.getString("mug", "No name defined");//"No name defined" is the default value.
        tv.setText(name);

        }


    /**
     * Setting toolbar
     */
    private void setActionbar()
    {
        ActionBar actionBar = getSupportActionBar();
        if (actionBar == null) {
            Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);

            if (toolbar != null) {
                setSupportActionBar(toolbar);
                actionBar = getSupportActionBar();

            }

            if (actionBar != null) {
                actionBar.setDisplayHomeAsUpEnabled(true);


            }

        }

    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                // for back button
                onBackPressed();
                return true;
        }

        return super.onOptionsItemSelected(item);
    }





}

