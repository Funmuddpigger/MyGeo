package com.example.geo.demo;

import com.example.geo.demo.pojo.Location;
import com.example.geo.demo.service.LocationService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.geo.Point;
import org.springframework.data.redis.core.RedisTemplate;


@SpringBootTest
class DemoApplicationTests {

    @Autowired
    private LocationService locationService;

    @Autowired
    RedisTemplate redisTemplate;

    @Test
    void contextLoads() {

    }

    @Test
    void postUserAddress(){
        locationService.postUserAddress("userlocation",116.405285,42.1,"zhangsan");
        locationService.postUserAddress("userlocation", 116.405285, 39.904989, "guangsi");
        locationService.postUserAddress("userlocation", 121.47, 31.23, "liliu");
        locationService.postUserAddress("userlocation", 113.27, 23.13, "jj");
        locationService.postUserAddress("userlocation", 43.86, 10.40, "bb");
    }

    @Test
    public void testadd(){
        Long addedNum = redisTemplate.opsForGeo()
                .add("userlocation",new Point(94.405,42.9),"wangwu");
        System.out.println(addedNum);
    }

    @Test
    public  void testlistNearbyUser(){
        //获取附近的人地理位置
        locationService.listNearbyUser("userlocation", "zhangsan", 8000, 4);
    }
}
