package com.eoi.springBootDemo.services;

import com.eoi.springBootDemo.entities.UsuarioDemo;
import com.eoi.springBootDemo.repositories.UsuarioPagingAndSortingRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.ArrayList;
import java.util.List;

public class UsuarioService {

    final private List<UsuarioDemo> books = new ArrayList<UsuarioDemo>();
    final private UsuarioPagingAndSortingRepository usuarioPagingAndSortingRepository;

    public UsuarioService(UsuarioPagingAndSortingRepository usuarioPagingAndSortingRepository) {
        this.usuarioPagingAndSortingRepository = usuarioPagingAndSortingRepository;
    }

    public Page<UsuarioDemo> findPaginated(Pageable pageable) {

        Page pagina = usuarioPagingAndSortingRepository.findAll(pageable);
        return pagina;


    }


}
