package test;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URL;

import wGet.WGETJava;



public class testDownload {
	
	public static void main(String args[]){
		new testDownload().test();
	}

	private void test() {
		
		try {
			new WGETJava().DownloadFile(new URL("http://torrents.thepiratebay.org/6143858/The_Mechanic_2011_TS_Xvid-Lyrical.6143858.TPB.torrent"),"file1.torrent");
			new WGETJava().DownloadFile(new URL("http://rss.thepiratebay.org/201"),"201.xml");
		} catch (MalformedURLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
