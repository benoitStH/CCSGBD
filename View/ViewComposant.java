package View;

import Model.Composant;
import ControllerComposant;

public class ViewComposant
{  
    private Scanner scan = new Scanner(System.in);
    private ControllerComposant Ctrl = new ControllerComposant();
  
    public Composant SelectComposant()
    {
          Composant comp;
          int id;
      
          System.out.print("Veuillez saisir l'id du composant recherché : ");
          id = scan.nextInt();
      
          comp = Ctrl.getComposantById(id);
      
          return comp;
      
    }
  
    public void ShowComposantsFrom(List<Composant> composants)
    {
        int taille = composants.size();
        Composant comp;
      
        if(taille == 0)
        {
            System.out.println("Aucun Composant"); 
            return;
        }
      
        System.out.println("Id \t\t Nom");
        for(int i = 0; i < taille; i++)
        {
            comp = composants.get(i);
            System.out.println(comp.getId()+"\t\t"+comp.getNom()); 
        }
    }
  
    public void ShowComposants()
    {
        List<Composant> composants = Ctrl.getAllComposants();
        ShowComposantsFrom(composants);
    }
  
  
}
