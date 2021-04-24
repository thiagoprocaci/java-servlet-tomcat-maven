package com.tbp.repository;

import com.tbp.model.Usuario;

import java.util.ArrayList;

import java.util.List;

public class UsuarioRepository {

    private static List<Usuario> usuarios = new ArrayList<>();

    public void salvar(String nome) {
        Usuario usuario = new Usuario(nome);
        usuarios.add(usuario);
    }

    public List<Usuario> listar() {
        return usuarios;
    }

}
