package it.polito.tdp.corsi.model;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import it.polito.tdp.corsi.db.CorsoDAO;
import it.polito.tdp.corsi.db.StudenteDAO;

public class Model {
	
	private List<Corso> corsi ;
	private CorsoDAO corsoDAO = null;
	private StudenteDAO studenteDAO = null;
	
	public Model() {
		corsoDAO = new CorsoDAO();
		studenteDAO = new StudenteDAO();
	}
	
	public List<Corso> listaCorsi() {
		// Carico una sola volta tutti i corsi
		// sfruttando un meccanismo di cache
		if (this.corsi == null)
			this.corsi = corsoDAO.listAll();
		return this.corsi;
	}
	
	public List<Corso> listaCorsiSemestre(int pd) {
		
		// Ctrl + 7 PER COMMENTARE BLOCCHI DI CODICE
		
        //opzione 1: leggo tutto e filtro io (java)
//		this.corsi = corsoDAO.listAll() ;
//		List<Corso> risultato = new ArrayList<>() ;
//		for(Corso c: this.corsi) {
//			if(c.getPd() == pd) {
//				risultato.add(c) ;
//			}
//		}
//		return risultato ;
	
		// opzione 2: faccio lavorare il database
		return corsoDAO.listByPD(pd);
		
	}
	
	public String getNomeCognomeFromMatricola(int matricola) {
		
		Studente s = studenteDAO.getStudenteByMatricola(matricola);
		if (s == null) {
			// la matricola non esiste
			return "Matricola non esistente";
		}
		
		return s.getNome() + " " + s.getCognome();
		
	}

	public List<Studente> getStudentiFromCodins(String codins) {
		
		List<Studente> studenti = studenteDAO.getStudentiByCodins(codins);	
		return studenti;
		
		// getStudentiByCodins possiamo pensare di implementarlo in StudenteDAO e non in CorsoDAO perché  
	    // questo metodo restituisce una lista di studenti, ecco prendiamo questo concetto come REGOLA!
	}
	
	public Map<Corso, Stats> getStats(){
		
		Map<Corso, Stats> corsoMap = new HashMap<Corso, Stats>();
		
		for (Corso c : listaCorsi()) {
			Stats stats = corsoDAO.getStatsByCodins(c.getCodIns());
			corsoMap.put(c, stats);
		}
		return corsoMap;
	}

}
