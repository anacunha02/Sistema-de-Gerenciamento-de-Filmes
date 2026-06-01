package com.Senai.Filmes.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.UUID;

@Data
@Entity
@Table (name = "cSessoes")

public class Sessao {
  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private UUID id;


  //Quero fazer uma cocnexao de muitos para um , classe sessão é many, a filme one.
    //defino de onde eu pego pelo private,  lá no inicio da tabela ele pega do filme
    //Join colum pega a coluna do banco de dados.


    @ManyToOne
    @JoinColumn (name = "filme_id")
    @NotNull
    private Filme filme;

    @ManyToOne
    @JoinColumn (name = "sala_id")
    @NotNull
    private Sala sala;

    @NotNull(message = "O horario do inicio é obrigatorio")
    private LocalDateTime inicio;

    @NotNull(message = "O horario do fim é obrigatorio")
    private LocalDateTime fim;

    @NotNull(message = "O preço é obrigatorio")
    private BigDecimal valor;







}
