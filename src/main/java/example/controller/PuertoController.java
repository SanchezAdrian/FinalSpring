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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import example.constantes.constantes;
import example.converter.PuertoConverter;
import example.entity.Puerto;
import example.model.CiclistaModel;
import example.model.EtapaModel;
import example.model.PuertoModel;
import example.service.CiclistaService;
import example.service.EtapaService;
import example.service.PuertoService;


@Controller
@RequestMapping("/ciclistas")
public class PuertoController {
	
	@Autowired
	@Qualifier("puertoConverter")
	private PuertoConverter puertoConverter;
	
	@Autowired
	@Qualifier("puertoServiceImpl")
	private PuertoService puertoService;
	
	@Autowired
	@Qualifier("etapaServiceImpl")
	private EtapaService etapaService;
	
	@Autowired
	@Qualifier("ciclistaServiceImpl")
	private CiclistaService ciclistaService;
	
	@GetMapping("/listaPuertos")
	public ModelAndView listapuertos() {
		ModelAndView mav=new ModelAndView(constantes.PUERTOS_VIEW);
		mav.addObject("puerto",new Puerto());
		mav.addObject("puertos",puertoService.getListPuerto());
		return mav;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/createPuertos")
	public ModelAndView createPuerto() {
		ModelAndView mav=new ModelAndView(constantes.CREATEPU_VIEW);
		mav.addObject("puerto",new Puerto());
		mav.addObject("ciclistas",ciclistaService.getListciclista());
		mav.addObject("etapas",etapaService.getListEtapa());
		return mav;
	}
	
	@PostMapping("/addPuertos")
	public ModelAndView addPuerto(@RequestParam(name="net") int net, @RequestParam(name="ci") int ci, @ModelAttribute PuertoModel puertoModel) {
		ModelAndView mav= new ModelAndView(constantes.PUERTOS_VIEW);
		
		for(CiclistaModel ciclistaModel:ciclistaService.getListciclista()) {
			if(ci == ciclistaModel.getDorsal()) {
				puertoModel.setDorsal(ciclistaModel);
			}
		}
		
		for(EtapaModel etapaModel:etapaService.getListEtapa()) {
			if (net == etapaModel.getNetapa()) {
				puertoModel.setNetapa(etapaModel);
			}
		}
		
		puertoService.addPuerto(puertoModel);
		mav.addObject("puertos",puertoService.getListPuerto());
		return mav;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/deletePuertos/{id}")
	public String deleteCiclista(@PathVariable("id") String id) {
		puertoService.removePuerto(id);
		return "redirect:/ciclistas/listaEtapas";
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/rmPuertos/{id}")
	public ModelAndView editEquipo(@PathVariable("id") String id) {
		ModelAndView mav = new ModelAndView(constantes.CREATEPU_VIEW);
		
		for(PuertoModel puerto:puertoService.getListPuerto() ) {
			if(id.equals(puerto.getNompuerto())) {
				mav.addObject("puerto",puertoConverter.model2entity(puerto));
			}
		}
		
		mav.addObject("ciclistas",ciclistaService.getListciclista());
		mav.addObject("etapas",etapaService.getListEtapa());
		puertoService.removePuerto(id);
		return mav;
	}
}
