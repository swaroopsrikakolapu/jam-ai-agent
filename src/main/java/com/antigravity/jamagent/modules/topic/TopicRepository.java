package com.antigravity.jamagent.modules.topic;

import com.antigravity.jamagent.models.Topic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface TopicRepository extends JpaRepository<Topic, Long> {

    // Fetch a random topic for the daily topic engine
    @Query(value = "SELECT * FROM topics ORDER BY RAND() LIMIT 1", nativeQuery = true)
    Optional<Topic> findRandomTopic();
}
