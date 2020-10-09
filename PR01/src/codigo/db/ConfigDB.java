package codigo.db;

import java.util.ArrayList;

public  class  ConfigDB {	
	
	private ConfigDB() {}
	
	public static String DB_CONEXION = "";
	
	public static void setDBConexion(String value) {
		DB_CONEXION = value;
	}

	public static ArrayList<String> queries = new ArrayList<String>(); 
	
	public static void addQuery(String query) {
		queries.add(query);
	} 
	
}
