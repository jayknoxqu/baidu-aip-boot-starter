package com.baidu.aip.pojo;

import com.alibaba.fastjson.annotation.JSONField;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.json.JSONObject;

/**
 * 基本包装类
 *
 * @author jayknoxqu
 */
@Data
@NoArgsConstructor
public class FaceResult<T> {

    @JSONField(name = "log_id")
    protected Integer logId;

    @JSONField(name = "error_code")
    protected Integer errorCode;

    @JSONField(name = "error_msg")
    protected String errorMsg;

    protected Integer cached;

    protected Integer timestamp;

    protected T result;

    public static <T> boolean isSuccess(JSONObject jsonObject) {
        if (jsonObject != null) {
            return jsonObject.getInt("error_code") == 0;
        }
        return false;
    }

}
