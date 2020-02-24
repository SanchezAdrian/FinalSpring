package example.controller;


import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

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
import example.converter.EquipoConverter;
import example.entity.Equipo;
import example.model.CiclistaModel;
import example.model.EquipoModel;
import example.service.CiclistaService;
import example.service.EquipoService;

@Controller
@RequestMapping("/ciclistas")
public class EquipoController {
	
	private static final Log LOG=LogFactory.getLog(EquipoController.class);
	
	@Autowired
	@Qualifier("equipoConverter")
	private EquipoConverter equipoConverter;
	
	@Autowired
	@Qualifier("equipoServiceImpl")
	private EquipoService equipoService;
	
	@Autowired
	@Qualifier("ciclistaServiceImpl")
	private CiclistaService ciclistaService;
	
	@Autowired
	@Qualifier("ciclistaConverter")
	private CiclistaConverter ciclistaConverter;
	
	@GetMapping("/listaEquipos")
	public ModelAndView listaEquipos() {
		ModelAndView mav=new ModelAndView(constantes.EQUIPOS_VIEW);
		mav.addObject("equipo",new Equipo());
		mav.addObject("equipos",equipoService.getListEquipo());
		return mav;
	}
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_TEAM')")
	@GetMapping("/createEquipos")
	public ModelAndView createEquipo() {
		ModelAndView mav = new ModelAndView(constantes.CREATEEQ_VIEW);
		mav.addObject("equipo",new Equipo());
		return mav;
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_TEAM')")
	@PostMapping("/addEquipos")
	public ModelAndView addEquipo(RedirectAttributes flash,@RequestParam("file") MultipartFile foto ,@ModelAttribute("equipo") EquipoModel equipoModel) {
	ModelAndView mav=new ModelAndView(constantes.EQUIPOS_VIEW);
	
	if (!foto.isEmpty()) {
		Path directorioRecursos=Paths.get("src/main//resources//static/image");
		String rootPath=directorioRecursos.toFile().getAbsolutePath();
		try {
			byte[] bytes=foto.getBytes();
			Path rutaCompleta=Paths.get(rootPath+"//"+equipoModel.getNomeq()+".png");
			Files.write(rutaCompleta, bytes);
			flash.addAttribute("info","Se ha subido correctamente");
			equipoModel.setLogo("/image/"+equipoModel.getNomeq()+".png");	
		} catch (IOException e) {
			e.printStackTrace();
		}
	} else {
		equipoModel.setLogo("/image/logo.png");	
	}
	
	equipoService.addEquipo(equipoModel);
	mav.addObject("equipos",equipoService.getListEquipo());
	return mav;

	}
	
	@GetMapping(value="/verEquipo/{id}")
	public String ver(@PathVariable(value="id") String id, Map<String,Object> model,RedirectAttributes flash)  {
		Equipo equipo=equipoService.findOne(id);
		if (equipo==null) {
			flash.addAttribute("error","no existe ese equipo");
			return "redirect:/ciclistas/listaEquipos";
		}
		model.put("equipo", equipo);
		model.put("titulo", "Detalle equipo: "+equipo.getNomeq());
		return "ver";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_TEAM')")
	@RequestMapping(value="/deleteEquipos/{id}")
	public String deleteEquipo(@PathVariable("id") String id, RedirectAttributes flash) {
		
		equipoService.removeEquipo(id);
		
		
		return "redirect:/ciclistas/listaEquipos";
	}
	
	@PreAuthorize("hasRole('ROLE_ADMIN') OR hasRole('ROLE_TEAM')")
	@RequestMapping("/editEquipos/{id}")
	public ModelAndView editEquipo(@PathVariable("id") String id) {
		ModelAndView mav = new ModelAndView(constantes.EDITEQ_VIEW);
		
		for(EquipoModel equipo:equipoService.getListEquipo()) {
			if(id.equals(equipo.getNomeq())) {
				mav.addObject("equipo",equipoConverter.model2entity(equipo));
			}
		}
		return mav;
	}
	
	// metodo para borrar el puerto y volver a crearlo pudiendo cambiar el id
	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@RequestMapping("/rmEquipos/{id}")
	public ModelAndView tmEquipo(@PathVariable("id") String id) {
		ModelAndView mav = new ModelAndView(constantes.CREATEEQ_VIEW);
		
		for(EquipoModel equipo:equipoService.getListEquipo()) {
			if(id.equals(equipo.getNomeq())) {
				mav.addObject("equipo",equipoConverter.model2entity(equipo));
			}
		}
		equipoService.removeEquipo(id);
		return mav;
	}
	
	@RequestMapping(value="/detailEquipos/{id}")
	public ModelAndView detailEquipos(@PathVariable("id") String id) {
		ModelAndView mav=new ModelAndView(constantes.DETAILEQ_VIEW);
		
		List<CiclistaModel> ciclistas=new ArrayList<CiclistaModel>();
		
		for(EquipoModel equipo:equipoService.getListEquipo()) {
			if(id.equals(equipo.getNomeq())) {
				mav.addObject("equipo",equipoConverter.model2entity(equipo));
				for(CiclistaModel ciclista:ciclistaService.getListciclista()) {
					if (ciclista.getNomeq().getNomeq().equals(equipo.getNomeq())) {
						ciclistas.add(ciclista);
					}
				}
			}
			
			}
			LOG.info("listAAAA"+ciclistas);
		mav.addObject("ciclistas",ciclistas);
		return mav;
	
	}	
}
