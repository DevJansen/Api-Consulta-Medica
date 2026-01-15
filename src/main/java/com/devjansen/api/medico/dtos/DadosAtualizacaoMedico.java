package com.devjansen.api.medico.dtos;

import com.devjansen.api.endereco.DadosEndereco;
import jakarta.validation.constraints.NotNull;

public record DadosAtualizacaoMedico(
        @NotNull
        Long id,
        String nome,
        String telefone,
        DadosEndereco dadosEndereco
) {
}
