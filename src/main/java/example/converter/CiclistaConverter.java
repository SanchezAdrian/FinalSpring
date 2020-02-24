package example.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import example.entity.Ciclista;
import example.model.CiclistaModel;
import example.repository.CiclistaJpaRepository;

@Component("ciclistaConverter")
public class CiclistaConverter {
	
	ModelMapper modelMapper = new ModelMapper(); 
	// Uso la libreria Model Mapper debido a que tras tratar de hacerlo de la forma explicada en las diapositivas
	// me encontre con el error de que no me permite cambiar los atributos que son de un tipo Modelo/entidad y para ello
	// buscando informacion encontre esta libreria y encontre oportuno su uso
	
	@Autowired
	@Qualifier("ciclistaJpaRepository")
	private CiclistaJpaRepository ciclistaJpaRepository;
	
		//Entity --> Model
		public CiclistaModel entity2model(Ciclista ciclista) {
		Ciclista saveCiclista = ciclistaJpaRepository.save(ciclista);
		CiclistaModel returnValue = modelMapper.map(saveCiclista, CiclistaModel.class);
		return returnValue;
		
		
		}
		
		//Model 2 Entity
		public Ciclista model2entity(CiclistaModel ciclistaModel) {
			Ciclista ciclista = modelMapper.map(ciclistaModel, Ciclista.class);
			return ciclista;
		}


}
