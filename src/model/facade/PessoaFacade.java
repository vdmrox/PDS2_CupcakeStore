package model.facade;

import java.util.List;

import model.domain.Pessoa;

public interface PessoaFacade {
	
	List<Pessoa> getPessoas();

	List<Pessoa> getPessoas(Integer id);

	void deletarPessoa(Integer id);

	Pessoa salvar(Pessoa pessoa);

	void atualizar(Pessoa pessoa);

}
