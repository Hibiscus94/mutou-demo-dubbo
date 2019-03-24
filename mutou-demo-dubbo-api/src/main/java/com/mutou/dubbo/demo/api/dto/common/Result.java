package com.mutou.dubbo.demo.api.dto.common;

import java.io.Serializable;

/**
 * ,__,
 * (oo)_____
 * (__)     )\
 * ````||---|| *
 * com.mutou.dubbo.demo.api.dto <br>
 * jdk 8
 *
 * @author mutou <br>
 * @version 1.0.0
 * @date 2019-03-23 <br>
 */
public class Result<T> implements Serializable {
    private boolean success;
    private String code;
    private String description;
    private T data;

    public Result() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public static <T> Result<T> create() {
        Result<T> result = new Result<>();
        result.setSuccess(false);
        return result;
    }

    public Result<T> success() {
        this.success(null);
        return this;
    }

    public Result<T> success(T data) {
        this.setSuccess(true);
        this.data = data;
        return this;
    }

    public Result<T> fail(String code, String description) {
        this.setSuccess(false);
        this.setCode(code);
        this.setDescription(description);
        return this;
    }

    public Result<T> fail(String code) {
        this.fail(code, (String)null);
        return this;
    }

    public Result<T> code(String code) {
        this.setCode(code);
        return this;
    }

    public Result<T> description(String description) {
        this.setDescription(description);
        return this;
    }

    public Result<T> data(T data) {
        this.data = data;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }
}
