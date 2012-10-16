package cmd.methode.unit;

public class DocumentLivre extends Document
{
    private boolean emprunt = false;
    
    public DocumentLivre(String saisie_isbn, String saisie_nomAuteur)
    {
	super(saisie_isbn, saisie_nomAuteur);
    }

    public boolean isEmprunt()
    {
	return this.emprunt;
    }


    public void setEmprunt(boolean emprunt)
    {
        this.emprunt = emprunt;
    }

    @Override
    public String toString()
    {
	return super.toString() + ", emprunt=" + emprunt + "]";
    } 
    
    

}
