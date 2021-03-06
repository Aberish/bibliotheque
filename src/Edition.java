/**
	*
	*@author Bernard VONG et Albert NGUYEN
	*
	*La classe Edition représente l'édition d'un livre
	*
*/

import java.util.Scanner;

public class Edition
{
	private String nom;
	private String numISBN;

	/**
		*Constructeur par défaut
	*/
	public Edition()
	{
		this.nom = "none";
		this.numISBN= "0";
	}

	/**
		*Constructeur champs a champs
		*
		*@param nom
		*	Nom de l'édition
		*@param numISBN
		*	Numéros ISBN du livre associé a l'édition
	*/
	public Edition(String nom, String numISBN)
	{ 
		this.nom = nom;
		this.numISBN = numISBN;
	}
	
	/**
		*Constructeur par copie
		*
		*@param edi
		*	Edition a copier
	*/
	public Edition(Edition edi)
	{
		this.nom = edi.nom;
		this.numISBN = edi.numISBN;
	}

	/**
		*Methode d'accès
		*
		*@return Nom de l'édition
	*/
	public String getNom()
	{
		return this.nom;
	}

	/**
		*Méthode d'écriture
		*
		*@param nom
		*	Nom de l'édition
	*/
	public void setNom(String nom)
	{
		this.nom = nom;
	}

	/**
		*Méthode d'accès
		*
		*@return Numéros ISBN de l'édition associé au livre
	*/
	public String getNumISBN()
	{
		return this.numISBN;
	}

	/**
		*Méthode d'écriture
		*
		*@param numISBN
			Numéros ISBN de l'édition associé au livre
	*/
	public void setNumISBN(String numISBN)
	{
		this.numISBN = numISBN;
	}

	/**
		*Initialision intéractive avec l'utilisateur
	*/
	public void init()
	{
		Scanner saisie = new Scanner(System.in);
		System.out.println("\nSaisir le nom de l'edition:");
		this.nom = saisie.nextLine();
		System.out.println("\nSaisir le numeros ISBN:");
		this.numISBN = saisie.nextLine();
	}

	/**
		*Affichage de l'édition
		*
		*@return Chaine de caractère à afficher
	*/
	public String toString()
	{
		String affichage = "| Edition: "+this.nom+"\n";
		affichage = affichage + "| Numéros ISBN: "+this.numISBN+"\n";
		return affichage;
	}
		
}
