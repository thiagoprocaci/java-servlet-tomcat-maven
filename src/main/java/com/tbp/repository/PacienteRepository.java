package com.tbp.repository;

import com.tbp.model.Paciente;

import java.util.ArrayList;
import java.util.List;

public class PacienteRepository {

    private static List<Paciente> pacienteList = new ArrayList<Paciente>();

    public void salvar(String cpf, String nome, String planoSaude) {
        Integer id = pacienteList.size();
        Paciente p = new Paciente(id, cpf, nome, planoSaude);
        pacienteList.add(p);
    }

    public List<Paciente> listar() {
        return pacienteList;
    }

    public Paciente obterPorId(Integer id) {
        for(Paciente p : pacienteList) {
            if(p != null && p.getId().equals(id))  {
                return p;
            }
        }
        return null;
    }
}
