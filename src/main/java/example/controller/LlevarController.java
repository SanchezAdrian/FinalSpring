package example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import example.constantes.constantes;
import example.converter.LlevarConverter;
import example.entity.Llevar;
import example.model.CiclistaModel;
import example.model.EtapaModel;
import example.model.LlevarModel;
import example.model.MaillotModel;
import example.repository.LlevarJpaRepository;
import example.service.CiclistaService;
import example.service.EtapaService;
import example.service.LlevarService;
import example.service.MaillotService;


@Controller
@RequestMapping("/ciclistas")
public class LlevarController {

	@Autowired
	@Qualifier("llevarServiceImpl")
	private LlevarService llevarService;
	
	@Autowired
	@Qualifier("llevarConverter")
	private LlevarConverter llevarConverter;
	
	@Autowired
	@Qualifier("llevarJpaRepository")
	private LlevarJpaRepository llevarJpaRepositoy;
	
	@Autowired
	@Qualifier("ciclistaServiceImpl")
	private CiclistaService ciclistaService;
	
	@Autowired
	@Qualifier("maillotServiceImpl")
	private MaillotService maillotService;
	

	@Autowired
	@Qualifier("etapaServiceImpl")
	private EtapaService etapaService;
	
	
	@GetMapping("/listaGanadores")
	public ModelAndView listaGanadores() {
		ModelAndView mav = new ModelAndView(constantes.GANADORES_VIEW);
		mav.addObject("llevar",new Llevar());
		mav.addObject("llevars",llevarService.getListLlevar());
		return mav;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
	@GetMapping("/createGanadores")
	public ModelAndView createGanadores() {
		ModelAndView mav = new ModelAndView(constantes.CREATEGA_VIEW);
		mav.addObject("ciclistas",ciclistaService.getListciclista());
		mav.addObject("maillots",maillotService.getListMaillot());
		mav.addObject("etapas",etapaService.getListEtapa());
		
		return mav;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_USER')")
	@PostMapping("/addGanadores")
	public ModelAndView addGanadores(@ModelAttribute("llevar") LlevarModel llevarModel,@RequestParam(name="et") int et, @RequestParam(name="ma") String ma,@RequestParam(name="ci") int ci) {
		ModelAndView mav = new ModelAndView(constantes.GANADORES_VIEW);
		
		// añadimos etapa
		for(EtapaModel etapaModel:etapaService.getListEtapa() ) {
			if(et == (etapaModel.getNetapa())) {
				llevarModel.setNetapa(etapaModel);;
			}
		}
		// añadimos ciclistas 
		for(CiclistaModel ciclistaModel:ciclistaService.getListciclista()) {
			if( ci == ciclistaModel.getDorsal()) {
				llevarModel.setDorsal(ciclistaModel);
			}
		}
		// añadimos maillot 
		for(MaillotModel maillotModel:maillotService.getListMaillot()) {
			if(ma.equals(maillotModel.getCodigo())) {
				llevarModel.setCodigo(maillotModel);
			}
		}
		
		llevarService.addLlevar(llevarModel);
		mav.addObject("llevar",new Llevar());
		mav.addObject("llevars",llevarService.getListLlevar());
		return mav;
		
	}
	
	
}
