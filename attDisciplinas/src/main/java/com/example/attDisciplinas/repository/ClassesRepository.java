package com.example.attDisciplinas.repository;

import com.example.attDisciplinas.model.classesmodel.Classes;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClassesRepository extends CrudRepository<Classes, Integer> {

}
