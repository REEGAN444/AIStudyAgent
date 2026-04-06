package com.reegan.AiStudyAgentBackend.repository;


import org.springframework.data.jpa.repository.JpaRepository;

import com.reegan.AiStudyAgentBackend.model.Goal;

public interface GoalRepository extends JpaRepository<Goal, Long> {
}