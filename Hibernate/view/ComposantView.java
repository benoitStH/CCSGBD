package view;

import controller.ControllerComposant;
import controller.ControllerEntity;

public class ComposantView extends EntityView {

	private ControllerComposant Ctrl;
	
	public ComposantView(ControllerEntity controller) {
		super(controller);
	}

	public void setController(ControllerEntity controller)
	{
		Ctrl = (ControllerComposant) controller;
	}
}
