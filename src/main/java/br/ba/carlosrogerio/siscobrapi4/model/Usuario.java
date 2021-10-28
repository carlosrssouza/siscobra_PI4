package br.ba.carlosrogerio.siscobrapi4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="usuario")
public class Usuario {
    @Column(name="nome")
    protected String nome;
    @Column(name="cargo")
    protected String cargo;
    @Id
    @Column(name="login")
    protected String login;
    @Column(name="senha")
    protected String senha;
    @Column(name="email")
    protected String email;

    public Usuario(){
        
    }

    public Usuario(String nome, String cargo, String senha, String email){
        super();
        this.nome = nome;
        this.cargo = cargo;
        this.senha = senha;
        this.email = email;
    }
    
    public Usuario(String nome, String cargo, String login, String senha, String email){
        super();
        this.nome = nome;
        this.cargo = cargo;
        this.login = login;
        this.senha = senha;
        this.email = email;
    }
    
    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo;
    }

    public String getLogin() {
        return login;
    }

    public void setLogin(String login) {
        this.login = login;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}