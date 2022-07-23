package com.baidu.aip.config;

import lombok.Data;
import lombok.EqualsAndHashCode;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.NestedConfigurationProperty;

/**
 * 百度大脑的账户信息
 *
 * @author jayknoxqu
 * @since 2019-04-24
 */
@Data
@ConfigurationProperties(prefix = "baidu.sdk")
public class BaiduProperties {


    /**
     * 建立连接的超时时间（单位：毫秒）
     **/
    private Integer connectionTimeout = 10000;

    /**
     * 打开的连接传输数据的超时时间（单位：毫秒）
     **/
    private Integer socketTimeout = 10000;

    @NestedConfigurationProperty
    private Ocr ocr;

    @NestedConfigurationProperty
    private Face face;


    @Data
    public static class Base {

        protected String appId;

        protected String apiKey;

        protected String secretKey;

    }


    /**
     * 人脸识别
     **/
    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Face extends Base {
        private String groupId;
    }


    /**
     * 证件识别
     **/
    @Data
    @EqualsAndHashCode(callSuper = true)
    public static class Ocr extends Base {
    }


}
