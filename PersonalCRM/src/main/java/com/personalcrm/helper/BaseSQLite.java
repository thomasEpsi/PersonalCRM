package com.personalcrm.helper;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.database.sqlite.SQLiteDatabase.CursorFactory;

/**
 * Created by Trabelsi Thomas on 14/04/14.
 */
public class BaseSQLite extends SQLiteOpenHelper {

    private static final String TABLE_ADRESSE = "CREATE TABLE T_Adresse(\n" +
                                                "\tAdresseLngId INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
                                                "\tAdresseStrLibelle TEXT NOT NULL,\n" +
                                                "\tAdresseLngCodePostale INTEGER NOT NULL,\n" +
                                                "\tAdresseStrVille TEXT NOT NULL,\n" +
                                                "\tAdresseDoubleLongitude REAL NULL,\n" +
                                                "\tAdresseDoubleLatitude REAL NULL\n" +
                                                "\t)";

    private static final String TABLE_CATEGORIEPRODUIT ="CREATE TABLE T_CategorieProduit(\n" +
            "\tCategorieProduitLngId INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\tCategorieProduitLngLibelle TEXT NOT NULL\n" +
            ")";

    private static final String TABLE_CLIENT = "CREATE TABLE client (CREATE TABLE T_Client(\n" +
            "\tClientLngId INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\tClientLngAdresseId INTEGER NOT NULL,\n" +
            "\tClientStrPrenom TEXT NOT NULL,\n" +
            "\tClientStrNom TEXT NOT NULL,\n" +
            "\tClientStrEmail TEXT NOT NULL,\n" +
            "\tClientLngTelMobile INTEGER NOT NULL,\n" +
            "\tClientLngPointFidelite INTEGER DEFAULT 0,\n" +
             "FOREIGN KEY (ClientLngAdresseId) REFERENCES T_Adresse (AdresseLngId));";

    private static final String TABLE_COMMANDE_FOURNISSEUR = "CREATE TABLE T_Commande_Fournisseur(\n" +
            "\tCommandeLngId INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\tCommandeLngFournisseurId INTEGER NOT NULL,\n" +
            "\tCommandeDatePrise TEXT NOT NULL,\n" +
            "\tCommandeLngPayer INTEGER NOT NULL,\n" +
            "\tCommandeDateAnnulation TEXT NULL,\n" +
            "\tCommandeDoublePrix REAL NOT NULL,\n" +
            "\tCommandeLngIdCommandeRef INTEGER NULL,\n" +
            "\tCommandeStrDescription TEXT NOT NULL\n, " +
            "FOREIGN KEY (CommandeLngFournisseurId) REFERENCES T_Fournisseur (FournisseurLngId));";

    private static final String TABLE_EMPLOYE = "CREATE TABLE T_Employe(\n" +
            "\tEmployeLngId INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\tEmployeStrNom TEXT NOT NULL,\n" +
            "\tEmployeStrPrenom TEXT NOT NULL,\n" +
            "\tEmployeDateEmploie TEXT NOT NULL,\n" +
            "\tEmployeStrTitre TEXT NOT NULL,\n" +
            "\tEmployeLngAdresseId INTEGER NOT NULL\n, " +
            "FOREIGN KEY (EmployeLngAdresseId) REFERENCES T_Adresse (AdresseLngId));";

    private static final String TABLE_EXEMPLAIRE = "CREATE TABLE T_Exemplaire(\n" +
            "\tExemplaireLngId INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\tExemplaireLngFournisseurId INTEGER NOT NULL,\n" +
            "\tExemplaireLngProduitId INTEGER NOT NULL,\n" +
            "\tExemplaireLngNumSerie INTEGER NULL,\n" +
            "\tExemplaireStrDescription TEXT NOT NULL,\n" +
            "\tExemplaireDateMisEnStock TEXT NULL,\n" +
            "\tExemplaireDatePeremption TEXT NULL\n, " +
            "FOREIGN KEY (ExemplaireLngFournisseurId) REFERENCES T_Fournisseur (FournisseurLngId),"+
            "FOREIGN KEY (ExemplaireLngProduitId) REFERENCES T_Produit (ProduitLngId));";

    private static final String TABLE_EXEMPLAIRE_COMMANDE = "CREATE TABLE T_ExemplaireParCommande(\n" +
            "\tExemplaireParCommandeId INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\tExemplaireParCommandeLngCommandeId INTEGER NOT NULL,\n" +
            "\tExemplaireParCommandeLngExemplId INTEGER NOT NULL\n, " +
            "FOREIGN KEY (ExemplaireParCommandeLngCommandeId) REFERENCES T_Commande (CommandeLngId),"+
            "FOREIGN KEY (ExemplaireParCommandeLngExemplId) REFERENCES T_Exemplaire (ExemplaireLngId));";

    private static final String TABLE_FONCTIONNALITE = "CREATE TABLE T_Fonctionnalite(\n" +
            "\tFonctionnaliteLngId INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\tFonctionnaliteStrLibelle TEXT NOT NULL,\n" +
            "\tFonctionnaliteLngRefFonction INTEGER NOT NULL,\n" +
            "\tFonctionnaliteDateActivation TEXT NOT NULL\n" +
            ")";
    private static final String TABLE_FONCTIONNALITE_EMPLOYE = "CREATE TABLE T_FonctionnalitePerEmploye(\n" +
            "\tFonctionPerEmployeLngId INTEGER NOT NULL,\n" +
            "\tFonctionPerEmployeLngFonctionId INTEGER NOT NULL,\n" +
            "\tFonctionPerEmployeLngEmployeId INTEGER NOT NULL\n, " +
            "FOREIGN KEY (FonctionPerEmployeLngEmployeId) REFERENCES T_Employe (EmployeLngId),"+
            "FOREIGN KEY (FonctionPerEmployeLngFonctionId) REFERENCES T_Fonctionnalite (FonctionnaliteLngId));";

