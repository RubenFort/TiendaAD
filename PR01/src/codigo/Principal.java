package codigo;
 
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Scanner;

import codigo.cfg.Config;
import codigo.db.DbObject;
import codigo.models.Persona;
import codigo.models.Producto;
import codigo.models.Usuario;

public class Principal {

	public static void main(String[] args) { 
				
		Config.getInstance();
		
		Scanner teclado = new Scanner(System.in);
		String opcion;
		boolean salir = false;
		DbObject model;
		
		do {
            System.out.println("****** TIENDA ******");
            System.out.println("1 - Persona");
            System.out.println("2 - Producto");
            System.out.println("3 - Usuario");
            System.out.println("4 - Salir");
            System.out.println("");
            System.out.print("Opción?:");
			opcion = teclado.nextLine();
            switch (opcion) {
                case "1":
                    model = new Persona();
                    menu();
                    menuPersona(model);
                    break;
                case "2":
                	model = new Producto();
                	menu();
                    menuProducto(model);
                    break;
                case "3":
                	model = new Usuario();
                	menu();
                    menuUsuario(model);
                    break;
                case "4":
                    System.out.println("Has elegido Salir");
                    salir = true;
                    break;
                default:
                    System.out.println("Opción no válida");
                    break;                   
            }
            
        } while (!salir);		
	}
			
	
//-------------------------------------------------------------USUARIO-------------------------------------------------------------
	
	private static void menuUsuario(DbObject model) {
		Scanner teclado = new Scanner (System.in);
		System.out.print("Opción?:");
	    String accion = teclado.nextLine();
	    switch (accion) {
	        case "I":
	        case "i":
	            insertarUsuario();
	            break;
	        case "U":
	        case "u":
	            updateUsuario();
	            break;
	        case "D":
	        case "d":
	            deleteUsuario();
	            break;
	        case "L":
	        case "l":
	            listarUsuario();
	            break;
	        case "A":
	        case "a":
	            break;
	        default:
	            System.out.println("Opción no válida");
	            break;
	    }			
	}
	
	private static void listarUsuario() {
		Scanner teclado = new Scanner (System.in);
		Usuario usu = new Usuario();
		
		ArrayList lista = null;
		try {
			lista = usu.list();
		} catch (SQLException e) {
			e.printStackTrace();
		}
		ArrayList<Usuario> lista2 = lista;
		System.out.println("---------------------TABLA USUARIO---------------------");
		for (Usuario usuario : lista2) {
			System.out.println(usuario.getId() + " Usuario: " + usuario.nombre + " Password: " + usuario.password);
		}
	}

	private static void deleteUsuario() {
		Scanner teclado = new Scanner (System.in);
		Usuario usu = new Usuario();
		int id;
		
		try {
			System.out.print("Que usuario quieres borrar?(id): ");
			id = Integer.parseInt(teclado.nextLine());
			usu.setId(id);
		} catch (Exception e) {
			System.out.println("Dato erroneo");
		}
		
		try {
			usu.delete();
		} catch (SQLException e) {
			e.printStackTrace();
		}
	}

	private static void updateUsuario() {
		Scanner teclado = new Scanner (System.in);
		Usuario usu = new Usuario();
		int id;
		
		try {
			System.out.print("Que usuario quieres modificar?(id): ");
			id = Integer.parseInt(teclado.nextLine());
			usu.setId(id);
		} catch (Exception e) {
			System.out.println("Dato erroneo");
		}
		
		System.out.print("Usuario: ");
		usu.nombre = teclado.nextLine();
		System.out.print("Password: ");
		usu.password = teclado.nextLine();
		
		try {
			usu.update();
		} catch (SQLException e) {
			e.printStackTrace();
		}		
	}

	private static void insertarUsuario() {
		Scanner teclado = new Scanner (System.in);
		Usuario usu = new Usuario();
		
		System.out.print("Usuario: ");
		usu.nombre = teclado.nextLine();
		System.out.print("Password: ");
		usu.password = teclado.nextLine();
		
		try {
			usu.insertar();
		} catch (SQLException e) {
			e.printStackTrace();
		}
}


