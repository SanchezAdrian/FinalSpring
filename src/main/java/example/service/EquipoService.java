package example.service;

import java.util.List;


import example.entity.Equipo;
import example.model.EquipoModel;

public interface EquipoService {
	public abstract List<EquipoModel> getListEquipo();
	public abstract Equipo addEquipo(EquipoModel equipoModel);
	public abstract int removeEquipo(String id);
	public abstract Equipo updateEquipo(EquipoModel equipoModel);
	public abstract Equipo findOne(String id);

}
