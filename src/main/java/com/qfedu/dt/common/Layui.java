package com.qfedu.dt.common;

import java.util.HashMap;
import java.util.List;

public class Layui extends HashMap<String, Object> {

    /**
     * 将layui页面所需格式封装进一个Layui对象中
     *
     * @param count 数据库总消息条数
     * @param data 发送给layui界面的数据
     * @return
     */
    public static Layui data(long count, List<?> data) {
        Layui r = new Layui();
        r.put("code", 0);
        r.put("msg", "");
        r.put("count", count);
        r.put("data", data);
        return r;
    }
}
