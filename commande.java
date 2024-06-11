package store;

import java.util.ArrayList;

public class commande {
    private int id;
    private String date;
    private String statut;
    private double montantTotal;

    
    private ArrayList<produit> produits;

    public commande(int id, String date, String statut, double montantTotal) {
        this.id = id;
        this.date = date;
        this.statut = statut;
        this.montantTotal = montantTotal;
        this.produits = new ArrayList<>();
    }

    public void ajouterCommande(commande nouvelleCommande, ArrayList<commande> commandes) {
        commandes.add(nouvelleCommande);
        System.out.println("Commande ajoutée avec succès!");
    }

    public void miseAJourCommande(commande commandeMiseAJour, ArrayList<commande> commandes) {
        for (commande cmd : commandes) {
            if (cmd.getId() == commandeMiseAJour.getId()) {
                cmd.setDate(commandeMiseAJour.getDate());
                cmd.setStatut(commandeMiseAJour.getStatut());
                cmd.setMontantTotal(commandeMiseAJour.getMontantTotal());
                System.out.println("Commande mise à jour avec succès!");
                return;
            }
        }
        System.out.println("Aucune commande trouvée avec l'ID : " + commandeMiseAJour.getId());
    }

    public void rechercherCommande(int idCommande, ArrayList<commande> commandes) {
        for (commande cmd : commandes) {
            if (cmd.getId() == idCommande) {
                System.out.println("Commande trouvée:");
                System.out.println("ID : " + cmd.getId());
                System.out.println("Date : " + cmd.getDate());
                System.out.println("Statut : " + cmd.getStatut());
                System.out.println("Montant total : " + cmd.getMontantTotal());
                return;
            }
        }
        System.out.println("Aucune commande trouvée avec l'ID : " + idCommande);
    }

    public void ajouterProduit(produit produit) {
        
        this.produits.add(produit);
        System.out.println("Produit ajouté à la commande avec succès!");
    }

   

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getStatut() {
        return statut;
    }

    public void setStatut(String statut) {
        this.statut = statut;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public ArrayList<produit> getProduits() {
        return produits;
    }

    public static void main(String[] args) {
        ArrayList<commande> commandes = new ArrayList<>();

        commande commande1 = new commande(1225, "2023-12-27", "En cours", 45.9);
        commande commande2 = new commande(1226, "2023-12-28", "Terminée", 30.5);

        commandes.add(commande1);
        commandes.add(commande2);

        System.out.println("ID de la commande : " + commande1.getId());
        System.out.println("Date de la commande : " + commande1.getDate());
        System.out.println("Statut de la commande : " + commande1.getStatut());
        System.out.println("Montant total de la commande : " + commande1.getMontantTotal());

        
        commande nouvelleCommande = new commande(1227, "2023-12-29", "En cours", 60.0);
        commande1.ajouterCommande(nouvelleCommande, commandes);

        commande commandeMiseAJour = new commande(1225, "2023-12-30", "En cours", 50.0);
        commande1.miseAJourCommande(commandeMiseAJour, commandes);

        commande1.rechercherCommande(1225, commandes);
        commande1.rechercherCommande(1228, commandes);

        
        produit produit1 = new produit("Parfum", "Parfum luxe", 10.0, 50, "Categorie A", "2023-12-27", "2023-12-28");
        commande1.ajouterProduit(produit1);
    }
}
 