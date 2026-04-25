package com.antigravity.jamagent.modules.exam;

import com.antigravity.jamagent.models.Question;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/exam")
public class MockTestController {

    @Autowired
    private AdaptiveQuizService adaptiveQuizService;

    @GetMapping("/mock")
    public ResponseEntity<List<Question>> getMockTest() {
        List<Question> questions = adaptiveQuizService.generateMockTest();
        return ResponseEntity.ok(questions);
    }
}
