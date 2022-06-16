package desafioalura.setediasdecodigo.models;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Filme implements Comparable<Filme>{

	private final String id;
	@JsonProperty("rank")
	private final String rank;
	@JsonProperty("title")
	private final String title;
	private final String fullTitle;
	@JsonProperty("year")
	private final String year;
	@JsonProperty("image")
	private final String image;
	private final String crew;
	@JsonProperty("imDbRating")
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

	@Override
	public int compareTo(Filme outroFilme) {
		
		long esteRank = Long.parseLong(this.rank);
		long outroRank = Long.parseLong(outroFilme.getRank());
		if (esteRank > outroRank) {
			return 1;
		} return -1;		
	}

}