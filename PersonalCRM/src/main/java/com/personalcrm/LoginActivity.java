package com.personalcrm;

import android.app.ActionBar;
import android.app.Activity;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.AsyncTask;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.personalcrm.tools.Util;

/**
 * Created by Trabelsi Thomas on 03/04/14.
 */
public class LoginActivity extends Activity {

    private Util util = new Util();
    private String username;
    private String password;
    private CheckBox remember_me;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));


    }

    public void getData(View v){

       boolean cancel = false;
        View focusView = null;

    //on vérifie si les champs sont vide
        if (TextUtils.isEmpty(this.password)) {
            ((EditText) findViewById(R.id.password)).setError("Champ vide !");
            focusView = ((EditText) findViewById(R.id.password));
            cancel = true;
        }
       if (TextUtils.isEmpty(this.username)) {
            ((EditText) findViewById(R.id.username)).setError("Champ vide !");
            focusView = ((EditText) findViewById(R.id.username));
            cancel = true;
        }
        // si cancel est true on affiche un message d'erreur sinon on récupére les données et on appel à l'asynchrone
        if (cancel) {
            focusView.requestFocus();
        } else {
            this.username = ((EditText) findViewById(R.id.username)).getText().toString();
            this.password = ((EditText) findViewById(R.id.password)).getText().toString();
            this.remember_me = (CheckBox) findViewById(R.id.remember_me);

            saveDate();
        }
    }
    public void saveDate(){

      /*  AsyncTaskConnexion asyncTaskConnexion = new AsyncTaskConnexion(this, this.username, this.util.md5(this.password));
        asyncTaskConnexion.execute();*/

        // Mise du login en preference
        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        SharedPreferences.Editor editor = preferences.edit();

        //Vérifie si la checkbox est checked
        if (this.remember_me.isChecked()) {
            editor.putString("username", this.username);
        } else {
            editor.remove("username");
        }
        editor.commit();
    }
}
