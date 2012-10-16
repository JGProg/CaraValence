package cmd.methode.unit;

import java.util.ArrayList;

public class Adherent
{
    private String nom;
    private String prenom;
    private ArrayList<Document> docEmprunt;
    
    public final static int MAX_DOCUMENTS_EMPRUNT = 100;
    
    /**7
     * Un adhérent est constitué d'un nom est d'un prénom
     * @param Saisie_nom
     * @param Saisie_prenom
     */
    public  Adherent(String Saisie_nom, String Saisie_prenom)
    {
	this.nom = Saisie_nom;
	this.prenom = Saisie_prenom;
	this.docEmprunt = new ArrayList<Document>();
    }
    

    
    public boolean rechercherDocumentEmprunt(String isbn)
    {
	int i = 0;
	boolean bool = false;
	
	while(i < docEmprunt.size())
	{
	    Document doc = docEmprunt.get(i);
	    if(doc.getIsbn() == isbn)
	    {
		break;
	    }
	    i++;
	}
	
	if(i == docEmprunt.size())
	{
	    bool = false;
	}
	else
	{
	    bool = true;
	}
	return bool;
    }
    
    public boolean rechercherDocumentEmprunt()
    {
	boolean nonEmprunt = false;
	for(Document doc : docEmprunt)
	{
	    System.out.println("\n---------Liste des documents empruntés par " + this.nom + " " + this.prenom);
	    System.out.println(doc);
	    nonEmprunt = true;
	}
	return nonEmprunt;

    }
    
    public boolean setDocEmprunt(String isbn, Bibliotheque b)
    {
	Document doc = b.rechercherDocument(isbn);
        return docEmprunt.add(doc);
    }


    public int getNbDocEmprunt()
    {
        return this.docEmprunt.size();
    }

    public static int getMaxDocumentsEmprunt()
    {
        return MAX_DOCUMENTS_EMPRUNT;
    }

    public String getNom()
    {
        return this.nom;
    }

    public String getPrenom()
    {
        return this.prenom;
    }

    public boolean equals(Object obj)
    {
	if(obj == null) return false;
	if(!(obj instanceof Adherent)) return false;
	Adherent ad = (Adherent) obj;
	if(!(ad.nom.equals(this.nom))) return false;
	return ad.prenom.equals(this.prenom);
    }

    @Override
    public String toString()
    {
	return "Adherent [nom=" + nom + ", prenom=" + prenom + ", docEmprunt="
		+ docEmprunt + "]";
    }    
}
