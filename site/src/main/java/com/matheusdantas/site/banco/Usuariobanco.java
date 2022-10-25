package com.matheusdantas.site.banco;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.matheusdantas.site.entidade.Usuario;

@Repository
public interface Usuariobanco extends CrudRepository<Usuario, Integer> {
    
}
