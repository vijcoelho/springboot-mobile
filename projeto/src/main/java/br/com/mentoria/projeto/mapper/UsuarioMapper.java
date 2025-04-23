package br.com.mentoria.projeto.mapper;

import br.com.mentoria.projeto.dto.request.usuario.CriarUsuarioRequest;
import br.com.mentoria.projeto.entity.Usuario;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface UsuarioMapper {
    @Mapping(target = "id", ignore = true)
    @Mapping(target = "cursos", ignore = true)
    Usuario entidadeCadastro (CriarUsuarioRequest request);
}
