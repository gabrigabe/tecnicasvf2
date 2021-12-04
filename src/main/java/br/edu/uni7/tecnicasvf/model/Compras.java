package br.edu.uni7.tecnicasvf.model;


import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.MongoId;

import java.util.List;
import java.util.UUID;

@Document
public class Compras {

    @MongoId
    private String id;
    private UUID notafiscal = UUID.randomUUID();
    private List<Produtos> produtos;
    private String cpfCliente;
    private Double valorcompras;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public UUID getNotafiscal() {
        return notafiscal;
    }

    public void setNotafiscal(UUID notafiscal) {
        this.notafiscal = notafiscal;
    }

    public List<Produtos> getProdutos() {
        return produtos;
    }

    public void setProdutos(List<Produtos> produtos) {
        this.produtos = produtos;
    }

    public String getCpfCliente() {
        return cpfCliente;
    }

    public void setCpfCliente(String cpfCliente) {
        this.cpfCliente = cpfCliente;
    }
    public Double getValorcompras() {
        return valorcompras;
    }

    public void setValorcompras(Double valorcompras) {
        this.valorcompras = valorcompras;
    }
}
