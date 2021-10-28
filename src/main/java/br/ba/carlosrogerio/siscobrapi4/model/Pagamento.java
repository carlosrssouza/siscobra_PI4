package br.ba.carlosrogerio.siscobrapi4.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="pagamento")
public class Pagamento {
    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(name="id_pagamento")
    private int idPagamento;
    @Column(name="id_divida")
    private int idDividaPagamento;
    @Column(name="data_pagamento")
    private String dataPagamento;
    @Column(name="valor_pago")
    private float valorPago;

    public Pagamento(){
        
    }
    
    public Pagamento(int idDividaPagamento, String dataPagamento, float valorPago){
        super();
        this.idDividaPagamento = idDividaPagamento;
        this.dataPagamento = dataPagamento;
        this.valorPago = valorPago;
    }    
    
    public Pagamento(int idPagamento, int idDividaPagamento, String dataPagamento, float valorPago){
        super();
        this.idPagamento = idPagamento;
        this.idDividaPagamento = idDividaPagamento;
        this.dataPagamento = dataPagamento;
        this.valorPago = valorPago;
    }

    public int getIdPagamento() {
        return idPagamento;
    }


    public void setIdPagamento(int idPagamento) {
        this.idPagamento = idPagamento;
    }


    public int getIdDividaPagamento() {
        return idDividaPagamento;
    }


    public void setIdDividaPagamento(int idDividaPagamento) {
        this.idDividaPagamento = idDividaPagamento;
    }


    public String getDataPagamento() {
        return dataPagamento;
    }


    public void setDataPagamento(String dataPagamento) {
        this.dataPagamento = dataPagamento;
    }


    public float getValorPago() {
        return valorPago;
    }


    public void setValorPago(float valorPago) {
        this.valorPago = valorPago;
    }

 
}
