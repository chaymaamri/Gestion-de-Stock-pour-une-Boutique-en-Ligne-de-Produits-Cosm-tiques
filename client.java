package store;

import java.util.ArrayList;

public class client {
    private int id;
    private String nom;
    private String prenom;
    private String tel;
    private String adresseEmail;
    private ArrayList<commande> historiqueCommandes = new ArrayList<>();

    public client(String nom, String prenom, String tel, String adresseEmail, int id) {
        this.id = id;
        this.nom = nom;
        this.prenom = prenom;
        this.tel = tel;
        this.adresseEmail = adresseEmail;
    }

    public void creerCompte(ArrayList<client> clients, String nom, String prenom, String tel, String adresseEmail, int id) {
       
        for (client cl : clients) {
            if (cl.getId() == id) {
                System.out.println("Un compte avec cet ID existe déjà.");
                return;
            }
        }

        client nouveauClient = new client(nom, prenom, tel, adresseEmail, id);

                clients.add(nouveauClient);

        System.out.println("Compte créé avec succès!");
    }

    public void rechercherClient(String nomRecherche, String prenomRecherche, ArrayList<client> clients) {
        for (client cl : clients) {
            if (cl.getNom().equals(nomRecherche) && cl.getPrenom().equals(prenomRecherche)) {
                System.out.println("Client trouvé:");
                System.out.println("ID : " + cl.getId());
                System.out.println("Nom : " + cl.getNom());
                System.out.println("Prénom : " + cl.getPrenom());
                System.out.println("Téléphone : " + cl.getTel());
                System.out.println("Adresse e-mail : " + cl.getAdresseEmail());
                return;
            }
        }
        System.out.println("Aucun client trouvé avec le nom : " + nomRecherche + " et le prénom : " + prenomRecherche);
    }

    public void passerCommande(produit produit, int quantite, String date) {
        int commandeId = historiqueCommandes.size() + 1;

 
        commande nouvelleCommande = new commande(commandeId, date, "En cours", produit.getPrix() * quantite);
        nouvelleCommande.ajouterProduit(produit);

        historiqueCommandes.add(nouvelleCommande);

        System.out.println("Commande passée avec succès!");
    }

    public void consulterHistorique() {
        if (historiqueCommandes.isEmpty()) {
            System.out.println("Aucune commande dans l'historique.");
        } else {
            System.out.println("Historique des commandes:");
            for (commande cmd : historiqueCommandes) {
                System.out.println("ID de la commande : " + cmd.getId());
                System.out.println("Date de la commande : " + cmd.getDate());
                System.out.println("Statut de la commande : " + cmd.getStatut());
                System.out.println("Montant total de la commande : " + cmd.getMontantTotal());
                System.out.println("Produits de la commande:");
                for (produit prod : cmd.getProduits()) {
                    System.out.println("- " + prod.getNom() + " (Quantité : " + prod.getQuantiteEnStock() + ")");
                }
                System.out.println("------------------------------");
            }
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

    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getTel() {
        return tel;
    }

    public void setTel(String tel) {
        this.tel = tel;
    }

    public String getAdresseEmail() {
        return adresseEmail;
    }

    public void setAdresseEmail(String adresseEmail) {
        this.adresseEmail = adresseEmail;
    }

	
public static void main(String[] args) {
	        ArrayList<client> clients = new ArrayList<>();

	        client client1 = new client("Amri", "Chayma", "6555669", "amrichayma@gmail.com", 1);
	        client client2 = new client("Ghanmi", "Tasnim", "12523456", "tasnimghanmit@example.com", 2);

	        clients.add(client1);
	        clients.add(client2);

	        
	        System.out.println("Client 1:");
	        System.out.println("Nom du client : " + client1.getNom());
	        System.out.println("Prénom du client : " + client1.getPrenom());
	        System.out.println("Téléphone du client : " + client1.getTel());
	        System.out.println("Adresse e-mail du client : " + client1.getAdresseEmail());

	        System.out.println("\nClient 2:");
	        System.out.println("Nom du client : " + client2.getNom());
	        System.out.println("Prénom du client : " + client2.getPrenom());
	        System.out.println("Téléphone du client : " + client2.getTel());
	        System.out.println("Adresse e-mail du client : " + client2.getAdresseEmail());


        System.out.println("Recherche du client par nom et prénom :");
        client1.rechercherClient("Amri", "Chayma", clients);
        client1.rechercherClient("ahmed", "Samir", clients);

      
        produit produit1 = new produit("Parfum", "Parfum luxe", 10.0, 50, "Categorie A", "2023-12-27", "2023-12-28");
        System.out.println("\nClient 1 passe une commande :");
        client1.passerCommande(produit1, 2, "2023-12-29");

        produit produit2 = new produit("Gloss", "Gloss transparent", 20.0, 100, "Categorie B", "2023-12-28", "2023-12-29");
        System.out.println("\nClient 2 passe une commande :");
        client2.passerCommande(produit2, 1, "2023-12-30");

      
        System.out.println("\nHistorique des commandes :");
        System.out.println("Commandes de Client 1 :");
        client1.consulterHistorique();
        System.out.println("\nCommandes de Client 2 :");
        client2.consulterHistorique();
    }
    }

