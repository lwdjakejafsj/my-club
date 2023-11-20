package com.luowei.oss.adapter;

import com.luowei.oss.entity.FileInfo;
import org.springframework.web.multipart.MultipartFile;

import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;

//@Service("aliyunStorageService")
public class AliyunStorageAdapter implements StorageAdapter {
    @Override
    public void createBucket(String bucket) {

    }

    @Override
    public void uploadFile(MultipartFile file, String bucket, String objectName) {

    }

    @Override
    public List<String> getAllBucket() {
        ArrayList<String> list = new ArrayList<>();
        list.add("oss");
        return list;
    }

    @Override
    public List<FileInfo> getAllFile(String bucket) {
        return null;
    }

    @Override
    public InputStream download(String bucket, String objectName) {
        return null;
    }

    @Override
    public void deleteBucket(String bucket) {

    }

    @Override
    public void deleteObject(String bucket, String objectName) {

    }

    @Override
    public String getUrl(String bucket, String objectName) {
        return null;
    }
}
