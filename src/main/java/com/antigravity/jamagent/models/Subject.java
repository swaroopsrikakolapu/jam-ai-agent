package com.antigravity.jamagent.models;

import jakarta.persistence.*;

@Entity
@Table(name = "subjects")
public class Subject {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String code;
    
    @Column(name = "jam_weightage")
    private Double jamWeightage;
    
    @Column(name = "color_code")
    private String colorCode;

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getName() { return name; }
    public void setName(String name) { this.name = name; }
    public String getCode() { return code; }
    public void setCode(String code) { this.code = code; }
    public Double getJamWeightage() { return jamWeightage; }
    public void setJamWeightage(Double jamWeightage) { this.jamWeightage = jamWeightage; }
    public String getColorCode() { return colorCode; }
    public void setColorCode(String colorCode) { this.colorCode = colorCode; }
}
