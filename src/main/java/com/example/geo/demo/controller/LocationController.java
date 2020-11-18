package com.example.geo.demo.controller;

import com.example.geo.demo.pojo.Location;
import com.example.geo.demo.pojo.NearUser;
import com.example.geo.demo.service.LocationService;
import com.example.geo.demo.utils.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.geo.GeoResults;
import org.springframework.data.redis.connection.RedisGeoCommands;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/get-location")
public class LocationController {

    @Autowired
    LocationService locationService;

    @RequestMapping(value = "/getPeople/all",method = {RequestMethod.GET,RequestMethod.POST})
    public Result getnearbylist(@RequestBody Location location){
        GeoResults<RedisGeoCommands.GeoLocation<String>> geoResults = locationService.listNearbyUser(location.getKey(), location.getName(),
                location.getDistance(), location.getCount());
        return Result.success(geoResults);
    }

    @RequestMapping(value = "/postPeople/nearby")
    public Result postUserAddress(@RequestBody NearUser nearUser){
        //换算位置
        System.out.println(nearUser);
        Long aLong = locationService.postUserAddress(nearUser.getKey(), nearUser.getLng(), nearUser.getLat(), nearUser.getName());
        return Result.success(aLong);
    }
}
