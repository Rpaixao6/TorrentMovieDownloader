package config;
import java.util.List;

public class ConfigurationsFile {

	private int minYear;
	
	private double minRate;

	private String minReleasequality;
	
	private int minNumberSeeds;
	
	private int minNumberLeechs;
	
	private String avoidGenre;
	
	private List avoidWords;
	
	public double getMinRate() {
		return minRate;
	}

	public void setMinRate(double minRate) {
		this.minRate = minRate;
	}

	public String getMinReleasequality() {
		return minReleasequality;
	}

	public void setMinReleasequality(String minReleasequality) {
		this.minReleasequality = minReleasequality;
	}

	public double getMinNumberSeeds() {
		return minNumberSeeds;
	}

	public void setMinNumberSeeds(int minNumberSeeds) {
		this.minNumberSeeds = minNumberSeeds;
	}

	public double getMinNumberLeechs() {
		return minNumberLeechs;
	}

	public void setMinNumberLeechs(int minNumberLeechs) {
		this.minNumberLeechs = minNumberLeechs;
	}

	public String getAvoidGenre() {
		return avoidGenre;
	}

	public void setAvoidGenre(String avoidGenre) {
		this.avoidGenre = avoidGenre;
	}

	public List getAvoidWords() {
		return avoidWords;
	}

	public void setAvoidWords(List avoidWords) {
		this.avoidWords = avoidWords;
	}

	public void setMinYear(int minYear) {
		this.minYear = minYear;
	}

	public int getMinYear() {
		return minYear;
	}

	public String print() {
		// TODO Auto-generated method stub
		return ("Minimum Year: "+minYear+"\n"+
				"Minimum TMDB rate: "+minRate+"\n"+
				"Minimum Leechers: "+minNumberLeechs+"\n"+
				"Minimum Seeders: "+minNumberSeeds+"\n"+
				"Avoid genre: "+avoidGenre+"\n");
	}
	
}
