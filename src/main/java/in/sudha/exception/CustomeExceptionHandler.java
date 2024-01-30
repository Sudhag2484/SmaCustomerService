package in.sudha.exception;

import java.util.Date;

import org.apache.hc.core5.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import in.sudha.payload.response.ErrorMessage;

@RestControllerAdvice
public class CustomeExceptionHandler {
	
	@ExceptionHandler(CustomerNotFoundException.class)
	/*
	public ResponseEntity<String> handleCompanyNotFoundException(CompanyNotFoundException cnf){
		return ResponseEntity.internalServerError().body(cnf.getMessage());
	}*/
	
	//or
	public ResponseEntity<ErrorMessage> handleCompanyNotFoundException(CustomerNotFoundException cnf){
		return ResponseEntity.internalServerError().body(new ErrorMessage(new Date().toString(), 
				cnf.getMessage(), 
				HttpStatus.SC_INTERNAL_SERVER_ERROR)); 
				
}
}
