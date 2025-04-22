package com.github.marciokleber.library.domain;

import org.hibernate.annotations.Comment;
import org.hibernate.annotations.Comments;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.SequenceGenerator;
import jakarta.persistence.Table;
import lombok.Getter;
import lombok.Setter;


@Setter
@Getter
@Entity
@Table(name = "TB_LIVRO")
public class Livro {


    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_LIVRO")
    @SequenceGenerator(name = "SEQ_LIVRO", sequenceName = "SEQ_LIVRO", allocationSize = 1)
    private Long id;


    @Comments(@Comment("CAMPO IDENTIFICADO DO TITULO DO LIVRO"))
    @Column(name = "TITULO", nullable = false)
    private String titulo;

    @Comments(@Comment("CAMPO IDENTIFICADO DO PROLOGO DO LIVRO"))
    @Column(name = "PROLOGO")
    private String prologo;

    @Comments(@Comment("CAMPO IDENTIFICADO DO ISBN DO LIVRO"))
    @Column(name = "ISBN", nullable = false)
    private String isbn;

    /**
     * relacionamentos:
     * Autor
     * Editora
     * categoria
     */
    
}
