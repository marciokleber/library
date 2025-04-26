package com.github.marciokleber.library.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.github.marciokleber.library.domain.Livro;
import com.github.marciokleber.library.service.LivroService;

import lombok.RequiredArgsConstructor;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;

@RestController
@RequestMapping("/api/v1/livro")
@RequiredArgsConstructor
public class LivroController {

    private LivroService livroService;

    @GetMapping
    public ResponseEntity<List<Livro>> findAll() {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.findAllLivros());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Livro> findById(@PathVariable("id") Long id) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.findByIdLivro(id));
    }

    @PostMapping
    public ResponseEntity<Livro> create(@RequestBody Livro livro) {
        return ResponseEntity.status(HttpStatus.CREATED).body(livroService.saveLivro(livro));
    }

    @PutMapping("/{id}")
    public ResponseEntity<Livro> update(@PathVariable("id") Long id, @RequestBody Livro livroAtualizado) {
        return ResponseEntity.status(HttpStatus.OK).body(livroService.updateLivro(id, livroAtualizado));
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleet(@PathVariable("id") Long id) {
        livroService.deleteLivro(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

}
