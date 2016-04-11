package model.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import model.domain.Pessoa;

public class PessoaDaoImpl implements PessoaDao{

	@PersistenceContext(unitName="CupcakeStorePU")
	private EntityManager entityManager;
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Pessoa> getPessoas(Pessoa pessoa) {
		StringBuffer hql = new StringBuffer("from Pessoa p" + " where 1 = 1");		
		if (pessoa.getIdPessoa() != null) {
			hql.append(" and c.idPessoa = :idPessoa");
		}
		Query query = entityManager.createQuery(hql.toString());
		if (pessoa.getIdPessoa() != null) {
			query.setParameter("idPessoa",pessoa.getIdPessoa());
		} 
		return query.getResultList();
	}

	@Override
	@Transactional
	public void excluir(Pessoa pessoa) {
		pessoa = entityManager.merge(pessoa);
		entityManager.remove(pessoa);
	}

	@Override
	public void atualizar(Pessoa pessoa) {
		pessoa = entityManager.merge(pessoa);
		entityManager.persist(pessoa);
	}

	@Override
	public Pessoa salvar(Pessoa pessoa) {
		entityManager.persist(pessoa);
		return pessoa;
	}

}
