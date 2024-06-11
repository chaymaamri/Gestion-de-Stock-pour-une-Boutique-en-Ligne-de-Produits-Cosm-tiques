package store;

import java.util.ArrayList;

public class fournisseur {
    private String nom;
    private String adresse;
    private String numeroTelephone;
    private String adresseEmail;
    private ArrayList<produit> produits;

    public fournisseur(String nom, String adresse, String numeroTelephone, String adresseEmail) {
        this.nom = nom;
        this.adresse = adresse;
        this.numeroTelephone = numeroTelephone;
        this.adresseEmail = adresseEmail;
        this.produits = new ArrayList<>();
    }

    public void ajouterProduit(produit produit) {
        this.produits.add(produit);
    }

    public void updateContact(String nouvelleAdresse, String nouveauNumeroTelephone, String nouvelleAdresseEmail ) {
        this.adresse=nouvelleAdresse;
        this.numeroTelephone=nouveauNumeroTelephone;
        this.adresseEmail=nouvelleAdresseEmail;
    }

    public void searchFournisseur(String nomFournisseur) {
        if (this.getNom().equals(nomFournisseur)) {
            System.out.println("Fournisseur trouvé :");
            System.out.println("Nom : " + this.getNom());
            System.out.println("Adresse : " + this.getAdresse());
            System.out.println("Numero de téléphone : " + this.getNumeroTelephone());
            System.out.println("Adresse e-mail : " + this.getAdresseEmail());
        } else {
            System.out.println("Fournisseur non trouvé pour le nom : " + nomFournisseur);
        }
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public String getAdresse() {
        return adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getNumeroTelephone() {
        return numeroTelephone;
    }

    public void setNumeroTelephone(String numeroTelephone) {
        this.numeroTelephone = numeroTelephone;
    }

    public String getAdresseEmail() {
        return adresseEmail;
    }

    public void setAdresseEmail(String adresseEmail) {
        this.adresseEmail = adresseEmail;
    }

    public static void main(String[] args) {
        produit produit1 = new produit("Gloss", "Gloss Transparent", 10.0, 100, "Categorie 1", "2023-12-27", "2023-12-28");
        produit produit2 = new produit("Rouge à lèvres", "Rouge intense", 15.0, 50, "Categorie 2", "2023-12-27", "2023-12-28");

        fournisseur fournisseur = new fournisseur("Ahmed Ben Ahmed", "2 rue de Tunis", "20233566", "ahmedbna@gmail.com");
        System.out.println("Nom du fournisseur : " + fournisseur.getNom());
        System.out.println("Adresse du fournisseur : " + fournisseur.getAdresse());
        System.out.println("Numero du fournisseur : " + fournisseur.getNumeroTelephone());
        System.out.println("Adresse e-mail du fournisseur : " + fournisseur.getAdresseEmail());

    
        fournisseur.ajouterProduit(produit1);
        fournisseur.ajouterProduit(produit2);

       
        fournisseur.searchFournisseur("Ahmed Ben Ahmed");
        fournisseur.searchFournisseur("Abd Sattar");  

        
        System.out.println("Produits associés au fournisseur :");
        for (produit p : fournisseur.produits) {
            System.out.println("- " + p.getNom());
        }
    }
}
