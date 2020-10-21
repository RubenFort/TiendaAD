package codigo.models;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import codigo.db.DbObject;


public class Producto extends DbObject{

	private static final String TABLE = "producto";
	private static final ArrayList COLS = getArrayCols();

	private int id = 0;
	public String nombre = "";
	public String descr = "";
	public int precio = 0; 
	public int stock = 1;
	
	private static ArrayList getArrayCols() {
		ArrayList list = new ArrayList();
		list.add("nombre");
		list.add("descr"); 
		list.add("precio");
		list.add("stock"); 
		return list;
	}
	
	public int getStock() {
		return stock;
	}
	public void setStock(int stock) {
		this.stock = stock;
	}
	public String getName() {
		return nombre;
	}
	public void setName(String nombre) {
		this.nombre = nombre;
	}
	public String getDesc() {
		return descr;
	}
	public void setDesc(String descr) {
		this.descr = descr;
	}
	/**
	 * 
	 * @return 100 = 1,00
	 */
	public int getPrecio() {
		return precio;
	}
	/**
	 * 
	 * @return 100 = 1,00
	 */
	public void setPrecio(int precio) {
		this.precio = precio;
	}
	@Override
	public int getId() {
		return this.id;
	}
	public void setId(int id) {
		this.id = id;
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
		list.add(this.descr);
		list.add(this.precio);
		list.add(this.stock);
		
		return list;
	}

	@Override
	public DbObject parse(ResultSet rs) throws SQLException {
		Producto prod = new Producto();
		prod.id = rs.getInt("id");
		prod.nombre = rs.getString("nombre");
		prod.descr = rs.getString("descr");
		prod.precio = rs.getInt("precio");
		prod.stock = rs.getInt("stock");
		return prod;
	}

}
