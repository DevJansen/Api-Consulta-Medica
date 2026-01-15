package com.devjansen.api.controller;

import com.devjansen.api.medico.DadosCadastroMedico;
import com.devjansen.api.medico.DadosListagemMedico;
import com.devjansen.api.medico.Medico;
import com.devjansen.api.medico.MedicoRepository;
import jakarta.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("medicos")
public class MedicoController {

    @Autowired
    private MedicoRepository medicoRepository;

    @PostMapping
    @Transactional
    public void cadastrar(@RequestBody @Valid DadosCadastroMedico dados){
        medicoRepository.save(new Medico(dados));
    }

    @GetMapping
    public Page<DadosListagemMedico> listar(Pageable paginacao){
        return medicoRepository.findAll(paginacao)
                .map(DadosListagemMedico::new);

    }

}
