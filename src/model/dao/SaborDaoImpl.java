package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Sabor;

public class SaborDaoImpl implements SaborDao{
	@PersistenceContext(unitName="CupcakeStorePU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Sabor> getSabores(Sabor sabor) {
		StringBuffer hql = new StringBuffer("from Sabor s" + " where 1 = 1");		
		if (sabor.getIdSabor() != null) {
			hql.append(" and s.idSabor = :idSabor");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (sabor.getIdSabor() != null) {
			query.setParameter("idSabor",sabor.getIdSabor());
		} 
		return query.getResultList();
	}

	@Override
	@Transactional
	public void excluir(Sabor sabor) {
		sabor = entityManager.merge(sabor);
		entityManager.remove(sabor);
	}

	@Override
	@Transactional
	public void atualizar(Sabor sabor) {
		sabor = entityManager.merge(sabor);
		entityManager.persist(sabor);
	}

	@Override
	@Transactional
	public Sabor salvar(Sabor sabor) {
		entityManager.persist(sabor);
		return sabor;
	}

}