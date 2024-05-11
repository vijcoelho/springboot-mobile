package com.example.attDisciplinas.model.classesmodel;

import com.example.attDisciplinas.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ClassesDao {

    private Classes classes;

    @Autowired
    private ClassesRepository classesRepository;

    public Classes saveClass(Classes classes) {
        return classesRepository.save(classes);
    }

    public List<Classes> getAllClasses() {
        List<Classes> classes = new ArrayList<>();
        Streamable.of(classesRepository.findAll())
                .forEach(classes::add);
        return classes;
    }
}
