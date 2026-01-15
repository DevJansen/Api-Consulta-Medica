package com.devjansen.api.controller;

import com.devjansen.api.paciente.dtos.DadosCadastroPaciente;
import com.devjansen.api.paciente.dtos.DadosListagemPaciente;
import com.devjansen.api.paciente.Paciente;
import com.devjansen.api.paciente.PacienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    @Autowired
    private PacienteRepository pacienteRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroPaciente dados){
        pacienteRepository.save(new Paciente(dados));
    }

    @GetMapping
    public Page<DadosListagemPaciente> listar(Pageable paginacao){
        return pacienteRepository.findAll(paginacao)
                .map(DadosListagemPaciente::new);
    }
}
