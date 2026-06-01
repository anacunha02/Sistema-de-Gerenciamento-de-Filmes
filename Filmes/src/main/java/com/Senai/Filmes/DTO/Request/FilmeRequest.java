package com.Senai.Filmes.DTO.Request;

import com.Senai.Filmes.Model.Enums.GeneroFilme;
import jakarta.persistence.Id;

import java.util.UUID;

public record FilmeRequest(

        UUID id,
        String titulo,
        String descricao,
        String urlPoster,
        GeneroFilme generoFilme,
        Integer duracaoMinutos
        ) {}
