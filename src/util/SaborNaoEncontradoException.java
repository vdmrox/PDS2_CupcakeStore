package util;

public class SaborNaoEncontradoException extends Exception {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public SaborNaoEncontradoException(Integer idSabor) {
		super(idSabor.toString());
	}

}