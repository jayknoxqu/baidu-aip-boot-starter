package com.baidu.aip.config;

import com.baidu.aip.client.AipFaceClient;
import com.baidu.aip.client.AipOcrClient;
import com.baidu.aip.client.BaseClient;
import com.baidu.aip.client.impl.AipFaceClientImpl;
import com.baidu.aip.client.impl.AipOcrClientImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 自动注入Bean
 *
 * @author jayknoxqu
 * @since 2019-04-24
 */
@Slf4j
@Configuration
@ConditionalOnClass(BaseClient.class)
@EnableConfigurationProperties(BaiduProperties.class)
public class BaiduAutoConfiguration {

    private final BaiduProperties baiduProperties;

    @Autowired
    public BaiduAutoConfiguration(BaiduProperties baiduProperties) {
        this.baiduProperties = baiduProperties;
    }


    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "baidu.sdk.face", name = {"app-id", "group-id"})
    public AipFaceClient aipFaceClient() {

        log.debug(">>>>>>> The AipFaceClient Not Found，Execute Create New Bean.");

        AipFaceClientImpl faceClient = new AipFaceClientImpl(
                baiduProperties.getFace().getGroupId(),
                baiduProperties.getFace().getAppId(),
                baiduProperties.getFace().getApiKey(),
                baiduProperties.getFace().getSecretKey()
        );

        faceClient.setConnectionTimeoutInMillis(baiduProperties.getConnectionTimeout());
        faceClient.setSocketTimeoutInMillis(baiduProperties.getSocketTimeout());
        return faceClient;
    }


    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "baidu.sdk.ocr", name = "app-id")
    public AipOcrClient aipOcrClient() {

        log.debug(">>>>>>> The AipOcrClient Not Found，Execute Create New Bean.");

        AipOcrClientImpl ocrClient = new AipOcrClientImpl(
                baiduProperties.getOcr().getAppId(),
                baiduProperties.getOcr().getApiKey(),
                baiduProperties.getOcr().getSecretKey()
        );

        ocrClient.setConnectionTimeoutInMillis(baiduProperties.getConnectionTimeout());
        ocrClient.setSocketTimeoutInMillis(baiduProperties.getSocketTimeout());
        return ocrClient;
    }


}
