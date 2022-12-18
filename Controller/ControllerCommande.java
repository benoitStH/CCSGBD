package Controller;

import Model.Commande;

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
          }
    }
  
  
}
