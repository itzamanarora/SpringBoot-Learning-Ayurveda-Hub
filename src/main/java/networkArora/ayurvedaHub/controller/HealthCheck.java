package networkArora.ayurvedaHub.controller;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.GetMapping;


@RestController
@RequestMapping("/api")
public class HealthCheck {

    @GetMapping("/health")
    public String healthCheck() {
        return "Ayurveda Hub is up and running!";
    }
}
