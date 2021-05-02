package com.tbp.model;



public class Medico extends Pessoa {

    private String crm;
   
    public Medico(Integer id, String cpf, String nome, String crm) {
        super(id, cpf, nome);
        this.crm = crm;
    }

    public String getCrm() {
        return crm;
    }

    
}
