package com.personalcrm.entity;

/**
 * Created by Trabelsi Thomas on 03/04/14.
 */
public class CommandeFournisseur  {

    private int idCommandeFournisseur;
    private Fournisseur fournisseur;


    public CommandeFournisseur() {}

    public int getIdCommandeFournisseur() {
        return idCommandeFournisseur;
    }

    public void setIdCommandeFournisseur(int idCommandeFournisseur) {
        this.idCommandeFournisseur = idCommandeFournisseur;
    }

    public Fournisseur getFournisseur() {
        return fournisseur;
    }

    public void setFournisseur(Fournisseur fournisseur) {
        this.fournisseur = fournisseur;
    }



    @Override
    public String toString() {
        return "CommandeFournisseur{" +
                "idCommandeFournisseur=" + idCommandeFournisseur +
                ", fournisseur=" + fournisseur +
                '}';
    }
}
