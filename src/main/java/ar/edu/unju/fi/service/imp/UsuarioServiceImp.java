package ar.edu.unju.fi.service.imp;



import ar.edu.unju.fi.service.IUsuarioService;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.util.ListaUsuario;

@Service("UsuarioServiceImpList")
public class UsuarioServiceImp implements IUsuarioService {
	
	@Autowired
	private ListaUsuario listaUsuario;
	
	@Override
	public Usuario getUsuario() {
		// TODO Auto-generated method stub
		return new Usuario();
	}

	@Override
	public boolean guardarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		return listaUsuario.getListaUsuario().add(usuario);
	}

	@Override
	public void modificarUsuario(Usuario usuario) {
		// TODO Auto-generated method stub
		for(Usuario user : listaUsuario.getListaUsuario()) {
			if(user.getDni() == usuario.getDni()) {
				user.setNombre(usuario.getNombre());
				user.setEmail(usuario.getEmail());
				user.setFechaNacimiento(usuario.getFechaNacimiento());
			}
		}
	}

	@Override
	public void eliminarUsuario(int dni) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public ListaUsuario getListaUsuarios() {
		// TODO Auto-generated method stub
		return listaUsuario;
	}

	@Override
	public Usuario buscarUsuario(int dni) {
		// TODO Auto-generated method stub
		Optional<Usuario> usuario = listaUsuario.getListaUsuario().stream().filter(a -> a.getDni() == dni).findFirst();
		return usuario.get();
	} 

}