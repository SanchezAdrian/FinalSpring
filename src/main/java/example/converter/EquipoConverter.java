package example.converter;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Component;

import example.entity.Equipo;
import example.model.EquipoModel;
import example.repository.EquipoJpaRepository;

@Component("equipoConverter")
public class EquipoConverter {
	
ModelMapper modelMapper = new ModelMapper();
	
	@Autowired
	@Qualifier("equipoJpaRepository")
	private EquipoJpaRepository equipoJpaRepository;

	
	//Entity --> Model
			public EquipoModel entity2model(Equipo equipo) {
			Equipo saveEquipo = equipoJpaRepository.save(equipo);
			EquipoModel returnValue = modelMapper.map(saveEquipo, EquipoModel.class);
			return returnValue;
			
			
			}
			
			//Model 2 Entity
			public Equipo model2entity(EquipoModel equipoModel) {
				Equipo equipo = modelMapper.map(equipoModel, Equipo.class);
				return equipo;
			}

}
