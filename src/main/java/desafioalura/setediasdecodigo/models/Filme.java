package desafioalura.setediasdecodigo.models;

public class Filme {

	private final String id;
	private final String rank;
	private final String title;
	private final String fullTitle;
	private final String year;
	private final String image;
	private final String crew;
	private final String imDbRating;
	private final String imDbRatingCount;

	public Filme(String id, String rank, String title, String fullTitle, String year, String image, String crew,
			String imDbRating, String imDbRatingCount) {
		this.id = id;
		this.rank = rank;
		this.title = title;
		this.fullTitle = fullTitle;
		this.year = year;
		this.image = image;
		this.crew = crew;
		this.imDbRating = imDbRating;
		this.imDbRatingCount = imDbRatingCount;
	}

	public String getId() {
		return id;
	}

	public String getRank() {
		return rank;
	}

	public String getTitle() {
		return title;
	}

	public String getFullTitle() {
		return fullTitle;
	}

	public String getYear() {
		return year;
	}

	public String getImage() {
		return image;
	}

	public String getCrew() {
		return crew;
	}

	public String getImDbRating() {
		return imDbRating;
	}

	public String getImDbRatingCount() {
		return imDbRatingCount;
	}

	@Override
	public String toString() {
		return "Filme: " + title + ", Url da imagem: " + image;
	}

}