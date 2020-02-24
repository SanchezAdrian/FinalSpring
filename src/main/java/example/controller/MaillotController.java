package example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import example.constantes.constantes;
import example.converter.MaillotConverter;
import example.entity.Maillot;
import example.model.MaillotModel;
import example.service.MaillotService;

@Controller
@RequestMapping("/ciclistas")
public class MaillotController {
	
	
	@Autowired
	@Qualifier("maillotServiceImpl")
	private MaillotService maillotService;
	
	@Autowired
	@Qualifier("maillotConverter")
	private MaillotConverter maillotConverter;
	
	@GetMapping("/listaMaillots")
	public ModelAndView listamaillots() {
		ModelAndView mav=new ModelAndView(constantes.MAILLOTS_VIEW);
		mav.addObject("maillot",new Maillot());
		mav.addObject("maillots",maillotService.getListMaillot());
		return mav;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/createMaillots")
	public ModelAndView createMaillot() {
		ModelAndView mav = new ModelAndView(constantes.CREATEMA_VIEW);
		mav.addObject("maillot",new Maillot());
		return mav;
	}
	
	@PostMapping("/addMaillots")
	public ModelAndView addMaillot(@ModelAttribute("maillot") MaillotModel maillotModel) {
		ModelAndView mav = new ModelAndView(constantes.MAILLOTS_VIEW);
		maillotService.addMaillot(maillotModel);
		mav.addObject("maillots",maillotService.getListMaillot());
		return mav;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/deleteMaillots/{id}")
	public String deleteMaillot(@PathVariable("id") String id) {
		maillotService.removeMaillot(id);
		return "redirect:/ciclistas/listaMaillots";
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/rmtMaillots/{id}")
	public ModelAndView editEquipo(@PathVariable("id") String id) {
		ModelAndView mav = new ModelAndView(constantes.CREATEMA_VIEW);
		
		for(MaillotModel maillot:maillotService.getListMaillot()) {
			if(id.equals(maillot.getCodigo())) {
				mav.addObject("maillot",maillotConverter.model2entity(maillot));
			}
		}
		maillotService.removeMaillot(id);
		return mav;
	}

}
