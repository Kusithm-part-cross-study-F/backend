package com.kusithm.partstudybackend.global.common;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthCheckApiController {
    @RequestMapping("/")
    public String crossStudyF() {
        return "PartCross-Study-Team F good d";
    }
}
