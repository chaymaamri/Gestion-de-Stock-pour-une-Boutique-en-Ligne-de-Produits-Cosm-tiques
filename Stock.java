package store;
import java.util.ArrayList;

public class Stock {
    private int id;
    private String nom;
    private String adresse;
    private ArrayList<produit> produits;  

    public Stock(int id, String nom, String adresse, ArrayList <produit> produits) {
        this.id=id;
        this.nom=nom;
        this.adresse=adresse;
        this.produits = produits;  
    }

    public void ajouterProduit(produit produit) {
        this.produits.add(produit);
    }

    public void retirerProduit(produit produit) {
        this.produits.remove(produit);
    }

    public void rechercherProduit(String nomProduit) {
        boolean produitTrouve = false;

        System.out.println("Résultats de la recherche pour le produit '" + nomProduit + "':");

        for (produit produit : produits) {
            if (produit.getNom().equalsIgnoreCase(nomProduit)) {
                System.out.println("- Nom: " + produit.getNom());
                System.out.println("  Description: " + produit.getDescription());
                System.out.println("  Prix: " + produit.getPrix());
                System.out.println("  Quantité en stock: " + produit.getQuantiteEnStock());
                System.out.println("  Catégorie: " + produit.getCategorie());
                System.out.println("  Date d'ajout: " + produit.getDateAjout());
                System.out.println("  Date de modification: " + produit.getDateModification());
                produitTrouve = true;
            }
        }

        if (!produitTrouve) {
            System.out.println("Aucun produit trouvé pour le nom : " + nomProduit);
        }
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public ArrayList<produit> getProduits() {
        return produits;
    }

    public static void main(String[] args) {
        produit produit1 = new produit("Parfum", "Parfum luxe", 10.0, 50, "Categorie A", "2023-12-27", "2023-12-28");
        produit produit2 = new produit("Gloss", "Gloss transparent", 20.0, 100, "Categorie B", "2023-12-28", "2023-12-29");

        ArrayList<produit> produits = new ArrayList<>();
        produits.add(produit1);
        produits.add(produit2);

        Stock stock = new Stock(1, "Stock A", "Adresse du stock A", produits);

        System.out.println("Nom du stock : " + stock.getNom());
        System.out.println("Adresse du stock : " + stock.getAdresse());
        System.out.println("Liste des produits : ");
        for (produit produit : stock.getProduits()) {
            System.out.println("- " + produit.getNom());
        }

        
        stock.rechercherProduit("Gloss");
        stock.rechercherProduit("Parfum");
        stock.rechercherProduit("Foundation");
    }
}