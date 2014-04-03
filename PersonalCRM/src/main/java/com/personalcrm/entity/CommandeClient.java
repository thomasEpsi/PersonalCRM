package com.personalcrm.entity;

/**
 * Created by Trabelsi Thomas on 03/04/14.
 */
public class CommandeClient extends Commande {

    private int idCommande;
    private Societe societe;
    private Client client;

    public CommandeClient() {}

    public int getIdCommande() {
        return idCommande;
    }

    public void setIdCommande(int idCommande) {
        this.idCommande = idCommande;
    }

    public Societe getSociete() {
        return societe;
    }

    public void setSociete(Societe societe) {
        this.societe = societe;
    }

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    @Override
    public String toString() {
        return "CommandeClient{" +
                "idCommande=" + idCommande +
                ", societe=" + societe +
                ", client=" + client +
                '}';
    }
}
