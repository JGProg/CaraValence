package cmd.methode.unit;

import java.util.ArrayList;


/**
 * @author AMCCS5V5.5
 *
 */
public class Bibliotheque
{
    private ArrayList<Document> document;
    private ArrayList<Adherent> adherent;
    
    public final static int MAX_DOCUMENTS = 100;
    public final static int MAX_ADHERENT = 100;

    /**
     *  La bibliotheque est constitué de documents et de livres
     */
    public Bibliotheque()
    {
	this.document = new ArrayList<Document>();
	this.adherent = new ArrayList<Adherent>();
    }
    
    /**
     * @param isbn
     * @param nom
     * @param prenom
     * @param Bibliothèque
     * @return Vrai si l'emprunt a peu avoir lieu
     */
    public boolean Emprunt(String isbn , String nom , String prenom, Bibliotheque b)
    {	
	boolean emprunte = false;
	DocumentLivre docEmprunt = (DocumentLivre) this.rechercherDocument(isbn);
	Adherent ad = this.rechercherAdherent(nom, prenom);
	if(Adherent.getMaxDocumentsEmprunt() != ad.getNbDocEmprunt() && docEmprunt.isEmprunt() == false)
	{
	    emprunte = ad.setDocEmprunt(isbn, b);
	    docEmprunt.setEmprunt(true);
	}
	return emprunte;
    }
    
    /**
     * @param isbn
     * @param nom
     * @param prenom
     * @return vrai si le document a été emprunté par l'adhérent
     */
    public boolean ListEmprunt(String isbn, String nom , String prenom)
    {
	Adherent ad = this.rechercherAdherent(nom, prenom);
	return ad.rechercherDocumentEmprunt(isbn);
    }
    
    /**
     * @param nom
     * @param prenom
     * @return vrai si au moins un document a été emprunté par l'adhérent
     */
    public boolean ListEmprunt(String nom , String prenom)
    {
	Adherent ad = this.rechercherAdherent(nom, prenom);
	return ad.rechercherDocumentEmprunt();
    }
    
    /**
     * @param nom
     * @param prenom
     * @return Vrai si l'ajout de l'adhérent à pu avoir lieu
     */
    public boolean ajouterbibliothequeAdherent(String nom, String prenom)
    {	
	boolean ajouter = false;
	Adherent adherentAjout = new Adherent(nom, prenom);
	if(this.adherent.size() != MAX_ADHERENT && rechercherAdherentBool(nom, prenom) == false )
	    ajouter = this.adherent.add(adherentAjout);
	return ajouter;
    }
    
    /**
     * @param ISBN
     * @param nom
     * @param Nomdessinateur
     * @return Vrai si l'ajout de la BD à pu avoir lieu
     */
    public boolean ajouterbibliothequeDocument(String ISBN, String nom, String Nomdessinateur)
    {	
	boolean ajouter = false;
	DocumentBD doc = new DocumentBD(ISBN, nom, Nomdessinateur);
	if(this.document.size() != MAX_DOCUMENTS && this.rechercherDocumentBool(doc.getIsbn()) == false)
	    ajouter = this.document.add(doc);
	return ajouter;
    }
    
    
    /**
     * @param ISBN
     * @param nom
     * @return Vrai si l'ajout du livre à pu avoir lieu
     */
    public boolean ajouterbibliothequeDocument(String ISBN, String nom)
    {	
	boolean ajouter = false;
	DocumentLivre doc = new DocumentLivre(ISBN, nom);
	if(this.document.size() != MAX_DOCUMENTS && this.rechercherDocumentBool(doc.getIsbn()) == false)
	    ajouter = this.document.add(doc);
	return ajouter;
    }
    
    /**
     * @param nom
     * @param prenom
     * @return Vrai si l'ajout de l'adhérent à pu avoir lieula suppression de l'adhérent à pu avoir lieu
     */
    public boolean supprimer(String nom, String prenom)
    {	
	boolean supprimer = false;
	Adherent ad = rechercherAdherent(nom, prenom);
	if(ad != null)
	{
	    supprimer = this.adherent.remove(ad);
	}
	return supprimer;
	
    }
 
    /**
     * @param nom
     * @param prenom
     * @return Adhérent
     */
    public Adherent rechercherAdherent(String nom, String prenom)
    {
	int i = 0;
	Adherent adreturn = null;
	Adherent Recherche = null;
	while(i < this.adherent.size())
	{
	    Recherche = adherent.get(i);
	    if(Recherche.getNom() == nom)
	    {
		if(Recherche.getPrenom() == prenom)
		{
		    adreturn = Recherche;
		    break;
		}
	    }
	    i++;
	}
	return adreturn;
    }
    
    /**
     * @param nom
     * @param prenom
     * @return Vrai si l'adhérent a été trouvé
     */
    public boolean rechercherAdherentBool(String nom, String prenom)
    {
	boolean bool = false;
	if(rechercherAdherent(nom, prenom) != null)
	{
	    bool = true;
	}
	else
	{
	    bool = false;
	}
	return bool;
    }
    

    /**
     * @param isbn
     * @return Document
     */
    public Document rechercherDocument(String isbn)
    {
	int i = 0;
	Document docReturn = null;
	Document docRecherche = null;
	
	while(i < this.document.size())
	{
	    docRecherche = this.document.get(i);
	    if(docRecherche.getIsbn() == isbn)
	    {
		docReturn = docRecherche;
		break;
	    }
	    i++;
	}
	return docReturn;
    }
    
    /**
     * @param isbn
     * @return Vrai si le document a été trouvé
     */
    public boolean rechercherDocumentBool(String isbn)
    {
	boolean bool = false;
	if(rechercherDocument(isbn) != null)
	{
	    bool = true;
	}
	else
	{
	    bool = false;
	}
	return bool;
    }
   
    public void afficherTousLesDocuments()
    {
	System.out.println("\n---------Affichage de tous les documents dans la bibliothèque");
	for(Document doc : document)
	{
	    System.out.println(doc.toString());
	}
    }


    public void afficherTousLesAdherents()
    {
	System.out.println("\n-----------Affichage de tous les adhérents présent dans la bibliothèque");
	for(Adherent ad : adherent)
	{
	    System.out.println(ad.toString());
	}
    }
    
    @Override
    public String toString()
    {
	String result="----------------------------\n";
	result = result + "Adhérent présent dans la base de donnée\n";
	for(int i=0; i < this.adherent.size();i++)
	{
	    Adherent ad = adherent.get(i);
	    result = result + "Nom: " + ad.getNom() + " Prenom : " + ad.getPrenom()+ "\n";
	}
	result = result + "....................................\n";
	for(int i=0; i < this.document.size(); i++)
	{
	    Document doc = document.get(i);
	    result = result + "Documents présents dans la base de donnée\n";
	    result = result + "Numero ISNB: " + doc.getIsbn() + " Nom de l'auteur: " + doc.getNomAuteur();
	    
	}
	return result;
    }
}
