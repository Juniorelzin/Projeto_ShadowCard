package com.shadowcard.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shadowcard.demo.entities.UsuarioEntity;


public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long>  {
    
}
