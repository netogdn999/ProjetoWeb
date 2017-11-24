package control;

public class ParametroVazioException extends Exception{
	private String message;
	
	public ParametroVazioException() {
		super();
	}
	
	public ParametroVazioException(String message) {
		this();
		setMessage(message);
	}
	
	public void setMessage(String message) {
		this.message = message;
	}
	
	@Override
	public String getMessage() {
		// TODO Auto-generated method stub
		return super.getMessage();
	}
}
