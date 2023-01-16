package view;

import controller.ControllerEntity;
import controller.ControllerMagasin;

public class MagasinView extends EntityView {

	private ControllerMagasin Ctrl;
	
	public MagasinView(ControllerEntity controller) {
		super(controller);
	}

	public void setController(ControllerEntity controller)
	{
		Ctrl = (ControllerMagasin) controller;
	}
}
