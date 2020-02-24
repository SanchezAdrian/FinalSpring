package example.service;

import java.util.List;

import example.entity.Puerto;
import example.model.PuertoModel;

public interface PuertoService {
	public abstract List<PuertoModel> getListPuerto();
	public abstract Puerto addPuerto(PuertoModel puertoModel);
	public abstract int removePuerto(String id);
	public abstract Puerto updatePuerto(PuertoModel puertoModel);

}
