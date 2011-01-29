import java.io.IOException;
import java.util.List;

import net.sf.jtmdb.Movie;

import org.json.JSONException;


public class main {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		
		try {
						
			List<Movie> a = Movie.search("The Green Hornet");
			System.out.println("Nome:"+a.get(0).getName());
			System.out.println("Data:"+a.get(0).getReleasedDate());
			System.out.println("IMDB ID:"+a.get(0).getImdbID());
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
		}

}
