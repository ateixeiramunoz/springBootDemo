package com.eoi.springBootDemo.repositories;

import com.eoi.springBootDemo.entities.UsuarioDemo;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;


@Repository
public interface UsuarioPagingAndSortingRepository extends PagingAndSortingRepository<UsuarioDemo, Integer> {

    Optional<UsuarioDemo> findBynombreDeUsuario(String username);

    Page<UsuarioDemo> findAllByAccountNonExpired(boolean status, Pageable pageable);


}

