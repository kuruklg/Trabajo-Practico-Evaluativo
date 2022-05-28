package ar.edu.unju.fi.util;

import java.util.ArrayList;

import ar.edu.unju.fi.model.Candidato;

public class ListaCandidato {
	private ArrayList<Candidato> listaCandidato;
	
	public ListaCandidato(){
		listaCandidato = new ArrayList<Candidato>();
		Candidato candidato1=new Candidato(111, "Artista1","Rock","Descripcion");
		Candidato candidato2=new Candidato(222, "Grupo2","Pop","Descripcion");
		Candidato candidato3=new Candidato(333, "Artista3","Rock","Descripcion");
		listaCandidato.add(candidato1);
		listaCandidato.add(candidato2);
		listaCandidato.add(candidato3);
	}
	
	public ArrayList<Candidato> getListaCandidato() {
		return listaCandidato;
	}


	public void setListaCandidato(ArrayList<Candidato> listaCandidato) {
		this.listaCandidato = listaCandidato;
	
	}
}
