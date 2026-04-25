package com.antigravity.jamagent.dto;

public class ChatResponseDto {
    private String response;
    private String source; // Real API vs Simulation

    public ChatResponseDto() {}

    public ChatResponseDto(String response, String source) {
        this.response = response;
        this.source = source;
    }

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }
}
