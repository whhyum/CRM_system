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
  private Integer status;

  @ApiModelProperty(value = "消息")
  private String message;

  @ApiModelProperty(value = "数据")
  private Object data;

  public Integer getStatus() {
    return status;
  }

  public void setStatus(Integer status) {
    this.status = status;
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

  public Result(int status, String msg, Object o) {
    this.status = status;
    this.message = msg;
    this.data = o;
  }

}
