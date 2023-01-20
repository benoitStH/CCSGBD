package controller;

import model.Composant;
import model.Composition;
import model.Materiaux;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.security.PublicKey;
import java.util.ArrayList;
import java.util.List;

public class ControllerComposant extends ControllerEntity {

    public ControllerComposant() {
        super();
    }

    public ControllerComposant(EntityManager manager) {
        super(manager);
    }

    public List<Composant> GetAll()
    {
        Query query = manager.createQuery("from Composant");
        List<Composant> composants = query.getResultList();
        return composants;
    }

    public Composant FindComposantByName(String name)
    {
        Query query = manager.createQuery("from Composant where nom = '"+ name + "'");
        List<Composant> recherche = query.getResultList();

        if(recherche.isEmpty())
        {
            return null;
        }
        else
        {
            return recherche.get(0);
        }
    }

    public Composant CreateComposant(Composant composant)
    {
        if(composant.getMateriaux() != null )
        {
            for(Materiaux m : composant.getMateriaux())
            {
                Materiaux provisoire = new ControllerMateriaux(manager).FindMateriauxByName(m.getNom());
                if(provisoire == null)
                {
                    return null;
                }
            }

        }

        manager.getTransaction().begin();
        manager.persist(composant);
        manager.getTransaction().commit();

        if(manager.contains(composant))
        {
            return composant;
        }else
        {
            return null;
        }
    }

    public Composant DeleteComposant(Composant composant)
    {
        Composant deletedComposant = FindComposantByName(composant.getNom());
        if(deletedComposant == null)
        {
            return null;
        }
        manager.getTransaction().begin();
        manager.remove(deletedComposant);
        manager.getTransaction().commit();

        if (manager.contains(deletedComposant)) {
            return deletedComposant;
        } else {
            return null;
        }
    }

    public Composant UpdateMateriauxForComposant(Composant composant, List<Materiaux> materiauxListe)
    {
       Composant updatedComposant = FindComposantByName(composant.getNom());
        List<Materiaux> listMateriaux = new ArrayList<>();
        Materiaux mockMateriaux = new Materiaux();

        for(Materiaux m : materiauxListe)
        {
            mockMateriaux = new ControllerMateriaux(manager).FindMateriauxByName(m.getNom());
            if(mockMateriaux == null)
            {
                new ControllerMateriaux(manager).CreateMateriaux(m);
            }
            listMateriaux.add(mockMateriaux);

        }

        updatedComposant.setMateriaux(listMateriaux);


        manager.getTransaction().begin();
        manager.merge(updatedComposant);
        manager.getTransaction().commit();

        if(manager.contains(updatedComposant))
        {
            return updatedComposant;
        }else
        {
            return null;
        }

    }

    public List<Materiaux> MateriauxFromComposant(Composant composant)
    {
        List<Materiaux> materiauxList =new ArrayList<>();
        List<Composition> compositionList =new ArrayList<>();
        Composant mockComposant = FindComposantByName(composant.getNom());
        if(mockComposant == null)
        {
            return null;
        }
        Query query = manager.createQuery("from Composition where composant_id = " + mockComposant.getId());
        compositionList = query.getResultList();



        if(!compositionList.isEmpty())
        {
            for(Composition c : compositionList)
            {
                System.out.println(c.toString());
               materiauxList.add(c.getMateriaux());
            }
        }


        return materiauxList;
    }

}
