package com.Senai.Filmes.Model;

import com.Senai.Filmes.Model.Enums.GeneroFilme;
import jakarta.persistence.*;
import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;

import java.util.UUID;

@Entity
@Data
@Table(name = "cFilmes")
public class Filme {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    @NotBlank(message = "O titulo é obrigatorio")
    private String titulo;

    @Column(columnDefinition = "TEXT")
    private String descricao;

    private String urlPoster;

    @NotNull(message = "o campo genero é obrigatorio")
    @Enumerated(EnumType.STRING)
    private GeneroFilme genero;

    @NotNull(message = "o campo genero é obrigatorio")
    @Min(value =1, message = "A duração dever ser maior que 6")
    private Integer duracaoMinutos;


}
