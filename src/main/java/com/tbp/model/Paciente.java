package com.tbp.model;

public class Paciente extends Pessoa {

    private String planoSaude;

    public Paciente(Integer id, String cpf, String nome, String planoSaude) {
        super(id, cpf, nome);
        this.planoSaude = planoSaude;
    }

    public String getPlanoSaude() {
        return planoSaude;
    }
}
