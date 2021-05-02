package com.tbp.service;

import com.tbp.model.Medico;
import com.tbp.model.Paciente;
import com.tbp.repository.LaudoRepository;
import com.tbp.repository.MedicoRepository;
import com.tbp.repository.PacienteRepository;

import java.util.List;

public class ConsultorioService {

    private MedicoRepository medicoRepository;
    private PacienteRepository pacienteRepository;
    private LaudoRepository laudoRepository;

    public ConsultorioService() {
        this.medicoRepository = new MedicoRepository();
        this.pacienteRepository = new PacienteRepository();
        this.laudoRepository = new LaudoRepository();
    }

    public void salvarMedico(String cpf, String nome, String crm) {
        medicoRepository.salvar(cpf, nome, crm);
    }

    public List<Medico> listarMedicos() {
        return medicoRepository.listar();
    }

    public Medico obterMedicoPorId(Integer id) {
        return medicoRepository.obterPorId(id);
    }

    public void salvarPaciente(String cpf, String nome, String planoSaude) {
        pacienteRepository.salvar(cpf, nome, planoSaude);
    }

    public List<Paciente> listarPacientes() {
        return pacienteRepository.listar();
    }

    public Paciente obterPacientePorId(Integer id) {
        return pacienteRepository.obterPorId(id);
    }

    public void salvarLaudo(Integer idPaciente, Integer idMedico, String descricao) {
        Paciente p = obterPacientePorId(idPaciente);
        Medico m = obterMedicoPorId(idMedico);
        laudoRepository.salvar(p, m , descricao);
    }


}
