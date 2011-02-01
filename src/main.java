import java.io.IOException;
import java.util.List;

import net.sf.jtmdb.Movie;



public class main {

	
	

	private static NameCleaner a;

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		System.out.println(ReleaseQuality.valueOf("HDTV"));
		a= new NameCleaner();
		a.clean("Inception (2010) DVDRip XviD-MAX");//The Kings.Speech.2001.DVDSCR.XviD.AC3-NYDIC");//"The.Green.Hornet.2010.TS.XViD-T0XiC-iNK");
		System.out.println("Name cleaned: "+a.name);
		System.out.println("Year: "+a.year);
		System.out.println("Release: "+a.releaseQuality);
		
		try {
						
			List<Movie> movies = Movie.search(a.name);
			   for(int i=0; i<movies.size(); i++){
		    System.out.println("------------------------------------------------");
			System.out.println("Nome: "+movies.get(i).getName());
			System.out.println("Data: "+movies.get(i).getReleasedDate());
			System.out.println("IMDB ID: "+movies.get(i).getImdbID());
			System.out.println("Rate: "+movies.get(i).getRating());
			System.out.println("URL: "+movies.get(i).getUrl());
			System.out.println("Trailer URL: "+movies.get(i).getTrailer());
			System.out.println("Alter Name: "+movies.get(i).getAlternativeName());
			}
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}

	private static void cleanName(String string) {
	 //Limpar os pontos separar nome do ano e da qualidade do torrent
		
	}

}
