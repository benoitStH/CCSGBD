package controller;

import javax.persistence.EntityManager;

public class ControllerEntity {

	public EntityManager manager;
	
	public ControllerEntity()
	{
		manager = null;
	}
	
	public ControllerEntity(EntityManager manager)
	{
		this.manager = manager;
	}
	
	public void setManager(EntityManager manager)
	{
		this.manager = manager;
	}
}
