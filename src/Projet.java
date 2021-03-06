
import java.util.*;

public class Projet
{
	public static void main(String[]arg)
	{	
		Scanner saisie = new Scanner(System.in);
		int programme = 1, choix1;

		Bibliotheque test = new Bibliotheque();
		System.out.println("\n\n--- Bienvenue ---\n");
		while(programme == 1)
		{
			System.out.println(" _________________________");
			System.out.println("|                         |");
			System.out.println("| 1 - Ajouter un livre    |");
			System.out.println("| 2 - Afficher les livres |");
			System.out.println("| 3 - Rechercher un livre |");
			System.out.println("| 4 - Commenter un livre  |");
			System.out.println("| 5 - Quitter             |");
			System.out.println("|_________________________|");
			System.out.println("\nVotre choix: ");
			choix1 = saisie.nextInt();
			
			if(choix1 == 1)
			{
				test.ajouterLivre();
			}
			else if(choix1 == 2)
			{
				System.out.println("\n"+test);
			}
			else if(choix1 == 3)
			{
				test.rechercherLivre();
			}
			else if(choix1 == 4)
			{
				int livreCommente = test.CommenterLivre();
				if(livreCommente!=-1)
				{test.analyseSemantique(livreCommente);}
			}
			else if(choix1 == 5)
			{
				System.out.println("Fermeture de l'application...");
				programme = 0;
			}
			
		}
		
	}
}
