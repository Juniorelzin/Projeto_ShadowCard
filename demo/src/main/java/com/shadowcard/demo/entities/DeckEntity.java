package com.shadowcard.demo.entities;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "decks") // Nome da tabela em plural
public class DeckEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "tipo")
    private String tipo;

    @ManyToMany
    @JoinTable(
        name = "deck_cartas", 
        joinColumns = @JoinColumn(name = "id_decks"), 
        inverseJoinColumns = @JoinColumn(name = "id_cartas")
    )
    private List<CartaEntity> cartas; // Renomear para cartas

    @ManyToMany
    @JoinTable(
        name = "deck_usuarios", 
        joinColumns = @JoinColumn(name = "id_decks"), 
        inverseJoinColumns = @JoinColumn(name = "id_usuarios")
    )
    private List<UsuarioEntity> usuarios; // Renomear para usuarios

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public List<CartaEntity> getCartas() {
        return cartas;
    }

    public void setCartas(List<CartaEntity> cartas) {
        this.cartas = cartas;
    }

    public List<UsuarioEntity> getUsuarios() {
        return usuarios;
    }

    public void setUsuarios(List<UsuarioEntity> usuarios) {
        this.usuarios = usuarios;
    }
}
