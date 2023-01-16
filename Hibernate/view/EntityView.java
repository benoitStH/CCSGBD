package view;

import java.util.Scanner;

import controller.ControllerEntity;

public abstract class EntityView implements InterfaceView {

	private Scanner scan;
	
	public EntityView()
	{
		scan = new Scanner(System.in);
	}
	
	public EntityView(ControllerEntity controller)
	{
		scan = new Scanner(System.in);
		setController(controller);
	}
	
	public String getInputString(String prompt)
	{
		String input;
		
		Ask(prompt);
		input = scan.next();
		
		return input;
	}
	
	public int getInputUntilPositiveInt(String prompt)
	{
		Integer valeur;
		
		do
		{
			valeur = getInputInt(prompt);
			if (valeur == null)
			{
				System.out.println("Veuillez saisir un nombre positif");
			}
			else if (valeur < 0)
			{
				System.out.println("Veuillez saisir un nombre positif");
				valeur = null;
			}
			
		}while(valeur == null);
		
		
		return valeur;
	}
	
	public Integer getInputInt(String prompt)
	{
		Integer valeur;
		
		Ask(prompt);
		
		if(scan.hasNextInt())
		{
			valeur = scan.nextInt();
			return valeur;
		}
		else
		{
			return null;
		}
	}
	
	private void Ask(String prompt)
	{
		if(prompt != null)
		{
			System.out.print(prompt);
		}
	}
	
	abstract public void setController(ControllerEntity controller);
}
