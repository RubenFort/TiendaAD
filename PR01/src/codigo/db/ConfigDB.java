package codigo.db;

import java.util.ArrayList;

public  class  ConfigDB {	
	
	private ConfigDB() {}
	
	public static String DB_CONEXION = "";
	
	public static void setDBConexion(String value) {
		DB_CONEXION = value;
	}

	public static ArrayList<String> queries = getQueries();

	private static ArrayList<String> getQueries() {
		ArrayList<String> queries = new ArrayList<String>();
		
		queries.add("CREATE TABLE IF NOT EXISTS 'person' ("
				+ "	'id'	INTEGER,"
				+ "	'name'	string,"
				+ "	'lastname'	TEXT,"
				+ "	PRIMARY KEY('id' AUTOINCREMENT)"
				+ ")");
		
		queries.add("CREATE TABLE IF NOT EXISTS 'producto' ("
				+ "	'id'	INTEGER,"
				+ "	'name'	TEXT,"
				+ "	'desc'	TEXT,"
				+ "	'precio' INTEGER DEFAULT 0,"
				+ "	'stock'	INTEGER DEFAULT 1,"
				+ "	PRIMARY KEY('id' AUTOINCREMENT)"
				+ ")");
		
		return queries;
	}

	
}
