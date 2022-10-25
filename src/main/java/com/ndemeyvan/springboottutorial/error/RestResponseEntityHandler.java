package com.ndemeyvan.springboottutorial.error;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

/*
 * Responsable de la creation du message de la requete quand une exception est leve
 */
@ControllerAdvice
@ResponseStatus
public class RestResponseEntityHandler extends ResponseEntityExceptionHandler {

    /*
     * Cette method va retourner une ErrorMessage comme reponse http a la requete en
     * cas d'erreur
     * il prend en parametre l'exception et le webRequest
     * 
     * @ExceptionHandler Execute toi uniquement quand cette exception est leve
     */
    @ExceptionHandler(DepartementNotFoundException.class)
    public ResponseEntity<ErrorMessage> departmentErrorMessage(
            DepartementNotFoundException departementNotFoundException, WebRequest webRequest) {
        ErrorMessage errorMessage = new ErrorMessage(HttpStatus.NOT_FOUND, departementNotFoundException.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(errorMessage);

    }

}
