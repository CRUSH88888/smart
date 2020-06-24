package edu.scau.common.utils;

/**
 * 参数为空的异常，主要用于校验请求参数
 * @author czh
 * @date 2020/4/8 21:57
 */
public class NullParameterException extends Exception {
    public NullParameterException() {
        super("null parameter");
    }

    public NullParameterException(String message) {
        super(message);
    }
}
