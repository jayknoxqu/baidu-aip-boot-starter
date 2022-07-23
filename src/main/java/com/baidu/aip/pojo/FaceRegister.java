package com.baidu.aip.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

/**
 * 注册人脸返回结果
 *
 * @author jayknoxqu
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FaceRegister extends FaceResult<FaceRegister.ResultDto> {

    private ResultDto result = new ResultDto();

    @Data
    @NoArgsConstructor
    public static class ResultDto {

        @JSONField(name = "face_token")
        private String faceToken;

        private LocationDTO location;

        @Data
        @NoArgsConstructor
        public static class LocationDTO {

            private Double top;

            private Double left;

            private Integer rotation;

            private Integer width;

            private Integer height;
        }
    }

}
