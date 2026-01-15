package com.devjansen.api.medico;

import com.devjansen.api.endereco.DadosEndereco;
import com.devjansen.api.endereco.Endereco;
import com.devjansen.api.medico.dtos.DadosAtualizacaoMedico;
import com.devjansen.api.medico.dtos.DadosCadastroMedico;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode(of = "id")


@Entity(name = "Medico")
@Table(name ="medicos")
public class Medico {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;
    private String crm;

    @Enumerated(EnumType.STRING)
    private Especialidade especialidade;

    @Embedded
    private Endereco endereco;

    public Medico(DadosCadastroMedico dados){
        this.nome = dados.nome();
        this.email = dados.email();
        this.telefone = dados.telefone();
        this.crm = dados.crm();
        this.especialidade = dados.especialidade();
        this.endereco = new Endereco(dados.endereco());
    }

    public void atualizarInformacoes(DadosAtualizacaoMedico dados){
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.telefone() != null){
            this.nome = dados.telefone();
        }
        if(dados.dadosEndereco() != null){
            this.endereco.atualizarEndereco(dados.dadosEndereco());
        }
    }


}
