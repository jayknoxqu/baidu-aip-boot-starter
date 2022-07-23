package com.baidu.aip.client;


import com.baidu.aip.pojo.FaceSearch;

/**
 * 人脸识别
 *
 * @author jayknoxqu
 * @since 2019-04-24
 */
public interface AipFaceClient {

    /**
     * 注册人脸
     *
     * @param userId    用户编号
     * @param imageByte 人脸图片地址
     * @return boolean
     */
    boolean register(String userId, byte[] imageByte);

    /**
     * 注册人脸
     *
     * @param userId 用户编号
     * @param url    人脸图片地址
     * @return boolean
     */
    boolean register(String userId, String url);

    /**
     * 删除人脸
     *
     * @param userId 用户编号
     * @return boolean
     */
    boolean delete(String userId);

    /**
     * 更新人脸
     *
     * @param userId    用户编号
     * @param imageByte 人脸图片
     * @return boolean
     */
    boolean update(String userId, byte[] imageByte);

    /**
     * 更新人脸
     *
     * @param userId 用户编号
     * @param url    人脸图片地址
     * @return boolean
     */
    boolean update(String userId, String url);

    /**
     * 人脸匹配
     *
     * @param imageByte 人脸图片
     * @param url       人脸图片地址
     * @return 相识度 (max = 100)
     */
    Double match(byte[] imageByte, String url);

    /**
     * 人脸搜索
     *
     * @param imageByte 人脸图片
     * @return FaceSearch
     */
    FaceSearch search(byte[] imageByte);

    /**
     * 人脸搜索
     *
     * @param url 人脸图片地址
     * @return FaceSearch
     */
    FaceSearch search(String url);

}