	//-------------------------------------------------------------PRODUCTO-------------------------------------------------------------
	
private static void menuProducto(DbObject model) {
	Scanner teclado = new Scanner (System.in);
	System.out.print("Opción?:");
	String accion = teclado.nextLine();
	switch (accion) {
        case "I":
        case "i":
            insertarProducto();
            break;
        case "U":
        case "u":
            updateProducto();
            break;
        case "D":
        case "d":
            deleteProducto();
            break;
        case "L":
        case "l":
            listarProducto();
            break;
        case "A":
        case "a":
            break;
        default:
            System.out.println("Opción no válida");
            break;
    }			
}

private static void deleteProducto() {
	Scanner teclado = new Scanner (System.in);
	Producto pro = new Producto();
	int id;
	try {
		System.out.print("Que producto quieres borrar?(id): ");
		id = Integer.parseInt(teclado.nextLine());
		pro.setId(id);
	} catch (Exception e) {
		System.out.println("Dato erroneo");
	}

	
	try {
		pro.delete();
	} catch (SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}

private static void listarProducto() {
	Scanner teclado = new Scanner (System.in);
	Producto pro = new Producto();
	
	ArrayList lista = null;
	try {
		lista = pro.list();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	ArrayList<Producto> lista2 = lista;
	System.out.println("---------------------TABLA PRODUCTO---------------------");
	System.out.println("INSERT");
	for (Producto producto : lista2) {
		System.out.println(producto.getId() + " Producto: " + producto.nombre + " Descripción: " + producto.descr + " Precio: " +
				+ producto.precio + " Stock " + producto.stock);
	}		
}

private static void updateProducto() {
	Scanner teclado = new Scanner (System.in);
	Producto pro = new Producto();
	int id;
	try {
		System.out.print("Que producto quieres modificar?(id): ");
		id = Integer.parseInt(teclado.nextLine());
		pro.setId(id);
		System.out.print("Nombre: ");
		pro.nombre = teclado.nextLine();
		System.out.print("Descripción: ");
		pro.descr = teclado.nextLine();
	
		System.out.print("Precio: ");
		pro.precio = Integer.parseInt(teclado.nextLine());
		System.out.print("Stock: ");
		pro.stock = Integer.parseInt(teclado.nextLine());
	} catch (Exception e) {
		System.out.println("Dato erroneo");
	}
	
	try {
		pro.update();
	} catch (SQLException e) {
		e.printStackTrace();
	}	
}

private static void insertarProducto() {
	Scanner teclado = new Scanner (System.in);
	Producto pro = new Producto();
	
	System.out.print("Nombre: ");
	pro.nombre = teclado.nextLine();
	System.out.print("Descripción: ");
	pro.descr = teclado.nextLine();
	try {
		System.out.print("Precio: ");
		pro.precio = Integer.parseInt(teclado.nextLine());
		System.out.print("Stock: ");
		pro.stock = Integer.parseInt(teclado.nextLine());
	} catch (Exception e) {
		System.out.println("Dato erroneo");
	}

	try {
		pro.insertar();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}


//-------------------------------------------------------------PERSONA-------------------------------------------------------------

private static void menuPersona(DbObject model) {
	Scanner teclado = new Scanner (System.in);
	System.out.print("Opción?:");
    String accion = teclado.nextLine();
    switch (accion) {
        case "I":
        case "i":
            insertarPersona();
            break;
        case "U":
        case "u":
            updatePersona();
            break;
        case "D":
        case "d":
            deletePersona();
            break;
        case "L":
        case "l":
            listarPersona();
            break;
        case "A":
        case "a":
            break;
        default:
            System.out.println("Opción no válida");
            break;
    }
		
}

private static void listarPersona() {
	Scanner teclado = new Scanner (System.in);
	Persona per = new Persona();
	
	ArrayList lista = null;
	try {
		lista = per.list();
	} catch (SQLException e) {
		e.printStackTrace();
	}
	ArrayList<Persona> lista2 = lista;
	System.out.println("---------------------TABLA PERSONA---------------------");
	for (Persona persona : lista2) {
		System.out.println(persona.getId() + " Persona: " + persona.name + " " + persona.lastname);
	}
}

private static void deletePersona() {
	Scanner teclado = new Scanner (System.in);
	Persona per = new Persona();
	int id;
	try {
		System.out.print("Que persona quieres borrar?(id): ");
		id = Integer.parseInt(teclado.nextLine());
		per.setId(id);
	} catch (Exception e) {
		System.out.println("Dato erroneo");
	}

	try {
		per.delete();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

private static void updatePersona() {
	Scanner teclado = new Scanner (System.in);
	Persona per = new Persona();
	int id;
	
	try {
		System.out.print("Que persona quieres modificar?(id): ");
		id = Integer.parseInt(teclado.nextLine());
		per.setId(id);
	} catch (Exception e) {
		System.out.println("Dato erroneo");
	}
	
	System.out.print("Nombre: ");
	per.name = teclado.nextLine();
	System.out.print("Apellidos: ");
	per.lastname = teclado.nextLine();
	
	try {
		per.update();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}

private static void insertarPersona() {
	
	Scanner teclado = new Scanner (System.in);
	Persona per = new Persona();
	
	System.out.print("Nombre: ");
	per.name = teclado.nextLine();
	System.out.print("Apellidos: ");
	per.lastname = teclado.nextLine();
	
	try {
		per.insertar();
	} catch (SQLException e) {
		e.printStackTrace();
	}
}


//-------------------------------------------------------------MENU-------------------------------------------------------------

	private static void menu() {
		System.out.println("****** MENU ******");
        System.out.println("(I)nsert)");
        System.out.println("(U)pdate");
        System.out.println("(D)elete");
        System.out.println("(L)istar");
        System.out.println("(A)tras");
        System.out.println("");
        
	}
	
	/*try {
	
	Persona per = new Persona();
	per.name     = "Douglas";
	per.lastname = "Adams";
	per.setId(1);
	
	per.insertar();
		ArrayList lista = per.list();
		ArrayList<Persona> lista2 = lista;
	System.out.println("---------------------TABLA PERSONA---------------------");
	System.out.println("INSERT");
	for (Persona persona : lista2) {
		System.out.println(persona.getId() + " Persona: " + persona.name + " " + persona.lastname);
	}
	
	per.name     = "Neal";
	per.lastname = "Stephenson";
	per.update();
	
	System.out.println("UPDATE");
	
	lista = per.list();
	lista2 = lista;
	for (Persona persona : lista2) {
		System.out.println(persona.getId() + " Persona: "+persona.name + " " + persona.lastname);
	}
	
	System.out.println("DELETE");
	
	per.delete();
	
	lista = per.list();
	lista2 = lista;
	
	for (Persona persona : lista2) {
		System.out.println(persona.getId() + " Persona: "+persona.name + " " + persona.lastname);
	}
}catch(SQLException e) {
	System.out.println( e.getMessage() );
}  

try {
	
	Usuario use = new Usuario();
	use.nombre   = "Ruben";
	use.password = "1234";
	use.setId(1);

	use.insertar();

	ArrayList lista = use.list();
	ArrayList<Usuario> lista2 = lista;
	System.out.println("---------------------TABLA USUARIO---------------------");
	System.out.println("INSERT");
	for (Usuario usuario : lista2) {
		System.out.println(usuario.getId() + " usuario: " + usuario.nombre + " " + usuario.password);
	}
	
	use.password = "12345";
	use.update();
	
	System.out.println("UPDATE");
	
	lista = use.list();
	lista2 = lista;
	for (Usuario usuario : lista2) {
		System.out.println(usuario.getId() + " usuario: " + usuario.nombre + " " + usuario.password);
	}
	
	System.out.println("DELETE");
	
	use.delete();
	
	lista = use.list();
	lista2 = lista;
	
	for (Usuario usuario : lista2) {
		System.out.println(usuario.getId() + " usuario: " + usuario.nombre + " " + usuario.password);
	}
}catch(SQLException e) {
	System.out.println( e.getMessage() );
}  

try {	
	
	Producto pro = new Producto();
	pro.nombre = "La Guia del Autoestopista Galactico";
	pro.descr = "Libro en tapa blanda";
	pro.precio = 20;
	pro.stock = 2;
	pro.setId(1);
	
	pro.insertar();

	ArrayList lista = pro.list();
	ArrayList<Producto> lista2 = lista;
	System.out.println("---------------------TABLA PRODUCTO---------------------");
	System.out.println("INSERT");
	for (Producto producto : lista2) {
		System.out.println(producto.getId() + " Producto: " + producto.nombre + " " + producto.descr + " " +
				+ producto.precio + " " + producto.stock);
	}
	
	pro.nombre     = "Snow Crash";
	pro.update();
	
	System.out.println("UPDATE");
	
	lista = pro.list();
	lista2 = lista;
	for (Producto producto : lista2) {
		System.out.println(producto.getId() + " Producto: " + producto.nombre + " " + producto.descr + " " +
				+ producto.precio + " " + producto.stock);
	}
	
	System.out.println("DELETE");
	
	pro.delete();
	
	lista = pro.list();
	lista2 = lista;
	
	for (Producto producto : lista2) {
		System.out.println(producto.getId() + " Producto: " + producto.nombre + " " + producto.descr + " " +
				+ producto.precio + " " + producto.stock);
	}
}catch(SQLException e) {
	System.out.println( e.getMessage() );
}  /*

//------------------------------------------------------------------------------------------------------------------


// create a database connection

/*
 * 
 * statement.executeUpdate("drop table if exists person");
 * 
 * statement.executeUpdate("create table person (id integer, name string)");
 * 
 * statement.executeUpdate("insert into person values(1, 'leo')");
 * statement.executeUpdate("insert into person values(2, 'yui')");
 * 
 * 
 * 
 * ResultSet rs = statement.executeQuery("select * from person");
 * while(rs.next()) { // read the result set System.out.println("name = " +
 * rs.getString("name")); }
 * 
 * 
 * //
 */
}