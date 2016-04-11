package model.dao;

import java.util.List;

import model.domain.Pedido;

public interface PedidoDao {
	
	List<Pedido> getPedidos(Pedido pedido);
	
	void excluir(Pedido pedido);
	
	void atualizar(Pedido pedido);
	
	Pedido salvar(Pedido pedido);
}
