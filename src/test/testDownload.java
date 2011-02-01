package test;

import download.Downloader;

public class testDownload {
	
	public static void main(String args[]){
		new testDownload().test();
	}

	private void test() {
		// TODO Auto-generated method stub
		 new Downloader().downloadFile("http://rss.thepiratebay.org/201","201.xml");
		
	}
}
