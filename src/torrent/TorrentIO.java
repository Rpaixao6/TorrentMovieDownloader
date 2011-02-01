package torrent;

import java.io.File;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

public class TorrentIO {
	LinkedList<Torrent> torrentList =new LinkedList<Torrent>();
	private static final boolean DEBUG = true;

	public LinkedList<Torrent>  getList (File filename){
		readRSS(filename);

		return torrentList;

	}


	private void readRSS(File filename) {
		// TODO ler o RSS devolvido Downloader e adicionar cada entrada a lista.
		try{


			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(filename);
			doc.getDocumentElement().normalize();
			NodeList nodeLst = doc.getElementsByTagName("item");

			if (DEBUG)
				System.out.println("DEBUG: - Number of lines Founded: "+nodeLst.getLength());
			
			for (int i=0; i!=nodeLst.getLength();i++){
				Node fstNode = nodeLst.item(i);
				Element fstElmnt = (Element) fstNode;
				//link
				NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("link");
				Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
				NodeList fstNm = fstNmElmnt.getChildNodes();
				
				String url=((Node) fstNm.item(0)).getNodeValue();
				//write minRate in configClass
				if(DEBUG)
					System.out.println("DEBUG: Adding url number "+i+" to the list");
				torrentList.add(new Torrent(null, 0, url, 0, 0, 0, null));
				if (DEBUG)
					System.out.println("DEBUG: Line Number:"+i+" URL:"  + url);
			}

		}catch (Exception e){
			if (DEBUG)
				System.out.println("ERROR - "+e.getMessage());
		}
	}
}
