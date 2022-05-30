package ar.edu.unju.fi.service.imp;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Candidato;
import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.service.ICandidatoService;
import ar.edu.unju.fi.util.ListaCandidato;

@Service("CandidatoServiceImpList")
public class CandidatoServiceImp implements ICandidatoService {
	
	@Autowired
	private ListaCandidato listaCandidato;
	
	@Override
	public Candidato getCandidato() {
		// TODO Auto-generated method stub
		return new Candidato();
	}

	@Override
	public boolean guardarCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		return listaCandidato.getListaCandidato().add(candidato);
	}

	@Override
	public void modificarCandidato(Candidato candidato) {
		// TODO Auto-generated method stub
		for(Candidato c : listaCandidato.getListaCandidato()) {
			if(c.getCodigo() == candidato.getCodigo()) {
				c.setNombre(candidato.getNombre());
				c.setGenero(candidato.getGenero());
				c.setDescripcion(candidato.getDescripcion());
			}
		}
	}

	@Override
	public void eliminarCandidato(int codigo) {
		// TODO Auto-generated method stub
		listaCandidato.getListaCandidato();
		int indice=-1;
		for(Candidato c : listaCandidato.getListaCandidato()) {
			if(c.getCodigo() == codigo) {
				indice = listaCandidato.getListaCandidato().indexOf(c);
			}
		}
		if(indice>=0) {
			listaCandidato.getListaCandidato().remove(indice);
		}
		
	}

	@Override
	public ListaCandidato getListaCandidatos() {
		// TODO Auto-generated method stub
		return listaCandidato;
	}

	@Override
	public Candidato buscarCandidato(int codigo) {
		// TODO Auto-generated method stub
		Optional<Candidato> candidato = listaCandidato.getListaCandidato().stream().filter(a -> a.getCodigo() == codigo).findFirst();
		System.out.println(candidato.get());
		return candidato.get();
	}

}
