package cmd.methode.unit;

public class DocumentBD extends Document
{
    private String NomDessinateur ="";

    public DocumentBD(String saisie_isbn, String saisie_nomAuteur, String saisie_nomDessinateur)
    {
	super(saisie_isbn, saisie_nomAuteur);
	this.NomDessinateur = saisie_nomDessinateur;
    }

    public String getNomDessinateur()
    {
        return this.NomDessinateur;
    }

    @Override
    public String toString()
    {
	return super.toString() + ", NomDessinateur=" + NomDessinateur + "]";
    }
    
    
}
