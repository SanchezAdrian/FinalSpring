package example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import example.entity.Ciclista;
import example.model.CiclistaModel;
import example.repository.CiclistaJpaRepository;
import example.service.CiclistaService;
import example.service.EquipoService;
import example.service.LlevarService;

@RestController
@RequestMapping("/ciclistas")
public class ApiController {
	

	@Autowired
	@Qualifier("ciclistaServiceImpl")
	private CiclistaService ciclistaService;
	
	@Autowired
	@Qualifier("ciclistaJpaRepository")
	private CiclistaJpaRepository ciclistaJpa;
	
	@Autowired
	@Qualifier("equipoServiceImpl")
	private EquipoService equipoService;
	
	@Autowired
	@Qualifier("llevarServiceImpl")
	private LlevarService llevarService;
	
	@GetMapping("/ciclistasApi")
	public @ResponseBody List<Ciclista> listCiclista() {
		return ciclistaJpa.findAll();
	}
	
	@GetMapping("/ciclistasApi/{id}")
	public @ResponseBody Ciclista getCiclista(@PathVariable int id) {
		return ciclistaService.findOne(id);
	}
	
	@PutMapping("ciclistasApi")
	public CiclistaModel updateCiclista(@RequestBody CiclistaModel ciclista) {
		ciclistaService.addCiclista(ciclista);
		return ciclista;
	}

}
