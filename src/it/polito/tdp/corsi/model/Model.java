package it.polito.tdp.corsi.model;

import java.util.ArrayList;
import java.util.List;

import it.polito.tdp.corsi.db.CorsoDAO;

public class Model {
	
	private List<Corso> corsi ;
	
	public List<Corso> listaCorsiSemestre(int pd) {
		
		CorsoDAO dao = new CorsoDAO() ;
		
		// opzione 1: leggo tutto e filtro io
		this.corsi = dao.listAll() ;
		
		List<Corso> risultato = new ArrayList<>() ;
		for(Corso c: this.corsi) {
			if(c.getPd() == pd) {
				risultato.add(c) ;
			}
		}
		return risultato ;
		
//		// opzione 2: faccio lavorare il database
//		List<Corso> risultato2 = dao.listByPD(pd) ;
//		return risultato2;
		
	}

}
