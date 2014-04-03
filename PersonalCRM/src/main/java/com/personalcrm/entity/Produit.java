package com.personalcrm.entity;

import java.sql.Date;

/**
 * Created by Trabelsi Thomas on 03/04/14.
 */
public class Produit {

    private int idProduit;
    private String libelle_produit;
    private Boolean en_vente;
    private Date date_mise_en_vente;
    private Date date_retirer_de_la_vente;
    private float prix_public;
    private CategorieProduit categorie_produit;



    public Produit() {}

    public int getIdProduit() {
        return idProduit;
    }

    public void setIdProduit(int idProduit) {
        this.idProduit = idProduit;
    }

    public String getLibelle_produit() {
        return libelle_produit;
    }

    public void setLibelle_produit(String libelle_produit) {
        this.libelle_produit = libelle_produit;
    }

    public Boolean getEn_vente() {
        return en_vente;
    }

    public void setEn_vente(Boolean en_vente) {
        this.en_vente = en_vente;
    }

    public Date getDate_mise_en_vente() {
        return date_mise_en_vente;
    }

    public void setDate_mise_en_vente(Date date_mise_en_vente) {
        this.date_mise_en_vente = date_mise_en_vente;
    }

    public Date getDate_retirer_de_la_vente() {
        return date_retirer_de_la_vente;
    }

    public void setDate_retirer_de_la_vente(Date date_retirer_de_la_vente) {
        this.date_retirer_de_la_vente = date_retirer_de_la_vente;
    }

    public float getPrix_public() {
        return prix_public;
    }

    public void setPrix_public(float prix_public) {
        this.prix_public = prix_public;
    }

    public CategorieProduit getCategorie_produit() {
        return categorie_produit;
    }

    public void setCategorie_produit(CategorieProduit categorie_produit) {
        this.categorie_produit = categorie_produit;
    }
    @Override
    public String toString() {
        return "Produit{" +
                "idProduit=" + idProduit +
                ", libelle_produit='" + libelle_produit + '\'' +
                ", en_vente=" + en_vente +
                ", date_mise_en_vente=" + date_mise_en_vente +
                ", date_retirer_de_la_vente=" + date_retirer_de_la_vente +
                ", prix_public=" + prix_public +
                ", categorie_produit=" + categorie_produit +
                '}';
    }
}
