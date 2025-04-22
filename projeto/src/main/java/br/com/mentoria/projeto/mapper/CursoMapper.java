package br.com.mentoria.projeto.mapper;

import br.com.mentoria.projeto.dto.request.CriarCursoRequest;
import br.com.mentoria.projeto.entity.Curso;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface CursoMapper {
    @Mapping(target = "id", ignore = true)
    Curso entidadeCurso (CriarCursoRequest request);
}
