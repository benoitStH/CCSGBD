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

    public Client CreateClient(Client client)
    {

        if (manager.contains(client.getStore()))
        {

        }
            client.getStore();
            manager.getTransaction().begin();
            manager.persist(client);
            manager.getTransaction().commit();

            if (manager.contains(client)) {
                return client;
            } else {
                return null;
            }
        }


}