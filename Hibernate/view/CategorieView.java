package view;

import controller.ControllerCategorie;
import controller.ControllerEntity;
import model.Categorie;
import model.Magasin;

public class CategorieView extends EntityView {

	private ControllerCategorie Ctrl;
	
	
	public CategorieView(ControllerEntity controller) {
		super(controller);
	}

	
	public void setController(ControllerEntity controller)
	{
		Ctrl = (ControllerCategorie) controller;
	}
	
}
