package com.tbp.model;

import java.util.ArrayList;
import java.util.List;

public class Pessoa {

    private Integer id;
    private String cpf;
    private String nome;
    private List<Laudo> laudoList;

    public Pessoa(Integer id, String cpf, String nome) {
        this.id = id;
        this.cpf = cpf;
        this.nome = nome;
        this.laudoList = new ArrayList<Laudo>();
    }

    public Integer getId() {
        return id;
    }

    public String getCpf() {
        return cpf;
    }

    public String getNome() {
        return nome;
    }

    public List<Laudo> getLaudoList() {
        return laudoList;
    }
}
