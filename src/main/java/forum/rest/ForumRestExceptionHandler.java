package forum.rest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ForumRestExceptionHandler {
	
	@ExceptionHandler
	public ResponseEntity<ForumErrorResponse> handleException(ForumItemNotFoundException exc) {
		
		ForumErrorResponse error = new ForumErrorResponse(
										HttpStatus.NOT_FOUND.value(),
										exc.getMessage(),
										System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	@ExceptionHandler
	public ResponseEntity<ForumErrorResponse> handleException(Exception exc) {
		
		ForumErrorResponse error = new ForumErrorResponse(
										HttpStatus.BAD_REQUEST.value(),
										exc.getMessage(),
										System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.NOT_FOUND);
	}
	
	

}
