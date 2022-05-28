package ar.edu.unju.fi.model;

public class Candidato {
	private int codigo;
	private String nombre;
	private String genero;
	private String descripcion;
	private int numVotos;
	public Candidato(int codigo, String nombre, String genero, String descripcion) {
		super();
		this.codigo = codigo;
		this.nombre = nombre;
		this.genero = genero;
		this.descripcion = descripcion;
		this.numVotos = 0;
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
	public void setNumVotos(int numVotos) {
		this.numVotos = numVotos;
	}
	
	
	
	
}
