package com.antigravity.jamagent.models;

import jakarta.persistence.*;

@Entity
@Table(name = "topics")
public class Topic {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "subject_id")
    private Subject subject;

    private String title;
    
    @Column(name = "content_json", columnDefinition = "TEXT")
    private String contentJson;
    
    private String difficulty; // BASIC, INTERMEDIATE, ADVANCED
    
    @Column(name = "sequence_no")
    private Integer sequenceNo;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Subject getSubject() { return subject; }
    public void setSubject(Subject subject) { this.subject = subject; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getContentJson() { return contentJson; }
    public void setContentJson(String contentJson) { this.contentJson = contentJson; }
    public String getDifficulty() { return difficulty; }
    public void setDifficulty(String difficulty) { this.difficulty = difficulty; }
    public Integer getSequenceNo() { return sequenceNo; }
    public void setSequenceNo(Integer sequenceNo) { this.sequenceNo = sequenceNo; }
}
