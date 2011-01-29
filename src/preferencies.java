import java.util.List;

public class preferencies {

	private double minRate;

	private String minReleasequality;
	
	private double minNumberSeeds;
	
	private double minNumberLeechs;
	
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

	public void setMinNumberSeeds(double minNumberSeeds) {
		this.minNumberSeeds = minNumberSeeds;
	}

	public double getMinNumberLeechs() {
		return minNumberLeechs;
	}

	public void setMinNumberLeechs(double minNumberLeechs) {
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
	
}
