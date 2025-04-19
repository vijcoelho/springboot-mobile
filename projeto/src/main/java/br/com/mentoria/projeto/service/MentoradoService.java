package br.com.mentoria.projeto.service;

import br.com.mentoria.projeto.repositories.MentoradoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MentoradoService {
    @Autowired
    private MentoradoRepository repository;
    
}
