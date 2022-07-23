package com.baidu.aip.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.*;

import java.util.ArrayList;
import java.util.List;

/**
 * 人脸搜索返回的实体类
 *
 * @author jayknoxqu
 */

@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = true)
public class FaceSearch extends FaceResult<FaceSearch.ResultDto> {

    private ResultDto result = new ResultDto();

    @Data
    @NoArgsConstructor
    public static class ResultDto {

        @JSONField(name = "face_token")
        private String faceToken;

        @JSONField(name = "user_list")
        private List<UserDto> userList = new ArrayList<>();

        @Getter
        @Setter
        @NoArgsConstructor
        public static class UserDto {

            private Double score;

            @JSONField(name = "group_id")
            private String groupId;

            @JSONField(name = "user_id")
            private String userId;

            @JSONField(name = "user_info")
            private String userInfo;
        }

    }

}
