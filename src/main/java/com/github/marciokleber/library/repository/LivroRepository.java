package com.github.marciokleber.library.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.github.marciokleber.library.domain.Livro;

@Repository
public interface LivroRepository extends JpaRepository<Livro, Long>{
    
}
