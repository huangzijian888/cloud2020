package com.lamdaer.springcloud.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author lamdaer
 * @createTime 2020/10/28
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class CommonResult<T> {
    private Integer code;
    private String message;
    private T data;
    
    public CommonResult(Integer code, String message) {
        this(code, message, null);
    }
}
