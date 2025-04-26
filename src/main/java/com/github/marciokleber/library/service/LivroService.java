package com.github.marciokleber.library.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.github.marciokleber.library.domain.Livro;
import com.github.marciokleber.library.repository.LivroRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class LivroService {

    private final LivroRepository livroRepository;

    public List<Livro> findAllLivros() {
        return livroRepository.findAll();
    }

    public Livro findByIdLivro(Long id) {
        return livroRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Livro saveLivro(Livro livro) {
        return livroRepository.save(livro);
    }

    public Livro updateLivro(Long id, Livro livroAtualizado) {
        var livro = findByIdLivro(id);
        BeanUtils.copyProperties(livroAtualizado, livro, "id") ;
        return saveLivro(livro);
    }

    public void deleteLivro(Long id) {
        livroRepository.delete(findByIdLivro(id));
    }

}
