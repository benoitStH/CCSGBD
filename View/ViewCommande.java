package View;

import Model.Commande;
import Controller.ControllerCommande;
import View.ViewClient;
import View.ViewMateriaux;

public class ViewCommande
{
      private Scanner scan = new Scanner(System.in);
      private ControllerCommande Ctrl = new ControllerCommande();
  
      public void AddCommande(Magasin magasin)
      {
            int choix = -1;
            ViewClient clientView = new ViewClient(); 
            Client client;
        
            if(magasin == null)
            {
                System.out.println("Aucun magasin selectionné");
                return;
            }
        
        
            if(magasin.getMateriaux() == null)
            {
                  System.out.println("Le magasin ne possède plus rien en stock");
                  return;
            }
        
            while(choix != 0)
            {
                  System.out.println("1 - Créer une commande pour un nouveau client");
                  System.out.println("2 - Créer une commande pour un client existant");
                  System.out.println("0 - Retourner à la page précédente");
              
                  System.out.print("Veuillez choisir une option : ");
                  choix = scan.nextInt();
              
                  if(choix == 1)
                  {
                        // Création d'un nouveau client
                        client = clientView.AddClientTo(magasin);
                    
                        AddCommande(magasin, client);
                  }
                  else if (choix == 2)
                  {
                        // choix d'un client parmi ceux du magasin
                        clientView.ShowClientsOf(magasin);
                        client = clientView.SelectClients();
                    
                        AddCommande(magasin, client);
                  }
            }
      }
  
      private void AddCommande(Magasin magasin, Client client)
      {
          ViewMateriaux materiauxView = new ViewMateriaux();
          Materiaux mat;
          int choix;
        
          if(client == null)
          {
              System.out.println("Aucun client sélectionné");
              return;
          }
        
          materiauxView.ShowMateriauxFrom(magasin.getMateriaux());
          mat = materiauxView.SelectMateriaux();
        
          System.out.print("Veuillez indiquer la quantité à commander : ");
          choix = scan.nextInt();
        
      }
}
