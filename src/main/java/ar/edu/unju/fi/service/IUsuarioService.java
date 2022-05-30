package ar.edu.unju.fi.service;

import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.util.ListaUsuario;

public interface IUsuarioService {
	public Usuario getUsuario();
	public boolean guardarUsuario(Usuario usuario);
	public void modificarUsuario(Usuario usuario);
	public void eliminarUsuario(int dni);
	public ListaUsuario getListaUsuarios();
	public Usuario buscarUsuario(int dni);
	public boolean validarUsuario(int dni);
	public boolean puedeVotar(int dni);
}
