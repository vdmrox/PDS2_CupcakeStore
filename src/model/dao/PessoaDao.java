package model.dao;

import java.util.List;

import model.domain.Pessoa;

public interface PessoaDao {
	
	List<Pessoa> getPessoas(Pessoa pessoa);
	
	void excluir(Pessoa pessoa);
	
	void atualizar(Pessoa pessoa);
	
	Pessoa salvar(Pessoa pessoa);
}
