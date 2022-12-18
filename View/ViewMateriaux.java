package View;

import Model.Materiaux;
import Controller.ControllerMateriaux;

public class ViewMateriaux
{
      private Scanner scan = new Scanner(System.in);
      private ControllerMateriaux Ctrl = new ControllerMateriaux();
  
      public Materiaux SelectMateriaux()
      {
          int id;
          Materiaux mat;
        
          System.out.print("Veuillez saisir l'id du matériel recherché : "); 
          id = scan.nextInt();
        
          mat = Ctrl.getMateriauxById(id);
        
          return mat;
        
      }
  
    public void ShowMateriauxFrom(List<Materiaux> materiaux)
    {
          int taille = materiaux.size();
          Materiaux mat;
      
          if(taille == 0)
          {
              System.out.println("Aucun Materiaux");
              return;
          }
      
          System.out.println("Id \t\t Nom \t\t Substituant");
          for(int i = 0; i < taille; i++)
          {
              // Affichage du materiel
              mat = materiaux.get(i);
              System.out.print(mat.getId()+"\t\t"+mat.getNom()+"\t\t");
              
              // Affichage du materiel substituant 
              mat = mat.getSubstitue();
              if(mat != null)
              {
                  System.out.println(mat.getNom());
              }
              else
              {
                  System.out.println("---"); 
              }
          }
      
    }
  
    public void ShowMateriaux()
    {
        List<Materiaux> materiaux = Ctrl.getAllMateriaux();
        ShowMateriauxFrom(materiaux);
    }
  
  
}
