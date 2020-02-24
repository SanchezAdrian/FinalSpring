package example.service;

import java.util.List;


import example.entity.Ciclista;
import example.model.CiclistaModel;

public interface CiclistaService {
	
	public abstract List<CiclistaModel> getListciclista();
	public abstract Ciclista addCiclista(CiclistaModel ciclistaModel);
	public abstract int removeCiclista(int id);
	
	public abstract Ciclista findOne(int id);
	Ciclista updateCiclista(CiclistaModel ciclistaModel, int id);

}
