package br.ba.carlosrogerio.siscobrapi4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Table;
import javax.persistence.Id;

@Entity
@Table(name="divida")
public class Divida {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_divida")
    private int idDivida;
    @Column(name="id_credor")
    private int idCredor;
    @Column(name="data_atualizacao")
    private String dataAtualizacao;
    @Column(name="valor_divida")
    private float valorDivida;
    @Column(name="id_devedor")
    private int idDevedor;

    public Divida(){
        
    }
    
    public Divida(int idCredor, String dataAtualizacao, float valorDivida, int idDevedor){
        super();
        this.idCredor = idCredor;
        this.dataAtualizacao = dataAtualizacao;
        this.valorDivida = valorDivida;
        this.idDevedor = idDevedor;
    }
    
    public Divida(int idDivida, int idCredor, String dataAtualizacao, float valorDivida, int idDevedor){
        super();
        this.idDivida = idDivida;
        this.idCredor = idCredor;
        this.dataAtualizacao = dataAtualizacao;
        this.valorDivida = valorDivida;
        this.idDevedor = idDevedor;
    }
    
    public int getIdDivida() {
        return idDivida;
    }

    public void setIdDivida(int idDivida) {
        this.idDivida = idDivida;
    }

    public int getIdCredor() {
        return idCredor;
    }

    public void setIdCredor(int idCredor) {
        this.idCredor = idCredor;
    }

    public String getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(String dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }

    public float getValorDivida() {
        return valorDivida;
    }

    public void setValorDivida(float valorDivida) {
        this.valorDivida = valorDivida;
    }

    public int getIdDevedor() {
        return idDevedor;
    }

    public void setIdDevedor(int idDevedor) {
        this.idDevedor = idDevedor;
    }
    
}
