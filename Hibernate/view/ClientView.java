package view;

import controller.ControllerClient;
import controller.ControllerEntity;

public class ClientView extends EntityView {

	private ControllerClient Ctrl;
	
	
	public ClientView(ControllerEntity controller) {
		super(controller);
	}
	
	public void setController(ControllerEntity controller)
	{
		Ctrl = (ControllerClient) controller;
	}
}
