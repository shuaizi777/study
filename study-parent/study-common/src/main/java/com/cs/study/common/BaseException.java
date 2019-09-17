package com.cs.study.common;

/**
 * @Description:
 * @Author: shuai.chen
 * @Date: 2019/9/16 08:52
 */
public class BaseException extends RuntimeException{

    private Integer code;

    private String message;

    public BaseException(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public BaseException(Integer code, String message, Throwable cause) {
        super(cause);
        this.code = code;
        this.message = message;
    }

    public BaseException(IoTCode ioTCode) {
        this.code = ioTCode.getCode();
        this.message = ioTCode.getMessage();
    }

    public BaseException(IoTCode ioTCode, Throwable cause) {
        super(cause);
        if (ioTCode == null) {
            throw new BaseException(IoTCodes.SYSTEM_ERROR);
        } else {
            this.code = ioTCode.getCode();
            this.message = ioTCode.getMessage();
        }
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
