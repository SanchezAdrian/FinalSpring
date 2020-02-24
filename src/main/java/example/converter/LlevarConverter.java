package example.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import example.entity.Llevar;
import example.model.LlevarModel;
import example.repository.LlevarJpaRepository;

@Component("llevarConverter")
public class LlevarConverter {
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	@Qualifier("llevarJpaRepository")
	private LlevarJpaRepository llevarJpaRepository;
	
		//Entity --> Model
		public LlevarModel entity2model(Llevar llevar) {
		Llevar saveLlevar = llevarJpaRepository.save(llevar);
		LlevarModel returnValue = modelMapper.map(saveLlevar, LlevarModel.class);
		return returnValue;
		
		
		}
		
		//Model 2 Entity
		public Llevar model2entity(LlevarModel llevarModel) {
			Llevar llevar = modelMapper.map(llevarModel, Llevar.class);
			return llevar;
		}


}
