package model.entidades;

import java.io.Serializable;

public class Cliente implements Serializable {
    private String cpf, nome, sobrenome, email, telefone, celular;
    private char genero;
    private boolean desativado;

    public Cliente() {
    }

    public Cliente(String cpf, String nome, String sobrenome, char genero, String email, String telefone, String celular, boolean desativado) {
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.genero = genero;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.desativado = desativado;
    }
    public Cliente(String cpf, String nome, String sobrenome, char genero, String email, String telefone, String celular) {
        this.cpf = cpf;
        this.nome = nome;
        this.sobrenome = sobrenome;
        this.genero = genero;
        this.email = email;
        this.telefone = telefone;
        this.celular = celular;
        this.desativado = false;
    }

    public boolean isDesativado() {
        return desativado;
    }

    public void setDesativado(boolean desativado) {
        this.desativado = desativado;
    }

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getSobrenome() {
        return sobrenome;
    }

    public void setSobrenome(String sobrenome) {
        this.sobrenome = sobrenome;
    }

    public String getGenero() {
       if(genero == 'M') return "Masculino";
       else return "Feminino";
    }

    public void setGenero(char genero) {
        this.genero = Character.toUpperCase(genero);
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }
    
    
}
