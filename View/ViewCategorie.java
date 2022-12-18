package View;

import java.util.Scanner;
import Model.Categorie;
import Controller.ControllerCategorie;

public class ViewCategorie
{
      private Scanner scan;
      private ControllerCategorie Ctrl;
      
      public ViewCategorie()
      {
            scan = new Scanner(System.in);
            Ctrl = new ControllerCategorie();
      }
  
      public Categorie SelectCategorie()
      {
          int id;
          Catagorie cat;
        
          System.out.prints("Veuillez saisir l'id de la categorie recherchée : "); 
          id = scan.nextInt();
        
          cat = Ctrl.getCategoryById(id);
        
          return cat;  
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
        
          taille = categories.size();
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
