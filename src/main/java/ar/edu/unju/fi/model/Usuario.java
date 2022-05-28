package ar.edu.unju.fi.model;

import java.time.LocalDate;
import java.time.Period;

public class Usuario {
	private int dni;
	private String nombre;
	private String email;
	private LocalDate fechaNacimiento;
	
	
	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(int dni, String nombre, String email, LocalDate fechaNacimiento) {
		super();
		this.dni = dni;
		this.nombre = nombre;
		this.email = email;
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public int getDni() {
		return dni;
	}
	
	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public LocalDate getFechaNacimiento() {
		return fechaNacimiento;
	}

	public void setFechaNacimiento(LocalDate fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}
	
	public int edad() {
		Period period = Period.between(LocalDate.now(), fechaNacimiento);
		return period.getYears();
	}
}
