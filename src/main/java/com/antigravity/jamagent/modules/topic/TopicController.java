package com.antigravity.jamagent.modules.topic;

import com.antigravity.jamagent.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/topic")
public class TopicController {

    @Autowired
    private TopicService topicService;

    @GetMapping("/daily")
    public ResponseEntity<Topic> getDailyTopic() {
        Topic topic = topicService.getDailyTopic();
        if (topic != null) {
            return ResponseEntity.ok(topic);
        }
        return ResponseEntity.notFound().build();
    }
}
