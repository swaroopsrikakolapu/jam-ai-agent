package com.antigravity.jamagent.modules.topic;

import com.antigravity.jamagent.models.Topic;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TopicService {

    @Autowired
    private TopicRepository topicRepository;

    public Topic getDailyTopic() {
        return topicRepository.findRandomTopic().orElse(null);
    }
}
