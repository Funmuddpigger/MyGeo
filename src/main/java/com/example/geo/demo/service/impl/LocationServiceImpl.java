package com.example.geo.demo.service.impl;

import com.example.geo.demo.pojo.Location;
import com.example.geo.demo.service.LocationService;
import com.example.geo.demo.utils.RedisUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.ZSetOperations;
import org.springframework.data.redis.core.script.DefaultRedisScript;
import org.springframework.stereotype.Service;

import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.TimeUnit;
import java.util.stream.Collectors;


@Service
public class LocationServiceImpl implements LocationService {

    @Autowired
    RedisTemplate redisTemplate;

    @Autowired
    RedisUtils redisUtils;

    /**
     *
     * @param key rediskey
     * @param lng 经度
     * @param lat 维度
     * @param name 位置名称
     */
    @Override
    public Long postUserAddress(String key, double lng, double lat, String name) {
        Long postPeopleAdd = redisUtils.redisGeoAdd(key, lng, lat, name);
        return postPeopleAdd;
    }

    @Override
    public GeoResults<RedisGeoCommands.GeoLocation<String>> listNearbyUser(String key, String name, Integer distance, Integer count) {
        GeoResults<RedisGeoCommands.GeoLocation<String>> geoResults = redisUtils.geoNearByPlace(key, name, distance, count);
        return geoResults;
    }
    @Override
    public void listNearbyUserLimit(Integer pageIndex, Integer pageSize, String key, String name, String distance, String distanceUnit, String sort, String newKey) {

    }

}
