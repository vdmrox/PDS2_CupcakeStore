package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import model.dao.PessoaDao;
import model.domain.Pessoa;

@WebService(serviceName="ws/pessoa")
public class PessoaFacadeImpl {
	
	@Inject
	private PessoaDao pessoaDao;
	
	@WebMethod
	public List<Pessoa> getPessoas() {
		return pessoaDao.getPessoas(new Pessoa());
	}
	
	@WebMethod(operationName="getPessoasParametro")
	public List<Pessoa> getPedidos(Pessoa pessoa) {
		return pessoaDao.getPessoas(pessoa);
	}
	
	@WebMethod
	public Pessoa salvar(Pessoa pessoa){
		return pessoaDao.salvar(pessoa);
	}
	
	@WebMethod
	public void atualizar(Pessoa pessoa){
		pessoaDao.atualizar(pessoa);
	}
	
	@WebMethod
	public void excluir(Pessoa pessoa){
		
		pessoaDao.excluir(pessoa);
	}

}