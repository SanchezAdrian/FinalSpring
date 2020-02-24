package example.service;

import java.util.List;

import example.entity.Etapa;
import example.model.EtapaModel;

public interface EtapaService {
	public abstract List<EtapaModel> getListEtapa();
	public abstract Etapa addEtapa(EtapaModel etapaModel);
	public abstract int removeEtapa(int id);
	public abstract Etapa updateEtapa(EtapaModel etapaModel);
	public abstract Etapa findOne(int id);

}
