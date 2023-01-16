package controller;

import java.util.List;

import javax.persistence.EntityManager;

import model.Magasin;
import model.Materiaux;

public class ControllerMagasin extends ControllerEntity {

	public ControllerMagasin() {
		super();
	}

	public ControllerMagasin(EntityManager manager) {
		super(manager);
	}
	
	

}
