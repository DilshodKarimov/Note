package com.example.notes.model;


import jakarta.persistence.*;
import lombok.Data;

@Entity
public class Note {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String headLine;

    private String bodyLine;

    public void setId(Long id) {
        this.id = id;
    }

    public void setHeadLine(String headLine) {
        this.headLine = headLine;
    }

    public void setBodyLine(String bodyLine) {
        this.bodyLine = bodyLine;
    }

    public Long getId() {
        return id;
    }

    public String getHeadLine() {
        return headLine;
    }

    public String getBodyLine() {
        return bodyLine;
    }
}
