package com.devjansen.api.paciente;

import com.devjansen.api.endereco.Endereco;
import com.devjansen.api.paciente.dtos.DadosAtualizacaoPaciente;
import com.devjansen.api.paciente.dtos.DadosCadastroPaciente;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")


@Entity(name = "Paciente")
@Table(name = "Pacientes")
public class Paciente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String cpf;
    private boolean ativo;

    @Embedded
    private Endereco endereco;


    public Paciente(DadosCadastroPaciente dados){

        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.cpf = dados.cpf();
        this.ativo = true;
        this.endereco = new Endereco(dados.endereco());

    }

    public  void atualizarPaciente(DadosAtualizacaoPaciente dados){
        if (dados.nome() != null){
            this.nome = dados.nome();
        }
        if (dados.telefone() != null){
            this.telefone = dados.telefone();
        }
        if(dados.dadosEndereco() != null){
            this.endereco.atualizarEndereco(dados.dadosEndereco());
        }
    }

    public void excluir(){
        this.ativo = false;
    }

}
