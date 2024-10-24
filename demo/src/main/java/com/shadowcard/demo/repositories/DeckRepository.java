package com.shadowcard.demo.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shadowcard.demo.entities.DeckEntity;


public interface DeckRepository extends JpaRepository<DeckEntity, Long>  {
    
}
