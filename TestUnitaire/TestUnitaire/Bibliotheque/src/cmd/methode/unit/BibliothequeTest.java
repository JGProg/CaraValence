package cmd.methode.unit;

import junit.framework.TestCase;

public class BibliothequeTest extends TestCase
{
	public void testSub()
	{
		Bibliotheque b = new Bibliotheque();
		ajoutAdherent("bouya","chaka", b);
		ajoutAdherent("j","l", b);

		ajoutDocumentBD("1254115", "Bouyachaka", "bouya", b);
		ajoutDocumentLivre("12541215", "Bouyachaka", b);
		ajoutDocumentLivre("125viv41215", "Bouyvjfachaka", b);

		supprimerAdherent("bouya","chaka", b);
		//Emprunt("125viv41215", "bouya" , "chaka", b); 

		b.afficherTousLesDocuments();
		b.afficherTousLesAdherents();

		//ListEmprunt("jh", "l", b);

	}

	public void ajoutAdherent(String nom, String prenom, Bibliotheque b)
	{
		assertTrue(b.ajouterbibliothequeAdherent(nom, prenom));
	}

	public void ajoutDocumentBD(String ISBN, String nom, String Nomdessinateur, Bibliotheque b)
	{
		assertTrue(b.ajouterbibliothequeDocument(ISBN, nom, Nomdessinateur));	
	}

	public void ajoutDocumentLivre(String ISBN, String nom, Bibliotheque b)
	{
		assertTrue(b.ajouterbibliothequeDocument(ISBN, nom));
	}

	public void supprimerAdherent(String nom, String prenom, Bibliotheque b)
	{
		assertTrue(b.supprimer(nom,prenom));
	}

	public void Emprunt(String isbn , String nom , String prenom, Bibliotheque b)
	{
		assertTrue(b.Emprunt(isbn, nom ,  prenom, b));
	}

	public void ListEmprunt(String nom, String prenom, Bibliotheque b)
	{
		assertTrue(b.ListEmprunt(nom, prenom));
	}

	public void ListEmprunt(String isbn, String nom, String prenom, Bibliotheque b)
	{
		assertTrue(b.ListEmprunt(isbn,nom, prenom));
	}
}