package view;

import controller.ControllerCommande;
import controller.ControllerEntity;

public class CommandeView extends EntityView {

	private ControllerCommande Ctrl;
	
	public CommandeView(ControllerEntity controller) {
		super(controller);
	}

	public void setController(ControllerEntity controller)
	{
		Ctrl = (ControllerCommande) controller;
	}
}
