package kr.withever.humanlibrary.exception;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;

/**
 * Created by youngjinkim on 2017. 2. 28..
 */
public class HumanLibraryErrorMessage {

    private ExceptionType code;

    private String message;

    public HumanLibraryErrorMessage(ExceptionType status, String message) {
        this.code = status;
        this.message = message;
    }

    public ExceptionType getCode() {
        return code;
    }

    public void setCode(ExceptionType code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
