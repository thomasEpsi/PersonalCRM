package com.personalcrm.entity;

import java.sql.Date;

/**
 * Created by Trabelsi Thomas on 03/04/14.
 */
public class Societe {

    private int idSociete;
    private String nom_societe;
    private String num_siret;
    private Date date_ouverture;

    public Societe() {}

    public int getIdSociete() {
        return idSociete;
    }

    public void setIdSociete(int idSociete) {
        this.idSociete = idSociete;
    }

    public String getNom_societe() {
        return nom_societe;
    }

    public void setNom_societe(String nom_societe) {
        this.nom_societe = nom_societe;
    }

    public String getNum_siret() {
        return num_siret;
    }

    public void setNum_siret(String num_siret) {
        this.num_siret = num_siret;
    }

    public Date getDate_ouverture() {
        return date_ouverture;
    }

    public void setDate_ouverture(Date date_ouverture) {
        this.date_ouverture = date_ouverture;
    }

    @Override
    public String toString() {
        return "Societe{" +
                "idSociete=" + idSociete +
                ", nom_societe='" + nom_societe + '\'' +
                ", num_siret='" + num_siret + '\'' +
                ", date_ouverture=" + date_ouverture +
                '}';
    }
}
