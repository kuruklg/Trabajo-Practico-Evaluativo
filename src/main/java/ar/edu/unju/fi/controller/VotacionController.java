package ar.edu.unju.fi.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import ar.edu.unju.fi.util.ListaCandidato;

@Controller
@RequestMapping("/votacion")
public class VotacionController {
	private static final Log LOGGER = LogFactory.getLog(VotacionController.class);
	
	@GetMapping("/ver")
	public ModelAndView getListadoVotacionPage() {
		ModelAndView mav = new ModelAndView("votacion");
		ListaCandidato listaC = new ListaCandidato();
		mav.addObject("candidatos", listaC.getListaCandidato());
		return mav;
	}

}
