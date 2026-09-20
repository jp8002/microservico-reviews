package se.magnus.api.core.review.resources.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.BAD_REQUEST)
public class ApiInvalidInputException extends RuntimeException{
    public ApiInvalidInputException(){
        super("O input está fora da regra");
    }
}
