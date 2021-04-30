package com.tbp.repository;

import com.tbp.exception.PratoException;
import com.tbp.model.Prato;

import java.util.ArrayList;
import java.util.List;

public class PratoRepository {

    private static List<Prato> pratoList = new ArrayList<Prato>();

    public List<Prato> listar() {
        return pratoList;
    }

    public void salvar(String nome, String calorias, String ingredientes) throws PratoException {
        validarPrato(nome, calorias, ingredientes);
        String[] arrayIngredientes = ingredientes.split(";");
        Prato prato = new Prato(nome, Float.parseFloat(calorias), arrayIngredientes);
        pratoList.add(prato);
    }

    private void validarPrato(String nome, String calorias, String ingredientes)
        throws PratoException {
        if(nome == null || nome.trim().length() == 0) {
            throw new PratoException("O nome nao pode ser vazio");
        }
        if(ingredientes == null || ingredientes.trim().length() == 0) {
            throw new PratoException("Os ingredientes nao podem ser vazios");
        }
        try {
            Float cal = Float.parseFloat(calorias);
            if(cal == null || cal <=0 ) {
                throw new PratoException("A caloria deve ser maior que zero");
            }
        } catch (NumberFormatException e) {
            throw new PratoException("A caloria deve ser um numero");
        }



    }

}
