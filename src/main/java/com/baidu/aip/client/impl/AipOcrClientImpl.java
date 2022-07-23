package com.baidu.aip.client.impl;

import com.baidu.aip.client.AipOcrClient;
import com.baidu.aip.ocr.AipOcr;
import lombok.extern.slf4j.Slf4j;

/**
 * 图片识别
 *
 * @author jayknoxqu
 * @see "https://ai.baidu.com/docs#/OCR-API/top"
 * @since 2019-04-24
 */
@Slf4j
public class AipOcrClientImpl extends AipOcr implements AipOcrClient {

    public AipOcrClientImpl(String appId, String apiKey, String secretKey) {
        super(appId, apiKey, secretKey);
    }

}
