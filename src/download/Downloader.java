package download;

import java.io.BufferedReader;
import java.io.BufferedWriter;

import java.io.FileWriter;
import java.io.IOException;

import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;



public class Downloader {



	public void downloadFile(String url,String filename){
		try{
			URL PageUrl;
			URLConnection GetConn = null;
			GetConn = null;  

			PageUrl = new URL(url);
			GetConn = PageUrl.openConnection();
			//establish connection:
			GetConn.connect();
			//save privacy policy source file into text file
			InputStreamReader ReadIn = new InputStreamReader(GetConn.getInputStream());
			BufferedReader BufData = new BufferedReader(ReadIn);
			String TextFileName = (filename); 
			FileWriter FWriter = new FileWriter(TextFileName);
			BufferedWriter BWriter = new BufferedWriter(FWriter);
			String UrlData = null;
			while ((UrlData = BufData.readLine()) != null)
			{
				BWriter.write(UrlData);
				BWriter.newLine();
			}
			BWriter.close();
			System.out.println("Done");
		}//end try
		catch(IOException io)
		{
			System.out.println(io);
		}
	}

}
