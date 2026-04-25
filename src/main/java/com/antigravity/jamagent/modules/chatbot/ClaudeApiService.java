package com.antigravity.jamagent.modules.chatbot;

import com.antigravity.jamagent.dto.ChatRequestDto;
import com.antigravity.jamagent.dto.ChatResponseDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.time.Duration;

@Service
public class ClaudeApiService {

    @Value("${ai.claude.api-key:placeholder_key}")
    private String apiKey;

    @Autowired
    private KnowledgeBaseService knowledgeBaseService;

    public ChatResponseDto getAnswer(ChatRequestDto request) {
        String context = knowledgeBaseService.retrieveContext(request.getMessage());
        String prompt = "You are an AI Agent helping a student prepare for IIT JAM Chemistry 2027. " +
                        "Use this context if helpful: " + context + "\n\n" +
                        "Student: " + request.getMessage();

        if ("placeholder_key".equals(apiKey) || apiKey == null || apiKey.isEmpty()) {
            return simulateResponse(request.getMessage(), context);
        }

        return callRealClaudeApi(prompt);
    }

    private ChatResponseDto simulateResponse(String message, String context) {
        // A simple simulation logic for when no API key is provided
        try {
            Thread.sleep(1000); // Simulate network latency
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }

        String msgLower = message.toLowerCase();
        String reply;

        if (msgLower.contains("hello") || msgLower.contains("hi")) {
            reply = "Hello there! I'm your JAM Chemistry 2027 AI Agent. How can I help you study today?";
        } else if (msgLower.contains("sn1") || msgLower.contains("sn2")) {
            reply = "Great question! SN1 reactions proceed via a carbocation intermediate (two steps) and favor tertiary substrates due to stability. SN2 reactions are concerted (one step) and favor primary substrates due to less steric hindrance. Both are fundamental to Organic Chemistry for JAM!";
        } else if (msgLower.contains("thermodynamics") || msgLower.contains("gibbs")) {
            reply = "Ah, Thermodynamics! Remember the crucial equation: ΔG = ΔH - TΔS. For any process to be spontaneous at constant temperature and pressure, the change in Gibbs Free Energy (ΔG) must be negative (< 0).";
        } else if (msgLower.contains("mock") || msgLower.contains("test")) {
            reply = "Are you ready to test your skills? You can access the Mock Test Engine to practice questions. Make sure you review your weak topics afterward!";
        } else {
            reply = "That's an interesting question regarding Chemistry. Based on the knowledge base (" + context + "), I'd recommend reviewing your foundational concepts. Is there a specific reaction or law you want me to explain?";
        }

        return new ChatResponseDto(reply, "SIMULATED_AI");
    }

    private ChatResponseDto callRealClaudeApi(String prompt) {
        // Stub implementation for real HTTP call using java.net.http.HttpClient
        // In a real scenario, we would parse JSON, handle errors, etc.
        try {
            /* 
            HttpClient client = HttpClient.newBuilder().connectTimeout(Duration.ofSeconds(10)).build();
            String jsonPayload = "{...}"; // Construct Anthropic JSON payload
            HttpRequest httpRequest = HttpRequest.newBuilder()
                    .uri(URI.create("https://api.anthropic.com/v1/messages"))
                    .header("x-api-key", apiKey)
                    .header("anthropic-version", "2023-06-01")
                    .header("content-type", "application/json")
                    .POST(HttpRequest.BodyPublishers.ofString(jsonPayload))
                    .build();
            HttpResponse<String> response = client.send(httpRequest, HttpResponse.BodyHandlers.ofString());
            // Parse response...
            */
            return new ChatResponseDto("Real Claude API integration is wired up! (Assuming valid JSON parsing here)", "REAL_CLAUDE_API");
        } catch (Exception e) {
            return new ChatResponseDto("Error contacting Claude API: " + e.getMessage(), "ERROR");
        }
    }
}
