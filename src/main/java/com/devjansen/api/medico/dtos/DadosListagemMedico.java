package com.devjansen.api.medico.dtos;

import com.devjansen.api.medico.Especialidade;
import com.devjansen.api.medico.Medico;

public record DadosListagemMedico(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade
) {

    public DadosListagemMedico(Medico dados){
        this(dados.getId(), dados.getNome(), dados.getEmail(), dados.getCrm(), dados.getEspecialidade());
    }

}
