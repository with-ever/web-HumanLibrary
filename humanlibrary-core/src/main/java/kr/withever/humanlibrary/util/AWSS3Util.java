
package kr.withever.humanlibrary.util;

import com.amazonaws.ClientConfiguration;
import com.amazonaws.Protocol;
import com.amazonaws.auth.AWSCredentials;
import com.amazonaws.auth.BasicAWSCredentials;
import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.*;

import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.List;

public class AWSS3Util {

	private static final String ACCESS_KEY = "AKIAJIX7HOHVUELEUN2A";

	private static final String SECRET_KEY = "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";
	
	private static final String END_POINT = "s3.ap-northeast-2.amazonaws.com";
	
	private static final String BUCKET_NAME = "humanlibrary";

	private AmazonS3 conn;

	public AWSS3Util() {
		AWSCredentials credentials = new BasicAWSCredentials(ACCESS_KEY, SECRET_KEY);
		ClientConfiguration clientConfig = new ClientConfiguration();
		clientConfig.setProtocol(Protocol.HTTP);
		this.conn = new AmazonS3Client(credentials, clientConfig);
		conn.setEndpoint(END_POINT);
	}
    // Bucket List
    public List<Bucket> getBucketList() {
        return conn.listBuckets();
    }
     
    // Bucket 생성 
    public Bucket createBucket(String bucketName) {
        return conn.createBucket(bucketName);
    }
     
    // 폴더 생성 (폴더는 파일명 뒤에 "/"를 붙여야한다.)
    public void createFolder(String bucketName, String folderName) {
        conn.putObject(bucketName, folderName + "/", new ByteArrayInputStream(new byte[0]), new ObjectMetadata());
    }
     
    // 파일 업로드
    // InputStream 으로 코드 리팩토링
    public void fileUpload(String bucketName, String fileName, File file) throws FileNotFoundException {
    	PutObjectRequest putObjectRequest = new PutObjectRequest(bucketName, fileName, file);
    	putObjectRequest.setCannedAcl(CannedAccessControlList.PublicRead);
		conn.putObject(putObjectRequest);
    }
     
    // 파일 삭제
    public void fileDelete(String bucketName, String fileName) {
        conn.deleteObject(bucketName, fileName);
    }
     
    // 파일 URL
    public String getFileURL(String bucketName, String fileName) {
        return conn.generatePresignedUrl(new GeneratePresignedUrlRequest(bucketName, fileName)).toString();
    }
    
	public String createBuckectName(String type) {
//		if (type.startsWith("\"") &&  type.endsWith("\"")) {
//			type = type.replace("\"", "");
//		}
		return BUCKET_NAME + "/" + type;
	}
	public String createFileName(String id, String fileName) {
//		if (id.startsWith("\"") && id.endsWith("\"")) {
//			id = id.replace("\"", "");
//		}
		return id + "_" + fileName;
	}

}
