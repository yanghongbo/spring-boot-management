package org.springframework.management.controller;

import org.springframework.http.HttpStatus;
import org.springframework.management.viewmodel.Message;

public abstract class BaseController {
    protected Message<Object> success() {
        return success(0, null);
    }

    protected Message<Object> success(int count) {
        return success(count, null);
    }

    protected Message<Object> success(int count, Object data) {
        return new Message<Object>(String.valueOf(HttpStatus.OK.value()), "操作成功", count, data);
    }

    protected Message fail(Integer statusCode,String msg){
        return new Message<Object>(statusCode.toString(), msg);
    }

    protected Message<Object> fail(HttpStatus httpStatus){
        return new Message<Object>(String.valueOf(httpStatus.value()), httpStatus.getReasonPhrase());
    }
}
