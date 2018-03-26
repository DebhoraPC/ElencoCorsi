package it.polito.tdp.corsi.model;

import java.util.List;

public class TestModel {

	public static void main(String[] args) {
		
		Model m = new Model() ;

		List<Corso> corsi = m.listaCorsiSemestre(2) ;
		
		for(Corso c: corsi)
			System.out.println(c);
	}

}
