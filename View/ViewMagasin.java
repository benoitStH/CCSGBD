package View;

import Model.Magasin;
import Controller.ControllerMagasin;
import View.ViewMateriaux;

public class ViewMagasin
{
      private Scanner scan = new Scanner(System.in);
      private ControllerMagasin Ctrl = new ControllerMagasin();
  
      public Magasin SelectMagasin()
      {
            int id;
            Magasin mag;
        
            System.out.print("Veuillez saisir l'id du magasin recherché : ");
            id = scan.nextId();
        
            mag = Ctrl.getMagasinById(id);
        
            return mag;
      }
  
      public void ShowMagasinsFrom(List<Magasin> magasins)
      {
            int taille;
            Magasin mag;
        
            if(magasins == null)
            {
                System.out.println("Aucun Magasin");
                return;
            }
        
            taille = magasins.size();
            if(taille == 0)
            {
                System.out.println("Aucun Magasin");
                return;
            }
        
          System.out.println("Id \t\t Nom");
          for(int i = 0; i < taille; i ++)
          {
                mag = magasins.get(i);
                System.out.println(mag.getId()+"\t\t"+mag.getNom());
          }
      }
  
      public void ShowMagasins()
      {
          ShowMagasinsFrom(Ctrl.getAllMagasins()); 
      }
  
      public void InspectMagasin(Magasin magasin)
      {
          int choix = -1;
          ViewMateriaux materiauxView = new ViewMateriaux();
        
          while(choix != 0)
				  {
					    System.out.println("1 - Afficher la quantité disponible en stock d'un matériel");
					    System.out.println("0 - Retourner à la page précedente");
					
					    System.out.print("Veuillez choisir une option : ");
					    choix = scan.nextInt();
            
              if(choix == 1)
              {
                    ShowStock(magasin, materiauxView.SelectMateriaux());
              }
				  } 
      }
  
      private void ShowStock(Magasin magasin, Materiaux mat)
      {
          boolean trouve = FindMateriaux(magasin, mat);
        
          if(trouve == false)
          {
              System.out.println("Le magasin ne possède pas ce matériel en stock"); 
          }
          else
          {
              System.out.println("La quantité en stock est : "+magasin.getStock().get(i));
          }
      }
  
      private boolean FindMateriaux(Magasin magasin, Materiaux mat)
      {
          int taille;
          int i;
          boolean trouve = false;
        
          if(magasin.getMateriaux() == null)
          {
              System.out.println("Le magasin ne possède aucun materiaux en stock");
              return false;
          }
          
          // Recherche du matériel dans le stock
          taille = magasin.getMateriaux().size();
          for(i = 0; i < taille && trouve == false; i++)
          {
               if(mat.getId() == magasin.getMateriaux().get(i).getId())
               {
                    trouve = true;
               }
          }
        
          return trouve;
      }
  
}
