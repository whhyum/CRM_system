package com.crm_system.springbootback.response;

public class ResultUtil {
    /**
     * 成功获取数据
     * @return
     */
    public static Result success(String msg, Object data){
        return new Result(200, msg, data);
    }

    /**
     * 失败
     * @param msg 返回失败的类型
     * @param data 空
     * @return
     */
    public static Result fail(String msg, Object data){
        return new Result(404, msg, data);
    }

}
