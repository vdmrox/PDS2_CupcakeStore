package util;

public class PedidoNaoEncontradoException extends Exception{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PedidoNaoEncontradoException(Integer idPedido) {
		super(idPedido.toString());
	}

}
