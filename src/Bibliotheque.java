import java.util.*;

public class Bibliotheque implements GestionBibliotheque
	{
	private ArrayList<Livre> biblio;
	/**
	 * Les constructeurs
	 */
	/**
	 * Constructeur par defaut
	 *
	 */
	public Bibliotheque(){
		this.biblio = new ArrayList<Livre>();
		}
	/**
	 * Constructeur d'initialisation de champ à champ
	 *@param liste
	 *		liste de livre
	 */
	public Bibliotheque(ArrayList<Livre> liste){
		this.biblio = new ArrayList<Livre>();
		for(int i = 0; i<liste.size(); i++)
			this.biblio.add(liste.get(i));
	}
	/**
	 * Affiche les livres correspondants aux informations saisie par l'utilisateur.

	 */
	public void rechercherLivre()
	{
		
		Livre l = new Livre();
		l.saisieInfoLivre();
		ArrayList<Livre> livres = new ArrayList<Livre>();	
		for(int i = 0; i<biblio.size(); i++)
			livres.add(biblio.get(i));
		if(l.getTitre().length()!=0)
		{
			for(int i=0;i<livres.size();i++)
			{
				if(!(l.getTitre().equals(livres.get(i).getTitre())))
				{
					livres.remove(livres.get(i));					
				}
			}
		}
		if(l.getAuteur().length()!=0)
		{
			for(int i=0;i<livres.size();i++)
			{
				if(!(l.getAuteur().equals(livres.get(i).getAuteur())))
				{
					livres.remove(livres.get(i));
				}
			}
		}
		if(l.getAnnee()!=-1)
		{
			for(int i=0;i<livres.size();i++)
			{
				if(l.getAnnee()!=livres.get(i).getAnnee())
				{
					livres.remove(livres.get(i));
				}
			}
		}
		if(l.getEditeur().length()!=0)
		{
			for(int i=0;i<livres.size();i++)
			{
				if(!(l.getEditeur().equals(livres.get(i).getEditeur())))
				{
					livres.remove(livres.get(i));
				}
			}
		}
		if(l.getGenre().length()!=0)
		{
			for(int i=0;i<livres.size();i++)
			{
				if(!(l.getGenre().equals(livres.get(i).getGenre())))
				{
					livres.remove(livres.get(i));
				}
			}
		}
		if(l.getEditions().get(0).getNom().length()!=0)
		{
			for(int i=0;i<livres.size();i++)
			{
				int test=0;
				for(int j=0;j<(livres.get(i).getEditions().size());j++)
					{
					if(l.getEditions().get(0).getNom().equals(livres.get(i).getEditions().get(j).getNom()))
					{
					test=1;
					}
					}
				if(	test==0)
					{
					livres.remove(livres.get(i));
					}
			}
		}
		
		if(l.getEditions().get(0).getNumISBN().length()!=0)
		{
			for(int i=0;i<livres.size();i++)
			{
				int test=0;
				for(int j=0;j<(livres.get(i).getEditions().size());j++)
				{
					if(l.getEditions().get(0).getNumISBN().equals(livres.get(i).getEditions().get(j).getNumISBN()))
						test=1;
				}
				if(test==0)
					livres.remove(livres.get(i));
			}
		}
		if(livres.size()==0)
			System.out.println("Le livre recherché n'a pas été trouvé");
		for(int i=0;i<livres.size();i++)
			System.out.println(livres.get(i));
	}
	/**
	 * Recherche rapide de livre selon trois critères. Retourne la valeur 0 si le livre n'existe pas, retourne la valeur 1
	 * si l'édition n'existe pas mais le livre existe et  retourne 2 si le livre et l'édition existe déjà.
	 * @return 0, 1 ou 2 
	 */
	public int rechercheLivre()
	{
		Livre l = new Livre();
		l.saisie3Info();
		ArrayList<Livre> livres = new ArrayList<Livre>();	
		for(int i = 0; i<this.biblio.size(); i++)
			livres.add(this.biblio.get(i));
		for(int a=0;a<livres.size();a++)
			{
				if(!(l.getTitre().equals(livres.get(a).getTitre())) || l.getAnnee()!=livres.get(a).getAnnee())
				{
					livres.remove(livres.get(a));
				}
			}
		if(livres.size()==0)
			{
			return 0;
			}
		System.out.println(livres);
		for(int j=0;j<livres.get(0).getEditions().size();j++)
				{
				String numISBN =livres.get(0).getEditions().get(j).getNumISBN();
				String num=l.getEditions().get(0).getNumISBN();
				if(num.equals(numISBN))
					{
					return 2;
					}
				}
		int indice= this.biblio.indexOf(livres.get(0));
		Scanner saisie = new Scanner(System.in);
		System.out.println("\nSaisir le nom de l'édition a ajouter au livre:\n");
		String nom = saisie.nextLine();
		this.biblio.get(indice).addEdition(nom, l.getEditions().get(0).getNumISBN());	
		return 1;
	}		
	/**
	 * La methode ajouterLivre :
	 * Si rechercheLivre retourne 0, la methode envoie que le livre n'existe pas et demande l'ajout du livre.
	 * Si rechercheLivre retourne 1, la methode envoie que l'édition a été ajouté.
	 * Et si rechercheLivre retourne 2, la methode envoie que le livre et l'édition sont déjà existants.
	 * 
	 */
	public void ajouterLivre()
	{
		System.out.println("Nous allons rechercher si le livre éxiste dans notre bibliothèque:");
		int i = this.rechercheLivre();
		if( i == 0)
		{
			System.out.println("\nLe livre n'éxiste pas. Veuillez saisir les informations pour creer le livre:");
			Livre l = new Livre();
			l.init();
			biblio.add(l);
			System.out.println("Le livre a été ajouté");
		}
		else if( i == 1)
			System.out.println("L'édition a été ajouté");
		else 
			System.out.println("Le livre existe déjà");
	}
	/**
	 * La methode demande quel est le livre a commenter si le livre n'existe pas il retourne -1, 
	 *sinon elle demande de saisir un commentaire et une note et retourne l'indice du livre.
	 */
	public int CommenterLivre()
	{
		Scanner saisie = new Scanner(System.in);
		String livre, auteur;
		System.out.println("Quel livre commenter?");
		livre = saisie.nextLine();
		System.out.println("Saisir son auteur:");
		auteur = saisie.nextLine();
		Commentaire commentaire;
		commentaire = new Commentaire();
		for(int i=0;i<this.biblio.size();i++)
		{
			if(livre.equals(this.biblio.get(i).getTitre()) && auteur.equals(this.biblio.get(i).getAuteur()))
			{
				commentaire.init();
				this.biblio.get(i).commentaires.add(commentaire);
				System.out.println("Le commentaire et la note ont bien été ajouté.");
				return i;
			}
		}
		
		System.out.println("Le livre n'est pas référencé");
		return -1;
		
	}
	/**
	 * La methode analyse le dernier commentaire du livre d'indice i,
	 * elle change analyse du commentaire en false si l'avis est négatif.
	 * @param i
	 *		Indice du livre où est présent le commentaire à analyser
	 * @return avis(true ou false)
	 */
	public boolean analyseSemantique(int i)
	{
		String bon[] ={"bon","interessante","interessant","recommandée","recommandé","captivant","émouvant","émouvante","fabuleux","fabuleuse","belle"};
		String mauvais[] = {"nul","mauvais","decu","déçu","décevant","captivé","lassant","lassante"};
		int positif = 0;
		int negatif = 0;
		boolean avis=true;
		int indice=this.biblio.get(i).getCommentaires().size()-1;
		String[] commentaireCoupe = this.biblio.get(i).getCommentaires().get(indice).getAvis().split("\\s");
		for (int j = 0; j < commentaireCoupe.length; j++)
		{
			for(int y = 0; y<bon.length ; y++)
			{
				if(commentaireCoupe[i].equals(bon[y]))
					positif++;
			}
			for(int y = 0; y<mauvais.length ; y++)
			{
				if(commentaireCoupe[i].equals(mauvais[y]))
					negatif++;
			}
		}
		if(negatif > positif)
			{
			avis=false;
			this.biblio.get(i).getCommentaires().get(indice).setAnalyse(avis);
			}
		return avis;
	}
	/**
		*Affichage de la Bibliothèque
		*
		*@return affichage
	*/
	public String toString()
	{
		if(this.biblio.size()!=0)
		{
			String affichage="\nLa bibliothèque contient les livres suivants:\n";
			for(int i=0;i<this.biblio.size();i++)
			{
				int y = i+1;
				affichage+="\nLe livre #"+y+":"+this.biblio.get(i).toString()+"\n_______________________\n";
			}
			return affichage;
		}
		else
			return "La bibliothèque est vide.";
	}
}
