package com.eoi.springBootDemo;

import com.eoi.springBootDemo.entities.UsuarioDemo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UsuarioRepository extends JpaRepository<UsuarioDemo, Integer> {

    Optional<UsuarioDemo> findBynombreDeUsuario(String username);

}