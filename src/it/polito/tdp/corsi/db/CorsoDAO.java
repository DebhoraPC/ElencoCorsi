package it.polito.tdp.corsi.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.model.Corso;

public class CorsoDAO {

	private final String jdbcURL = "jdbc:mysql://localhost/iscritticorsi?user=root&password=root" ;
	
	/**
	 * Ritorna tutti gli elementi della tabella CORSO
	 * @return
	 */
	public List<Corso> listAll() {
		
		String sql = "SELECT codins, crediti, nome, pd " + 
				"FROM corso" ;
		
		List<Corso> result = new ArrayList<>() ;
		
		try {
			Connection conn = DriverManager.getConnection(jdbcURL) ;
			
			PreparedStatement st = conn.prepareStatement(sql) ;
			
			ResultSet res = st.executeQuery() ;
			
			while(res.next()) {
				Corso c = new Corso(res.getString("codins"),
						res.getInt("crediti"),
						res.getString("nome"),
						res.getInt("pd") ) ;
				
				result.add(c) ;
			}
			
			conn.close();
			
		} catch (SQLException e) {
			throw new RuntimeException(e) ;
		}
		
		return result;
	}

	/**
	 * Ritorna i corsi che hanno questo periodo diattico {@code pd}
	 * @param pd
	 * @return
	 */
	public List<Corso> listByPD(int pd) {
		// TODO Auto-generated method stub
		return null;
	}

}
