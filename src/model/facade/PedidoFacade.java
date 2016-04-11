package model.facade;

import java.util.List;

import model.domain.Pedido;

public interface PedidoFacade {
	
	List<Pedido> getPedidos();

	List<Pedido> getPedidos(Integer idPedido);

	void deletarPedido(Integer idPedido);

	Pedido salvar(Pedido pedido);

	void atualizar(Pedido pedido);

}
