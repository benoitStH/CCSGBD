package view;

import controller.ControllerCategorie;
import controller.ControllerEntity;

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
