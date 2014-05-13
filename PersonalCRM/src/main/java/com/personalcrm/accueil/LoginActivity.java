package com.personalcrm.accueil;

import android.app.ActionBar;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.text.TextUtils;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;

import com.personalcrm.R;
import com.personalcrm.tools.Util;

/**
 * Created by Trabelsi Thomas on 03/04/14.
 */
public class LoginActivity extends Activity {


    public final static String REMEMBER_USER = "remember_user";

    public Util util = new Util();

    private String mlogin;
    private String mPassword;
    private EditText mloginTF;
    private EditText mPasswordTF;
    private CheckBox mRemember;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.login_layout);
        ActionBar actionBar = getActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.BLACK));

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
        String lastUser = preferences.getString(REMEMBER_USER, "");
        mlogin = lastUser;
        mloginTF = (EditText) findViewById(R.id.username);
        mloginTF.setText(mlogin);
        mPasswordTF = (EditText) findViewById(R.id.password);

    }


    //methode vérifiant les champs du formulaire
    public void getData(View v){

        mRemember = (CheckBox) findViewById(R.id.remember_me);
        mlogin = mloginTF.getText().toString();
        mPassword = mPasswordTF.getText().toString();
        boolean cancel = false;
        View focusView = null;

        // vérification du champ Login non vide
        if (TextUtils.isEmpty(mPassword)) {
            mPasswordTF.setError(getString(R.string.error_field_required));
            focusView = mPasswordTF;
            cancel = true;
        }
        // vérification du champ Password non vide
        if (TextUtils.isEmpty(mlogin)) {
            mloginTF.setError(getString(R.string.error_field_required));
            focusView = mloginTF;
            cancel = true;
        }
        // si un des deux champs vides, focus sur le champ correspondant
        if (cancel) {
            focusView.requestFocus();
        } else {

            // Mise du login en preference
            SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(this);
            SharedPreferences.Editor editor = preferences.edit();

            if (mRemember.isChecked()) {
                editor.putString(REMEMBER_USER, mlogin);
            } else {
                editor.remove(REMEMBER_USER);
            }
            editor.commit();

            saveDate();
        }
    }

    //methode pour vérifier l'utilisateur
    public void saveDate() {

        if(isOnline()){
            /*  AsyncTaskConnexion asyncTaskConnexion = new AsyncTaskConnexion(this, this.username, this.util.md5(this.password));
        asyncTaskConnexion.execute();*/
        }else{
            //vérification en sqlite
        }

        goTo();

    }

    //methode pour aller à la vue Accueil
    public void goTo(){

        Intent intent = new Intent(LoginActivity.this, AccueilActivity.class);
        startActivity(intent);
    }

    //fonction permettant de vérifier si le device a de la connectivité wifi
    private boolean isOnline() {

        ConnectivityManager cm = (ConnectivityManager) getSystemService(Context.CONNECTIVITY_SERVICE);
        final NetworkInfo mobileNetwork = cm.getNetworkInfo(ConnectivityManager.TYPE_WIFI);

        if ( mobileNetwork.isAvailable() && mobileNetwork.getDetailedState() == NetworkInfo.DetailedState.CONNECTED) {
            return true;
        }
        return false;
    }
}
