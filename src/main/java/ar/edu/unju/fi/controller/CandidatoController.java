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
import ar.edu.unju.fi.service.ICandidatoService;
import ar.edu.unju.fi.util.ListaCandidato;

@Controller
@RequestMapping("/candidato")
public class CandidatoController {
	
	@Autowired
	@Qualifier("CandidatoServiceImpList")
	private ICandidatoService candidatoService;
	
	private static final Log LOGGER = LogFactory.getLog(CandidatoController.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoCandidatoPage(Model model) {
		model.addAttribute("candidato", candidatoService.getCandidato());
		return "nuevo_candidato";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaCandidatosPage(@Validated @ModelAttribute("candidato")Candidato candidato,
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_candidato");
			mav.addObject("candidatos", candidato);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/candidato/listaCandidatos");
		
		if(candidatoService.guardarCandiato(candidato)) {
			LOGGER.info("Se registra el candidato "+candidato.getNombre());
		}
		
		return mav;
	}
	
	@GetMapping("/listaCandidatos")
	public ModelAndView getListadoCandidatosPage() {
		
		ModelAndView mav = new ModelAndView("lista_candidatos");
		ListaCandidato listaC = new ListaCandidato();
		mav.addObject("candidatos", candidatoService.getListaCandidatos().getListaCandidato());
		return mav;
	}
	
	@GetMapping("/editar/{codigo}")
	public ModelAndView getEditarCandidatoPage(@PathVariable(value="codigo") int codigo) {
		ModelAndView mav = new ModelAndView("edicion_candidato");
		Candidato candidato = candidatoService.buscarCandidato(codigo);
		mav.addObject("candidato",candidato);
		return mav;
		
	}
	

}
