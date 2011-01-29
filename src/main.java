import java.io.IOException;
import java.util.List;

import net.sf.jtmdb.Movie;



public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		cleanName("The.Green.Hornet.2010.TS.XViD-T0XiC-iNK");
		
		
		try {
						
			List<Movie> a = Movie.search("The Green Hornet");
			   for(int i=0; i<a.size(); i++){
		    System.out.println("------------------------------------------------");
			System.out.println("Nome: "+a.get(i).getName());
			System.out.println("Data: "+a.get(i).getReleasedDate());
			System.out.println("IMDB ID: "+a.get(i).getImdbID());
			System.out.println("Rate: "+a.get(i).getRating());
			System.out.println("URL: "+a.get(i).getUrl());
			System.out.println("Trailer URL: "+a.get(i).getTrailer());
			System.out.println("Alter Name: "+a.get(i).getAlternativeName());
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
