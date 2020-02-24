package example.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import example.entity.Maillot;
import example.model.MaillotModel;
import example.repository.MaillotJpaRepository;

@Component("maillotConverter")
public class MaillotConverter {
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	@Qualifier("maillotJpaRepository")
	private MaillotJpaRepository maillotJpaRepository;
	
		//Entity --> Model
		public MaillotModel entity2model(Maillot maillot) {
		Maillot saveMaillot = maillotJpaRepository.save(maillot);
		MaillotModel returnValue = modelMapper.map(saveMaillot, MaillotModel.class);
		return returnValue;
		
		
		}
		
		//Model 2 Entity
		public Maillot model2entity(MaillotModel maillotModel) {
			Maillot maillot = modelMapper.map(maillotModel, Maillot.class);
			return maillot;
		}


}
