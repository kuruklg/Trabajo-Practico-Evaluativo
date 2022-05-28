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

import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.util.ListaUsuario;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	private static final Log LOGGER = LogFactory.getLog(UsuarioController.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoUsuarioPage(Model model) {
		model.addAttribute("usuario", new Usuario());
		return "nuevo_usuario";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaUsuariosPage(@ModelAttribute("usuario")Usuario usuario) {
		ModelAndView mav = new ModelAndView("lista_usuarios");
		ListaUsuario listaUsuarios = new ListaUsuario();
		if(listaUsuarios.getListaUsuario().add(usuario)) {
			LOGGER.info("Se registra el usuario "+usuario.getNombre());
		}
		mav.addObject("usuarios", listaUsuarios.getListaUsuario());
		return mav;
	}
	
	@GetMapping("/listaUsuarios")
	public ModelAndView getListadoUsuariosPage() {
		
		ModelAndView mav = new ModelAndView("lista_usuarios");
		ListaUsuario listaU = new ListaUsuario();
		mav.addObject("usuarios", listaU.getListaUsuario());
		return mav;
	}
	
}
