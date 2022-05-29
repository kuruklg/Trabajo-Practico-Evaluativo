package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.model.Candidato;
import ar.edu.unju.fi.util.ListaCandidato;

@Controller
@RequestMapping("/candidato")
public class CandidatoController {
	private static final Log LOGGER = LogFactory.getLog(CandidatoController.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoCandidatoPage(Model model) {
		model.addAttribute("candidato", new Candidato());
		return "nuevo_candidato";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaCandidatosPage(@ModelAttribute("candidato")Candidato candidato) {
		ModelAndView mav = new ModelAndView("lista_candidato");
		ListaCandidato listaCandidatos = new ListaCandidato();
		if(listaCandidatos.getListaCandidato().add(candidato)) {
			LOGGER.info("Se registra el candidato "+candidato.getNombre());
		}
		mav.addObject("candidatos", listaCandidatos.getListaCandidato());
		return mav;
	}
	
	@GetMapping("/listaCandidatos")
	public ModelAndView getListadoCandidatosPage() {
		
		ModelAndView mav = new ModelAndView("lista_candidatos");
		ListaCandidato listaC = new ListaCandidato();
		mav.addObject("candidatos", listaC.getListaCandidato());
		return mav;
	}

}
