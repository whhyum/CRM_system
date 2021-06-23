package com.crm_system.springbootback.response;

import com.alibaba.fastjson.JSON;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;

/*
状态码改成枚举类：
        202 成功
400 数据字段缺少
404 数据错误
500 其他
*/


@ApiModel(value = "响应结果")
public class Result<T> {
  @ApiModelProperty(value = "状态码")
  private Integer code;

  @ApiModelProperty(value = "消息")
  private String message;

  @ApiModelProperty(value = "数据")
  private Object data;

  public Integer getCode() {
    return code;
  }

  public void setCode(Integer code) {
    this.code = code;
  }

  public String getMessage() {
    return message;
  }

  public void setMessage(String message) {
    this.message = message;
  }

  public Object getData() {
    return data;
  }

  public void setData(Object data) {
    this.data = data;
  }

  public Result(int code, String msg, Object o) {
    this.code = code;
    this.message = msg;
    this.data = o;
  }

}
