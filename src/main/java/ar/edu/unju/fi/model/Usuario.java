package ar.edu.unju.fi.model;

import java.time.LocalDate;
import java.time.Period;

import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.stereotype.Component;

@Component
public class Usuario {
	@Min(value=1000000,message="El DNI debe ser mayor o igual a 1.000.000")
	private int dni;
	@Size(min=3, max=100, message="El nombre debe tener entre 3 a 100 caracteres")
	@NotEmpty(message="El nombre del usuario no puede ser vacío")
	private String nombre;
	@NotEmpty @Email
	private String email;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private LocalDate fechaNacimiento;
	private int cantVotaciones;
	
	
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
		this.cantVotaciones = 0;
	}
	
	public int getDni() {
		return dni;
	}
	
	public void setDni(int dni) {
		this.dni = dni;
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
	
	public int getCantVotaciones() {
		return cantVotaciones;
	}

	public void setCantVotaciones(int cantVotaciones) {
		this.cantVotaciones = cantVotaciones;
	}

	public int edad() {
		Period period = Period.between(LocalDate.now(), fechaNacimiento);
		return period.getYears();
	}

	@Override
	public String toString() {
		return "Usuario [dni=" + dni + ", nombre=" + nombre + ", email=" + email + ", fechaNacimiento="
				+ fechaNacimiento + ", cantVotaciones=" + cantVotaciones + "]";
	}
	
	
}
