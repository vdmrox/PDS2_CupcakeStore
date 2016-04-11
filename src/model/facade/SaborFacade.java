package model.facade;

import java.util.List;

import model.domain.Sabor;

public interface SaborFacade {
	
	List<Sabor> getSabores();

	List<Sabor> getSabores(Integer idSabor);

	void deletarSabor(Integer idSabor);

	Sabor salvar(Sabor sabor);

	void atualizar(Sabor sabor);

}
