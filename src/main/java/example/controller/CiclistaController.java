package example.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;


import org.apache.juli.logging.Log;
import org.apache.juli.logging.LogFactory;
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
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import example.constantes.constantes;
import example.converter.CiclistaConverter;
import example.converter.LlevarConverter;
import example.entity.Ciclista;
import example.model.CiclistaModel;
import example.model.EquipoModel;
import example.model.LlevarModel;
import example.service.CiclistaService;
import example.service.EquipoService;
import example.service.LlevarService;


@Controller
@RequestMapping("/ciclistas")
public class CiclistaController {
	
	private static final Log LOG=LogFactory.getLog(CiclistaController.class);
	
	@Autowired
	@Qualifier("ciclistaServiceImpl")
	private CiclistaService ciclistaService;
	
	@Autowired
	@Qualifier("equipoServiceImpl")
	private EquipoService equipoService;
	
	@Autowired
	@Qualifier("llevarServiceImpl")
	private LlevarService llevarService;
	
	@Autowired
	@Qualifier("ciclistaConverter")
	private CiclistaConverter ciclistaConverter;
	
	@Autowired
	@Qualifier("llevarConverter")
	private LlevarConverter llevarConverter;
	
	@GetMapping("/listaCiclistas")
	public ModelAndView listaCiclistas() {
		ModelAndView mav=new ModelAndView(constantes.CICLISTAS_VIEW);
		mav.addObject("ciclista",new Ciclista());
		mav.addObject("ciclistas",ciclistaService.getListciclista());
		return mav;
	}
	
	@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_TEAM')")
	@PostMapping("/addCiclistas")
	public ModelAndView addCiclista(RedirectAttributes flash,@RequestParam("file") MultipartFile foto,@RequestParam(name="eq") String eq, @ModelAttribute("ciclista") CiclistaModel ciclistaModel) {
		ModelAndView mav=new ModelAndView(constantes.CICLISTAS_VIEW);
		
		if (!foto.isEmpty()) {
			Path directorioRecursos=Paths.get("src/main//resources//static/image");
			String rootPath=directorioRecursos.toFile().getAbsolutePath();
			try {
				byte[] bytes=foto.getBytes();
				Path rutaCompleta=Paths.get(rootPath+"//"+ciclistaModel.getNombre()+".png");
				Files.write(rutaCompleta, bytes);
				flash.addAttribute("info","Se ha subido correctamente");
				ciclistaModel.setFoto("/image/"+ciclistaModel.getNombre()+".png");	
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			ciclistaModel.setFoto("/image/avatar.png");	
		}
		
		for(EquipoModel equipoModel:equipoService.getListEquipo()) {
			if(eq.equals(equipoModel.getNomeq())) {
				ciclistaModel.setNomeq(equipoModel);
			}
		}
		ciclistaService.addCiclista(ciclistaModel);
		mav.addObject("ciclistas",ciclistaService.getListciclista());
		return mav;
	}
	

	
	@PreAuthorize("hasRole('ROLE_USER') OR hasRole('ROLE_TEAM')")
	@GetMapping("/createCiclistas")
	public ModelAndView createCiclista() {
		ModelAndView mav=new ModelAndView(constantes.CREATECI_VIEW);
		mav.addObject("ciclista",new Ciclista());
		mav.addObject("equipos",equipoService.getListEquipo());
		LOG.info("Devolvemos la vista de crear ciclistas con los equipos para poder seleccionarlos");
		return mav;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_TEAM')")
	@RequestMapping(value="/deleteCiclistas/{id}")
	public String deleteCiclista(@PathVariable("id") int id, RedirectAttributes flash) {
	    ciclistaService.removeCiclista(id);
	
	    return "redirect:/ciclistas/listaCiclistas";
	}
	
	@RequestMapping(value="/detailCiclistas/{id}")
	public ModelAndView detailCiclistas(@PathVariable("id") int id) {
		ModelAndView mav=new ModelAndView(constantes.DETAILCI_VIEW);
		for(CiclistaModel ciclistaModel:ciclistaService.getListciclista()) {
			if(id == ciclistaModel.getDorsal()) {
				mav.addObject("ciclista",ciclistaConverter.model2entity(ciclistaModel));
			}
			for(LlevarModel llevarModel:llevarService.getListLlevar()) {
				if (ciclistaModel.getLlevars() == llevarModel) {
					mav.addObject("llevar",llevarConverter.model2entity(llevarModel));
				}
			}
			
		}
		
		return mav;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_TEAM')")
	@RequestMapping("/editCiclistas/{id}")
	public ModelAndView editCiclista(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView(constantes.CREATECI_VIEW);
		
		for(CiclistaModel ciclistaModel:ciclistaService.getListciclista()) {
			if(id == ciclistaModel.getDorsal()) {
				mav.addObject("ciclista",ciclistaConverter.model2entity(ciclistaModel));
			}
		}
		LOG.info("Devolvemos la vista de crear ciclistas con los equipos para poder seleccionarlos");
		mav.addObject("equipos",equipoService.getListEquipo());
		return mav;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_TEAM')")
	@RequestMapping("/rmCiclistas/{id}")
	public ModelAndView tmCiclista(@PathVariable("id") int id) {
		ModelAndView mav = new ModelAndView("EditCiclistas");
		for(CiclistaModel ciclista:ciclistaService.getListciclista()) {
			if(id == ciclista.getDorsal()) {
				mav.addObject("ciclista",ciclistaConverter.model2entity(ciclista));
			}
		}
		mav.addObject("equipos",equipoService.getListEquipo());
		// ciclistaService.removeCiclista(id);
		return mav;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_TEAM')")
	@PostMapping("/updateCiclistas")
	public ModelAndView updateCiclista(@RequestParam(name="newDorsal")int newDorsal,RedirectAttributes flash,@RequestParam("file") MultipartFile foto,@RequestParam(name="eq") String eq, @ModelAttribute("ciclista") CiclistaModel ciclistaModel) {
		ModelAndView mav=new ModelAndView(constantes.CICLISTAS_VIEW);
		System.out.println(newDorsal);
		if (!foto.isEmpty()) {
			Path directorioRecursos=Paths.get("src/main//resources//static/image");
			String rootPath=directorioRecursos.toFile().getAbsolutePath();
			try {
				byte[] bytes=foto.getBytes();
				Path rutaCompleta=Paths.get(rootPath+"//"+ciclistaModel.getNombre()+".png");
				Files.write(rutaCompleta, bytes);
				flash.addAttribute("info","Se ha subido correctamente");
				ciclistaModel.setFoto("/image/"+ciclistaModel.getNombre()+".png");	
			} catch (IOException e) {
				e.printStackTrace();
			}
		} else {
			ciclistaModel.setFoto("/image/avatar.png");	
		}
		
		for(EquipoModel equipoModel:equipoService.getListEquipo()) {
			if(eq.equals(equipoModel.getNomeq())) {
				ciclistaModel.setNomeq(equipoModel);
			}
		}
		
		int oldId = ciclistaModel.getDorsal();
		System.out.println(ciclistaModel.getDorsal());
		LOG.info(newDorsal + "Id de parametros");
		ciclistaModel.setDorsal(newDorsal);
		ciclistaService.updateCiclista(ciclistaModel,newDorsal);
		ciclistaService.removeCiclista(oldId);
		mav.addObject("ciclistas",ciclistaService.getListciclista());
		return mav;
	}
	
	

}
