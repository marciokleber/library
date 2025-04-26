package com.github.marciokleber.library.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.github.marciokleber.library.domain.Categoria;
import com.github.marciokleber.library.repository.CategoriaRepository;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CategoriaService {

    private final CategoriaRepository categoriaRepository;

    public List<Categoria> findAllCategoria() {
        return categoriaRepository.findAll();
    }

    public Categoria findByIdCategoria(Long id){
        return categoriaRepository.findById(id).orElseThrow(EntityNotFoundException::new);
    }

    public Categoria saveCategoria(Categoria categoria){
        return categoriaRepository.save(categoria);
    }

    public Categoria updateCategoria(Long id, Categoria categoriaAtualizada){
        var categoria = findByIdCategoria(id);
        BeanUtils.copyProperties(categoriaAtualizada, categoria, "id");
        return saveCategoria(categoria);
    }

    public void deleteCategoria(Long id){
        categoriaRepository.delete(findByIdCategoria(id));
    }

}
