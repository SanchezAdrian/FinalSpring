package example.service;

import java.util.List;

import example.entity.Maillot;
import example.model.MaillotModel;

public interface MaillotService {

	public abstract List<MaillotModel> getListMaillot();
	public abstract Maillot addMaillot(MaillotModel maillotModel);
	public abstract int removeMaillot(String id);
	public abstract Maillot updateMaillot(MaillotModel maillotModel);

}
