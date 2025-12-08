package iestp.edu.pe.exception;

import java.time.LocalDateTime;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

public class GlobalErrorHandler  extends ResponseEntityExceptionHandler{
	//excepcion por default padre
    @ExceptionHandler(Exception.class)
    public ResponseEntity<CustomErrorResponse> handleDefaultException(Exception ex, WebRequest request){
        CustomErrorResponse errorResponse=new CustomErrorResponse(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    //esta es la forma clasica
    @ExceptionHandler(ModelNotFoutException.class)
    public ResponseEntity<CustomErrorResponse> handleModelNotFoundException(ModelNotFoutException ex, WebRequest request){
        CustomErrorResponse errorResponse=new CustomErrorResponse(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(ArithmeticException.class)
    public ResponseEntity<CustomErrorResponse> handleArithmeticException(ModelNotFoutException ex, WebRequest request){
        CustomErrorResponse errorResponse=new CustomErrorResponse(LocalDateTime.now(),ex.getMessage(),request.getDescription(false));
        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_ACCEPTABLE);
    }
}
