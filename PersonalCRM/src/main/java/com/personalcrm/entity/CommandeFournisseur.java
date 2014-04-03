package com.personalcrm.entity;

/**
 * Created by Trabelsi Thomas on 03/04/14.
 */
public class CommandeFournisseur extends Commande {

    private int idCommandeFournisseur;
    private Fournisseur fournisseur;
    private Societe societe;

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

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    @Override
    public String toString() {
        return "CommandeFournisseur{" +
                "idCommandeFournisseur=" + idCommandeFournisseur +
                ", fournisseur=" + fournisseur +
                ", societe=" + societe +
                '}';
    }
}
