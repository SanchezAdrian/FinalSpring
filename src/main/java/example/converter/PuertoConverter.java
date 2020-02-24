package example.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import example.entity.Puerto;
import example.model.PuertoModel;
import example.repository.PuertoJpaRepository;

@Component("puertoConverter")
public class PuertoConverter {
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	@Qualifier("puertoJpaRepository")
	private PuertoJpaRepository puertoJpaRepository;
	
		//Entity --> Model
		public PuertoModel entity2model(Puerto puerto) {
		Puerto savePuerto = puertoJpaRepository.save(puerto);
		PuertoModel returnValue = modelMapper.map(savePuerto, PuertoModel.class);
		return returnValue;
		
		
		}
		
		//Model 2 Entity
		public Puerto model2entity(PuertoModel puertoModel) {
			Puerto puerto = modelMapper.map(puertoModel, Puerto.class);
			return puerto;
		}


}
