package kr.withever.humanlibrary.exception;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by youngjinkim on 2017. 2. 28..
 */
public class HumanLibraryException extends RuntimeException {

    private ExceptionType code;

    private List<String> messages;

    public HumanLibraryException(Exception e, ExceptionType type) {
        super(e);
        this.code = type;
    }

    public HumanLibraryException(ExceptionType type) {
        this.code = type;
    }

    public HumanLibraryException(ExceptionType type, String ... params) {
        this.code = type;

        if (params == null) return;

        this.messages = new ArrayList<>();
        for (String param: params) {
            this.messages.add(param);
        }
    }


    public ExceptionType getCode() {
        return code;
    }

    public List<String> getMessages() { return messages; }
}
