package com.luowei.oss.utils;


import com.luowei.oss.entity.FileInfo;
import io.minio.*;
import io.minio.errors.*;
import io.minio.http.Method;
import io.minio.messages.Bucket;
import io.minio.messages.Item;
import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

@Component
public class MinioUtil {

    @Resource
    private MinioClient minioClient;

    /*
        创建桶
     */
    public void createBucket(String bucket) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        boolean exists = minioClient.bucketExists(BucketExistsArgs.builder().bucket(bucket).build());
        if (!exists) {
            minioClient.makeBucket(MakeBucketArgs.builder().bucket(bucket).build());
        }
    }

    /*
        上传文件
     */
    public void uploadFile(MultipartFile file,String bucket,String objectName) throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        minioClient.putObject(PutObjectArgs.builder().bucket(bucket)
                .object(objectName).stream(file.getInputStream(),-1,Integer.MAX_VALUE).build());
    }

    /*
        列出所有桶
     */
    public List<String> getAllBucket() throws ServerException, InsufficientDataException, ErrorResponseException, IOException, NoSuchAlgorithmException, InvalidKeyException, InvalidResponseException, XmlParserException, InternalException {
        List<Bucket> buckets = minioClient.listBuckets();
        if (buckets == null) {
            return null;
        }
        return buckets.stream().map(Bucket::name).collect(Collectors.toList());
    }

    /*
        得到当前桶的所有文件
     */
    public List<FileInfo> getAllFile(String bucket) throws Exception{
        Iterable<Result<Item>> results = minioClient
                .listObjects(ListObjectsArgs.builder().bucket(bucket).build());

        List<FileInfo> fileInfos = new LinkedList<>();
        for (Result<Item> result : results) {
            Item item = result.get();
            FileInfo fileInfo = new FileInfo();
            fileInfo.setFileName(item.objectName());
            fileInfo.setDirectionFlag(item.isDir());
            fileInfo.setEtag(item.etag());
        }
        return fileInfos;
    }

    /*
        下载
     */
    public InputStream download(String bucket,String objectName) throws Exception{
        return minioClient.getObject(GetObjectArgs
                .builder().bucket(bucket).object(objectName).build());
    }

    /*
        删除桶
     */
    public void deleteBucket(String bucket) throws Exception{
         minioClient.removeBucket(RemoveBucketArgs.builder().bucket(bucket).build());
    }

    /*
        删除文件
     */
    public void deleteObject(String bucket,String objectName) throws Exception{
        minioClient.removeObject(RemoveObjectArgs.builder().bucket(bucket).object(objectName).build());
    }

    /*
        获取文件url
     */
    public String getPreviewFileUrl(String bucketName, String objectName) throws Exception{
        GetPresignedObjectUrlArgs args = GetPresignedObjectUrlArgs.builder()
                .method(Method.GET)
                .bucket(bucketName).object(objectName).build();
        return minioClient.getPresignedObjectUrl(args);
    }
}
