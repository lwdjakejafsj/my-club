package com.luowei.oss.adapter;

import com.luowei.oss.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.List;

public interface StorageAdapter {
    /*
        创建桶
     */
    void createBucket(String bucket);

    /*
        上传文件
     */
    void uploadFile(MultipartFile file, String bucket, String objectName);

    /*
        列出所有桶
     */
    List<String> getAllBucket();

    /*
        得到当前桶的所有文件
     */
    List<FileInfo> getAllFile(String bucket);

    /*
        下载
     */
    InputStream download(String bucket, String objectName);

    /*
        删除桶
     */
    void deleteBucket(String bucket);

    /*
        删除文件
     */
    void deleteObject(String bucket, String objectName);

    String getUrl(String bucket,String objectName);
}
