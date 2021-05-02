package com.tbp.repository;

import com.tbp.model.Medico;

import java.util.ArrayList;
import java.util.List;

public class MedicoRepository {

    private static List<Medico> medicoList = new ArrayList<Medico>();

    public void salvar(String cpf, String nome, String crm) {
        Integer id = medicoList.size();
        Medico m = new Medico(id, cpf, nome, crm);
        medicoList.add(m);
    }

    public List<Medico> listar() {
        return medicoList;
    }

    public Medico obterPorId(Integer id) {
        for(Medico m : medicoList) {
            if(m != null && m.getId().equals(id)) {
                return m;
            }
        }
        return null;
    }
}
