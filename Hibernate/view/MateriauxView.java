package view;

import controller.ControllerEntity;
import controller.ControllerMateriaux;

public class MateriauxView extends EntityView {

	private ControllerMateriaux Ctrl;
	
	public MateriauxView(ControllerEntity controller) {
		super(controller);
	}

	public void setController(ControllerEntity controller)
	{
		Ctrl = (ControllerMateriaux) controller;
	}
}
