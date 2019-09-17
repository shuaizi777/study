package com.cs.study.common;

import com.cs.study.common.constant.Constants;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/9/16 09:26
 */
public class NotFoundException extends BaseException {

    public NotFoundException() {
        super(IoTCodes.NOT_FOUND_RESOURCES);
    }

    public NotFoundException(String message) {
        super(Constants.NOT_FOUNT_CODE, message);
    }
}
