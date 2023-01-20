package view;

import java.util.List;

import controller.ControllerClient;
import controller.ControllerEntity;
import model.Client;
import model.Magasin;

public class ClientView extends EntityView {

	private ControllerClient Ctrl;
	
	
	public ClientView(ControllerEntity controller) {
		super(controller);
	}
	
	public void setController(ControllerEntity controller)
	{
		Ctrl = (ControllerClient) controller;
	}
	
	public Client AddClientTo(Magasin store)
	{
		String nom, prenom;
		Client client = new Client();
		
		
		System.out.println("Création d'un nouveau client");
		
		nom = getInputString("Nom du nouveau client : ");
		prenom = getInputString("Prenom de nouveau client : ");
		
		client.setPrenom(prenom);
		client.setNom(nom);
		
		return Ctrl.CreateClient(client, store);
	}
	
	public void Show(List<Client> clients)
	{
		int taille;
		
		if(clients == null)
		{
			System.out.println("Aucun client");
			return;
		}
		
		taille = clients.size();
		
		for(int i = 0; i < taille; i++)
		{
			System.out.println(clients.get(i).getPrenom()+" "+clients.get(i).getNom());
		}
	}
}
