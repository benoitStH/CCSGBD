package view;

import java.util.List;

import controller.ControllerCommande;
import controller.ControllerEntity;
import model.Commande;
import model.Panier;

public class CommandeView extends EntityView {

	private ControllerCommande Ctrl;
	
	public CommandeView(ControllerEntity controller) {
		super(controller);
	}

	public void setController(ControllerEntity controller)
	{
		Ctrl = (ControllerCommande) controller;
	}
	
	public Commande AddCommande(Commande commande, List<Panier> paniers)
	{
		return Ctrl.CreateCommande(commande, paniers);
	}
}
