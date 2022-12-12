package dev.soulcatcher.salvelatin.advice;

import dev.soulcatcher.salvelatin.dtos.ErrorResponse;
import dev.soulcatcher.salvelatin.exceptions.InvalidUsernameException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.ArrayList;
import java.util.List;

@RestControllerAdvice
public class RestExceptionHandler {

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ErrorResponse handleInvalidArgument(MethodArgumentNotValidException ex) {
        List<String> errors = new ArrayList<>();
        ex.getBindingResult().getFieldErrors().forEach(error ->
                errors.add(error.getDefaultMessage())
        );
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), errors);
    }
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(InvalidUsernameException.class)
    public ErrorResponse handleBadRequest(Throwable t) {
        t.printStackTrace();
        List<String> messages = new ArrayList<>();
        messages.add("Invalid email address.");
        return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), messages);
    }
}
