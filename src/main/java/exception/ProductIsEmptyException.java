package exception;

public class ProductIsEmptyException extends Exception {
	
	private static final long serialVersionUID = 1L;
	String exception;
	
	public ProductIsEmptyException(String exception){
		this.exception = exception;
	}
	
	public String toString(){ 
		return ("CartIsEmptyException Occurred: "+exception) ;
	   }


}
