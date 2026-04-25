package com.antigravity.jamagent.modules.chatbot;

import com.antigravity.jamagent.dto.ChatRequestDto;
import com.antigravity.jamagent.dto.ChatResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController {

    @Autowired
    private ClaudeApiService claudeApiService;

    @PostMapping("/chat")
    public ResponseEntity<ChatResponseDto> chat(@RequestBody ChatRequestDto request) {
        if (request.getMessage() == null || request.getMessage().trim().isEmpty()) {
            return ResponseEntity.badRequest().build();
        }
        
        ChatResponseDto response = claudeApiService.getAnswer(request);
        return ResponseEntity.ok(response);
    }
}
