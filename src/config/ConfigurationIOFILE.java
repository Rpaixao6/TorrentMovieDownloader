package config;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.StringWriter;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.OutputKeys;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;


public class ConfigurationIOFILE {
	private static final String FILENAME = "config.xml";
	private static final boolean DEBUG = false;

	public ConfigurationsFile loadFile(ConfigurationsFile configFile) {
		//TODO Implementar Exceptions
		
		try{
			
			File f = new File(FILENAME);
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			DocumentBuilder db = dbf.newDocumentBuilder();
			Document doc = db.parse(f);
			doc.getDocumentElement().normalize();
			NodeList nodeLst = doc.getElementsByTagName("config");
			if (DEBUG)
				System.out.println("DEBUG - "+doc.getDocumentElement().getNodeName());

			Node fstNode = nodeLst.item(0);
			Element fstElmnt = (Element) fstNode;

			
			
			//minRate
			NodeList fstNmElmntLst = fstElmnt.getElementsByTagName("minRate");
			Element fstNmElmnt = (Element) fstNmElmntLst.item(0);
			NodeList fstNm = fstNmElmnt.getChildNodes();
			
			//write minRate in configClass
			configFile.setMinRate(Double.parseDouble(  ((Node) fstNm.item(0)).getNodeValue()  ));
			if (DEBUG)
				System.out.println("DEBUG - minRate: "  + ((Node) fstNm.item(0)).getNodeValue());

			//minReleaseQuality
			NodeList scndNmElmntLst = fstElmnt.getElementsByTagName("minReleaseQuality");
			Element scndNmElmnt = (Element) scndNmElmntLst.item(0);
			NodeList scndNm = scndNmElmnt.getChildNodes();
			
			//write minReleaseQuality in configClass
			configFile.setMinReleasequality(((Node) scndNm.item(0)).getNodeValue());
			if (DEBUG)
				System.out.println("DEBUG - minReleaseQuality: "  + ((Node) scndNm.item(0)).getNodeValue());


			//minNumberSeeds
			NodeList thrdNmElmntLst = fstElmnt.getElementsByTagName("minNumberSeeds");
			Element thrdNmElmnt = (Element) thrdNmElmntLst.item(0);
			NodeList thrdNm = thrdNmElmnt.getChildNodes();
			
			//write minNumberSeeds in configClass
			configFile.setMinNumberSeeds(Integer.parseInt(  ((Node) thrdNm.item(0)).getNodeValue()  ));
			if (DEBUG)
				System.out.println("DEBUG - minNumberSeeds: "  + ((Node) thrdNm.item(0)).getNodeValue());

			//minNumberLeeches
			NodeList frthNmElmntLst = fstElmnt.getElementsByTagName("minNumberLeeches");
			Element frthNmElmnt = (Element) frthNmElmntLst.item(0);
			NodeList frthNm = frthNmElmnt.getChildNodes();
			
			//write minNumberLeeches in configClass
			configFile.setMinNumberLeechs(Integer.parseInt(  ((Node) frthNm.item(0)).getNodeValue()  ));
			if (DEBUG)
				System.out.println("DEBUG - minNumberLeeches: "  + ((Node) frthNm.item(0)).getNodeValue());

			//avoidGenre
			//TODO implement cycle
			NodeList ffthNmElmntLst = fstElmnt.getElementsByTagName("avoidGenre");
			Element ffthNmElmnt = (Element) ffthNmElmntLst.item(0);
			NodeList ffthNm = ffthNmElmnt.getChildNodes();
			
			//write avoidGenre in configClass
			configFile.setAvoidGenre(((Node) ffthNm.item(0)).getNodeValue());
			if (DEBUG)
				System.out.println("DEBUG - avoidGenre: "  + ((Node) ffthNm.item(0)).getNodeValue());


			//avoidWords
			//TODO implement cycle

			NodeList sixNmElmntLst = fstElmnt.getElementsByTagName("avoidWords");
			Element sixNmElmnt = (Element) sixNmElmntLst.item(0);
			NodeList sixNm = sixNmElmnt.getChildNodes();
			if (DEBUG)
				System.out.println("DEBUG - avoidWords: "  + ((Node) sixNm.item(0)).getNodeValue());

			//minYear
			NodeList svnthNmElmntLst = fstElmnt.getElementsByTagName("minYear");
			Element svnthNmElmnt = (Element) svnthNmElmntLst.item(0);
			NodeList svnthNm = svnthNmElmnt.getChildNodes();
			configFile.setMinNumberLeechs(Integer.parseInt(  ((Node)  svnthNm.item(0)).getNodeValue()  ));
			if (DEBUG)
				System.out.println("DEBUG - minYear: "  + ((Node)  svnthNm.item(0)).getNodeValue());


		}catch(Exception e){
			if (DEBUG)
				System.out.println("DEBUG - ERROR - "+e.getMessage());
		}
		return configFile;

	}


	public void createFile() throws IOException {
		/*
		TODO Falta perguntar ao user as infos
		TODO Implementar Exceptions
		//add a text element to the child
            Text text = doc.createTextNode("5.0");
            minRate.appendChild(text);
		
		
		*/
		File f = new File(FILENAME);
		f.createNewFile();
		try{
			DocumentBuilderFactory dbfac = DocumentBuilderFactory.newInstance();
			DocumentBuilder docBuilder = dbfac.newDocumentBuilder();
			Document doc = docBuilder.newDocument();

			//create the root element and add it to the document
			Element root = doc.createElement("config");
			doc.appendChild(root);

			//create child element, add an attribute, and add to root
			Element prefs = doc.createElement("Preferences");
			root.appendChild(prefs);

			//minRate
			Element minRate = doc.createElement("minRate");
			prefs.appendChild(minRate);
			
			//minReleaseQuality
			Element minReleaseQuality = doc.createElement("minRate");
			prefs.appendChild(minReleaseQuality);

			//minNumberSeeds
			Element minNumberSeeds = doc.createElement("minNumberSeeds");
			prefs.appendChild(minNumberSeeds);

			//minNumberLeeches
			Element minNumberLeeches = doc.createElement("minNumberLeeches");
			prefs.appendChild(minNumberLeeches);

			//avoidGenre
			Element avoidGenre = doc.createElement("avoidGenre");
			prefs.appendChild(avoidGenre);

			//avoidWords
			Element avoidWords = doc.createElement("avoidWords");
			prefs.appendChild(avoidWords);

			//set up a transformer
			TransformerFactory transfac = TransformerFactory.newInstance();
			Transformer trans = transfac.newTransformer();
			trans.setOutputProperty(OutputKeys.OMIT_XML_DECLARATION, "yes");
			trans.setOutputProperty(OutputKeys.INDENT, "yes");

			//create string from xml tree
			StringWriter sw = new StringWriter();
			StreamResult result = new StreamResult(sw);
			DOMSource source = new DOMSource(doc);
			trans.transform(source, result);
			String xmlString = sw.toString();

			//print xml
			if(DEBUG)
			System.out.println("DEBUG: the xml:\n\n" + xmlString);

			//Write to file
			FileWriter fstream = new FileWriter(FILENAME);
			BufferedWriter out = new BufferedWriter(fstream);
			out.write(xmlString);
			out.close();


		}catch(Exception e){
			System.out.println("DEBUG - ERROR - "+e.getMessage());
		}
	}
}
