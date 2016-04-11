package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import model.dao.PedidoDao;
import model.domain.Pedido;

@WebService(serviceName="ws/pedido")
public class PedidoFacadeImpl {
	
	@Inject
	private PedidoDao pedidoDao;
	
	@WebMethod
	public List<Pedido> getPedidos() {
		return pedidoDao.getPedidos(new Pedido());
	}
	
	@WebMethod(operationName="getPedidosParametro")
	public List<Pedido> getPedidos(Pedido pedido) {
		return pedidoDao.getPedidos(pedido);
	}
	
	@WebMethod
	public Pedido salvar(Pedido pedido){
		return pedidoDao.salvar(pedido);
	}
	
	@WebMethod
	public void atualizar(Pedido pedido){
		pedidoDao.atualizar(pedido);
	}
	
	@WebMethod
	public void excluir(Pedido pedido){
		pedidoDao.excluir(pedido);
	}

}
