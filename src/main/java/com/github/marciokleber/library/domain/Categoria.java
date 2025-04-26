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

@Getter
@Setter
@Entity
@Table(name = "TB_CATEGORIA")
public class Categoria {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "SEQ_CATEGORIA")
    @SequenceGenerator(name = "SEQ_CATEGORIA", sequenceName = "SEQ_CATEGORIA", allocationSize = 50)
    private Long id;


    @Column(nullable = false)
    @Comments(@Comment("CAMPO IDENTIFICADOR DO NOME DA CATEGORIA"))
    private String nome;

    @Comments(@Comment("CAMPO IDENTIFICADOR DA DESCRIÇÃO DA CATEGORIA"))
    private Long descricao;

}
