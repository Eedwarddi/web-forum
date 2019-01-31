package forum.rest;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException exc,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		ForumErrorResponse error = new ForumErrorResponse(
				HttpStatus.BAD_REQUEST.value(),
				"ARGUMENT IS NOT VALID! ERROR MESSAGE: ",
				System.currentTimeMillis());
		
		return new ResponseEntity<>(error, HttpStatus.BAD_REQUEST);

	}

}
