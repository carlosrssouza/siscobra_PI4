package br.ba.carlosrogerio.siscobrapi4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pessoa")
public class Pessoa {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_pessoa")
    private int idPessoa;
    @Column(name="nome_pessoa")
    private String nomePessoa;
    @Column(name="endereco")
    private String endereco;
    @Column(name="uf")
    private String uf;
    @Column(name="telefone")
    private String telefone;
    @Column(name="documento")
    private String documento;
    @Column(name="email")
    private String email;

    public Pessoa(){
        
    }

    public Pessoa(String nomePessoa, String endereco, String uf,  String telefone, String documento, String email){
        super();
        this.nomePessoa = nomePessoa;
        this.endereco = endereco;
        this.uf = uf;
        this.telefone = telefone;
        this.documento = documento;
        this.email = email;
    }

    public Pessoa(int idPessoa, String nomePessoa, String endereco, String uf,  String telefone, String documento, String email){
        super();
        this.idPessoa = idPessoa;
        this.nomePessoa = nomePessoa;
        this.endereco = endereco;
        this.uf = uf;
        this.telefone = telefone;
        this.documento = documento;
        this.email = email;
    }    
    
    public int getIdPessoa() {
        return idPessoa;
    }

    public void setIdPessoa(int idPessoa) {
        this.idPessoa = idPessoa;
    }

    public String getNomePessoa() {
        return nomePessoa;
    }

    public void setNomePessoa(String nomePessoa) {
        this.nomePessoa = nomePessoa;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setEndereco(String endereco) {
        this.endereco = endereco;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

}