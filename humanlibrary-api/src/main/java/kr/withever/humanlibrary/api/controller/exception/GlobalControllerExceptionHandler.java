package kr.withever.humanlibrary.api.controller.exception;

import kr.withever.humanlibrary.exception.HumanLibraryErrorMessage;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Locale;

/**
 * Created by youngjinkim on 2017. 2. 28..
 */

@ControllerAdvice
public class GlobalControllerExceptionHandler {

    @Autowired
    private MessageSource messageSource;

    @ExceptionHandler ({ HumanLibraryException.class })
    public ResponseEntity<HumanLibraryErrorMessage> makeApiException(HumanLibraryException exception) {
        // @TODO Using MessageResource and set message

        String message = messageSource.getMessage(exception.getCode().name(), exception.getMessages().toArray(), Locale.KOREA);

        HumanLibraryErrorMessage errorMessage = new HumanLibraryErrorMessage(exception.getCode(), message);
        ResponseEntity<HumanLibraryErrorMessage> responseEntity = new ResponseEntity<HumanLibraryErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

//    @ExceptionHandler ( { HumanLibraryNotFoundException.class })
//    public ResponseEntity<HumanLibraryErrorMessage> makeNotFoundApiException(HumanLibraryNotFoundException exception) {
//        // @TODO Using MessageResource and set message
//        HumanLibraryErrorMessage errorMessage = new HumanLibraryErrorMessage(exception.getCode(), exception.getParams());
//        ResponseEntity<HumanLibraryErrorMessage> responseEntity = new ResponseEntity<HumanLibraryErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
//        return responseEntity;
//    }
}
