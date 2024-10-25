package com.shadowcard.demo.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.shadowcard.demo.dtos.req.CreateUsuarioDTO;

import com.shadowcard.demo.dtos.res.ShowUsuarioDTO;

import com.shadowcard.demo.entities.UsuarioEntity;

import com.shadowcard.demo.repositories.UsuarioRepository;



@Service
public class UsuarioService {

    @Autowired
    private UsuarioRepository usuarioRepository;


    
    public void createUsuario(CreateUsuarioDTO dto) {

      
        UsuarioEntity usuarioEntity = new UsuarioEntity();
        usuarioEntity.setNome(dto.getNome());
        usuarioEntity.setEmail(dto.getEmail());
        usuarioEntity.setSenha(dto.getSenha());
        usuarioEntity.setDinheiro(dto.getDinheiro());
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

            return usuarioDTO;
        }).toList();
    }
}
