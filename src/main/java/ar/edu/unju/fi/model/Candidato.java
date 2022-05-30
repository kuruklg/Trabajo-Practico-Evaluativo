package ar.edu.unju.fi.model;

import java.util.ArrayList;

import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.stereotype.Component;
@Component
public class Candidato {
	private int codigo;
	@Size(min=3, max=100, message="El nombre debe tener entre 3 a 100 caracteres")
	private String nombre;
	private String genero;
	@Size(max=150, message="La descripción no debe superar los 150 caracteres")
	private String descripcion;
	private int numVotos;
	//private ArrayList<Usuario> listaVotaciones;
	

	public Candidato() {
		super();
		// TODO Auto-generated constructor stub
	}
	public Candidato(int codigo, String nombre, String genero, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.genero = genero;
		this.descripcion = descripcion;
		this.numVotos = 0;
		//this.listaVotaciones = new ArrayList<Usuario>();
	}
	public int getCodigo() {
		return codigo;
	}
	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getGenero() {
		return genero;
	}
	public void setGenero(String genero) {
		this.genero = genero;
	}
	public String getDescripcion() {
		return descripcion;
	}
	public void setDescripcion(String descripcion) {
		this.descripcion = descripcion;
	}
	public int getNumVotos() {
		return numVotos;
	}
	public void setNumVotos() {
		this.numVotos = numVotos+1;
	}
	/*public ArrayList<Usuario> getListaVotaciones() {
		return listaVotaciones;
	}
	public void setListaVotaciones(ArrayList<Usuario> listaVotaciones) {
		this.listaVotaciones = listaVotaciones;
	}*/
	
	
	
	
	
	
}
