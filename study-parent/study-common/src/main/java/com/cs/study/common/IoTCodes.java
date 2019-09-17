package com.cs.study.common;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/9/16 09:24
 */
public class IoTCodes {

    public static IoTCode SUCCESS = new IoTCode(200, "success");
    public static IoTCode REQUEST_ERROR = new IoTCode(400, "request error");
    public static IoTCode PARAM_ERROR = new IoTCode(460, "param error");
    public static IoTCode SYSTEM_ERROR = new IoTCode(500, "system error");
    public static IoTCode NOT_FOUND_RESOURCES = new IoTCode(404, "can't find resources");

    public IoTCodes() {
    }
}
