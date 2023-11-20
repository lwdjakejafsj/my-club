package com.luowei.oss.entity;

/**
 * @Author: luowei
 * @Description: 文件类
 * @DateTime:
 */
public class FileInfo {
    private String fileName;
    private Boolean directionFlag;
    private String etag;

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public String getFileName() {
        return fileName;
    }

    public Boolean getDirectionFlag() {
        return directionFlag;
    }

    public String getEtag() {
        return etag;
    }

    public void setDirectionFlag(Boolean directionFlag) {
        this.directionFlag = directionFlag;
    }

    public void setEtag(String etag) {
        this.etag = etag;
    }
}
