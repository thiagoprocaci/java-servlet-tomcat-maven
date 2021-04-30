package com.tbp.model;

import java.util.ArrayList;
import java.util.List;

public class Prato {

    private String nome;
    private Float calorias;
    private List<String> ingredientes;

    public Prato(String nome, Float calorias, List<String> ingredientes) {
        this.nome = nome;
        this.calorias = calorias;
        this.ingredientes = ingredientes;
    }

    public Prato(String nome, Float calorias, String[] ingredientes) {
        this.nome = nome;
        this.calorias = calorias;
        if(ingredientes != null) {
            this.ingredientes = new ArrayList<String>();
            for(String ingrediente : ingredientes) {
                this.ingredientes.add(ingrediente);
            }
        }
    }


    public String getNome() {
        return nome;
    }

    public Float getCalorias() {
        return calorias;
    }

    public List<String> getIngredientes() {
        return ingredientes;
    }

    @Override
    public String toString() {
        return nome;
    }
}
