package com.tanxm.girl.domain;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

/**
    * @Title: Result
    * @Package com.tanxm.girl.domain
    * @Description: http请求返回的最外层对象
    * @author 谭小曼
    * @date 2019/1/19 18:55
    * @version V1.0
    */
@Data
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class Result<T> {
    /**错误码  */
    private Integer code;
    /**提示信息  */
    private String msg;
    /**具体的内容  */
    private T data;
}
