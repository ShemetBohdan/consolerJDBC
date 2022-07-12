package com.example.consolerjdbc.model;

import lombok.Builder;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.redis.core.RedisHash;
@Data
@Builder
@RedisHash
public class Feed {

    @Id
    private int feedId;
    private String feedName;
    private String manufacturer;

}
