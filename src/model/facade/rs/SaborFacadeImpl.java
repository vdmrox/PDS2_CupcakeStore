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

import model.dao.SaborDao;
import model.domain.Sabor;
import model.facade.SaborFacade;

@Path("/sabor")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class SaborFacadeImpl implements SaborFacade{

	@Inject
	private SaborDao saborDao;
	
	@Override
	@GET
	public List<Sabor> getSabores(){
		return saborDao.getSabores(new Sabor());
	}
	
	@Override
	@GET
	@Path("/{idSabor}")
	public List<Sabor> getSabores(@PathParam("idSabor") Integer idSabor){
		Sabor sabor = new Sabor();
		sabor.setIdSabor(idSabor);
		return saborDao.getSabores(sabor);
	}
	
	@Override
	@POST
	public Sabor salvar(Sabor sabor){
		sabor = saborDao.salvar(sabor);
		return sabor;
	}
	
	@Override
	@PUT
	public void atualizar(Sabor sabor){
		saborDao.atualizar(sabor);
	}
	
	@Override
	@DELETE
	@Path("{/idSabor}")
	public void deletarSabor(@PathParam("idSabor") Integer idSabor){
		Sabor sabor = new Sabor();
		sabor.setIdSabor(idSabor);
		saborDao.excluir(sabor);
	}
}
