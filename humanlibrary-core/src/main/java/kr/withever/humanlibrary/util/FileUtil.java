package kr.withever.humanlibrary.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by youngjinkim on 2017. 4. 5..
 */
public class FileUtil {

    public static File convertMultipartFileToFile(MultipartFile multipartFile) throws IllegalStateException, IOException {
        File file = new File(multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        return file;
    }
}
