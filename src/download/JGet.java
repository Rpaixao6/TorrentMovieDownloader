package download;

/*
 * A simple Java class to provide functionality similar to Wget.
 *
 * Note: Could also strip out all of the html w/ jtidy.
 */

import java.io.*;
import java.net.*;

public class JGet
{

  public  void downloadFile(String args)
  {

//    if ( (args.length != 1) )
//    {
//      System.err.println( "\nUsage: java JGet [urlToGet]" );
//      System.exit(1);
//    }

    String url = args;

    URL u;
    InputStream is = null;
    DataInputStream dis;
    String s;

    try
    {
      u = new URL(url);
      is = u.openStream();
      dis = new DataInputStream(new BufferedInputStream(is));
      while ((s = dis.readLine()) != null)
      {
        System.out.println(s);
      }
    }
    catch (MalformedURLException mue)
    {
      System.err.println("Ouch - a MalformedURLException happened.");
      mue.printStackTrace();
      System.exit(2);
    }
    catch (IOException ioe)
    {
      System.err.println("Oops- an IOException happened.");
      ioe.printStackTrace();
      System.exit(3);
    }
    finally
    {
      try
      {
        is.close();
      }
      catch (IOException ioe)
      {
      }
    }

  }

}
