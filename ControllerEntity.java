package controller;

import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.EntityTransaction;

public class ControllerEntity {

    public EntityManager manager;
    protected EntityTransaction transaction;

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