    private static final String TABLE_FOURNISSEUR = "CREATE TABLE T_Fournisseur(\n" +
            "\tFournisseurLngId INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\tFournisseurLngAdrIdFacturation INTEGER NOT NULL,\n" +
            "\tFournisseurLngAdrIdLivraison INTEGER NULL,\n" +
            "\tFournisseurStrLibelle TEXT NOT NULL,\n" +
            "\tFournisseurStrNomContact TEXT NULL,\n" +
            "\tFournisseurLngNumTel INTEGER NOT NULL,\n" +
            "\tFournisseurLngActif INTEGER NOT NULL,\n" +
            "\tFournisseurDateDernierContact TEXT NULL\n, " +
            "FOREIGN KEY (FournisseurLngAdrIdFacturation) REFERENCES T_Adresse (AdresseLngId),"+
            "FOREIGN KEY (FournisseurLngAdrIdLivraison) REFERENCES T_Adresse (AdresseLngId));";

    private static final String TABLE_OPTION = "CREATE TABLE T_Option(\n" +
            "\tOptionLngId INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\tOptionStrLibelle TEXT NOT NULL,\n" +
            "\tOptionStrValeur INTEGER NULL\n" +
            " )";
    private static final String TABLE_PRODUIT = "CREATE TABLE T_Produit(\n" +
            "\tProduitLngId INTEGER NOT NULL,\n" +
            "\tProduitLngCategorieProduit INTEGER NOT NULL,\n" +
            "\tProduitStrLibelle TEXT NOT NULL,\n" +
            "\tProduitStrMarque TEXT NULL,\n" +
            "\tProduitLngEnVente INTEGER NOT NULL,\n" +
            "\tProduitDateRetraitVente TEXT NULL,\n" +
            "\tProduitStrDescription TEXT NOT NULL\n, " +
            "FOREIGN KEY (ProduitLngId) REFERENCES T_CategorieProduit (CategorieProduitLngId));";

    private static final String TABLE_VENTE = "CREATE TABLE T_Vente(\n" +
            "\tVenteLngId INTEGER PRIMARY KEY AUTOINCREMENT,\n" +
            "\tVenteLngEmployeId INTEGER NOT NULL,\n" +
            "\tVenteLngClientId INTEGER NULL,\n" +
            "\tVenteLngExemplaireId INTEGER NOT NULL,\n" +
            "\tVenteDateFacture TEXT NOT NULL,\n" +
            "\tVenteLngReducPourcentage INTEGER NULL\n, " +
            "FOREIGN KEY (VenteLngClientId) REFERENCES T_Client (ClientLngId),"+
            "FOREIGN KEY (VenteLngEmployeId) REFERENCES T_Employe (EmployeLngId),"+
            "FOREIGN KEY (VenteLngExemplaireId) REFERENCES T_Exemplaire (ExemplaireLngId));";




    public BaseSQLite(Context context, String name, CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        db.execSQL(TABLE_ADRESSE);
        db.execSQL(TABLE_CATEGORIEPRODUIT);
        db.execSQL(TABLE_CLIENT);
        db.execSQL(TABLE_COMMANDE_FOURNISSEUR);
        db.execSQL(TABLE_EMPLOYE);
        db.execSQL(TABLE_EXEMPLAIRE);
        db.execSQL(TABLE_EXEMPLAIRE_COMMANDE);
        db.execSQL(TABLE_FOURNISSEUR);
        db.execSQL(TABLE_FONCTIONNALITE);
        db.execSQL(TABLE_FONCTIONNALITE_EMPLOYE);
        db.execSQL(TABLE_OPTION);
        db.execSQL(TABLE_PRODUIT);
        db.execSQL(TABLE_VENTE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //lorsque il y a une mise à jour de la bdd , on détruit toutes les tables et on recréer la base
        db.execSQL("DROP TABLE " + TABLE_ADRESSE + ";");
        db.execSQL("DROP TABLE " + TABLE_CATEGORIEPRODUIT + ";");
        db.execSQL("DROP TABLE " + TABLE_CLIENT + ";");
        db.execSQL("DROP TABLE " + TABLE_COMMANDE_FOURNISSEUR + ";");
        db.execSQL("DROP TABLE " + TABLE_EMPLOYE + ";");
        db.execSQL("DROP TABLE " + TABLE_EXEMPLAIRE + ";");
        db.execSQL("DROP TABLE " + TABLE_EXEMPLAIRE_COMMANDE + ";");
        db.execSQL("DROP TABLE " + TABLE_FOURNISSEUR + ";");
        db.execSQL("DROP TABLE " + TABLE_FONCTIONNALITE + ";");
        db.execSQL("DROP TABLE " + TABLE_FONCTIONNALITE_EMPLOYE + ";");
        db.execSQL("DROP TABLE " + TABLE_OPTION + ";");
        db.execSQL("DROP TABLE " + TABLE_PRODUIT + ";");
        db.execSQL("DROP TABLE " + TABLE_VENTE + ";");
        onCreate(db);
    }
}
