package com.example.geo.demo.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.stereotype.Component;

import java.io.Serializable;

@Data
@Component
@AllArgsConstructor
@NoArgsConstructor
public class Location implements Serializable {
    public String key;

    public String name;

    public Integer distance;

    public Integer count;

}
