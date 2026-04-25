package com.antigravity.jamagent.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class AiApiConfig {

    @Value("${ai.claude.api-key}")
    private String claudeApiKey;

    public String getClaudeApiKey() {
        return claudeApiKey;
    }
}
