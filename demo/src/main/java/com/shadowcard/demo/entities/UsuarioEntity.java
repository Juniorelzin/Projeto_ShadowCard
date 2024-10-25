
package com.shadowcard.demo.entities;

import java.util.List;
import jakarta.persistence.*;

@Entity
@Table(name = "usuarios") // Nome da tabela em plural
public class UsuarioEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(name = "nome")
    private String nome;

    @Column(name = "email")
    private String email;

    @Column(name = "senha")
    private String senha;

    @Column(name = "dinheiro")
    private int dinheiro;

    @ManyToMany
    @JoinTable(
        name = "deck_usuarios", 
        joinColumns = @JoinColumn(name = "id_usuarios"), 
        inverseJoinColumns = @JoinColumn(name = "id_decks")
    )
    private List<DeckEntity> decks; // Renomear para decks no plural

    // Getters e Setters
    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }
    
    public int getDinheiro() {
        return dinheiro;
    }

    public void setDinheiro(int dinheiro) {
        this.dinheiro = dinheiro;
    }

    public List<DeckEntity> getDecks() {
        return decks;
    }

    public void setDecks(List<DeckEntity> decks) {
        this.decks = decks;
    }

    
}
