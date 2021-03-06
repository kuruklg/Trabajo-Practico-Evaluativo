package ar.edu.unju.fi.service;

import org.springframework.stereotype.Service;

import ar.edu.unju.fi.model.Candidato;
import ar.edu.unju.fi.util.ListaCandidato;

@Service("CandidatoServiceImpList")
public interface ICandidatoService {
	public Candidato getCandidato();
	public boolean guardarCandidato(Candidato candidato);
	public void modificarCandidato(Candidato candidato);
	public void eliminarCandidato(int codigo);
	public ListaCandidato getListaCandidatos();
	public Candidato buscarCandidato(int codigo);
}
