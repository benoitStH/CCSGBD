package controller;

import javax.persistence.EntityManager;

public class ControllerCommande extends ControllerEntity {

	public ControllerCommande() {
		super();
	}

	public ControllerCommande(EntityManager manager) {
		super(manager);
	}

}
