package br.com.mentoria.projeto.repositories;

import br.com.mentoria.projeto.entities.Mentor;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentorRepository extends MongoRepository<Mentor, String> {
}
