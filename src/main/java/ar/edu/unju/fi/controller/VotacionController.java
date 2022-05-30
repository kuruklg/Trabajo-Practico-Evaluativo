package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Candidato;
import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.service.ICandidatoService;
import ar.edu.unju.fi.service.IUsuarioService;
import ar.edu.unju.fi.service.imp.UsuarioServiceImp;
import ar.edu.unju.fi.util.ListaCandidato;
import ar.edu.unju.fi.util.ListaUsuario;

@Controller
@RequestMapping("/votacion")
public class VotacionController {
	
	@Autowired
	@Qualifier("UsuarioServiceImpList")
	private IUsuarioService usuarioService;
	@Autowired
	@Qualifier("CandidatoServiceImpList")
	private ICandidatoService candidatoService;
	private static final Log LOGGER = LogFactory.getLog(VotacionController.class);
	
	@GetMapping("/ver")
	public ModelAndView getListadoVotacionPage() {
		ModelAndView mav = new ModelAndView("votacion");
		ListaCandidato listaC = new ListaCandidato();
		Usuario u = usuarioService.getUsuario();
		mav.addObject("candidatos", candidatoService.getListaCandidatos().getListaCandidato());
		mav.addObject("usuario", u);
		return mav;
	}
	
	@PostMapping("/votar")
	public ModelAndView getAccesoVotarPage(@ModelAttribute("usuario") Usuario usuario) {
		ModelAndView mav;
		if(usuarioService.validarUsuario(usuario.getDni()) && usuarioService.puedeVotar(usuario.getDni())) {
			mav = new ModelAndView("votar");
			Usuario u = usuarioService.buscarUsuario(usuario.getDni());
			mav.addObject(u);
			ListaCandidato listaC = new ListaCandidato();
			mav.addObject("candidatos", candidatoService.getListaCandidatos().getListaCandidato());
		}else {
			LOGGER.info("El usuario no está registrado ");
			
			mav = new ModelAndView("redirect:/usuario/nuevo");
			mav.addObject("usuario", usuarioService.getUsuario());
		}
		
		return mav;
	}
	
	@GetMapping("/registrar_voto/{dni}/{artista}")
	public ModelAndView getEditarUsuarioPage(@PathVariable(value="dni") int dni, @PathVariable(value="artista")int codigo) {
		ModelAndView mav = new ModelAndView("gracias_votacion");
		Usuario usuario = usuarioService.buscarUsuario(dni);
		
		mav.addObject("usuario",usuario);
		Candidato candidato = candidatoService.buscarCandidato(codigo);
		//usuario.getListaVotaciones().add(candidato);
		usuario.setCantVotaciones();
		System.out.println(usuario.getCantVotaciones());
		
		
		//candidato.getListaVotaciones().add(usuario);
		candidato.setNumVotos();
		
		mav.addObject("usuario",usuario);
		
		return mav;
		
	}
	
	
}
