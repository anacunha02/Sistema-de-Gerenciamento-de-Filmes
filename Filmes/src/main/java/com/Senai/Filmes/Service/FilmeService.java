package com.Senai.Filmes.Service;

import com.Senai.Filmes.DTO.Request.FilmeRequest;
import com.Senai.Filmes.DTO.Response.FilmeResponse;
import com.Senai.Filmes.Model.Filme;
import com.Senai.Filmes.Repository.IFilmeRepository;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;
import java.util.UUID;

@Service
public class FilmeService {

    private IFilmeRepository filmeRepository;

    //CRUD

    //LIstar toodos

    public List<FilmeResponse> listarTodos() {
        return filmeRepository.findAll().stream().map(this::toResponse).toList();

    }


    public  FilmeResponse buscarPorFilmeId(UUID id){
        Filme filme = filmeRepository.findById(id)
                .orElseThrow(()-> new EntityNotFoundException("Filme não encontrado"));
                return  toResponse(filme);


    }
    public FilmeResponse cadastrarFilme(FilmeRequest request) {
        Filme filme = new Filme();
        filme.setTitulo(request.titulo());
        filme.setDescricao(request.descricao());
        filme.setUrlPoster(request.urlPoster());
        filme.setGenero(request.generoFilme());

        return toResponse(filmeRepository.save(filme));
    }










    private FilmeResponse toResponse(Filme filme) {
        return new FilmeResponse(
                filme.getId(),
                filme.getTitulo(),
                filme.getDescricao(),
                filme.getUrlPoster(),
                filme.getGenero(),
                filme.getDuracaoMinutos()


        );
    }
}