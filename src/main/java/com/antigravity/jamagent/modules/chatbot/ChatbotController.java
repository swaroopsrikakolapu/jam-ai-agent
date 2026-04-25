package com.antigravity.jamagent.modules.chatbot;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/chatbot")
public class ChatbotController {

    @GetMapping("/chat")
    public String chat() {
        return "Chatbot Engine Stub";
    }
}
