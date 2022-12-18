package View;

import Model.Categorie;
import Controller.ControllerCategorie;

public class ViewCategorie
{
      private Scanner scan = new Scanner(System.in);
      private ControllerCategorie Ctrl = new ControllerCategorie();
  
      public Categorie SelectCategorie()
      {
          int id;
          Catagorie cat;
        
          System.out.print("Veuillez saisir l'id de la categorie recherchée : "); 
          id = scan.nextInt();
        
          cat = Ctrl.getCategorieById(id);
        
          return client;  
      }
  
      public void ShowCategoriesFrom(List<Categorie> categories)
      {
          int taille;
          Categorie cat;
        
          if(categories == null)
          {
              System.out.println("Aucune categorie"); 
              return;
          }
        
          taille = categorie.size();
          if(taille == 0)
          {
              System.out.println("Aucune categorie");
              return;
          }
        
          System.out.println("Id \t\t Nom");
          for(int i = 0; i < taille; i++)
          {
              cat = categories.get(i);
              System.out.println(cat.getId()+"\t\t"+cat.getNom());
          }
      }
  
      public void ShowCategories()
      {
          ShowCategoriesFrom(Ctrl.getAllCategories()); 
      }
  
    
}
