package com.example.attDisciplinas.repository;

import com.example.attDisciplinas.model.classesmodel.Classes;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends JpaRepository<Classes, Long> {
    Classes findClassByClassName(String className);
}
