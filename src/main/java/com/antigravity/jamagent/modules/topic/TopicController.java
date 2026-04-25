package com.antigravity.jamagent.modules.topic;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topic")
public class TopicController {

    @GetMapping("/daily")
    public String getDailyTopic() {
        return "Daily Topic Engine Stub";
    }
}
