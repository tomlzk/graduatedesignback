package com.example.back.utils.base;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * 返回结果模板类
 */
@Setter
@Getter
@ToString
@Accessors(chain = true)//链式调用，例如setName("Alice").setAge(25);
public class Result<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private int code;
    private Boolean success;
    private T data;
    private String message;
    private String path;
    private Map<String, Object> extra;
    private long timestamp = System.currentTimeMillis();

    //无参构造
    private Result() {
        super();
    }

    //有参构造
    private Result(Boolean success, int code, T data, String message) {
        this.success = success;
        this.code = code;
        this.data = data;
        this.message = message;
    }

    /**
     * 返回成功
     *
     * @param data 内容
     */
    public static <E> Result<E> success(E data) {
        return new Result<>(true, BearCode.SUCCESS.getCode(), data, BearCode.SUCCESS.getMsg());
    }

    public static Result<Boolean> success() {
        return new Result<>(true, BearCode.SUCCESS.getCode(), true, BearCode.SUCCESS.getMsg());
    }

    public static <E> Result<E> success(E data, String msg) {
        return new Result<>(true,BearCode.SUCCESS.getCode(), data, msg);
    }

    public static <E> Result<E> fail(int code, String msg) {
        return new Result<>(false,code, null, (msg == null || msg.isEmpty()) ? BearCode.FAIL.getMsg() : msg);
    }

    public static <E> Result<E> fail(String msg) {
        return new Result<>(false,BearCode.FAIL.getCode(), null, (msg == null || msg.isEmpty()) ? BearCode.FAIL.getMsg() : msg);
    }

    public static <E> Result<E> fail(Throwable throwable) {
        return fail(BearCode.FAIL.getCode(), throwable != null ? throwable.getMessage() : BearCode.FAIL.getMsg());
    }

    public static <E> Result<E> fail() {
        return fail(BearCode.FAIL.getCode(), BearCode.FAIL.getMsg());
    }

    public static <E> Result<E> timeout() {
        return fail(BearCode.SYSTEM_TIMEOUT.getCode(), BearCode.SYSTEM_TIMEOUT.getMsg());
    }

    public Result<T> put(String key, Object value) {
        if (this.extra == null)
        {
            this.extra = new HashMap<String, Object>();
        }
        this.extra.put(key, value);
        return this;
    }
}
