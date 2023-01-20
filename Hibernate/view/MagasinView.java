package view;

import java.util.ArrayList;
import java.util.List;

import controller.ControllerEntity;
import controller.ControllerMagasin;
import model.Categorie;
import model.Client;
import model.Commande;
import model.Magasin;
import model.Materiaux;
import model.Panier;
import model.Stock;


public class MagasinView extends EntityView {

	private ControllerMagasin Ctrl;
	private ClientView clientV;
	private MateriauxView materiauxV;
	
	public MagasinView(ControllerEntity controller) {
		super(controller);
	}

	public void setController(ControllerEntity controller)
	{
		Ctrl = (ControllerMagasin) controller;
	}
	
	public void setClientView(ClientView view)
	{
		clientV = view;
	}
	
	public void setCommandeView(MateriauxView view)
	{
		materiauxV = view;
	}

	
	public void SelectShop()
	{
		Integer choix;
		List<Magasin> magasins = Ctrl.GetAll();
		
		if(magasins == null)
		{
			System.out.println("Aucun magasin disponible");
			return;
		}
		
		// Affichage des magasins existants
		Show(magasins);
		
		// Choix entre 1 et N
		choix = getInputInt("Selectionnez le numero du magasin : ");
		
		if(choix == null || choix < 1 || choix > magasins.size())
		{
			System.out.println("Aucun magasin sélectionné");
			System.out.println("Retour à la page précédente");
			return;
		}
		
		// Affectation du magasin choisi
		Ctrl.setMagasin(magasins.get(choix-1));
		System.out.println("\nMagasin '"+Ctrl.getMagasin().getNom()+"' sélectionné");
		
		InspectShop();
		
	}
	
	private void InspectShop()
	{
		Integer choix;
		
		do
		{
		
			System.out.println("1 - Voir les stocks");
			System.out.println("2 - Voir la liste des clients");
			System.out.println("3 - Voir la liste des commandes");
			System.out.println("4 - Ajouter une commande cliente");
			System.out.println("0 - Retour à la page précédente");
			
			choix = getInputUntilPositiveInt("Veuillez choisir une option [0-4] : ");
			
			switch(choix)
			{
			
				case 1:
					// Affichage des Stocks
					ShowStock();
				break;
				
	
				case 2:
					// Affichage des clients
					ShowClients();
				break;
	
				case 3:
					// Affichage des commandes
					ShowCommandes();
				break;
				
				case 4:
					// Affichage des commandes
					AddCommande();
				break;
				
				case 0:
					// Retour
					System.out.println("Retour à la page précédente");
				break;
				
				default:
					// Autre
					System.out.println("Option "+choix+" inconnue");
					break;
			}
			
		}while(choix != 0);
	}
	
	public void AddCommande()
	{
		int taille;
		Integer choix;
		List<Client> clients;
		Client client;
		Categorie categorie;
		Materiaux materiaux;
		Commande commande;
		List<Panier> paniers = new ArrayList<Panier>();
		
		// Selection d'un client ou Création d'un nouveau client
		clients = Ctrl.GetClientMagasin(Ctrl.getMagasin());
		
		taille = clients.size();
		for(int i = 0; i < taille; i++)
		{
			System.out.println((i+1)+" - "+clients.get(i).getPrenom()+" "+clients.get(i).getNom());
		}
		System.out.println("0 - Nouveau client");
		
		choix = getInputUntilPositiveInt("Veuillez choisir le client concerné : ");
		
		if(choix > taille)
		{
			System.out.println("Aucun client sélectionné ");
			System.out.println("Retour à la page précédente");
			return;
		}
		
		if(choix == 0)
		{
			client = clientV.AddClientTo(Ctrl.getMagasin());
		}
		else
		{
			client = clients.get(choix - 1);
		}
		
		
		if(client == null)
		{
			System.out.println("Erreur pour le client sélectionné");
			System.out.println("Retour à la page précédente");
			return;
		}
		
		// Ajout de materiaux dans le panier d'une commande
		
		do
		{
			// Selection d'un materiel 1-N ou 0 pour quitter
			ShowStock();
			
			choix = getInputUntilPositiveInt("Veuillez saisir le numero du materiel à commander : ");
			
			if(choix != 0)
			{

				// Saisie de la quantité
				choix = getInputUntilPositiveInt("Veuillez saisir la quantité à commander : ");
				
				
				// Vérification de la quantité en stock et la quantité voulue
				
				
				// Vérification du seuil du client
				
				
				// Décrémentation du stock et incrementation du panier OU Erreur
				
				
				choix = 1; // Selection d'un autre materiel
			}
			
			
		}while(choix != 0);
		
		// Création de la commande et ajout dans la base
		commande = new Commande(client);
		
		
	}
	
	public void ShowCommandes()
	{
		int taille;
		List<Commande> commandes = Ctrl.GetCommandeMagasin(Ctrl.getMagasin());
		
		if(commandes == null || commandes.size() == 0)
		{
			System.out.println("Il n'y a aucune commande");
			return;
		}
		
		taille = commandes.size();
		
		for(int i = 0; i < taille; i++)
		{
			System.out.println(commandes.get(i).getId() + " - "+commandes.get(i).getClient().getNom());
		}
		System.out.println();
	}
	
	public void ShowClients()
	{
		int taille;
		List<Client> clients = Ctrl.GetClientMagasin(Ctrl.getMagasin());
		
		if(clients == null || clients.size() == 0)
		{
			System.out.println("Il n'y a aucun client");
			return;
		}
		
		clientV.Show(clients);
		System.out.println();
	}
	
	public void ShowStock()
	{
		int taille;
		List<Stock> stocks = Ctrl.GetStockMagasin(Ctrl.getMagasin());
		
		if(stocks == null || stocks.size() == 0)
		{
			System.out.println("Il n'y a rien en stock");
			return;
		}
		
		taille = stocks.size();
		
		for(int i = 0; i < taille; i++)
		{
			System.out.println((i+1)+" - "+stocks.get(i).getMateriaux().getNom()+" (x"+stocks.get(i).getQuantite()+")");
		}
		System.out.println();
		
	}
	
	public void Show(List<Magasin> magasins)
	{
		int taille;
		
		if(magasins == null || magasins.size() == 0)
		{
			System.out.println("Aucun magasin existant");
			return;
		}
		
		taille = magasins.size();
		
		for(int i = 0; i < taille; i++)
		{
			System.out.println((i+1)+" - "+magasins.get(i).getNom());
		}
	}
	
}
