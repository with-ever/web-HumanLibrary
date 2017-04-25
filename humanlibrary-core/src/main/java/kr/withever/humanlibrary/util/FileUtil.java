package kr.withever.humanlibrary.util;

import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;

/**
 * Created by youngjinkim on 2017. 4. 5..
 */
public class FileUtil {

    public static File convertMultipartFileToFile(MultipartFile multipartFile) throws IllegalStateException, IOException {
        // 파일 업로드시 권한 문제때문에 임시 파일을 생성 후 업로드.
        // 확장자 이슈 체크.
        File file = File.createTempFile("HLIBRARY", ""); // new File(multipartFile.getOriginalFilename());
        multipartFile.transferTo(file);
        return file;
    }
}
