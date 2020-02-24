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
import example.converter.EtapaConverter;
import example.entity.Etapa;
import example.model.CiclistaModel;
import example.model.EtapaModel;
import example.service.CiclistaService;
import example.service.EtapaService;

@Controller
@RequestMapping("/ciclistas")
public class EtapaController {
	

	
	@Autowired
	@Qualifier("etapaServiceImpl")
	private EtapaService etapaService;
	
	@Autowired
	@Qualifier("ciclistaServiceImpl")
	private CiclistaService ciclistaService;
	
	@Autowired
	@Qualifier("etapaConverter")
	private EtapaConverter etapaConverter;
	
	
	
	@GetMapping("/listaEtapas")
	public ModelAndView listaEtapas() {
		ModelAndView mav=new ModelAndView(constantes.ETAPAS_VIEW);
		mav.addObject("etapa",new Etapa());
		mav.addObject("etapas",etapaService.getListEtapa());
		return mav;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@GetMapping("/createEtapas")
	public ModelAndView createEtapa() {
		ModelAndView mav= new ModelAndView(constantes.CREATEET_VIEW);
		mav.addObject("etapa",new Etapa());
		mav.addObject("ciclistas",ciclistaService.getListciclista());
		return mav;
	}
	
	@PostMapping("/addEtapas")
	public ModelAndView addEtapa(@RequestParam(name="ci") int ci, @ModelAttribute("etapa") EtapaModel etapaModel) {
		ModelAndView mav=new ModelAndView(constantes.ETAPAS_VIEW);
		
		for(CiclistaModel ciclistaModel:ciclistaService.getListciclista()) {
			if(ciclistaModel.getDorsal() == ci) {
				etapaModel.setDorsal(ciclistaModel);
			}	
		}
		etapaService.addEtapa(etapaModel);
		mav.addObject("etapas",etapaService.getListEtapa());
		return mav;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping(value="/deleteEtapas/{id}")
	public String deleteCiclista(@PathVariable("id") int id) {
	    etapaService.removeEtapa(id);
	    return "redirect:/ciclistas/listaEtapas";
	}
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/rmtEtapas/{id}")
	public ModelAndView editEquipo(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView(constantes.CREATEET_VIEW);
		
		for(EtapaModel etapa:etapaService.getListEtapa() ) {
			if(id == etapa.getNetapa()) {
				mav.addObject("etapa",etapaConverter.model2entity(etapa));
			}
		}
		
		mav.addObject("ciclistas",ciclistaService.getListciclista());
		etapaService.removeEtapa(id);
		return mav;
	}

}
