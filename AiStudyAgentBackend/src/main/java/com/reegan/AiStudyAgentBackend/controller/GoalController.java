package com.reegan.AiStudyAgentBackend.controller;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.reegan.AiStudyAgentBackend.model.Goal;
import com.reegan.AiStudyAgentBackend.service.PlannerService;

@RestController
@RequestMapping("/api/goals")
@CrossOrigin
public class GoalController {

    @Autowired
    private PlannerService plannerService;

    @PostMapping
    public String createGoal(@RequestBody Goal goal) {
        return plannerService.generatePlan(goal);
    }
}