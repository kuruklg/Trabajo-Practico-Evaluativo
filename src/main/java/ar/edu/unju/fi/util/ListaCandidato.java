package ar.edu.unju.fi.util;

import java.util.ArrayList;

import org.springframework.stereotype.Component;

import ar.edu.unju.fi.model.Candidato;

@Component
public class ListaCandidato {
	private ArrayList<Candidato> listaCandidato;
	
	public ListaCandidato(){
		listaCandidato = new ArrayList<Candidato>();
		Candidato candidato1=new Candidato(111, "Artista1","Rock","Descripcion breve del artista 1 ...");
		Candidato candidato2=new Candidato(222, "Grupo2","Pop","Descripcion breve del grupo 2 ...");
		Candidato candidato3=new Candidato(333, "Artista3","Rock","Descripcion breve del artista 3 ...");
		Candidato candidato4=new Candidato(444, "Artista4","Rap","Descripcion breve del artista 4 ...");
		Candidato candidato5=new Candidato(555, "Artista5","Rap","Descripcion breve del artista 5 ...");
		Candidato candidato6=new Candidato(666, "Artista6","Pop","Descripcion breve del artista 6 ...");
		Candidato candidato7=new Candidato(000, "Ninguno","---","---------------------");
		listaCandidato.add(candidato1);
		listaCandidato.add(candidato2);
		listaCandidato.add(candidato3);
		listaCandidato.add(candidato4);
		listaCandidato.add(candidato5);
		listaCandidato.add(candidato6);
		listaCandidato.add(candidato7);
	}
	
	public ArrayList<Candidato> getListaCandidato() {
		return listaCandidato;
	}


	public void setListaCandidato(ArrayList<Candidato> listaCandidato) {
		this.listaCandidato = listaCandidato;
	
	}
}
