package com.example.geo.demo.service;

import org.springframework.data.geo.GeoResults;
import org.springframework.data.redis.connection.RedisGeoCommands;

public interface LocationService {
    /***
     * 添加地理位置
     * @param key rediskey
     * @param lng 经度
     * @param lat 维度
     * @param name 位置名称
     */
    Long postUserAddress(String key, double lng, double lat, String name);

    /***
     * 获取最近附近的人地理位置
     * @param key rediskey
     * @param name 位置名称
     * @param distance 范围km数
     * @param count 获取最近几条
     */
    GeoResults<RedisGeoCommands.GeoLocation<String>> listNearbyUser(String key, String name, Integer distance, Integer count);

    /***
     * 分页获取最近附近的人地理位置
     * @param pageIndex 第几页
     * @param pageSize 每页条数
     * @param key redis key "city",
     * @param name 位置名称 "深圳",
     * @param distance 距离 "8000",
     * @param distanceUnit 距离单位 "km",
     * @param sort 排序 "asc",
     * @param newKey 新的redis key "shenzhennewkey"
     */
    void listNearbyUserLimit(Integer pageIndex, Integer pageSize, String key, String name, String distance, String distanceUnit, String sort, String newKey);
}

