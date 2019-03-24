package com.mutou.dubbo.demo.api.dto.common;

import java.io.Serializable;

/**
 * ,__,
 * (oo)_____
 * (__)     )\
 * ````||---|| *
 * com.mutou.dubbo.demo.api.dto.common <br>
 * jdk 8
 *
 * @author mutou <br>
 * @version 1.0.0
 * @date 2019-03-23 <br>
 */
public class Request<T> implements Serializable{

    private T data;

    public Request() {
    }

    public Request(T data) {
        this.data = data;
    }

    public static <T> Request<T> create() {
        return new Request<>();
    }

    public Request<T> data(T data) {
        this.data = data;
        return this;
    }

    public T getData() {
        return this.data;
    }

    public void setData(T data) {
        this.data = data;
    }

    @Override
    public String toString() {
        return "Request{" +
                "data=" + data +
                '}';
    }
}
