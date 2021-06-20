package kodlamaio.hrms.core.globalExceptionHandler;

import lombok.Data;

@Data
public class ValidationError {

	private boolean success;
	private String message;
	private String details;
	
	public ValidationError(boolean success, String message, String details) {
		super();
		this.success = success;
		this.message = message;
		this.details = details;
	}
}
