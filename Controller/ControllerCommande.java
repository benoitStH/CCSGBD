package Controller;

import Model.Commande;
import Model.Magasin;
import Model.Client;

public class ControllerCommande {

    private CommandeDAO dao = new CommandeDAO();
  
    public List<Commande> getAllCommandes()
    {
          return dao.getCommandes(); 
    }
  
    public Commande getCommandeById(int value)
    {
          Commande result = dao.getElementById(value);
      
          if(result == null)
          {
                System.out.println("Erreur : Aucune commande ne possède l'id "+value); 
                return new Commande(-1, null, null);
          }
        
          return result;
    }
    
    public void AddCommande(Commande commande, Magasin magasin, Client client)
    {
        dao.AddCommande(commande, magasin, client);
    }
  
  
}
