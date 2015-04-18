/**
	*
	*@author Bernard VONG et Albert NGUYEN
	*
	*La classe Genre permet de définir quel thème le livre aborde
	*
*/


import java.util.Scanner;

public class Genre
{
	public static final String[] Tabgenres ={"Autobiographie",
	"Biographie", "Contes", "Enfants", "Fable", "Fantastique",
	"Horreur", "Nouvelle", "Policier", "Recueil",
	"Roman", "Science-Fiction"};
	private String genre;
	
	/**
		*Constructeur par défaut
	*/
	public Genre()
	{
		this.genre="Non défini";
	}
	
	/**
		*Constructeur champs à champs
		*
		*@param genre
		*	genre du Livre
	*/
	public Genre(String genre)
	{
		this.genre = genre;
	}
	/**
		*Méthode d'accès
		*
		*@return Genre du livre
	*/
	public String getGenre()
	{
		return this.genre;
	}

	/**
		*Méthode d'écriture
		*@param genre
		*	Genre à injecter
	*/
	public void setGenre(String genre)
	{
		this.genre = genre;
	}
	/**
	* @return Existance du genre
	*/
	private boolean estDansGenre()
	{
		boolean test = false;
		String g = this.genre.trim();
		for(int i=0;i<(Tabgenres.length);i++)
			{
			if(g.equals(Tabgenres[i]))
				{
				test=true;
				}
			}
		return test;
	}
	/**
		*Initialisation intéractive avec l'utilisateur
	*/
	public void init()
	{
		Scanner saisie = new Scanner(System.in);
		this.genre="";
		System.out.println("\nSaisir le genre du livre:");
		this.genre = saisie.nextLine();
		while(this.genre.length()==0 || this.estDansGenre()==false)
		{
		System.out.println("\nVeillez saisir un de ces genres:");
		afficherTabGenres();
		this.genre = saisie.nextLine();
		}
	}
	/**
	*	Methode pour saisir le genre recherché
	*/
	public void initRecherche(){
		Scanner saisie = new Scanner(System.in);
		this.genre="";
		System.out.println("\nSaisir le genre du livre Recherché:");
		this.genre = saisie.nextLine();
		}
	/**
	* methode privée permettant d'afficher le tableau des genres
	*/
	private void afficherTabGenres()
		{
		String affiche="";
		for(int i=0;i<(Tabgenres.length);i++)
		{ affiche+=Tabgenres[i]+" | ";
		}
		System.out.println(affiche);
		}
	/**
		*Affichage réprésentatif d'un Genre
		*
		*@return Chaine de caractère qui caractérise l'objet courant, de classe Genre
	*/
	public String toString()
	{
		String affichage = "| Genre: "+this.genre+"\n";
		return affichage;
	}

}
