package com.antigravity.jamagent.modules.placement;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/placement")
public class ResumeController {

    @GetMapping("/resume")
    public String getResumeBuilder() {
        return "Resume Builder Stub";
    }
}
