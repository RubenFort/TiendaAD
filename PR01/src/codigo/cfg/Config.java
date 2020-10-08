package codigo.cfg;

import java.io.File;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;

import org.w3c.dom.Attr;
import org.w3c.dom.Document;
import org.w3c.dom.Element;

import codigo.db.Conexion;

public class Config { 
	
	private static final String CONFIG_FILE = "config.xml";
	private Document configFile;
	private static Config instance;

	private Config() {
		this.checkConfigFile();
	}

	public static Config getInstance() {
		if (instance == null) {
			instance = new Config();
		}
		return instance;
	}
	 
	
	private void checkConfigFile(){
		File file = new File(CONFIG_FILE);
		if (file.exists()) {
			// Cargamos la Config
			configFile = loadDocument();
		}else {
			// Creamos la Config
			configFile = createDocument();
		}
	}
	
	private Document loadDocument() {
		// TODO Auto-generated method stub
		return null;
	}

	private Document createDocument() {
		
		try {
			DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
			  DocumentBuilder db = dbf.newDocumentBuilder();
			  Document doc = db.newDocument();
			
			  // =============================== 
			  Element config = doc.createElement("configuration");
			  doc.appendChild(config);		
			  
			  Element conex = doc.createElement("conexion"); 			  
			  Attr attr = doc.createAttribute("value");
			  attr.setValue("jdbc:sqlite:sample.db");
			  conex.setAttributeNode(attr);
			  config.appendChild(conex);	 
			  
			  
			  Element queries = doc.createElement("queries");
			  config.appendChild(queries);		
			  
			  Element query01 = doc.createElement("query");
			  query01.appendChild(doc.createTextNode("CREATE TABLE IF NOT EXISTS 'person' ("
						+ "	'id'	INTEGER,"
						+ "	'name'	string,"
						+ "	'lastname'	TEXT,"
						+ "	PRIMARY KEY('id' AUTOINCREMENT)"
						+ ")"));
			  queries.appendChild(query01);	  
			  
			  Element query02 = doc.createElement("query");
			  query02.appendChild(doc.createTextNode("CREATE TABLE IF NOT EXISTS 'producto' ("
						+ "	'id'	INTEGER,"
						+ "	'name'	TEXT,"
						+ "	'desc'	TEXT,"
						+ "	'precio' INTEGER DEFAULT 0,"
						+ "	'stock'	INTEGER DEFAULT 1,"
						+ "	PRIMARY KEY('id' AUTOINCREMENT)"
						+ ")"));
			  queries.appendChild(query02);	   
			  
			   
			  
			  // ===============================
			  
			  TransformerFactory transformerFactory = TransformerFactory.newInstance();
			  Transformer transformer = transformerFactory.newTransformer();
			  DOMSource source = new DOMSource(doc);
			  
			  File file = new File("config.xml");
			  StreamResult result = new StreamResult(file);		 

			  transformer.transform(source, result);
			   
			  System.out.println(file.getAbsolutePath());
			  
			  System.out.println("FILE EXISTS: "+file.exists());
			  
			  return doc;
		}catch(Exception e) {
			System.err.println(e.getMessage());
		} 
		return null;
	}
}
