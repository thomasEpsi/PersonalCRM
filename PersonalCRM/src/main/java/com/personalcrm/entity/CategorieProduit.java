package com.personalcrm.entity;

/**
 * Created by Trabelsi Thomas on 03/04/14.
 */
public class CategorieProduit {

    private int idCategorie;
    private String libelle_categorie;

    public CategorieProduit() {}

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getLibelle_categorie() {
        return libelle_categorie;
    }

    public void setLibelle_categorie(String libelle_categorie) {
        this.libelle_categorie = libelle_categorie;
    }

    @Override
    public String toString() {
        return "CategorieProduit{" +
                "idCategorie=" + idCategorie +
                ", libelle_categorie='" + libelle_categorie + '\'' +
                '}';
    }
}
