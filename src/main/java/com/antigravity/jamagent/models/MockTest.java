package com.antigravity.jamagent.models;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
@Table(name = "mock_tests")
public class MockTest {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "user_id")
    private Long userId; // Dummy for now since we don't have User entity yet

    @Column(name = "start_time")
    private LocalDateTime startTime;

    @Column(name = "end_time")
    private LocalDateTime endTime;

    private Double score;
    
    @Column(name = "max_score")
    private Double maxScore;
    
    @Column(name = "rank_estimate")
    private Integer rankEstimate;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getUserId() { return userId; }
    public void setUserId(Long userId) { this.userId = userId; }
    public LocalDateTime getStartTime() { return startTime; }
    public void setStartTime(LocalDateTime startTime) { this.startTime = startTime; }
    public LocalDateTime getEndTime() { return endTime; }
    public void setEndTime(LocalDateTime endTime) { this.endTime = endTime; }
    public Double getScore() { return score; }
    public void setScore(Double score) { this.score = score; }
    public Double getMaxScore() { return maxScore; }
    public void setMaxScore(Double maxScore) { this.maxScore = maxScore; }
    public Integer getRankEstimate() { return rankEstimate; }
    public void setRankEstimate(Integer rankEstimate) { this.rankEstimate = rankEstimate; }
}
