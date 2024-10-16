package com.shadowcard.demo.dtos.res;

public class ShowCartaDTO {
    
    private Long id;
    private String nome;
    private int numero;
    private int ataque;
    private int defesa;
    private String tipo;
    private String localImagem;

    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }
    public int getNumero() {
        return numero;
    }
    public void setNumero(int numero) {
        this.numero = numero;
    }
    public int getAtaque() {
        return ataque;
    }
    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }
    public int getDefesa() {
        return defesa;
    }
    public void setDefesa(int defesa) {
        this.defesa = defesa;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getLocalImagem() {
        return localImagem;
    }
    public void setLocalImagem(String localImagem) {
        this.localImagem = localImagem;
    } 
    
}
