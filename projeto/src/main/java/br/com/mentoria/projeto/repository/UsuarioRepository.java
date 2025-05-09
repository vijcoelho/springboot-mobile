package br.com.mentoria.projeto.repository;

import br.com.mentoria.projeto.entity.Curso;
import br.com.mentoria.projeto.entity.Usuario;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UsuarioRepository extends MongoRepository<Usuario, String> {
    Optional<Usuario> findByCpf (String cpf);
    Optional<Usuario> findByEmail (String email);
}
