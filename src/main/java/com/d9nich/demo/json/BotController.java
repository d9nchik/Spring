package com.d9nich.demo.json;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BotController {
    @PostMapping(value = "/greet", consumes = "application/json")
    public String greet(@RequestBody List<UserInfo> userInfoList) {
        return String.format("OK, %d of users have been logged out!", userInfoList.size());
    }
}
