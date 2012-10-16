package cmd.methode.unit;

public class Document
{
	private String isbn;
	private String nomAuteur;

	public Document(String saisie_isbn, String saisie_nomAuteur)
	{
		this.isbn = saisie_isbn;
		this.nomAuteur = saisie_nomAuteur;
	}


	public String getIsbn()
	{
		return this.isbn;
	}

	public String getNomAuteur()
	{
		return this.nomAuteur;
	}


	@Override
	public String toString()
	{
		return "Document [isbn=" + isbn + ", nomAuteur=" + nomAuteur;
	}

}
