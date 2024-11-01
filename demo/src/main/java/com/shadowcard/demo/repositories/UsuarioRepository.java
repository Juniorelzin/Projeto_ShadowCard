package com.shadowcard.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shadowcard.demo.entities.UsuarioEntity;
import java.util.Optional;


public interface UsuarioRepository extends JpaRepository<UsuarioEntity, Long> {
    Optional<UsuarioEntity> findById(Long id);
}
