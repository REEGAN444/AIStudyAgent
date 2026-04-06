package com.reegan.AiStudyAgentBackend.agent;



import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;

import java.util.Map;

@Component
public class PlannerAgent {

    @Value("${ollama.url}")
    private String ollamaUrl;

    @Value("${ollama.model}")
    private String model;

    public String createPlan(String title, int days) {

        RestTemplate restTemplate = new RestTemplate();

        String prompt = "Create a " + days +
                "-day structured study plan for " + title +
                " with daily tasks and progression.";

        HttpHeaders headers = new HttpHeaders();
        headers.setContentType(MediaType.APPLICATION_JSON);

        Map<String, Object> body = Map.of(
                "model", model,
                "prompt", prompt,
                "stream", false
        );

        HttpEntity<Map<String, Object>> request =
                new HttpEntity<>(body, headers);

        ResponseEntity<Map> response = restTemplate.postForEntity(
                ollamaUrl,
                request,
                Map.class
        );

        return response.getBody().get("response").toString();
    }
}