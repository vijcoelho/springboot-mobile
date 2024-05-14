package com.example.attDisciplinas.controllers;

import com.example.attDisciplinas.model.classesmodel.ClassesDao;
import com.example.attDisciplinas.model.classesmodel.Classes;
import com.example.attDisciplinas.model.classesmodel.UpdateClasseNameRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class ClassesController {

    @Autowired
    private ClassesDao classesDao;

    @PostMapping("/classes/save")
    public Classes save(@RequestBody Classes classes) {
        return classesDao.saveClass(classes);
    }

    @GetMapping("/classes/getAll")
    public List<Classes> getAll() {
        return classesDao.getAllClasses();
    }

    @PostMapping("/classes/updateName")
    public Classes updateClassName(@RequestBody UpdateClasseNameRequest request) {
        return classesDao.changeClassName(request.getId(), request.getNewClassName());
    }
}
