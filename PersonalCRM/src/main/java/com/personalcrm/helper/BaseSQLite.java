package com.personalcrm.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * Created by Trabelsi Thomas on 14/04/14.
 */
public class BaseSQLite extends SQLiteOpenHelper {
    private static final String TABLE_CATEGORIE_PRODUIT = " CREATE TABLE categorie_produit ()";



    private static final String TABLE_CLIENT = "CREATE TABLE client ()";
    private static final String TABLE_COMMANDE = "CREATE TABLE commande ()";
    private static final String TABLE_COMMANDE_CLIENT = "CREATE TABLE commande_client ()";
    private static final String TABLE_COMMANDE_FOURNISSEUR = "CREATE TABLE commande_fournisseur ()";
    private static final String TABLE_EXEMPLAIRE = "CREATE TABLE exemplaire ()";
    private static final String TABLE_FOURNISSEUR = "CREATE TABLE fournisseur ()";
    private static final String TABLE_PERSONNE_MORALE = "CREATE TABLE personne_morale ()";;
    private static final String TABLE_PERSONNE_PHYSIQUE = "CREATE TABLE personne_physique ()";
    private static final String TABLE_PRODUIT = "CREATE TABLE produit ()";
    private static final String TABLE_SOCIETE = "CREATE TABLE societe ()";

    public BaseSQLite(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //on créer chaque table de la base SQLite
        db.execSQL(TABLE_CATEGORIE_PRODUIT);
        db.execSQL(TABLE_CLIENT);
        db.execSQL(TABLE_COMMANDE);
        db.execSQL(TABLE_COMMANDE_CLIENT);
        db.execSQL(TABLE_COMMANDE_FOURNISSEUR);
        db.execSQL(TABLE_EXEMPLAIRE);
        db.execSQL(TABLE_FOURNISSEUR);
        db.execSQL(TABLE_PERSONNE_MORALE);
        db.execSQL(TABLE_PERSONNE_PHYSIQUE);
        db.execSQL(TABLE_PRODUIT);
        db.execSQL(TABLE_SOCIETE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //lorsque il y a une mise à jour de la bdd , on détruit toutes les tables et on recréer la base
        db.execSQL("DROP TABLE " + TABLE_CATEGORIE_PRODUIT + ";");
        db.execSQL("DROP TABLE " + TABLE_CLIENT + ";");
        db.execSQL("DROP TABLE " + TABLE_COMMANDE + ";");
        db.execSQL("DROP TABLE " + TABLE_COMMANDE_CLIENT + ";");
        db.execSQL("DROP TABLE " + TABLE_COMMANDE_FOURNISSEUR + ";");
        db.execSQL("DROP TABLE " + TABLE_EXEMPLAIRE + ";");
        db.execSQL("DROP TABLE " + TABLE_FOURNISSEUR + ";");
        db.execSQL("DROP TABLE " + TABLE_PERSONNE_MORALE + ";");
        db.execSQL("DROP TABLE " + TABLE_PERSONNE_PHYSIQUE + ";");
        db.execSQL("DROP TABLE " + TABLE_PRODUIT + ";");
        db.execSQL("DROP TABLE " + TABLE_SOCIETE + ";");
        onCreate(db);
    }
}
