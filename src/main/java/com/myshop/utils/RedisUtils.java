package com.myshop.utils;

import com.alibaba.fastjson.JSON;
import redis.clients.jedis.Jedis;

import java.util.List;

public class RedisUtils {
    public static Jedis jedis=null ;

    private Jedis getConn(){
        if (jedis==null){
            jedis = new Jedis("39.97.118.214", 6379);
            jedis.auth("hemengwei");
        }
       return jedis;
   }


    public void set(String key, Object object) {
        Jedis jedis = getConn();
        jedis.set(key, JSON.toJSONString(object));
        //jedis.set(string, object.toString());
    }
 
    public Object get(String string,Class cls) {
        Jedis jedis = getConn();
        String value = jedis.get(string);
        return JSON.parseObject(value,cls);

    }

    /**
     * @auther: 何一
     * @date: 2020/8/6
     * @Description:redis放集合
     */
    public void setList(String key, List list) {
        Jedis jedis = getConn();

        jedis.set(key, JSON.toJSONString(list));
        //jedis.set(string, object.toString());
    }

    /**
     * @auther: 何一
     * @date: 2020/8/6
     * @Description:取list转成数组对象
     */
    public List getList(String string,Class cls) {
        Jedis jedis = getConn();
        String value = jedis.get(string);
        return JSON.parseArray(value,cls);
    }

    public void close() {
        if (jedis != null) {
            jedis.close();
        }
    }

    public void del(String str) {
        Jedis jedis = getConn();
       jedis.del(str);
    }
}
