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

import model.dao.PedidoDao;
import model.domain.Pedido;
import model.facade.PedidoFacade;

@Path("/pedido")
@Consumes({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
@Produces({MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PedidoFacadeImpl implements PedidoFacade{

	@Inject
	private PedidoDao pedidoDao;
	
	@Override
	@GET
	public List<Pedido> getPedidos(){
		return pedidoDao.getPedidos(new Pedido());
	}
	
	@Override
	@GET
	@Path("/{idPedido}")
	public List<Pedido> getPedidos(@PathParam("idPedido") Integer idPedido){
		Pedido pedido = new Pedido();
		pedido.setIdPedido(idPedido);
		return pedidoDao.getPedidos(pedido);
	}
	
	@Override
	@POST
	public Pedido salvar(Pedido pedido){
		pedido = pedidoDao.salvar(pedido);
		return pedido;
	}
	
	@Override
	@PUT
	public void atualizar(Pedido pedido){
		pedidoDao.atualizar(pedido);
	}
	
	@Override
	@DELETE
	@Path("/{idPedido}")
	public void deletarPedido(@PathParam("idPedido") Integer idPedido){
		Pedido pedido = new Pedido();
		pedido.setIdPedido(idPedido);
		pedidoDao.excluir(pedido);
	}
}
