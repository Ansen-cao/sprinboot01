package com.ansen.service;

/**
 * @Desc redis操作类
 * @Author caomx
 * @Date 2021-08-11
 */
public interface RedisService {

    /**
     * @Desc 存储数据
     * @param key
     * @param value
     */
    void set(String key,String value);

    /**
     * @Desc 获取数据
     * @param key
     * @return
     */
    String get(String key);

    /**
     * @Desc 删除数据
     * @param key
     */
    void  delete(String key);

    /**
     * @Desc 设置超期时间
     * @param key
     * @param expire
     * @return
     */
    boolean expire(String key,long expire);

    /**
     * @Desc 自增操作
     * @param key
     * @param delta
     * @return
     */
    Long increment(String key,long delta);
}
