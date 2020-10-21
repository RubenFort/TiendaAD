package codigo.models;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import codigo.db.DbObject;

public class Usuario extends DbObject {

	private static final String TABLE = "usuario";
	private static final ArrayList COLS = getArrayCols();

	private int id = 0;
	public String nombre = "";
	public String password = "";
	
	private static ArrayList getArrayCols() {
		ArrayList list = new ArrayList();
		list.add("nombre");
		list.add("password");
		return list;
	}
	
	
	public String getName() {
		return nombre;
	}

	public void setName(String name) {
		this.nombre = nombre;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public int getId() {
		return this.id;
	}

	@Override
	public String getTable() {
		return TABLE;
	}

	@Override
	public ArrayList getCols() {
		return COLS;
	}

	@Override
	public ArrayList getValues() {
		ArrayList list = new ArrayList();
		list.add(this.nombre);
		list.add(this.password);
		
		return list;
	}

	@Override
	public DbObject parse(ResultSet rs) throws SQLException {
		Usuario user = new Usuario();
		user.id = rs.getInt("id");
		user.nombre = rs.getString("nombre");
		user.password = rs.getString("password");
		return user;
	}
	  

}
