package com.antigravity.jamagent.modules.exam;

import com.antigravity.jamagent.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AdaptiveQuizService {

    @Autowired
    private QuestionRepository questionRepository;

    public List<Question> generateMockTest() {
        return questionRepository.findRandomQuestions();
    }
}
