package com.shadowcard.demo.dtos.req;

import java.util.List;

public class CreateUsuarioDTO {
    private String nome;
    private String email;
    private String senha;
    private int dinheiro;
    private List<Long> decks; // Lista de IDs dos decks

    // Getters e Setters
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

    public List<Long> getDecks() {
        return decks;
    }

    public void setDecks(List<Long> decks) {
        this.decks = decks;
    }
}
