package com.Senai.Filmes.Model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@Entity
@Table(name = "cAssentos")
public class Assento {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID id;

    //ManyTo one- Muitos pedidos pertencem a um cliente.
    //ela é uma chave estrangeira
    @ManyToOne
    @JoinColumn(name = "sala_id")
    private Sala sala;

    //Quando é tipo String @notBlanck
    @NotBlank(message = "A fileira é obrigatoria")
    private String fileira;

    //NotNULL PARA Casos que não string

    @NotNull(message = " O numero do assento é obrigatorio ")
    private Integer numero;


}
