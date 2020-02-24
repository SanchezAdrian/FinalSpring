package example.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import example.converter.EtapaConverter;
import example.entity.Etapa;
import example.model.EtapaModel;
import example.repository.EtapaJpaRepository;
import example.service.EtapaService;

@Service
public class EtapaServiceImpl implements EtapaService {
	
	@Autowired
	@Qualifier("etapaJpaRepository")
	private EtapaJpaRepository etapaJpaRepository;
	
	@Autowired
	@Qualifier("etapaConverter")
	private EtapaConverter etapaConverter;
	
	

	@Override
	public List<EtapaModel> getListEtapa() {
		List<EtapaModel> etapaModel=new ArrayList<EtapaModel>();
		for(Etapa etapaEntity: etapaJpaRepository.findAll())
			etapaModel.add(etapaConverter.entity2model(etapaEntity));
		return etapaModel;
	}

	@Override
	public Etapa addEtapa(EtapaModel etapaModel) {
		Etapa etapa=etapaConverter.model2entity(etapaModel);
		return etapaJpaRepository.save(etapa);
	}

	@Override
	public int removeEtapa(int id) {
		 etapaJpaRepository.deleteById(id);
		 return 0;
	}

	@Override
	public Etapa updateEtapa(EtapaModel etapaModel) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Etapa findOne(int id) {
		Etapa etapa = etapaJpaRepository.findById(id).get();
		return etapa;
	}

}
