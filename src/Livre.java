/**
	*@author Bernard VONG et Albert NGUYEN
	*
	*La classe Livre est la réprésentation d'un livre
*/

import java.util.*;

public class Livre
{
	private String titre;
	private String auteur;
	private String editeur;
	private int annee;
	private ArrayList<Edition> editions;
	private Genre genre;
	public ArrayList<Commentaire> commentaires;
	 
	/**
		*Constructeur par défaut
	*/
	public Livre()
	{
	this.titre="";
	this.auteur="";
	this.editeur="";
	this.annee=-1;
	this.editions = new ArrayList<Edition>();
	this.genre = new Genre();
	this.commentaires = new ArrayList<Commentaire>();
	}
	
	/**
		*Constructeur champs a champs
		*
		*@param titre
		*	Titre du livre
		*@param auteur
		*	Auteur du livre
		*@param editeur
		*	Editeur du livre
		*@param annee
		*	Année de parution
		*@param editions
		*	Une liste d'édition
		*@param genre
		*	Genre du livre
		*@param commentaires
		*	Liste de commentaire
	*/
	public Livre(String titre, String auteur, String editeur, int annee, ArrayList <Edition> editions, Genre genre, ArrayList<Commentaire> commentaires)
	{
	this.titre = titre;
	this.auteur = auteur;
	this.editeur = editeur;
	this.annee = annee;
	this.editions = new ArrayList<Edition>();
	for(int i = 0; i<editions.size(); i++)
		this.editions.set(i,editions.get(i));
	this.genre = genre;
	this.commentaires = new ArrayList<Commentaire>();
	for(int i = 0; i<commentaires.size(); i++)
		this.commentaires.set(i,commentaires.get(i));
	}

	/**
		*Constructeur par copie
		*
		*@param livrecopier
		*	Livre a copier
	*/
	public Livre(Livre livrecopier)
	{
		this.titre = livrecopier.titre;
		this.auteur = livrecopier.auteur;
		this.editeur = livrecopier.editeur;
		this.annee = livrecopier.annee;
		this.editions = new ArrayList<Edition>();
		for(int i = 0; i<livrecopier.editions.size(); i++)
			this.editions.set(i, livrecopier.editions.get(i));
		this.genre = livrecopier.genre;
		this.commentaires = new ArrayList<Commentaire>();
		for(int i = 0; i<livrecopier.commentaires.size(); i++)
			this.commentaires.set(i, livrecopier.commentaires.get(i));
	}

	/**
		*Methode d'accès
		*
		*@return Titre du livre
	*/
	public String getTitre()
	{
		return this.titre;
	}
	
	/**
		*Methode d'accès
		*
		*@return l'auteur du livre
	*/
	public String getAuteur()
	{
		return this.auteur;
	}
	
	/**
		*Methode d'accès
		*
		*@return Editeur du livre
	*/
	public String getEditeur()
	{
		return this.editeur;
	}

	/**
		*Méthode d'accès
		*
		*@return La liste d'édition
	*/
	public ArrayList<Edition> getEditions()
	{
		return this.editions;
	}

	/**
		*Méthode d'accès
		*
		*@return l'année de parution
	*/
	public int getAnnee()
	{
		return this.annee;
	}

	/**
		*Méthode d'accès
		*
		*@return La liste d'édition
	*/
	public String getGenre()
	{
		return this.genre.getGenre();
	}
	
	/**
		*Méthode d'accès
		*
		*@return La liste de commentaire
	*/
	public ArrayList<Commentaire> getCommentaires()
	{
		return this.commentaires;
	}
	
	/**
		*Méthode d'écriture
		*
		*@param titre
		*	Titre du livre
	*/
	public void setTitre(String titre)
	{
		this.titre = titre;
	}

	/**
		*Méthode d'écriture
		*
		*@param auteur
		*	Auteur du livre
	*/
	public void setAuteur(String auteur)
	{
		this.auteur = auteur;
	}

	/**
		*Méthode d'écriture
		*
		*@param editeur
		*	Editeur du livre
	*/
	public void setEditeur(String editeur)
	{
		this.editeur = editeur;
	}

	/**
		*Méthode d'écriture
		*
		*@param annee
		*	Année de parution
	*/
	public void setAnnee(int annee )
	{
		this.annee = annee;
	}

	/**
		*Méthode d'écriture
		*
		*@param editions	
		*	Une liste d'edition 
	*/
	public void setEditions(ArrayList<Edition> editions)
	{
		for(int i = 0; i<editions.size() ; i++)
			this.editions.set(i,editions.get(i));
	}

	/**
		*Méthode d'écriture
		*
		*@param genre
		*	Genre du livre
	*/
	public void setGenre(String genre)
	{
		this.genre.setGenre(genre);
	}
	
