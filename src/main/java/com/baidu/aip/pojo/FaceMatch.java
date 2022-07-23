package com.baidu.aip.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

import java.util.List;

/**
 * 人脸对比返回结果
 *
 * @author jayknoxqu
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FaceMatch extends FaceResult<FaceMatch.ResultDto> {

    private ResultDto result = new ResultDto();

    @Data
    @NoArgsConstructor
    public static class ResultDto {

        /**
         * 相识度 (max = 100)
         */
        private Double score;

        @JSONField(name = "face_list")
        private List<FaceListDTO> faceList;

        @Data
        @NoArgsConstructor
        public static class FaceListDTO {
            @JSONField(name = "face_token")
            private String faceToken;
        }

    }

}
