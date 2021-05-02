package com.tbp.model;

import java.util.ArrayList;
import java.util.List;

public class Medico extends Pessoa {

    private String crm;
    private List<Laudo> laudoList;

    public Medico(Integer id, String cpf, String nome, String crm) {
        super(id, cpf, nome);
        this.crm = crm;
        this.laudoList = new ArrayList<Laudo>();
    }

    public String getCrm() {
        return crm;
    }

    @Override
    public List<Laudo> getLaudoList() {
        return laudoList;
    }
}
