package com.antigravity.jamagent.modules.crt;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/crt")
public class AptitudeController {

    @GetMapping("/aptitude")
    public String getAptitudeTest() {
        return "Aptitude Module Stub";
    }
}
