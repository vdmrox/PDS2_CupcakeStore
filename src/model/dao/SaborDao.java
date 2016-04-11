package model.dao;

import java.util.List;

import model.domain.Sabor;

public interface SaborDao {
	
	List<Sabor> getSabores(Sabor sabor);
	
	void excluir(Sabor sabor);
	
	void atualizar(Sabor sabor);
	
	Sabor salvar(Sabor sabor);
}

