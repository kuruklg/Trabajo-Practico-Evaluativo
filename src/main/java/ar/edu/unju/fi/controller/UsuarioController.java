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

import ar.edu.unju.fi.model.Usuario;
import ar.edu.unju.fi.service.IUsuarioService;
import ar.edu.unju.fi.util.ListaUsuario;


@Controller
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	@Qualifier("UsuarioServiceImpList")
	private IUsuarioService usuarioService;
	
	private static final Log LOGGER = LogFactory.getLog(UsuarioController.class);
	
	@GetMapping("/nuevo")
	public String getFormNuevoUsuarioPage(Model model) {
		model.addAttribute("usuario", usuarioService.getUsuario());
		return "nuevo_usuario";
	}
	
	@PostMapping("/guardar")
	public ModelAndView getListaUsuariosPage(@Validated @ModelAttribute("usuario")Usuario usuario, 
			BindingResult bindingResult) {
		if(bindingResult.hasErrors()) {
			ModelAndView mav = new ModelAndView("nuevo_usuario");
			mav.addObject("usuarios", usuario);
			return mav;
		}
		ModelAndView mav = new ModelAndView("redirect:/usuario/listaUsuarios");
		
		if(usuarioService.guardarUsuario(usuario)) {
			LOGGER.info("Se registra el usuario "+usuario.getNombre());
		}
		
		return mav;
	}
	
	@GetMapping("/listaUsuarios")
	public ModelAndView getListadoUsuariosPage() {
		
		ModelAndView mav = new ModelAndView("lista_usuarios");
		ListaUsuario listaU = new ListaUsuario();
		mav.addObject("usuarios", usuarioService.getListaUsuarios().getListaUsuario());
		return mav;
	}
	
	
	@GetMapping("/editar/{dni}")
	public ModelAndView getEditarUsuarioPage(@PathVariable(value="dni") int dni) {
		ModelAndView mav = new ModelAndView("edicion_usuario");
		Usuario usuario = usuarioService.buscarUsuario(dni);
		mav.addObject("usuario",usuario);
		return mav;
		
	}
	
	@PostMapping("/modificar")
	public ModelAndView editarDatosUsuario(@Validated @ModelAttribute("usuario") Usuario usuario, BindingResult bindingResult ) {
		if(bindingResult.hasErrors()) {
			LOGGER.info("ocurrió un error "+usuario);
			ModelAndView mav = new ModelAndView("edicion_usuario");
			mav.addObject("usuario", usuario);
			return mav;
		}
		
		ModelAndView mav = new ModelAndView("redirect:/usuario/listaUsuarios");
		usuarioService.modificarUsuario(usuario);
		return mav;
		
	}
	
	@GetMapping("/eliminar/{dni}")
	public ModelAndView eliminarUsuario(@PathVariable("dni")int dni) {
		
		ModelAndView mav = new ModelAndView("redirect:/usuario/listaUsuarios");
		usuarioService.eliminarUsuario(dni);
		
		return mav;
		
	}
	
}
