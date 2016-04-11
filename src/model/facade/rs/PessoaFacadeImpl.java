package model.facade.rs;

import java.util.List;

import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

import model.dao.PessoaDao;
import model.domain.Pessoa;
import model.facade.PessoaFacade;

@Path("/pessoa")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PessoaFacadeImpl implements PessoaFacade{

	@Inject
	private PessoaDao pessoaDao;
	
	@Override
	@GET
	public List<Pessoa> getPessoas(){
		return pessoaDao.getPessoas(new Pessoa());
	}
	
	@Override
	@GET
	@Path("/{idPedido}")
	public List<Pessoa> getPessoas(@PathParam("idPessoa") Integer idPessoa){
		Pessoa pessoa = new Pessoa();
		pessoa.setIdPessoa(idPessoa);
		return pessoaDao.getPessoas(pessoa);
	}
	
	@Override
	@POST
	public Pessoa salvar(Pessoa pessoa){
		pessoa = pessoaDao.salvar(pessoa);
		return pessoa;
	}
	
	@Override
	@PUT
	public void atualizar(Pessoa pessoa){
		pessoaDao.atualizar(pessoa);
	}
	
	@Override
	@DELETE
	@Path("{/idPessoa}")
	public void deletarPessoa(@PathParam("idPessoa") Integer idPessoa){
		Pessoa pessoa = new Pessoa();
		pessoa.setIdPessoa(idPessoa);
		pessoaDao.excluir(pessoa);
	}
}
