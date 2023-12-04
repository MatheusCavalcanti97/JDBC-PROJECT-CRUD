package projetoBDJDBC.exception;

public class CpfException extends IllegalArgumentException {

	private static final long serialVersionUID = 6949644602875796614L;

	public CpfException() { }

	public CpfException(String msg) { super(msg); }

}
