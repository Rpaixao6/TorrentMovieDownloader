package test;

import java.io.File;
import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

import org.json.JSONException;

import net.sf.jtmdb.Movie;

import config.ConfigurationIOFILE;
import config.ConfigurationsFile;

import cleaner.NameCleaner;

import torrent.Torrent;
import torrent.TorrentIO;
import wGet.WGETJava;

public class testMain {
	private static final String FILENAME = "config.xml";
	private boolean DEBUG =false;
	ConfigurationsFile configFile; 
	
	public static void main(String args[]) throws IOException, JSONException{
		new testMain().test();
	}

	private void test() throws IOException, JSONException {
		
		//dwonloadRSS
		downloadRSS(DEBUG);
		
		TorrentIO tIO = new TorrentIO();
		LinkedList<Torrent> tList = tIO.getList(new File("201.xml"),DEBUG);
		loadConfigs(DEBUG);
		if (DEBUG)
		System.out.println("Configs:\n"+configFile.print());
		System.out.println("-------Possible Movies-------");
		for (int i=0;i!=tList.size();i++){
			//System.out.println("Torrent in list number "+i+" url:"+tList.get(i).getURL());
			NameCleaner nc =new NameCleaner();
			nc.clean(tList.get(i).getURL(),false);
			if(nc.cleaned){
//			System.out.println("Name cleaned: "+nc.name);
//			System.out.println("Year: "+nc.year);
//			System.out.println("Release: "+nc.releaseQuality);
			searchMovie(nc);
			}
			
			//Print configs
			
		}
	}

	private void searchMovie(NameCleaner nc) throws IOException, JSONException {
		List<Movie> movies = Movie.search(nc.name);
		// Date today=new Date();  
		
		   for(int i=0; i<movies.size(); i++){
			   if(movies.get(i).getReleasedDate()!=null && (nc.year>=configFile.getMinYear()) && (nc.year==(movies.get(i).getReleasedDate().getYear()+1900))){
			   System.out.println("------------------------------------------------");
			    
			   	System.out.println("Torrent  name: "+nc.name.toLowerCase());
				System.out.println("Database name: "+movies.get(i).getName().toLowerCase());
				System.out.println("Torrent  year: "+nc.year);
				System.out.println("Database year: "+(movies.get(i).getReleasedDate().getYear()+1900));
				String torrentName =nc.name.toLowerCase().trim();
				String databasename=movies.get(i).getName().toLowerCase().trim();
				if(databasename.equals(torrentName)){
					System.out.println("Name and Year Ok. Now check my prefs!.");
					System.out.println("Torrent     Release: "+nc.releaseQuality);
					System.out.println("Preferences Release: "+configFile.getMinReleasequality());
					System.out.println("Database    Rate: "+movies.get(i).getRating());
					System.out.println("Preferences Rate: "+configFile.getMinRate());
//					System.out.println("Configs:\n"+configFile.print());
					if (movies.get(i).getRating()>=configFile.getMinRate())
						System.out.println("Downloading Torrent File! (not yet)");
					//		downloadTorrent(DEBUG);//TODO falta passar o URL do torrent!!!!
					
				}
//				System.out.println("Data: "+movies.get(i).getReleasedDate());
//				System.out.println("IMDB ID: "+movies.get(i).getImdbID());
//				System.out.println("Rate: "+movies.get(i).getRating());
//				System.out.println("URL: "+movies.get(i).getUrl());
//				System.out.println("Trailer URL: "+movies.get(i).getTrailer());
//				System.out.println("Alter Name: "+movies.get(i).getAlternativeName());
			   }
		   }
		   }
		
	

	private void downloadTorrent(boolean dEBUG2) throws MalformedURLException, IOException {
		new WGETJava().DownloadFile(new URL("http://torrents.thepiratebay.org/6143858/The_Mechanic_2011_TS_Xvid-Lyrical.6143858.TPB.torrent"),"file1.torrent");
		
	}

	private void loadConfigs(boolean dEBUG2) {
		configFile = new ConfigurationsFile();
		ConfigurationIOFILE configIO =new ConfigurationIOFILE();
		File f= new File(FILENAME);
		if(DEBUG)
			System.out.println("DEBUG - Config file exists? "+ f.exists());

		//tentar criar ficheiro xml de config.
		if(DEBUG)
			System.out.println("DEBUG - Trying to create config file.");
		if (!f.exists()){
			try {
				configIO.createFile();
			} catch (IOException e) {
				if(DEBUG)
					System.out.println("DEBUG - ERROR - Could not create file.");
			}
		}else{
			
			configFile=configIO.loadFile(configFile);
		}

		
		
	}
	
	private void downloadRSS(boolean debug2) throws MalformedURLException, IOException {
		if (DEBUG)
			System.out.println("Downloading RSS file from piratebay.");
		new WGETJava().DownloadFile(new URL("http://rss.thepiratebay.org/201"),"201.xml");
		
	}
}


