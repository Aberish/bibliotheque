/**
	*
	*@author Bernard VONG et Albert NGUYEN
	*
	* La classe Commentaire représente un commentaire
	*
*/
import java.util.Scanner;

public class Commentaire
{

	private String avis;
	private int note;
	private boolean analyse;
	private static final int NOTE_MAX=20;
	private static final int NOTE_MIN=0;

/**
	*
	*Constructeur par défaut
*/
public Commentaire()
{
	this.avis="";
	this.note=10;
	this.analyse=true;
}

/**
	*
	*Constructeur champs a champs
	*@param avis
	*	L'avis de l'utilisateur
	*@param note
	*	La note donnée par l'utilisateur
	*@param analyse
	*	Analyse sémantique effectué par le systême
*/
public Commentaire(String avis, int note, boolean analyse)
{
	this.avis=avis;
	this.note=note;
	this.analyse=analyse;
}

/**
	*
	*Constructeur par copie
	*
	*@param c
	*	Commentaire a copier
*/
public Commentaire(Commentaire c)
{
	this.avis=c.avis;
	this.note=c.note;
	this.analyse=c.analyse;
}

/**
	*Methode d'accès
	*
	*@return L'avis de l'utilisateur
*/
public String getAvis()
{
	return avis;
}

/**
	*Methode d'accès
	*
	*@return la note donnée par l'utilisateur
*/
public int getNote()
{
	return note;
}

/**
	*Methode d'accès
	*
	*@return Résultat de l'analyse sémantique 
*/
public boolean getAnalyse()
{
	return analyse;
}

/**
	*Methode d'écriture de l'avis
	*
	*@param avis
	*	Avis a injecter dans le commentaire
*/
public void setAvis(String avis)
{
	this.avis=avis;
}

/**
	*Methode d'écriture de la note
	*
	*@param note
	*	Note a injecter dans le commentaire
*/
public void setNote(int note)
{
	this.note=note;
}

/**
	*Methode d'écriture de l'analyse
	*
	*@param analyse
	*	Etat de l'analyse sémantique
*/
public void setAnalyse(boolean analyse)
{
	this.analyse=analyse;
}

/**
	*Initialisation interactive avec l'utilisateur
	*
*/
public void init()
{
	boolean test= true;
	Scanner saisie = new Scanner(System.in);
	System.out.println("\nSaisir un commentaire pour le livre:");
	avis = saisie.nextLine();
	while(test==true)
	{
	System.out.println("\nSaisir une note:");
	String notetest = saisie.nextLine();
	try
	{
	note = Integer.parseInt(notetest);
	if(note>=0 && note<=20)
	{test=false;}
	else
		System.out.println("Saisir une note entre 0 et 20");
	}
	catch( NumberFormatException e){
		System.out.println(e);
		}
	}
}

/**
	*Affichage ordonnée d'un commentaire
	*
	*@return Une chaine de caractère a afficher
*/
public String toString()
{
	String i =this.avis +"\nNote: " + this.note;
	if(analyse)
		i+="\nAvis positif.";
	else
		i+="\nAvis négatif.";
	return i;
}

}

