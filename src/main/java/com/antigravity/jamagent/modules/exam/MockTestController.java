package com.antigravity.jamagent.modules.exam;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/exam")
public class MockTestController {

    @GetMapping("/mock")
    public String getMockTest() {
        return "Mock Test Engine Stub";
    }
}
