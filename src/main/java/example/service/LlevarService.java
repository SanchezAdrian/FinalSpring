package example.service;

import java.util.List;

import example.entity.Llevar;
import example.model.LlevarModel;

public interface LlevarService {
	public abstract List<LlevarModel> getListLlevar();
	public abstract Llevar addLlevar(LlevarModel llevarModel);
	public abstract int removeLlevar(int id);
	public abstract Llevar updateLlevar(LlevarModel llevarModel);

}
