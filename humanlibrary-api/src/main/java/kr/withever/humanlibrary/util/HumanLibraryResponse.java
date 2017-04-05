package kr.withever.humanlibrary.util;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by youngjinkim on 2017. 4. 3..
 */
public class HumanLibraryResponse {

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

}
