package Dao;

import Model.Categorie;
import Model.Client;
import Model.Commande;
import Model.Magasin;
import utility.Utility;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class ClientDAO extends SuperDAO {

	public ClientDAO() {
		super("client");

	}

	public Client getElementById(int value)
	{
		Client client = null;
		List<Categorie> listCat = new ArrayList<>();
		List<Integer> listSeuilParMagasin = new ArrayList<>();
		int id = 0;
		int idMag = 0;
		String nom = null;
		String prenom = null;
		ResultSet rs = getElementById("idCli",value);
		try
		{

			while(rs.next()) {
				//Recuperation de l'Id, Nom  et du prenom
				id = rs.getInt(1);
				nom = rs.getString(2);
				prenom = rs.getString(3);
			}



		}catch (SQLException e)
		{
			System.out.println("Erreur lors de l'implémentation 1");
		}
		try {
			Statement stmt = Utility.initConnexion().createStatement();
			String sql  ="SELECT * FROM seuil WHERE idcli =" + id  + ";" ;
			ResultSet rSet = stmt.executeQuery(sql);
			while(rSet.next())
			{
				//Ajout du magasin dans l'arbre
				CategorieDAO daoCat = new CategorieDAO();
				listCat.add(daoCat.getElementById(rSet.getInt(1)));

				//Ajout du seuil
				listSeuilParMagasin.add(rSet.getInt(3));
			}
			client=new Client(id,nom,prenom,listSeuilParMagasin,listCat);
		}catch (SQLException e1)
		{
			System.out.println("Erreur lors de l'implémentation 2");
			e1.printStackTrace();
		}

		return client;
	}

	public List<Client> getClients()
	{
		List<Client> listCli = new ArrayList<>();
		try{
			Statement stmt = Utility.initConnexion().createStatement();
			String sql = "SELECT * FROM client";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				listCli.add(getElementById(rs.getInt(1)));
			}
		}catch(SQLException sqlE)
		{

		}

		return listCli;
	}

	public void AddClientToMagasin(Client client, Magasin magasin)
	{
		try {
			Statement sClient = Utility.initConnexion().createStatement();
			//Ajout Client
			String sql = "INSERT INTO client (idCli, nom, prenom, idMag) VALUES ( "+ client.getId() +",'" +  client.getNom() + "','" + client.getPrenom() + "'," + magasin.getId() + ");";
			sClient.executeUpdate(sql);
			//Ajout Seuil
			for(int i = 0; i< client.getSeuilMax().size();i++)
			{

				sql = "INSERT INTO seuil (idCat, idCli, quantiteMax) VALUES ("+ client.getListCat().get(i).getId() +"," + client.getId()+ ","+ client.getSeuilMax().get(i) +");";
				sClient.executeUpdate(sql);
			}

		} catch (SQLException e) {
			System.out.println("Erreur l'hors de l'ajout ");
			e.printStackTrace();
		}
	}

	public List<Client> getClientsOf(Magasin magasin) {

		List<Client> listCli = new ArrayList<>();
		try {
			Statement stmt = Utility.initConnexion().createStatement();
			String sql = "SELECT idCli FROM client WHERE idMag = " + magasin.getId()+";";
			ResultSet rs = stmt.executeQuery(sql);
			while(rs.next())
			{
				int idcli = rs.getInt(1);
				listCli.add((getElementById(idcli)));
			}

		}catch(SQLException e)
		{
			e.printStackTrace();
			System.out.println("Erreur lors de la récupération des clients");
		}


		return listCli;
	}
}