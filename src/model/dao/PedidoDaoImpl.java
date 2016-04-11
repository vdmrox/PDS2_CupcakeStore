package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Pedido;

public class PedidoDaoImpl implements PedidoDao{
	@PersistenceContext(unitName="CupcakeStorePU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Pedido> getPedidos(Pedido pedido) {
		StringBuffer hql = new StringBuffer("from Pedido p" + " where 1 = 1");		
		if (pedido.getIdPedido() != null) {
			hql.append(" and c.idPedido = :idPedido");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (pedido.getIdPedido() != null) {
			query.setParameter("idPedido",pedido.getIdPedido());
		} 
		return query.getResultList();
	}
	
	@Override
	@Transactional
	public void excluir(Pedido pedido){
		pedido = entityManager.merge(pedido);
		entityManager.remove(pedido);
	}

	@Override
	@Transactional
	public void atualizar(Pedido pedido) {
		pedido = entityManager.merge(pedido);
		entityManager.persist(pedido);
	}

	@Override
	@Transactional
	public Pedido salvar(Pedido pedido) {
		entityManager.persist(pedido);
		return pedido;
	}
	
}