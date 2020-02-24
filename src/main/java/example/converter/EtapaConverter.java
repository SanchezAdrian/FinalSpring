package example.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import example.entity.Etapa;
import example.model.EtapaModel;
import example.repository.EtapaJpaRepository;

@Component("etapaConverter")
public class EtapaConverter {
	
	ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	@Qualifier("etapaJpaRepository")
	private EtapaJpaRepository etapaJpaRepository;
	
		//Entity --> Model
		public EtapaModel entity2model(Etapa etapa) {
		Etapa saveEtapa = etapaJpaRepository.save(etapa);
		EtapaModel returnValue = modelMapper.map(saveEtapa, EtapaModel.class);
		return returnValue;
		
		
		}
		
		//Model 2 Entity
		public Etapa model2entity(EtapaModel etapaModel) {
			Etapa etapa = modelMapper.map(etapaModel, Etapa.class);
			return etapa;
		}


}
