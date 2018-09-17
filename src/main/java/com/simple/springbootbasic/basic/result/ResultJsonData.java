package com.simple.springbootbasic.basic.result;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;
import java.util.List;
/**
 * @Description 统一json格式
 * @Author Simple
 * @Date 2018/9/17 17:13
 * @Version 1.0
 */
@Data
public class ResultJsonData<T> {
    private Integer code;
    private String message;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private T object;
    @JsonInclude(JsonInclude.Include.NON_NULL)
    private List<T> dataList;

    public ResultJsonData(Integer code, String message) {
        this.code = code;
        this.message = message;
    }

    public ResultJsonData(Integer code, String message, T object) {
        this.code = code;
        this.message = message;
        this.object = object;
    }

    public ResultJsonData(Integer code, String message, List<T> dataList) {
        this.code = code;
        this.message = message;
        this.dataList = dataList;
    }
}
