package com.antigravity.jamagent.models;

import jakarta.persistence.*;

@Entity
@Table(name = "questions")
public class Question {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "topic_id")
    private Topic topic;

    @Column(columnDefinition = "TEXT")
    private String text;

    @Column(name = "options_json", columnDefinition = "TEXT")
    private String optionsJson;

    @Column(name = "correct_answer")
    private String correctAnswer;

    private String type; // MCQ, MSQ, NAT
    private String difficulty;
    @Column(name = "exam_year")
    private Integer examYear;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Topic getTopic() { return topic; }
    public void setTopic(Topic topic) { this.topic = topic; }
    public String getText() { return text; }
    public void setText(String text) { this.text = text; }
    public String getOptionsJson() { return optionsJson; }
    public void setOptionsJson(String optionsJson) { this.optionsJson = optionsJson; }
    public String getCorrectAnswer() { return correctAnswer; }
    public void setCorrectAnswer(String correctAnswer) { this.correctAnswer = correctAnswer; }
    public String getType() { return type; }
    public void setType(String type) { this.type = type; }
    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    public Integer getExamYear() { return examYear; }
    public void setExamYear(Integer examYear) { this.examYear = examYear; }
}
