package example.service.Impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import example.converter.MaillotConverter;
import example.entity.Maillot;
import example.model.MaillotModel;
import example.repository.MaillotJpaRepository;
import example.service.MaillotService;

@Service
public class MaillotServiceImpl implements MaillotService {

	@Autowired
	@Qualifier("maillotJpaRepository")
	private MaillotJpaRepository maillotJpaRepository;
	
	@Autowired
	@Qualifier("maillotConverter")
	private MaillotConverter maillotConverter;

	@Override
	public List<MaillotModel> getListMaillot() {
		List<MaillotModel> maillotModel=new ArrayList<MaillotModel>();
		for(Maillot maillotEntity: maillotJpaRepository.findAll())
			maillotModel.add(maillotConverter.entity2model(maillotEntity));
		return maillotModel;
	}


	@Override
	public Maillot addMaillot(MaillotModel maillotModel) {
		Maillot maillot=maillotConverter.model2entity(maillotModel);
		return maillotJpaRepository.save(maillot);
	}

	@Override
	public int removeMaillot(String id) {
		maillotJpaRepository.deleteById(id);
		return 0;
	}

	@Override
	public Maillot updateMaillot(MaillotModel maillotModel) {
		return null;
	}

}
