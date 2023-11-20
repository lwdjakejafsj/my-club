package com.luowei.oss.adapter;

import com.luowei.oss.entity.FileInfo;
import com.luowei.oss.utils.MinioUtil;
import lombok.SneakyThrows;
import org.springframework.web.multipart.MultipartFile;

import javax.annotation.Resource;
import java.io.InputStream;
import java.util.List;

//@Service("minioStorageService")
public class MinioStorageAdapter implements StorageAdapter {
    @Resource
    private MinioUtil minioUtil;

    //  @SneakyThrows 是lombok的一个注解，些代码时异常太难抛，可以使用这个注解在编译时完成抛出异常
    @Override
    @SneakyThrows
    public void createBucket(String bucket) {
        minioUtil.createBucket(bucket);
    }

    @Override
    @SneakyThrows
    public void uploadFile(MultipartFile file, String bucket, String objectName) {
        minioUtil.createBucket(bucket);
        if (objectName != null) {
            minioUtil.uploadFile(file,bucket,objectName+"/"+file.getName());
        } else {
            minioUtil.uploadFile(file,bucket,file.getName());
        }
    }

    @Override
    @SneakyThrows
    public List<String> getAllBucket() {
        return minioUtil.getAllBucket();
    }

    @Override
    @SneakyThrows
    public List<FileInfo> getAllFile(String bucket) {
        return minioUtil.getAllFile(bucket);
    }

    @Override
    @SneakyThrows
    public InputStream download(String bucket, String objectName) {
        return minioUtil.download(bucket, objectName);
    }

    @Override
    @SneakyThrows
    public void deleteBucket(String bucket) {
        minioUtil.deleteBucket(bucket);
    }

    @Override
    @SneakyThrows
    public void deleteObject(String bucket, String objectName) {
        minioUtil.deleteObject(bucket, objectName);
    }

    @Override
    @SneakyThrows
    public String getUrl(String bucket, String objectName) {
        return minioUtil.getPreviewFileUrl(bucket, objectName);
    }
}
