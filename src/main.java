import java.io.IOException;
import java.util.List;

import net.sf.jtmdb.Movie;



public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
						
			List<Movie> a = Movie.search("The Green Hornet");
			   for(int i=0; i<a.size(); i++){
			System.out.println("Nome:"+a.get(i).getName());
			System.out.println("Data:"+a.get(i).getReleasedDate());
			System.out.println("IMDB ID:"+a.get(i).getImdbID());
			   }
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}

}