	/**
		*Méthode d'écriture
		*
		*@param commentaires
		*	Une liste de commentaires
	*/
	public void setCommentaires(ArrayList<Commentaire> commentaires)
	{
		for(int i = 0; i<commentaires.size() ; i++)
			this.commentaires.set(i,commentaires.get(i));
	}

	/**
		*Initialisation interactive avec l'utilisateur
	*/
	public void init()
	{
		boolean test = true;
		int nombreEdition = 0;
		Scanner saisie = new Scanner(System.in);
		do
		{
			System.out.println("\nSaisir le titre:");
			this.titre = saisie.nextLine();
		} while(this.titre.length()==0);
	
		do
		{
			System.out.println("\nSaisir auteur:");
			this.auteur = saisie.nextLine();
		} while(this.auteur.length()==0);
	
		do
		{
			System.out.println("\nSaisir editeur:");
			this.editeur = saisie.nextLine();
		} while(this.editeur.length()==0);

		do
		{
			System.out.println("\nSaisir l'annee:");
			String testannee = saisie.nextLine();
			try
			{
				this.annee = Integer.parseInt(testannee);
				if(this.annee>0)
				{test=false;}
			}
			catch( NumberFormatException e)
			{
				System.out.println(e);
				test=true;

			}
		} while(test==true);

		do
		{
			System.out.println("\nSaisir le nombre d'edition: ");
			String testnbed = saisie.nextLine();
			try
			{
				nombreEdition= Integer.parseInt(testnbed);
				test=false;
			}
			catch( NumberFormatException e)
			{
				System.out.println(e);
				test=true;
			}
		}while(test==true);

		for(int i = 0; i<nombreEdition ; i++)
		{
			int y=i+1;
			System.out.println("\nEdition numéros "+y+":");
			this.editions.add(new Edition());
			this.editions.get(i).init();
		}

		this.genre.init();
	}

	/**
		*Affichage d'un livre
		*
		*@return Chaine de caractère qui represente le livre
	*/
	public String toString()
	{
		String affichage = "\n| Titre: "+this.titre+"\n";
		affichage+="| Auteur: "+this.auteur+"\n";
		affichage+="| Editeur: "+this.editeur+"\n";
		affichage+="| Annee: "+this.annee+"\n";
		affichage+=this.genre.toString();
		affichage+="\n\nLes editions du livre sont:\n";
		for(int i = 0;i<editions.size();i++)
			affichage+=editions.get(i).toString();
		if(this.commentaires.size()!=0)
		{
			affichage+="\nLes commentaires du livre sont:\n";
			for(int y = 0; y<this.commentaires.size();y++)
				affichage+=this.commentaires.get(y)+"\n\n";
		}
		else
			affichage+="\nIl n'y a pas de commentaires sur ce livre.";
		return affichage;
	}

	/**
		*Methode qui permet l'ajout d'une Edition dans la liste editions
		*
		*@param nom
		*	Nom de l'édition a ajouter
		*@param numISBN
		*	Numéros ISBN de l'édition a ajouter
	*/
	public void addEdition(String nom, String numISBN)
	{
		Edition ajouter = new Edition(nom, numISBN);
		this.editions.add(ajouter);
	}
	
	/**
		*Méthode pour saisir les différentes informations d'un livre
	*/
	public void saisieInfoLivre()
		{
			boolean test = true;
		int nombreEdition=0;
		Scanner saisie = new Scanner(System.in);
		System.out.println("\nSaisir le titre:");
		this.titre = saisie.nextLine();
		System.out.println("\nSaisir auteur:");
		this.auteur = saisie.nextLine();
		System.out.println("\nSaisir editeur:");
		this.editeur = saisie.nextLine();
		while(test==true)
		{
		System.out.println("\nSaisir l'annee:");
		String testannee = saisie.nextLine();
		try{
		if(testannee.length()==0)
			this.annee=-1;
		else{
		this.annee = Integer.parseInt(testannee);}
		test=false;
		}
		catch( NumberFormatException e){
			System.out.println(e);
			}
		}
		System.out.println("\nSaisir l'edition recherché: ");
		this.editions.add(new Edition());
		this.editions.get(0).init();
		this.genre.initRecherche();
		}
		
	/**
		*Méthode pour saisir exactement 3 informations sur un livre
	*/
	public void saisie3Info()
		{
		boolean test=true;
		Scanner saisie = new Scanner(System.in);
		while(this.titre.length()==0)
		{
		System.out.println("\nSaisir le titre recherché:");
		this.titre = saisie.nextLine();
		}
		while(test==true)
		{
		System.out.println("\nSaisir l'annee:");
		String testannee = saisie.nextLine();
		try{
		this.annee = Integer.parseInt(testannee);
		if(this.annee>0)
		{test=false;}
		}
		catch( NumberFormatException e){
			System.out.println(e);
		}
		}
		System.out.println("\nEdition recherché...");
		this.editions.add(new Edition());
		this.editions.get(this.editions.size()-1).init();
		this.auteur = "";
		this.editeur = "";
		}
}

		
	
