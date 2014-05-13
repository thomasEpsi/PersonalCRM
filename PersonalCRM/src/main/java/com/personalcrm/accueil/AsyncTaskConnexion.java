package com.personalcrm.accueil;

import android.app.ProgressDialog;
import android.content.Context;
import android.os.AsyncTask;
import com.personalcrm.tools.RestClient;
import org.json.JSONArray;
import com.personalcrm.tools.Util.RequestMethod;

/**
 * Created by Trabelsi Thomas on 03/04/14.
 */
public class AsyncTaskConnexion extends AsyncTask<Void,Integer,String> {
    private ProgressDialog pDialog;
    private Context ctx;
    private String username;
    private String password;

    public AsyncTaskConnexion(Context ctx, String username, String password) {
        this.ctx = ctx;
        this.username = username;
        this.password = password;
    }

    @Override
    protected void onPreExecute() {
        super.onPreExecute();

        this.pDialog  = new ProgressDialog(this.ctx);
        this.pDialog.setMessage("Please wait..");
        this.pDialog.setIndeterminate(true);
        this.pDialog.setCancelable(true);
        this.pDialog.show();
    }

    @Override
    protected String doInBackground(Void... voids) {

        RestClient client = new RestClient("url_du_webservice");
        client.AddParam("username", this.username);
        client.AddParam("password", this.password);

        try {
            client.Execute(RequestMethod.POST);
        } catch (Exception e) {
            e.printStackTrace();
        }

        String response = client.getResponse();

        return response;
    }

    @Override
    protected void onPostExecute(String response) {
        super.onPostExecute(response);

        if(response.equals(null)){
            //on va a la vu d'après (presque fini)
        }else{
           //affiche message d'erreur
        }
    }


}
