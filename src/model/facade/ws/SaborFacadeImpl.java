package model.facade.ws;

import java.util.List;

import javax.inject.Inject;
import javax.jws.WebMethod;
import javax.jws.WebService;

import model.dao.SaborDao;
import model.domain.Sabor;

@WebService(serviceName="ws/sabor")
public class SaborFacadeImpl {
	
	@Inject
	private SaborDao saborDao;
	
	@WebMethod
	public List<Sabor> getSabor() {
		return saborDao.getSabores(new Sabor());
	}
	
	@WebMethod(operationName="getSaboresParametro")
	public List<Sabor> getPedidos(Sabor sabor) {
		return saborDao.getSabores(sabor);
	}
	
	@WebMethod
	public Sabor salvar(Sabor sabor){
		return saborDao.salvar(sabor);
	}
	
	@WebMethod
	public void atualizar(Sabor sabor){
		saborDao.atualizar(sabor);
	}
	
	@WebMethod
	public void excluir(Sabor sabor){
		saborDao.excluir(sabor);
	}

}

