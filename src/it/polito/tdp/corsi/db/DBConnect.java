package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// CLASSE CHE GESTISCE TUTTE LE CONNESSIONI 
public class DBConnect {
	
	// RICORDA: una variabile static occupa una sola locazione di memoria ed è uguale in ogni istanza dell'oggetto
	// DBConnect, mentre se la variabile è final allora vuol dire che può essere inzializzata una volta sola, cioè
	// al contrario della static, non può cambiare il suo valore nel tempo.
	
	private static final String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root&password=root" ;
	private static Connection conn = null;
	
	// metodo comune a tutte le istanze di DBConnect
	public static Connection getConnection() {
		
		// è possibile che il database non sia raggiungibile
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(jdbcURL) ;
			}
		} catch (SQLException e) {
			System.out.println("Non è possibile aprire la connessione con il DB");
			//e.printStackTrace();
		}
		
		return conn;
	}
	
}
