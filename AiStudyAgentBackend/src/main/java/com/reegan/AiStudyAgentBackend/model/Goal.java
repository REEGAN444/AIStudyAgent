package com.reegan.AiStudyAgentBackend.model;

import jakarta.persistence.*;

@Entity
public class Goal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int days;

    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }

    public int getDays() { return days; }
    public void setDays(int days) { this.days = days; }
}
