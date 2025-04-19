package br.com.mentoria.projeto.repositories;

import br.com.mentoria.projeto.entities.Curso;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CursoRepository extends MongoRepository<Curso, String> {
}
