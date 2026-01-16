package com.devjansen.api.paciente.dtos;

import com.devjansen.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoPaciente(

        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco dadosEndereco

) {
}
