package br.com.mentoria.projeto.repositories;

import br.com.mentoria.projeto.entities.Mentorado;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MentoradoRepository extends MongoRepository<Mentorado, String> {
}
