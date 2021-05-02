package com.tbp.repository;

import com.tbp.model.Laudo;
import com.tbp.model.Medico;
import com.tbp.model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class LaudoRepository {

    private static List<Laudo> laudoList = new ArrayList<Laudo>();

    public void salvar(Paciente paciente, Medico medico, String descricao) {
        Laudo laudo = new Laudo(medico, paciente, descricao);
        medico.getLaudoList().add(laudo);
        paciente.getLaudoList().add(laudo);
        laudoList.add(laudo);
    }



}
