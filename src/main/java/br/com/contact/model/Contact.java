package br.com.contact.model;

import java.util.Date;

public class Contact {

    public Contact(String nome, int idade, String email, Date dataDeCadastro) {
        this.nome = nome;
        this.idade = idade;
        this.email = email;
        this.dataDeCadastro = dataDeCadastro;
    }

    private String nome;
    private int idade;
    private String email;
    private Date dataDeCadastro;

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public int getIdade() {
        return idade;
    }

    public void setIdade(int idade) {
        this.idade = idade;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Date getDataDeCadastro() {
        return dataDeCadastro;
    }

    public void setDataDeCadastro(Date dataDeCadastro) {
        this.dataDeCadastro = dataDeCadastro;
    }
}
