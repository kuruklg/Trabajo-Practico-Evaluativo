package ar.edu.unju.fi.util;

import java.time.LocalDate;
import java.util.ArrayList;

import ar.edu.unju.fi.model.Usuario;

public class ListaUsuario {
	private ArrayList<Usuario> listaUsuario;
	
	public ListaUsuario(){
		listaUsuario = new ArrayList<Usuario>();
		Usuario usuario1=new Usuario(11111111, "Jose","jose@gmail.com",LocalDate.of(2001,03,01));
		Usuario usuario2=new Usuario(22222222, "Clara","clara@gmail.com",LocalDate.of(1996,03,01));
		Usuario usuario3=new Usuario(33333333, "Matias","matias@gmail.com",LocalDate.of(1991,03,01));
		listaUsuario.add(usuario1);
		listaUsuario.add(usuario2);
		listaUsuario.add(usuario3);
	}
	
	public ArrayList<Usuario> getListaUsuario() {
		return listaUsuario;
	}


	public void setListaUsuario(ArrayList<Usuario> listaUsuario) {
		this.listaUsuario = listaUsuario;
	
	}
}
