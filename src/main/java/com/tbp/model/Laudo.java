package com.tbp.model;

public class Laudo {

    private Medico medico;
    private Paciente paciente;
    private String descricao;

    public Laudo(Medico medico, Paciente paciente, String descricao) {
        this.medico = medico;
        this.paciente = paciente;
        this.descricao = descricao;
    }

    public Medico getMedico() {
        return medico;
    }

    public Paciente getPaciente() {
        return paciente;
    }

    public String getDescricao() {
        return descricao;
    }
}
