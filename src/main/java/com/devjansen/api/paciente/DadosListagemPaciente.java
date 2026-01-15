package com.devjansen.api.paciente;

public record DadosListagemPaciente(
        String nome,
        String email,
        String cpf
) {

    public DadosListagemPaciente(Paciente dados){
        this(dados.getNome(), dados.getEmail(), dados.getCpf());
    }

}
