package com.matheusdantas.site.controller;

import java.util.List;
import java.util.Optional;
import java.util.function.Function;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.matheusdantas.site.banco.Usuariobanco;
import com.matheusdantas.site.entidade.Usuario;

@CrossOrigin ("*")
@RestController
public class UsuarioController {

    @Autowired
    private Usuariobanco acessoBanco;
    

    @GetMapping("/usuarios")
    public List<Usuario> listarUsuarios (){
        return (List<Usuario>) acessoBanco.findAll();
    }

    @GetMapping ("/usuario/{id}")
    public Optional<Usuario> peguePorId(@PathVariable int id) {
        return acessoBanco.findById(id);
    } 

    @DeleteMapping("/delete/{id}")
    public void deletePorId(@PathVariable int id) {
        acessoBanco.deleteById(id);
    }

    @PostMapping("/cadastrar")
    public void cadastrarUsuario( @RequestBody Usuario novoUsuario){
        acessoBanco.save(novoUsuario);
    }

    @PutMapping("/alterar/{id}")
    public void alterarUsuario( @RequestBody Usuario usuario, @PathVariable int id){
        acessoBanco.findById(id).map((Function<? super Usuario, ? extends Usuario>) u -> {
            u.setEmail(usuario.getEmail());
            u.setSenha(usuario.getSenha());
            return acessoBanco.save(u);
        });
    }
}