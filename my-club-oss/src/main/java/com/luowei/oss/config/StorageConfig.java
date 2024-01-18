package com.luowei.oss.config;

import com.alibaba.nacos.api.config.annotation.NacosValue;
import com.luowei.oss.adapter.AliyunStorageAdapter;
import com.luowei.oss.adapter.MinioStorageAdapter;
import com.luowei.oss.adapter.StorageAdapter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @Author: luowei
 * @Description: @RefreshScope 用来进行动态刷新
 * @DateTime:
 */
@Configuration
@RefreshScope
public class StorageConfig {
    @Value("${storage.service.type}")
    private String storageType;

    @Bean
    @RefreshScope
    public StorageAdapter storageService() {
        if ("minio".equals(storageType)) {
            return new MinioStorageAdapter();
        } else if ("aliyun".equals(storageType)) {
            return new AliyunStorageAdapter();
        } else {
            throw new IllegalArgumentException("未找到对应的存储服务");
        }
    }
}
