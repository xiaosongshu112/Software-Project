package com.student.system.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

//时区配置
@Component
public class TimeZoneConfig {
    @Value("${spring.jackson.time-zone}")
    private String timeZone;

    @PostConstruct
    public void setTimeZone() {
        TimeZone.setDefault(TimeZone.getTimeZone(timeZone));
    }
}
