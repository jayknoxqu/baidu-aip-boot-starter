package com.baidu.aip.client.impl;

import com.alibaba.fastjson.JSON;
import com.baidu.aip.client.AipFaceClient;
import com.baidu.aip.face.AipFace;
import com.baidu.aip.face.MatchRequest;
import com.baidu.aip.pojo.FaceMatch;
import com.baidu.aip.pojo.FaceResult;
import com.baidu.aip.pojo.FaceSearch;
import com.baidu.aip.util.Base64Util;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.ObjectUtils;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

/**
 * 人脸识别
 *
 * @author jayknoxqu
 * @since 2019-04-24
 */
@Slf4j
public class AipFaceClientImpl extends AipFace implements AipFaceClient {

    private final String groupId;

    public AipFaceClientImpl(String groupId, String appId, String apiKey, String secretKey) {
        super(appId, apiKey, secretKey);
        this.groupId = groupId;
    }


    @Override
    public Double match(byte[] imageByte, String url) {
        try {
            List<MatchRequest> matchRequests = new ArrayList<>();
            matchRequests.add(new MatchRequest(Base64Util.encode(imageByte), "BASE64"));
            matchRequests.add(new MatchRequest(url, "URL"));
            JSONObject match = super.match(matchRequests);
            log.debug("人脸匹配返回结果为:{}", match);

            if (FaceResult.isSuccess(match)) {
                FaceMatch matchResult = JSON.parseObject(match.toString(), FaceMatch.class);
                return ObjectUtils.defaultIfNull(matchResult, new FaceMatch()).getResult().getScore();
            }

        } catch (Exception e) {
            log.error("人脸匹配失败", e);
        }

        return 0d;
    }

    @Override
    public boolean register(String userId, byte[] imageByte) {
        try {
            String base64Str = Base64Util.encode(imageByte);
            JSONObject register = super.addUser(base64Str, "BASE64", groupId, userId, null);
            log.debug("注册人脸返回结果为:{}", register);
            return FaceResult.isSuccess(register);
        } catch (Exception e) {
            log.error("注册人脸失败：", e);
        }
        return false;
    }

    @Override
    public boolean register(String userId, String url) {
        try {
            JSONObject register = super.addUser(url, "URL", groupId, userId, null);
            log.debug("注册人脸返回结果为:{}", register);
            return FaceResult.isSuccess(register);
        } catch (Exception e) {
            log.error("注册人脸失败：", e);
        }

        return false;
    }

    @Override
    public boolean delete(String userId) {
        try {
            JSONObject delete = super.deleteUser(groupId, userId, null);
            log.debug("删除人脸返回结果为:{}", delete);
            return FaceResult.isSuccess(delete);
        } catch (Exception e) {
            log.error("删除人脸失败：", e);
        }

        return false;
    }

    @Override
    public boolean update(String userId, byte[] imageByte) {
        try {
            String base64Str = Base64Util.encode(imageByte);
            JSONObject update = super.updateUser(base64Str, "BASE64", groupId, userId, null);
            log.debug("更新人脸返回结果为:{}", update);
            return FaceResult.isSuccess(update);
        } catch (Exception e) {
            log.error("更新人脸失败：", e);
        }

        return false;
    }

    @Override
    public boolean update(String userId, String url) {
        try {
            JSONObject update = super.updateUser(url, "URL", groupId, userId, null);
            log.debug("更新人脸返回结果为:{}", update);
            return FaceResult.isSuccess(update);
        } catch (Exception e) {
            log.error("更新人脸失败：", e);
        }

        return false;
    }

    @Override
    public FaceSearch search(byte[] imageByte) {
        try {
            String base64Str = Base64Util.encode(imageByte);
            JSONObject search = super.search(base64Str, "BASE64", groupId, null);
            log.debug("人脸搜索返回结果为:{}", search);
            return JSON.parseObject(search.toString(), FaceSearch.class);
        } catch (Exception e) {
            log.error("人脸搜索失败：", e);
        }
        return new FaceSearch();
    }


    @Override
    public FaceSearch search(String url) {
        try {
            JSONObject search = super.search(url, "URL", groupId, null);
            log.debug("人脸搜索返回结果为:{}", search);
            return JSON.parseObject(search.toString(), FaceSearch.class);
        } catch (Exception e) {
            log.error("人脸搜索失败:", e);
        }
        return new FaceSearch();
    }


}
