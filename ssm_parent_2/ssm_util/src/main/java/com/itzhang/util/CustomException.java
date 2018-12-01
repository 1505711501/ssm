package com.itzhang.util;

/**
 * @Auther: wyan
 * @Date: 2018/11/28 12:06
 * @Description:
 */
public class CustomException extends Exception {

    private String errorCode ;
    private String errorMsg;

    public CustomException(String errorCode, String errorMs){
        this.errorCode=errorCode;
        this.errorMsg=errorMs;
    }

    @Override
    public String getMessage() {
        return this.errorMsg;
    }
}
