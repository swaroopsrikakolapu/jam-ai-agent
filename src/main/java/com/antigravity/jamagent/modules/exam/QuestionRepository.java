package com.antigravity.jamagent.modules.exam;

import com.antigravity.jamagent.models.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface QuestionRepository extends JpaRepository<Question, Long> {

    // Fetch 5 random questions for a mock test
    @Query(value = "SELECT * FROM questions ORDER BY RAND() LIMIT 5", nativeQuery = true)
    List<Question> findRandomQuestions();
}
