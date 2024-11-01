package com.shadowcard.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadowcard.demo.dtos.req.CreateUsuarioDTO;

import com.shadowcard.demo.dtos.res.ShowUsuarioDTO;
import com.shadowcard.demo.dtos.req.CreateAddDeckUsuario;
import com.shadowcard.demo.entities.DeckEntity;
import com.shadowcard.demo.entities.UsuarioEntity;

import com.shadowcard.demo.repositories.UsuarioRepository;
import com.shadowcard.demo.repositories.DeckRepository;



@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;

    @Autowired
    private DeckRepository deckRepository;


    
    public void createUsuario(CreateUsuarioDTO dto) {

      
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNome(dto.getNome());
        usuarioEntity.setEmail(dto.getEmail());
        usuarioEntity.setSenha(dto.getSenha());
        usuarioEntity = usuarioRepository.save(usuarioEntity);
    
    }


    public List<ShowUsuarioDTO> getUsuarios() {
        List<UsuarioEntity> usuarioEntity = usuarioRepository.findAll();

        return usuarioEntity.stream().map(usuario -> {
            ShowUsuarioDTO usuarioDTO = new ShowUsuarioDTO();
                
            
            usuarioDTO.setId(usuario.getId());
            usuarioDTO.setNome(usuario.getNome());
            usuarioDTO.setEmail(usuario.getEmail());
            usuarioDTO.setDinheiro(usuario.getDinheiro());
            usuarioDTO.setDecks(usuario.getDecks().stream().map(deck -> deck.getId()).toList());

            return usuarioDTO;
        }).toList();
    }


    public void addDecksToUsuario(CreateAddDeckUsuario dto) {
    UsuarioEntity usuario = usuarioRepository.findById(dto.getUsuarioId())
        .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));

    List<DeckEntity> decks = deckRepository.findAllById(dto.getDeckIds());
    
    usuario.getDecks().addAll(decks);
    usuarioRepository.save(usuario);
        }


    public void buyDecksUsuario(CreateAddDeckUsuario dto) {
            UsuarioEntity usuario = usuarioRepository.findById(dto.getUsuarioId())
                .orElseThrow(() -> new RuntimeException("Usuário não encontrado"));
            
            List<DeckEntity> decks = deckRepository.findAllById(dto.getDeckIds());
            
            int totalCusto = 10;
    
            if (usuario.getDinheiro() < totalCusto) {
                throw new RuntimeException("Dinheiro insuficiente para comprar os decks.");
            }

            usuario.getDecks().addAll(decks);
        
            usuario.setDinheiro(usuario.getDinheiro() - totalCusto);
        
            usuarioRepository.save(usuario);
    }
        
}
