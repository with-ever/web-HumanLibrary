package kr.withever.humanlibrary.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youngjinkim on 2017. 4. 3..
 */
public class HumanLibraryResponse {

    private static final String SUCCESS_MESSAGE = "success";

    private static final String FAIL_MESSAGE =  "fail";

    private Object result;

    public HumanLibraryResponse() {
    }

    public HumanLibraryResponse(Object result) {
        this.result = result;
    }

    public Object getResult() {
        return result;
    }

    public void setResult(Object result) {
        this.result = result;
    }

    public static HumanLibraryResponse successMessage() {
        return new HumanLibraryResponse(SUCCESS_MESSAGE);
    }

    public static HumanLibraryResponse failMessage() {
        return new HumanLibraryResponse(FAIL_MESSAGE);
    }

}
