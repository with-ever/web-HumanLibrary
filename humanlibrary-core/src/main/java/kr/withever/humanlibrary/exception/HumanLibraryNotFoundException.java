package kr.withever.humanlibrary.exception;

import kr.withever.humanlibrary.domain.common.exception.ExceptionType;

/**
 * Created by youngjinkim on 2017. 3. 9..
 */
public class HumanLibraryNotFoundException extends HumanLibraryException {

    public HumanLibraryNotFoundException(Exception e, ExceptionType type) {
        super(e, type);
    }

    public HumanLibraryNotFoundException(ExceptionType type) {
        super(type);
    }

    public HumanLibraryNotFoundException(ExceptionType type, String... params) {
        super(type, params);
    }
}
