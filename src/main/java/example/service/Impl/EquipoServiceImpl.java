package example.service.Impl;

import java.util.ArrayList;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import example.converter.EquipoConverter;
import example.entity.Equipo;
import example.model.EquipoModel;
import example.repository.EquipoJpaRepository;
import example.service.EquipoService;

@Service
public class EquipoServiceImpl implements EquipoService {
	

	@Autowired
	@Qualifier("equipoJpaRepository")
	private EquipoJpaRepository equipoJpaRepository;
	
	@Autowired
	@Qualifier("equipoConverter")
	private EquipoConverter equipoConverter;

	@Override
	public List<EquipoModel> getListEquipo() {
		List<EquipoModel> equipoModel=new ArrayList<EquipoModel>();
		for(Equipo equipoEntity: equipoJpaRepository.findAll())
			equipoModel.add(equipoConverter.entity2model(equipoEntity));
		return equipoModel;
	}

	@Override
	public Equipo addEquipo(EquipoModel equipoModel) {
		Equipo equipo=equipoConverter.model2entity(equipoModel);
		return equipoJpaRepository.save(equipo);
	}
	
	@Override
	public Equipo findOne(String id) {
		Equipo equipo = equipoJpaRepository.findById(id).get();
		return equipo;
	}

	@Override
	public int removeEquipo(String id) {
		equipoJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Equipo updateEquipo(EquipoModel equipoModel) {
		Equipo equipo=equipoConverter.model2entity(equipoModel);
		equipoJpaRepository.deleteById(equipoModel.getNomeq());
		return equipoJpaRepository.save(equipo);
	}

}
