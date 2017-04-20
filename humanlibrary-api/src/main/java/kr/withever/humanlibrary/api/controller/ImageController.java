package kr.withever.humanlibrary.api.controller;

import io.swagger.annotations.ApiParam;
import kr.withever.humanlibrary.util.AWSS3Util;
import kr.withever.humanlibrary.util.FileUtil;
import kr.withever.humanlibrary.util.HumanLibraryResponse;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

/**
 * Created by youngjinkim on 2017. 4. 5..
 */
@RestController
@RequestMapping(value = "/api/images")
public class ImageController {

    @RequestMapping(method = RequestMethod.POST)
    public HumanLibraryResponse createImage(
            @RequestParam(value = "image") MultipartFile multipartFile,
            @RequestParam(value = "id") String id,
            @ApiParam(value = "humanbook & user", required = true) @RequestParam(value = "type") String type
    ) throws IOException {
        AWSS3Util s3Util = new AWSS3Util();
        String bucketName = s3Util.createBuckectName(type);
        String fileName = s3Util.createFileName(id, multipartFile.getOriginalFilename());
        s3Util.fileUpload(bucketName, fileName, FileUtil.convertMultipartFileToFile(multipartFile));

        String url = s3Util.getFileURL(bucketName, fileName);
        return new HumanLibraryResponse(url.split("\\?")[0]);
    }
}
