package store;
import java.util.ArrayList;
public class produit {
	    private String nom;
	    private String description;
	    private double prix;
	    private int quantiteEnStock;
	    private String categorie;
	    private String dateAjout;
	    private String dateModification;

	    public produit (String nom, String description, double prix, int quantiteEnStock, String categorie, String dateAjout, String dateModification ) 
	    {
	        this.nom=nom;
	        this.description=description;
	        this.prix=prix;
	        this.quantiteEnStock=quantiteEnStock;
	        this.categorie=categorie; 
	        this.dateAjout=dateAjout;
	        this.dateModification=dateModification; 
	    }

	    public void updateQuantiteEnStock(int nouvelleQuantite) {
	        this.setQuantiteEnStock(nouvelleQuantite);
	    }

	    public void updatePrix(double nouveauPrix) {
	        this.setPrix(nouveauPrix);
	    }

	    public void searchProduit(String nomProduit, ArrayList<produit> produits) {
	        for (produit p : produits) {
	            if (p.getNom().equals(nomProduit)) {
	                System.out.println("Produit trouvé:");
	                System.out.println("Nom: " + p.getNom());
	                System.out.println("Description: " + p.getDescription());
	                System.out.println("Prix: " + p.getPrix());
	                System.out.println("Quantité en stock: " + p.getQuantiteEnStock());
	                System.out.println("Catégorie: " + p.getCategorie());
	                System.out.println("Date d'ajout: " + p.getDateAjout());
	                System.out.println("Date de modification: " + p.getDateModification());
	                return; 
	            }
	        }
	        System.out.println("Produit non trouvé pour le nom: " + nomProduit);
	    }

		public String getNom() {
			return nom;
		}

		public void setNom(String nom) {
			this.nom = nom;
		}

		public String getDescription() {
			return description;
		}

		public void setDescription(String description) {
			this.description = description;
		}

		public double getPrix() {
			return prix;
		}

		public void setPrix(double prix) {
			this.prix = prix;
		}

		public int getQuantiteEnStock() {
			return quantiteEnStock;
		}

		public void setQuantiteEnStock(int quantiteEnStock) {
			this.quantiteEnStock = quantiteEnStock;
		}

		public String getCategorie() {
			return categorie;
		}

		public void setCategorie(String categorie) {
			this.categorie = categorie;
		}

		public String getDateAjout() {
			return dateAjout;
		}

		public void setDateAjout(String dateAjout) {
			this.dateAjout = dateAjout;
		}

		public String getDateModification() {
			return dateModification;
		}

		public void setDateModification(String dateModification) {
			this.dateModification = dateModification;
		}
	
		public static void main(String[] args) {
		    
		    produit produit1 = new produit("Gloss", "Gloss Transparent", 10.0, 100, "Categorie 1", "2023-12-27", "2023-12-28");
		    produit produit2 = new produit("Rouge à lèvres", "Rouge intense", 15.0, 50, "Categorie 2", "2023-12-27", "2023-12-28");

		    System.out.println("Prix: " + produit1.getPrix()); 
		    System.out.println("Quantité en stock: " + produit1.getQuantiteEnStock()); 
		    System.out.println("Nom: " + produit1.getNom()); 
		    System.out.println("Description: " + produit1.getDescription()); 
		    System.out.println("Categorie: " + produit1.getCategorie()); 
		    System.out.println("Date d'ajout: " + produit1.getDateAjout()); 
		    System.out.println("Date de modification: " + produit1.getDateModification()); 
		    ArrayList<produit> produits = new ArrayList<>();
		    produits.add(produit1);
		    produits.add(produit2);

		    
		    produit1.searchProduit("Gloss", produits);
		    produit2.searchProduit("Foundation", produits); 
		}}
