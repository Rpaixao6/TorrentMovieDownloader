
public class Torrent {

	private String name;
	private int year;
	private String url;
	private double rate;
	private int leeches;
	private int seeds;
	private String genre;
	

	public Torrent(String name, int year, String url, double rate, int leeches,
			int seeds, String genre) {
		super();
		this.name = name;
		this.year = year;
		this.url = url;
		this.rate = rate;
		this.leeches = leeches;
		this.seeds = seeds;
		this.genre = genre;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getYear() {
		return year;
	}
	public void setYear(int year) {
		this.year = year;
	}
	public String getURL() {
		return url;
	}
	public void setURL(String uRL) {
		url = uRL;
	}
	public double getRate() {
		return rate;
	}
	public void setRate(double rate) {
		this.rate = rate;
	}
	public int getLeeches() {
		return leeches;
	}
	public void setLeeches(int leeches) {
		this.leeches = leeches;
	}
	public int getSeeds() {
		return seeds;
	}
	public void setSeeds(int seeds) {
		this.seeds = seeds;
	}
	public String getGenre() {
		return genre;
	}
	public void setGenre(String genre) {
		this.genre = genre;
	}
	
}
