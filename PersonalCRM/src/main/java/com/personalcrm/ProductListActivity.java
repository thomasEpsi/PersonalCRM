package com.personalcrm;


import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;

import com.personalcrm.R;

import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.ActionBar;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.os.Build;

public class ProductListActivity extends ListActivity {


    ArrayAdapter<String> _data;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        _data = new ArrayAdapter<String>(this , R.layout.activity_liste_produit);
        setListAdapter(_data);
    }
}
