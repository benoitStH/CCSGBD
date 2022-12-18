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
                        client = clientView.SelectClient();
                    
                        AddCommande(magasin, client);
                  }
            }
      }
  
      private void AddCommande(Magasin magasin, Client client)
      {
            ViewCategorie categorieView = new ViewCategorie();
            ViewMateriaux materiauxView = new ViewMateriaux();
            Categorie cat, c;
            Materiaux mat;
            Commande commande;
            List<Materiaux> materiaux;
            List<Integer> quantite;
            int choix;
            int total;
            int max;
        
            if(client == null)
            {
              System.out.println("Aucun client sélectionné");
              return;
            }
        
            categorieView.ShowCategories();
            cat = categorieView.SelectCategorie();
            total = 0;
            
            for(int i = 0; i < client.getListCat().size(); i++)
            {
                  c = client.getListCat().get(i);
                  if(cat.getId() == c.getId())
                  {
                        max = client.getSeuilMax().get(i);
                        break;
                  }
            }
            
            do
            {
                  materiauxView.ShowMateriauxFrom(cat.getListMat());
                  mat = materiauxView.SelectMateriaux();
        
                  if(mat.getId() == -1)
                  {
                        break;
                  }
                  
                  System.out.print("Veuillez indiquer la quantité à commander : ");
                  choix = scan.nextInt();
                  if(total+choix > max)
                  {
                       System.out.println("La quantité choisie dépasse le seuil maximal autorisé");
                  }
                  else
                  {
                        total += choix;
                        materiaux.add(mat);
                        quantite.add(choix);
                  }
                  
            }while(mat.getId() != -1);
            
            commande = new Commande(IdMax()+1, quantite, materiaux);
            Ctrl.AddCommande(commande, client);
      }
      
      private int IdMax()
      {
            List<Commande> commandes = Ctrl.getAllCommandes();
            int taille = commandes.size();
            int id = 0;
            
            for(int i = 0; i < taille; i++)
            {
                  if(id < commandes.get(i).getId())
                  {
                        id = commandes.get(i).getId();     
                  }
            }
            
            return id;
      }
}
