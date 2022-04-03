package cl.com.mobdev.testbackend.exception;

import javax.validation.ConstraintViolationException;

import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/**
 * The Class CustomizedResponseEntityExceptionHandler.
 * 
 *  Esta clase filtra todos las  excepciones para crear una respuesta manejada.
 * 
 * Source https://www.springboottutorial.com/spring-boot-exception-handling-for-rest-services
 */
@ControllerAdvice
@RestController
public class CustomizedResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

	@ExceptionHandler(CharacterNotFoundException.class)
	public final ResponseEntity<String> handleInvalidParameterException(CharacterNotFoundException ex, WebRequest request) {
		request.getDescription(false);
		return ResponseEntity.status(HttpStatus.NOT_FOUND)
				.contentType(MediaType.APPLICATION_JSON)
				.body(ex.getMessage());
	}

}
