package com.personalcrm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import com.personalcrm.accueil.AccueilActivity;
import com.personalcrm.accueil.ListContactActivity;
import com.personalcrm.tools.Util;

public class ContactMainActivity extends Activity{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_contact_main);
    }



    public void goToListContact(View v){
        Intent intent = new Intent(ContactMainActivity.this, ListContactActivity.class);
        startActivity(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.accueil_menu, menu);
        menu.getItem(0).setTitle(Util.textDateNow());
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.menu_now:
                return true;
            case R.id.menu_accueil_com:
//                Intent activiteU = new Intent(AccueilActivity.this, CommandeActivity.class);
//                startActivity(activiteU);
                return true;
            case R.id.menu_accueil:
                Intent activiteP = new Intent(ContactMainActivity.this, AccueilActivity.class);
                startActivity(activiteP);
                return true;
            case R.id.menu_accueil_stock:
//                Intent activitet = new Intent(AccueilActivity.this, StockActivity.class);
//                startActivity(activitet);
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

}
