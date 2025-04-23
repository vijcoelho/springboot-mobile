package br.com.mentoria.projeto.repository;

import br.com.mentoria.projeto.entity.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface CursoRepository extends MongoRepository<Curso, String> {
    Curso findByTitulo (String titulo);
}
