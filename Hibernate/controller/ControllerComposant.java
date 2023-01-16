package controller;

import java.util.List;

import javax.persistence.EntityManager;

import model.Composant;

public class ControllerComposant extends ControllerEntity {

	public ControllerComposant() {
		super();
	}

	public ControllerComposant(EntityManager manager) {
		super(manager);
	}


}
