package example.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import example.converter.PuertoConverter;
import example.entity.Puerto;
import example.model.PuertoModel;
import example.repository.PuertoJpaRepository;
import example.service.PuertoService;

@Service
public class PuertoServiceImpl implements PuertoService {

	@Autowired
	@Qualifier("puertoJpaRepository")
	private PuertoJpaRepository puertoJpaRepository;
	
	@Autowired
	@Qualifier("puertoConverter")
	private PuertoConverter puertoConverter;

	@Override
	public List<PuertoModel> getListPuerto() {
		List<PuertoModel> puertoModel=new ArrayList<PuertoModel>();
		for(Puerto puertoEntity: puertoJpaRepository.findAll())
			puertoModel.add(puertoConverter.entity2model(puertoEntity));
		return puertoModel;
	}


	@Override
	public Puerto addPuerto(PuertoModel puertoModel) {
		Puerto puerto=puertoConverter.model2entity(puertoModel);
		return puertoJpaRepository.save(puerto);
	}

	@Override
	public int removePuerto(String id) {
		puertoJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Puerto updatePuerto(PuertoModel puertoModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
