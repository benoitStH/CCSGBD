package controller;

import javax.persistence.EntityManager;

import model.Client;

public class ControllerClient extends ControllerEntity {

	public ControllerClient() {
		super();
	}

	public ControllerClient(EntityManager manager) {
		super(manager);
	}

}
