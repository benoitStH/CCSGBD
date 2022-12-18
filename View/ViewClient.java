package View;

import Model.Client;
import Controller.ControllerClient;

public class ViewClient
{
      private Scanner scan = new Scanner(System.in);
      private ControllerClient Ctrl = new ControllerClient();
  
      public Client SelectClient()
      {
          int id;
          Client client;
        
          System.out.print("Veuillez saisir l'id du client recherché : "); 
          id = scan.nextInt();
        
          client = Ctrl.getClientById(id);
        
          return client; 
      }
  
    public void ShowClientsFrom(List<Client> clients)
    {
        int taille;
        Client client;
      
        if(clients == null)
        {
            System.out.println("Aucun client");
            return;
        }
      
        taille = clients.size();
      
        if(taille == 0)
        {
            System.out.println("Aucun Client");
            return;
        }
      
        System.out.println("Id \t\t Nom");
        for(int i = 0; i < taille; i++)
        {
            client = clients.get(i);
            System.out.println(client.getId()+"\t\t"+client.getNom()); 
        }
      
    }
  
    public void ShowClientsOf(Magasin magasin)
    {
        ShowClientsFrom(Ctrl.getClientsOf(magasin));
    }
  
    public void ShowClients()
    {
        ShowClientsFrom(Ctrl.getAllClients()); 
    }


}
