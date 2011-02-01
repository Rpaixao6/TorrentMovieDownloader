package wGet;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.rmi.server.UID;

/**
 * @author David Cheeseman
 * 	changes: Rui Lopes da Silva
 *	DePauw '08
 *	Last revised 080505.
 */
public class WGETJava {
	

	/**
	 * This function downloads the file specified in the URL to the
	 * current working directory.
	 * @param theURL
	 * The URL of the file to be downloaded.
	 * @return
	 * An integer result based on the WGETJavaResults Enumeration.
	 * Values Include:
	 * 	FAILED_IO_EXCEPTION - Could not open a connection to the URL.
	 * 	FAILED_UKNOWNTYPE - Could not determine the file type.
	 * 	COMPLETE - Downloaded completed sucessfully.
	 * @throws IOException
	 */
	public static WGETJavaResults DownloadFile(URL theURL, String savingFilename) throws IOException {
		URLConnection con;
		UID uid = new UID();

		con = theURL.openConnection();
		con.connect();

		String type = con.getContentType();
		System.out.println(type);

		if (type != null) {
			byte[] buffer = new byte[4 * 1024];
			int read;

						
			FileOutputStream os = new FileOutputStream(savingFilename);
			InputStream in = con.getInputStream();

			while ((read = in.read(buffer)) > 0) {
				os.write(buffer, 0, read);
			}

			os.close();
			in.close();

			return WGETJavaResults.COMPLETE;
		} else {
			return WGETJavaResults.FAILED_UKNOWNTYPE;
		}
	}
}
