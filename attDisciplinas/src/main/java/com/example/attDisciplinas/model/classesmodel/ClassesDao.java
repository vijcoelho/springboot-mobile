package com.example.attDisciplinas.model.classesmodel;

import com.example.attDisciplinas.repository.ClassesRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.util.Streamable;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public Classes changeClassName(Long classesId, String newName) {
        Optional<Classes> optionalClasses = classesRepository.findById(classesId);
        if (optionalClasses.isPresent()) {
            Classes classes = optionalClasses.get();
            classes.setClassName(newName);
            return classesRepository.save(classes);
        } else {
            return null;
        }
    }
}
