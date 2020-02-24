package example.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import example.converter.LlevarConverter;
import example.entity.Llevar;
import example.model.LlevarModel;
import example.repository.LlevarJpaRepository;
import example.service.LlevarService;

@Service
public class LlevarServiceImpl implements LlevarService {
	
	

	@Autowired
	@Qualifier("llevarJpaRepository")
	private LlevarJpaRepository llevarJpaRepository;
	
	@Autowired
	@Qualifier("llevarConverter")
	private LlevarConverter llevarConverter;

	@Override
	public List<LlevarModel> getListLlevar() {
		List<LlevarModel> llevarModel=new ArrayList<LlevarModel>();
		for(Llevar llevarEntity: llevarJpaRepository.findAll())
			llevarModel.add(llevarConverter.entity2model(llevarEntity));
		return llevarModel;
	}


	@Override
	public Llevar addLlevar(LlevarModel llevarModel) {
		Llevar llevar = llevarConverter.model2entity(llevarModel);
		return llevarJpaRepository.save(llevar);
	}

	@Override
	public int removeLlevar(int id) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Llevar updateLlevar(LlevarModel llevarModel) {
		// TODO Auto-generated method stub
		return null;
	}

}
