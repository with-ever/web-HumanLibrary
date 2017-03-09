package kr.withever.humanlibrary.exception;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;

/**
 * Created by youngjinkim on 2017. 3. 9..
 */
public class HumanLibraryRuntimeException extends HumanLibraryException {

    public HumanLibraryRuntimeException(Exception e, ExceptionType type) {
        super(e, type);
    }

    public HumanLibraryRuntimeException(ExceptionType type) {
        super(type);
    }

    public HumanLibraryRuntimeException(ExceptionType type, String... params) {
        super(type, params);
    }

}
