package com.personalcrm.entity;

import java.sql.Date;
import java.util.ArrayList;

/**
 * Created by Trabelsi Thomas on 03/04/14.
 */
public class Commande {

    private int idCommande;
    private Date date_commande;
    private ArrayList<Produit> liste_produit;


    public Commande() {}

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public Date getDate_commande() {
        return date_commande;
    }

    public void setDate_commande(Date date_commande) {
        this.date_commande = date_commande;
    }

    public ArrayList<Produit> getListe_produit() {
        return liste_produit;
    }

    public void setListe_produit(ArrayList<Produit> liste_produit) {
        this.liste_produit = liste_produit;
    }


    @Override
    public String toString() {
        return "Commande{" +
                "idCommande=" + idCommande +
                ", date_commande=" + date_commande +
                ", liste_produit=" + liste_produit +
                '}';
    }
}
