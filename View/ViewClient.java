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


    public Client AddClientTo(Magasin magasin)
    {
        Client client = null;
        String nom, prenom;
        ControllerCategorie CtrlCat = new ControllerCategorie();
        List<Categorie> categories = CtrlCat.getAllCategories();
        List<Integer> seuilMax = new ArrayList<Integer>();
        
        System.out.print("Nom du client : ");
        nom = scan.nextString();
          
        System.out.print("Prénom du client : ");
        prenom = scan.nextString();
        
        client = new Client(IdMaxFrom(Ctrl.getAllClients()), nom, prenom, null, null);
        
        if(FincClientInMagasin(client, magasin))
        {
             System.out.print("Il existe déjà un client avec le même nom et prénom")
             return null;     
        }
        
        for(int i = 0; i < taille; i++)
        {
            System.out.println("Seuil maximal pour la catégorie "+categories.get(i).getNom()+ ": ");
            seuilMax.add(scan.nextInt());
        }
          
        client = new Client(client.getId(), nom, prenom, categories, seuilMax);
        
        Ctrl.AddClientToMagasin(client, magasin);
          
        return client;
          
    }
      
    private boolean FindClientInMagasin(Client client, Magasin magasin)
    {
         List<Client> clients = Ctrl.getClientsOf(magasin);
         int taille = clients.size();
         boolean trouve = false;
          
         for(int i = 0; i < taille && trouve == false; i++)
         {
              if(client.getNom() == clients.get(i).getNom() && client.getPrenom() == clients.get(i).getPrenom())
              {
                   trouve = true;     
              }
         }
          
         return trouve;
         
    }
      
    private int IdMaxFrom(List<Client> clients)
    {
            int taille = clients.size();
            int id = 0;
          
            for(int i = 0; i < taille; i++)
            {
                 if(id < clients.get(i).getId())
                 {
                       id = clients.get(i).getId();
                 }
            }
    }
      
}
