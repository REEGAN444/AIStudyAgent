package com.reegan.AiStudyAgentBackend.service;



import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.reegan.AiStudyAgentBackend.agent.PlannerAgent;
import com.reegan.AiStudyAgentBackend.agent.QuizAgent;
import com.reegan.AiStudyAgentBackend.model.Goal;
import com.reegan.AiStudyAgentBackend.repository.GoalRepository;

@Service
public class PlannerService {

    @Autowired
    private PlannerAgent plannerAgent;

    @Autowired
    private QuizAgent quizAgent;

    @Autowired
    private GoalRepository goalRepository;

    public String generatePlan(Goal goal) {

        goalRepository.save(goal);

        String plan = plannerAgent.createPlan(
                goal.getTitle(), goal.getDays()
        );

        String quiz = quizAgent.generateQuiz(goal.getTitle());

        return plan + "\n\n===== QUIZ =====\n" + quiz;
    }
}