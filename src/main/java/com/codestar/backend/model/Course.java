package com.codestar.backend.model;

public class Course {
    private Long id;
    private String title;
    private String description;
    private String content;

    public Course(Long id, String title, String description, String content){
        this.id = id;
        this.title = title;
        this.description = description;
        this.content = content;
    }

    public Long getId(){ return id; }
    public String getTitle() { return title; }
    public String getDescription() { return description; }
    public String getContent() { return content; }
}
