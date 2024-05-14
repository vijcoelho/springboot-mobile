package com.example.attDisciplinas.model.classesmodel;

public class UpdateClasseNameRequest {

    private Long id;
    private String newClassName;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNewClassName() {
        return newClassName;
    }

    public void setNewClassName(String newClassName) {
        this.newClassName = newClassName;
    }
}

