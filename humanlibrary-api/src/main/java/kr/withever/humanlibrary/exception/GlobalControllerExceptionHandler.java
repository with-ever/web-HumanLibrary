package kr.withever.humanlibrary.exception;

import kr.withever.humanlibrary.exception.HumanLibraryErrorMessage;
import kr.withever.humanlibrary.exception.HumanLibraryException;
import kr.withever.humanlibrary.exception.HumanLibraryNotFoundException;
import kr.withever.humanlibrary.exception.HumanLibraryRuntimeException;
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

    @ExceptionHandler({HumanLibraryRuntimeException.class})
    public ResponseEntity<HumanLibraryErrorMessage> makeApiException(HumanLibraryRuntimeException exception) {
        String message = messageSource.getMessage(exception.getCode().name(), exception.getMessages().toArray(), Locale.KOREA);
        HumanLibraryErrorMessage errorMessage = new HumanLibraryErrorMessage(exception.getCode(), message);
        ResponseEntity<HumanLibraryErrorMessage> responseEntity = new ResponseEntity<HumanLibraryErrorMessage>(errorMessage, HttpStatus.INTERNAL_SERVER_ERROR);
        return responseEntity;
    }

    // @TODO Not Found Exception을 따로 두는데 추가되어야 할 코드라는것이 필요할까?
    @ExceptionHandler({HumanLibraryNotFoundException.class})
    public ResponseEntity<HumanLibraryErrorMessage> makeNotFoundApiException(HumanLibraryNotFoundException exception) {
        String message = messageSource.getMessage(exception.getCode().name(), exception.getMessages().toArray(), Locale.KOREA);
        HumanLibraryErrorMessage errorMessage = new HumanLibraryErrorMessage(exception.getCode(), message);
        ResponseEntity<HumanLibraryErrorMessage> responseEntity = new ResponseEntity<HumanLibraryErrorMessage>(errorMessage, HttpStatus.NOT_FOUND);
        return responseEntity;
    }
}
