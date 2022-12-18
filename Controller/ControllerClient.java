package Controller;

import Model.Client;
import Model.Magasin;

public class ControllerClient {

    private ClientDAO dao = new ClientDAO();
  
    public List<Client> getAllClients
    {
          return dao.getClients(); 
    }
  
    public Client getClientById(int value)
    {
          Client result = dao.getElementById(value);
      
          if(result == null)
          {
              System.out.println("Erreur : Aucun client ne possède l'id "+value);
              return new Client(-1, "###", "###", null, null);
          }
      
          return result;
    }
  
    public void AddClientToMagasin(Client client, Magasin magasin)
    {
        dao.AddClientToMagasin(client, magasin);
    }
  
}
