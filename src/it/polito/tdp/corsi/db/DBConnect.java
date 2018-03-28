package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

// CLASSE CHE GESTISCE TUTTE LE CONNESSIONI 
public class DBConnect {
	
	// RICORDA: una variabile static occupa una sola locazione di memoria ed � uguale in ogni istanza dell'oggetto
	// DBConnect, mentre se la variabile � final allora vuol dire che pu� essere inzializzata una volta sola, cio�
	// al contrario della static, non pu� cambiare il suo valore nel tempo.
	
	private static final String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root&password=root" ;
	private static Connection conn = null;
	
	// metodo comune a tutte le istanze di DBConnect
	public static Connection getConnection() {
		
		// � possibile che il database non sia raggiungibile
		try {
			if (conn == null || conn.isClosed()) {
				conn = DriverManager.getConnection(jdbcURL) ;
			}
		} catch (SQLException e) {
			System.out.println("Non � possibile aprire la connessione con il DB");
			//e.printStackTrace();
		}
		
		return conn;
	}
	
}
