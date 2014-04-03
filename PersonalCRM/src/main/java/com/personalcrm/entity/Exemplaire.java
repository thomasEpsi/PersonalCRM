package com.personalcrm.entity;

/**
 * Created by Trabelsi Thomas on 03/04/14.
 */
public class Exemplaire extends Produit {

    private int idExemplaire;
    private String num_serie;
    private Produit produit;



    public Exemplaire() {}

    public int getIdExemplaire() {
        return idExemplaire;
    }

    public void setIdExemplaire(int idExemplaire) {
        this.idExemplaire = idExemplaire;
    }

    public String getNum_serie() {
        return num_serie;
    }

    public void setNum_serie(String num_serie) {
        this.num_serie = num_serie;
    }

    public Produit getProduit() {
        return produit;
    }

    public void setProduit(Produit produit) {
        this.produit = produit;
    }

    @Override
    public String toString() {
        return "Exemplaire{" +
                "idExemplaire=" + idExemplaire +
                ", num_serie='" + num_serie + '\'' +
                ", produit ='" + produit +
                '}';
    }
}
